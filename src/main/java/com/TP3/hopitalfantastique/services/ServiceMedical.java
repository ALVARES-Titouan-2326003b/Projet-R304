package com.TP3.hopitalfantastique.services;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public class ServiceMedical {

    // Attributs généraux du service médical
    private String nom;  // Nom du service médical
    private float superficie;  // Superficie du service médical (en m²)
    private int capaciteMax;  // Capacité maximale du service médical
    private int nombreCreature;  // Nombre actuel de créatures dans le service médical
    private ArrayList<CreaturePatient> listeCreatures;  // Liste des créatures présentes dans le service médical
    private String budget;  // Budget alloué au service médical

    /**
     * Constructeur du service médical
     * @param nom Le nom du service médical
     * @param superficie La superficie du service médical
     * @param capaciteMax La capacité maximale du service médical
     * @param budget Le budget alloué au service médical
     */
    public ServiceMedical(String nom, float superficie, int capaciteMax, String budget) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        nombreCreature = 0;  // Initialisation du nombre de créatures à 0
        this.budget = budget;
        listeCreatures = new ArrayList<>();  // Initialisation de la liste des créatures
    }

    /**
     * Getter pour obtenir la liste des créatures présentes dans le service médical
     * @return Liste des créatures présentes
     */
    public ArrayList<CreaturePatient> getListeCreatures() {
        return listeCreatures;
    }

    /**
     * Getter pour obtenir le nom du service médical
     * @return Nom du service médical
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter pour obtenir la capacité maximale du service médical
     * @return Capacité maximale
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }

    /**
     * Getter pour obtenir le nombre actuel de créatures dans le service médical
     * @return Nombre de créatures
     */
    public int getNombreCreature() {
        return nombreCreature;
    }

    /**
     * Incrémente le nombre de créatures dans le service médical
     */
    public void setNombreCreature() {
        this.nombreCreature++;  // Incrémente le nombre de créatures
    }

    /**
     * Méthode pour ajouter une créature au service médical
     * @param creature La créature à ajouter
     * @return true si la créature a été ajoutée, false si la capacité est dépassée
     */
    public boolean ajouterCreature(CreaturePatient creature) {
        if (listeCreatures.size() < capaciteMax) {
            listeCreatures.add(creature);  // Ajoute la créature à la liste
            nombreCreature++;  // Incrémente le nombre de créatures
            return true;
        }
        else return false;  // Retourne false si la capacité est dépassée
    }

    /**
     * Méthode pour enlever une créature du service médical
     * @param creature La créature à enlever
     */
    public void enleverCreature(CreaturePatient creature) {
        listeCreatures.remove(creature);  // Supprime la créature de la liste
        nombreCreature--;  // Décrémente le nombre de créatures
    }

    /**
     * Méthode pour soigner une créature
     * @param creature La créature à soigner
     * @param maladie Le nom de la maladie à traiter
     */
    public void soignerCreature(CreaturePatient creature, String maladie) {
        creature.estSoignee(maladie);  // Appelle la méthode pour soigner la créature
    }

    /**
     * Méthode pour réviser le budget du service médical
     * @param budget Le nouveau budget
     */
    public void reviserBudget(String budget) {
        this.budget = budget;  // Met à jour le budget du service
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères du service médical
     * @return Description du service médical sous forme de chaîne
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Service Médical :\n");
        sb.append("Nom : ").append(nom).append("\n");
        sb.append("Superficie : ").append(superficie).append(" m²\n");
        sb.append("Capacité maximale : ").append(capaciteMax).append("\n");
        sb.append("Nombre de créatures présentes : ").append(nombreCreature).append("\n");
        sb.append("Budget : ").append(budget).append("\n");

        sb.append("Créatures présentes :\n");
        if (listeCreatures.isEmpty()) {
            sb.append("Aucune créature présente.\n");  // Si aucune créature, mentionne qu'il n'y en a pas
        }
        else {
            for (CreaturePatient creature : listeCreatures) {
                sb.append(creature.toString()).append("\n");  // Affiche les détails de chaque créature
            }
        }
        return sb.toString();  // Retourne la description complète du service médical
    }
}
