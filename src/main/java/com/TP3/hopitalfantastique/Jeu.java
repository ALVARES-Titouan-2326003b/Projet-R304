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
    // Déclaration des variables du jeu
    private ArrayList<ServiceMedical> services; // Liste des services médicaux dans l'hôpital
    private ArrayList<CreatureMedecin> medecins; // Liste des médecins (créatures capables de soigner)
    private ArrayList<CreaturePatient> fileAttente; // Liste des créatures en attente de soin
    private int actionsRestantes; // Nombre d'actions restantes dans une journée (5 par jour ici)
    private int jour; // Jour actuel dans le jeu
    private int argent; // Budget de l'hôpital

    // Constructeur du jeu, initialise les variables et appelle la méthode d'initialisation
    public Jeu() {
        this.services = new ArrayList<>(); // Initialisation de la liste des services médicaux
        this.medecins = new ArrayList<>(); // Initialisation de la liste des médecins
        this.fileAttente = new ArrayList<>(); // Initialisation de la liste des créatures en attente
        this.actionsRestantes = 5; // 5 actions possibles par jour
        this.jour = 1; // Le jeu commence au jour 1
        initialiserJeu(); // Appel à la méthode pour initialiser les services, médecins et créatures
    }

    // Méthode pour lancer la boucle principale du jeu
    public void jouer() {
        Scanner scanner = new Scanner(System.in);

        // Boucle principale du jeu
        while (true) {
            System.out.println("\n=== Jour " + jour + " ==="); // Affiche le jour actuel
            afficherEtat(); // Affiche l'état de l'hôpital

            // Réinitialiser le nombre d'actions disponibles pour la journée
            actionsRestantes = 5;

            // Boucle pour gérer les actions pendant une journée
            while (actionsRestantes > 0) {
                System.out.println("\nActions restantes : " + actionsRestantes); // Affiche les actions restantes
                System.out.println("Budget :" + argent); // Affiche le budget actuel
                System.out.println("Choisissez une action :"); // Demande à l'utilisateur de choisir une action
                System.out.println("1. Placer une créature dans un service");
                System.out.println("2. Soigner une créature");
                System.out.println("3. Réviser un budget");
                System.out.println("4. Déplacer une créature");
                System.out.println("5. Passer au jour suivant");

                int choix = scanner.nextInt(); // Lecture du choix de l'utilisateur
                scanner.nextLine(); // Consomme le caractère de nouvelle ligne après la lecture du choix

                // Traitement du choix de l'utilisateur
                switch (choix) {
                    case 1: // Placer une créature dans un service
                        placerCreature(scanner);
                        break;
                    case 2: // Soigner une créature
                        soignerCreature(scanner);
                        break;
                    case 3: // Réviser un budget
                        reviserBudget(scanner);
                        break;
                    case 4: // Déplacer une créature
                        deplacerCreature(scanner);
                        break;
                    case 5: // Passer au jour suivant
                        actionsRestantes = 0; // Met à 0 les actions restantes pour passer au jour suivant
                        break;
                    default: // Si l'utilisateur fait un choix invalide
                        System.out.println("Choix invalide. Réessayez.");
                }
            }

            // Passe au jour suivant après avoir effectué toutes les actions
            progresserUnJour();
        }
    }

    // Méthode pour afficher l'état actuel de l'hôpital
    private void afficherEtat() {
        System.out.println("\n--- État de l'Hôpital ---");
        System.out.println("File d'attente des créatures :");
        // Affichage des créatures en attente
        for (int i = 0; i < fileAttente.size(); i++) {
            System.out.println((i + 1) + ". " + fileAttente.get(i).getNom() + " (" + fileAttente.get(i).getClass().getSimpleName() + ")");
        }

        // Affichage des services médicaux
        System.out.println("\nServices médicaux :");
        for (ServiceMedical service : services) {
            System.out.println(service); // Affiche chaque service médical
        }
    }

    // Méthode pour placer une créature dans un service médical
    private void placerCreature(Scanner scanner) {
        // Vérifie si la file d'attente est vide
        if (fileAttente.isEmpty()) {
            System.out.println("Aucune créature en attente.");
            return;
        }

        // Affiche les créatures en attente pour permettre à l'utilisateur de faire un choix
        System.out.println("\nChoisissez une créature à placer :");
        for (int i = 0; i < fileAttente.size(); i++) {
            System.out.println((i + 1) + ". " + fileAttente.get(i).getNom());
        }

        int choixCreature = scanner.nextInt() - 1; // Lecture du choix de la créature à placer
        if (choixCreature < 0 || choixCreature >= fileAttente.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        // Récupère la créature sélectionnée
        CreaturePatient creature = fileAttente.get(choixCreature);

        // Affiche les services disponibles pour permettre à l'utilisateur de choisir un service
        System.out.println("\nChoisissez un service médical :");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1; // Lecture du choix du service
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        // Récupère le service sélectionné
        ServiceMedical service = services.get(choixService);
        if (service.ajouterCreature(creature)) { // Si la créature est placée avec succès
            System.out.println(creature.getNom() + " a été placé dans " + service.getNom() + ".");
            fileAttente.remove(creature); // Retire la créature de la file d'attente
            actionsRestantes--; // Réduit le nombre d'actions disponibles
        } else {
            System.out.println("Impossible de placer la créature.");
        }
    }

    // Méthode pour soigner une créature dans un service médical
    private void soignerCreature(Scanner scanner) {
        System.out.println("\nChoisissez un service médical pour soigner une créature :");
        // Affiche les services disponibles
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1; // Lecture du choix du service
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        // Récupère le service sélectionné
        ServiceMedical service = services.get(choixService);
        if (service.getNombreCreature() > 0) { // Vérifie s'il y a des créatures à soigner
            System.out.println("Choisissez une créature à soigner :");
            ArrayList<CreaturePatient> patients = service.getListeCreatures();
            for (int i = 0; i < patients.size(); ++i) {
                if (!patients.get(i).getListeMaladie().isEmpty()) System.out.println((i + 1) + ". " + patients.get(i));
            }

            int choixCreature = scanner.nextInt() - 1; // Choix de la créature à soigner
            if (choixCreature < 0 || choixCreature >= patients.size()) {
                System.out.println("Choix invalide.");
                return;
            }
            CreaturePatient patient = patients.get(choixCreature);

            // Affiche les maladies de la créature et permet de choisir laquelle soigner
            System.out.println("Choisissez la maladie à soigner :");
            ArrayList<Maladie> maladies = patient.getListeMaladie();
            for (int i = 0; i < maladies.size(); ++i) {
                System.out.println((i + 1) + ". " + maladies.get(i).getNomComplet());
            }

            int choixMaladie = scanner.nextInt() - 1; // Choix de la maladie à soigner
            if (choixMaladie < 0 || choixMaladie >= maladies.size()) {
                System.out.println("Choix invalide.");
                return;
            }
            String maladie = maladies.get(choixMaladie).getNomComplet();

            // Soigne la créature et réduit le nombre d'actions
            System.out.println("Un médecin soigne une créature de " + service.getNom() + "...");
            service.soignerCreature(patient, maladie); // Soins effectués
            actionsRestantes--; // Réduit les actions restantes
        } else {
            System.out.println("Aucune créature à soigner dans ce service.");
        }
    }

    // Méthode pour réviser le budget d'un service médical
    private void reviserBudget(Scanner scanner) {
        System.out.println("\nChoisissez un service médical pour réviser son budget :");
        // Demande un nouveau budget pour le service
        String nouveauBudget = scanner.nextLine();
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }

        int choixService = scanner.nextInt() - 1; // Lecture du choix du service
        if (choixService < 0 || choixService >= services.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        // Récupère le service sélectionné et met à jour son budget
        ServiceMedical service = services.get(choixService);
        service.reviserBudget(nouveauBudget); // Mise à jour du budget
        actionsRestantes--; // Réduit les actions restantes
    }

    // Méthode pour déplacer une créature (fonctionnalité non implémentée ici)
    private void deplacerCreature(Scanner scanner) {
        System.out.println("Fonctionnalité non implémentée pour cette version.");
    }

    // Méthode pour faire progresser d'un jour dans le jeu, avec des événements aléatoires
    private void progresserUnJour() {
        ++jour; // Incrémente le jour
        Random random = new Random();
        ArrayList<String> budgets = new ArrayList<>(Arrays.asList("Inexistant", "Mediocre", "Insuffisant", "Faible"));

        // Modifications aléatoires des créatures (par exemple, tombent malades)
        for (CreaturePatient creature : fileAttente) {
            if (random.nextBoolean()) {
                creature.tombeMalade(new Maladie()); // Création d'une maladie aléatoire
                System.out.println(creature.getNom() + " est tombé(e) malade.");
            }
        }

        // Modifications aléatoires des services médicaux (révision du budget)
        for (ServiceMedical service : services) {
            if (random.nextBoolean()) {
                service.reviserBudget(budgets.get(random.nextInt(budgets.size()))); // Mise à jour aléatoire du budget
            }
        }
    }

    // Méthode pour initialiser le jeu avec des services, des médecins et des créatures en attente
    private void initialiserJeu() {
        // Création de services médicaux
        services.add(new ServiceMedical("Service Central", 800.0f, 25, "Inexistant"));
        services.add(new CentreQuarantaine("Quarantaine Ouest", 300.0f, 10, "Inexistant"));
        services.add(new Crypte("Crypte Nord", 400.0f, 5, "Inexistant", 8, 15));

        // Création de médecins
        medecins.add(new ElfMedecin("Dr. Elrond", "M", 500));
        medecins.add(new OrqueMedecin("Dr. Gruzog", "M", 300));

        // Ajout de créatures en attente
        fileAttente.add(new OrquePatient("Grog", "M", 120.0f, 180.0f, 35, new ArrayList<>(), 10));
        fileAttente.add(new ZombiePatient("Zed", "M", 90.0f, 170.0f, 200, new ArrayList<>(), 10));
        fileAttente.add(new VampirePatient("Lestat", "M", 80.0f, 175.0f, 150, new ArrayList<>(), 10));
    }

}
