package com.TP3.hopitalfantastique.services;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public class ServiceMedical {
    private String nom;
    private float superficie;
    private int capaciteMax;
    private int nombreCreature;
    private ArrayList<CreaturePatient> listeCreatures;
    private String budget;

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
        nombreCreature = 0;
        this.budget = budget;
        listeCreatures = new ArrayList<>();
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
            listeCreatures.add(creature);
            nombreCreature++;
            return true;
        }
        else return false;
    }

    /**
     * Méthode pour enlever une créature du service médical
     * @param creature La créature à enlever
     */
    public void enleverCreature(CreaturePatient creature) {
        listeCreatures.remove(creature);
        nombreCreature--;
    }

    /**
     * Méthode pour soigner une créature
     * @param creature La créature à soigner
     * @param maladie Le nom de la maladie à traiter
     */
    public void soignerCreature(CreaturePatient creature, String maladie) {
        creature.estSoignee(maladie);
    }

    /**
     * Méthode pour réviser le budget du service médical
     * @param budget Le nouveau budget
     */
    public void reviserBudget(String budget) {
        this.budget = budget;
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
            sb.append("Aucune créature présente.\n");
        }
        else {
            for (CreaturePatient creature : listeCreatures) {
                sb.append(creature.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
