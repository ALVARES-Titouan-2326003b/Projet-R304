package com.TP3.hopitalfantastique;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.Maladie;
import com.TP3.hopitalfantastique.creatures.medecin.ElfMedecin;
import com.TP3.hopitalfantastique.services.CentreQuarantaine;
import com.TP3.hopitalfantastique.services.Crypte;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.medecin.OrqueMedecin;
import com.TP3.hopitalfantastique.creatures.patient.OrquePatient;
import com.TP3.hopitalfantastique.creatures.patient.VampirePatient;
import com.TP3.hopitalfantastique.creatures.patient.ZombiePatient;

import java.util.Arrays;
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
        if (service.getNombreCreature() > 0) {
            System.out.println("Choisissez une créature à soigner :");
            ArrayList<CreaturePatient> patients = service.getListeCreatures();
            for (int i = 0; i < services.size(); ++i) {
                if (!patients.get(i).getListeMaladie().isEmpty()) System.out.println((i + 1) + ". " + patients.get(i));
            }
            int choixCreature = scanner.nextInt() - 1;
            if (choixCreature < 0 || choixCreature >= patients.size()) {
                System.out.println("Choix invalide.");
                return;
            }
            CreaturePatient patient = patients.get(choixCreature);

            System.out.println("Choisissez la maladie à soigner :");
            ArrayList<Maladie> maladies = patient.getListeMaladie();
            for (int i = 0; i < maladies.size(); ++i) {
                System.out.println((i + 1) + ". " + maladies.get(i).getNomComplet());
            }
            int choixMaladie = scanner.nextInt() - 1;
            if (choixMaladie < 0 || choixMaladie >= maladies.size()) {
                System.out.println("Choix invalide.");
                return;
            }
            String maladie = maladies.get(choixMaladie).getNomComplet();

            System.out.println("Un médecin soigne une créature de " + service.getNom() + "...");
            service.soignerCreature(patient, maladie); // Implémentation dans la classe ServiceMedical
            actionsRestantes--;
        } else {
            System.out.println("Aucune créature à soigner dans ce service.");
        }
    }

    private void reviserBudget(Scanner scanner) {
        System.out.println("\nChoisissez un service médical pour réviser son budget :");
        String nouveauBudget = scanner.nextLine();
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1;
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        ServiceMedical service = services.get(choixService);
        service.reviserBudget(nouveauBudget);
        actionsRestantes--;
    }

    private void deplacerCreature(Scanner scanner) {
        System.out.println("Fonctionnalité non implémentée pour cette version.");
    }


    private void progresserUnJour() {
        ++jour;
        Random random = new Random();
        ArrayList<String> budgets = new ArrayList<>(Arrays.asList("Inexistant", "Mediocre", "Insuffisant", "Faible"));

        // Modifications aléatoires des créatures
        for (CreaturePatient creature : fileAttente) {
            if (random.nextBoolean()) {
                creature.tombeMalade(new Maladie());
                System.out.println(creature.getNom() + " est tombé(e) malade.");
            }
        }

        // Modifications aléatoires des services médicaux
        for (ServiceMedical service : services) {
            if (random.nextBoolean()) {
                service.reviserBudget(budgets.get(random.nextInt(budgets.size())));
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
        fileAttente.add(new OrquePatient("Grog", "M", 120.0f, 180.0f, 35, new ArrayList<>(), 10));
        fileAttente.add(new ZombiePatient("Zed", "M", 90.0f, 170.0f, 200, new ArrayList<>(), 10));
        fileAttente.add(new VampirePatient("Lestat", "M", 80.0f, 175.0f, 150, new ArrayList<>(), 10));
    }
}










