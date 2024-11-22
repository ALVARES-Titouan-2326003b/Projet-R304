package java.com.hopitalfantastique;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.medecin.ElfMedecin;
import java.com.hopitalfantastique.creatures.medecin.OrqueMedecin;
import java.com.hopitalfantastique.creatures.patient.ElfPatient;
import java.com.hopitalfantastique.creatures.patient.OrquePatient;
import java.com.hopitalfantastique.creatures.patient.VampirePatient;
import java.com.hopitalfantastique.creatures.patient.ZombiePatient;
import java.com.hopitalfantastique.services.Crypte;
import java.com.hopitalfantastique.services.ServiceMedical;
import java.com.hopitalfantastique.services.CentreQuarantaine;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Jeu {
    private ArrayList<ServiceMedical> services;
    private ArrayList<CreatureMedecin> medecins;
    private ArrayList<CreaturePatient> fileAttente; // Monstres en attente
    private int actionsRestantes;
    private int jour;
    private int argent;

    public Jeu() {
        this.services = new ArrayList<>();
        this.medecins = new ArrayList<>();
        this.fileAttente = new ArrayList<>();
        this.actionsRestantes = 5; // Par exemple, 5 actions par jour
        this.jour = 1;
        initialiserJeu();
    }



    public void jouer() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Jour " + jour + " ===");
            afficherEtat();

            // Réinitialiser les actions quotidiennes
            actionsRestantes = 5;

            while (actionsRestantes > 0) {
                System.out.println("\nActions restantes : " + actionsRestantes);
                System.out.println("Budget :" + argent);
                System.out.println("Choisissez une action :");
                System.out.println("1. Placer une créature dans un service");
                System.out.println("2. Soigner une créature");
                System.out.println("3. Réviser un budget");
                System.out.println("4. Déplacer une créature");
                System.out.println("5. Passer au jour suivant");

                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        placerCreature(scanner);
                        break;
                    case 2:
                        soignerCreature(scanner);
                        break;
                    case 3:
                        reviserBudget(scanner);
                        break;
                    case 4:
                        deplacerCreature(scanner);
                        break;
                    case 5:
                        actionsRestantes = 0; // Passer au jour suivant
                        break;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            }

            progresserUnJour();
        }
    }


    private void afficherEtat() {
        System.out.println("\n--- État de l'Hôpital ---");
        System.out.println("File d'attente des créatures :");
        for (int i = 0; i < fileAttente.size(); i++) {
            System.out.println((i + 1) + ". " + fileAttente.get(i).getNom() + " (" + fileAttente.get(i).getClass().getSimpleName() + ")");
        }

        System.out.println("\nServices médicaux :");
        for (ServiceMedical service : services) {
            System.out.println(service);
        }
    }


    private void placerCreature(Scanner scanner) {
        if (fileAttente.isEmpty()) {
            System.out.println("Aucune créature en attente.");
            return;
        }

        System.out.println("\nChoisissez une créature à placer :");
        for (int i = 0; i < fileAttente.size(); i++) {
            System.out.println((i + 1) + ". " + fileAttente.get(i).getNom());
        }

        int choixCreature = scanner.nextInt() - 1;
        if (choixCreature < 0 || choixCreature >= fileAttente.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        CreaturePatient creature = fileAttente.get(choixCreature);

        System.out.println("\nChoisissez un service médical :");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1;
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        ServiceMedical service = services.get(choixService);
        if (service.ajouterCreature(creature)) {
            System.out.println(creature.getNom() + " a été placé dans " + service.getNom() + ".");
            fileAttente.remove(creature);
            actionsRestantes--;
        } else {
            System.out.println("Impossible de placer la créature.");
        }
    }


    private void soignerCreature(Scanner scanner) {
        System.out.println("\nChoisissez un service médical pour soigner une créature :");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1;
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        ServiceMedical service = services.get(choixService);
        if (service.getNombreCreatures() > 0) {
            System.out.println("Un médecin soigne une créature de " + service.getNom() + "...");
            service.soignerCreatures(); // Implémentation dans la classe ServiceMedical
            actionsRestantes--;
        } else {
            System.out.println("Aucune créature à soigner dans ce service.");
        }
    }

    private void reviserBudget(Scanner scanner) {
        System.out.println("\nChoisissez un service médical pour réviser son budget :");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1;
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        ServiceMedical service = services.get(choixService);
        service.reviserBudget();
        actionsRestantes--;
    }

    private void deplacerCreature(Scanner scanner) {
        System.out.println("Fonctionnalité non implémentée pour cette version.");
    }


    private void progresserUnJour() {
        jour++;
        Random random = new Random();

        // Modifications aléatoires des créatures
        for (CreaturePatient creature : fileAttente) {
            if (random.nextBoolean()) {
                creature.tombeMalade();
                System.out.println(creature.getNom() + " est tombé(e) malade.");
            }
        }

        // Modifications aléatoires des services médicaux
        for (ServiceMedical service : services) {
            if (random.nextBoolean()) {
                service.reviserBudget();
            }
        }
    }




    private void initialiserJeu() {



        // Création de quelques services médicaux
        services.add(new ServiceMedical("Service Central", 800.0f, 25, "Inexistant"));
        services.add(new CentreQuarantaine("Quarantaine Ouest", 300.0f, 10, "Inexistant"));
        services.add(new Crypte("Crypte Nord", 400.0f, 5, "Inexistant", 8, 15));

        // Création de médecins
        medecins.add(new ElfMedecin("Dr. Elrond", "M", 500));
        medecins.add(new OrqueMedecin("Dr. Gruzog", "M", 300));

        // Ajout de quelques créatures en attente
        fileAttente.add(new OrquePatient("Grog", "M", 120.0f, 180.0f, 35, liste1));
        fileAttente.add(new ZombiePatient("Zed", "M", 90.0f, 170.0f, 200, liste2));
        fileAttente.add(new VampirePatient("Lestat", "M", 80.0f, 175.0f, 150, liste3));
    }
}










