package com.TP3.hopitalfantastique.creatures;

import com.TP3.hopitalfantastique.creatures.especesInterface.Race;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import java.util.ArrayList;
import java.util.Random;

public abstract class CreaturePatient implements Race {
    private String nom;          // Nom de la créature
    private String sexe;         // Sexe de la créature
    private float poids;         // Poids de la créature
    private float taille;        // Taille de la créature
    private int age;             // Âge de la créature
    private int indMoral;        // Indicateur de moral de la créature
    private int numHurlement;    // Compteur du nombre de hurlements
    private ArrayList<Maladie> listeMaladie;  // Liste des maladies de la créature
    private ServiceMedical service;  // Service médical auquel la créature est associée
    private double factContamination;   // Facteur de contamination correspondant à la probabilité de contaminer une autre créature

    /**
     * Constructeur pour initialiser les attributs de la créature patient.
     * @param nom Le nom de la créature
     * @param sexe Le sexe de la créature
     * @param poids Le poids de la créature
     * @param taille La taille de la créature
     * @param age L'âge de la créature
     * @param listeMaladie Liste des maladies de la créature
     * @param indMoral L'indicateur de moral de la créature
     */
    public CreaturePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.listeMaladie = listeMaladie;
        this.indMoral = indMoral;
        this.numHurlement = 0;   // Initialisation du nombre de hurlements à 0
        this.service = null;     // Initialisation du service médical à null
        this.factContamination = 0.15;  // Initialisation du facteur de contamination à 0.15
    }

    // Getters et Setters pour chaque attribut

    public int getNumHurlement() {
        return numHurlement;
    }

    public void setNumHurlement(int numHurlement) {
        this.numHurlement = numHurlement;
    }

    public ServiceMedical getService() {
        return service;
    }

    public void setService(ServiceMedical service) {
        this.service = service;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndMoral() {
        return indMoral;
    }

    public void setIndMoral(int indMoral) {
        this.indMoral = indMoral;
    }

    public void setListeMaladie(ArrayList<Maladie> listeMaladie) {
        this.listeMaladie = listeMaladie;
    }

    public ArrayList<Maladie> getListeMaladie() {
        return listeMaladie;
    }

    public double getFactContamination() {
        return factContamination;
    }

    public void setFactContamination(double factContamination) {
        this.factContamination = factContamination;
    }

    /**
     * La créature attend, si son moral est positif, il baisse. Si son moral est nul ou négatif, elle hurle.
     */
    public void attendre() {
        if (indMoral > 0) {
            --indMoral;   // Diminue l'indicateur de moral
        } else {
            hurler();     // Si le moral est faible, la créature hurle
        }
    }

    /**
     * La créature hurle. Si elle a déjà hurlé plus de 3 fois, elle se met en colère.
     */
    public void hurler() {
        if (numHurlement > 3) {
            semporte();  // Si la créature a trop hurlé, elle se met en colère
        } else {
            ++numHurlement;  // Incrémente le nombre de hurlements
        }
    }

    /**
     * La créature se met en colère et contamine d'autres créatures du service.
     */
    public void semporte() {
        if (service == null) return;  // Si la créature n'est associée à aucun service, rien ne se passe
        Random rand = new Random();
        int nombreAContaminer = rand.nextInt(3)+1;  // Choisit aléatoirement combien de fois la créature va contaminer (entre 1 et 3, tous les deux inclus)
        for (int i = 0; i < nombreAContaminer; ++i) { contamine(); }
    }

    /**
     * Méthode par défaut qui permet de contaminer une créature avec une maladie.
     * Elle choisit aléatoirement une maladie d'une créature et essaie de la transmettre
     * à une autre créature qui ne possède pas encore cette maladie.
     * Si la créature choisie a déjà la maladie, la méthode réessaie jusqu'à ce qu'elle en trouve une autre.
     * Si toutes les créatures ont déjà la maladie, la méthode augmente le niveau de la maladie de la créature choisie.
     */
    public void contamine() {
        if (service == null) return; // Si la créature n'est associée à aucun service, rien ne se passe

        Random rd = new Random();  // Création d'un générateur de nombres aléatoires

        // Choisit une maladie aléatoire parmi celles de la créature
        Maladie maladie = listeMaladie.get(rd.nextInt(listeMaladie.size()));

        // Récupère la liste des créatures dans le même service médical
        ArrayList<CreaturePatient> listeCreatures = (ArrayList<CreaturePatient>) service.getListeCreatures().clone();

        // Choisit une créature aléatoire parmi les autres créatures du service
        CreaturePatient aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));

        // Si la créature choisie possède déjà la maladie, on en choisit une autre
        while (aContaminer.possedeMaladie(maladie.getNomComplet())) {
            listeCreatures.remove(aContaminer);  // Retire la créature de la liste des choix

            // Si toutes les créatures ont déjà la maladie, on augmente le niveau de la maladie de la créature choisie
            if (listeCreatures.isEmpty()) {
                for (Maladie maladie1 : aContaminer.getListeMaladie()) {
                    if (maladie1.getNomComplet().equals(maladie.getNomComplet())) {
                        maladie1.setLvlActuel(maladie.getLvlActuel() + 1);  // Augmente le niveau de la maladie
                        return;  // Fin de la méthode
                    }
                }
            }

            // Si une autre créature peut être choisie, on le fait
            aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        }

        // Si la créature choisie n'a pas la maladie, elle la contracte
        aContaminer.tombeMalade(new Maladie(maladie.getNomComplet(), maladie.getNomAbrege(), maladie.getLvlLetal()));
    }

    /**
     * La créature tombe malade en ajoutant une nouvelle maladie à sa liste de maladies.
     * @param maladie La maladie que la créature contracte
     */
    public void tombeMalade(Maladie maladie) {
        // Vérifie si la créature possède déjà cette maladie
        for (Maladie maladie1 : listeMaladie) {
            if (maladie1.getNomComplet().equals(maladie.getNomComplet())) {
                return;  // Si elle a déjà la maladie, rien n'est fait
            }
        }
        listeMaladie.add(maladie);  // Ajoute la maladie à la liste
    }

    /**
     * La créature est soignée et la maladie est retirée de sa liste.
     * @param nomMaladieComplet Le nom complet de la maladie à retirer
     */
    public void estSoignee(String nomMaladieComplet) {
        // Cherche la maladie à soigner et la retire de la liste
        ArrayList<Maladie> aRetirer = new ArrayList<>();
        for (Maladie maladie : listeMaladie) {
            if (maladie.getNomComplet().equals(nomMaladieComplet)) {
                aRetirer.add(maladie);
            }
        }
        for (Maladie maladie : aRetirer) listeMaladie.remove(maladie);
    }

    /**
     * Vérifie si la créature possède une certaine maladie.
     * @param nomMaladieComplet Le nom complet de la maladie à vérifier
     * @return true si la créature possède la maladie, false sinon
     */
    public boolean possedeMaladie(String nomMaladieComplet) {
        for (Maladie maladie1 : listeMaladie) {
            if (maladie1.getNomComplet().equals(nomMaladieComplet)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne une représentation textuelle de la créature avec ses caractéristiques.
     * @return La description complète de la créature
     */
    public String toString () {
        return nom + " " + sexe + " " + poids + " " + taille + " " + indMoral + " " + age + " " + listeMaladie.toString();
    }

    /**
     * La créature meurt et est retirée du service médical.
     */
    public void meurt() {
        if (service != null) {
            service.enleverCreature(this);  // Si elle est dans un service, elle est enlevée de ce service
            service = null;
        }
    }
}
