package com.TP3.hopitalfantastique.services;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.comportements.MortVivant;

public class Crypte extends ServiceMedical {

    // Attributs spécifiques à la Crypte
    private int niveauVentilation;  // Niveau de ventilation dans la crypte
    private float temperature;  // Température de la crypte

    /**
     * Constructeur de la Crypte
     * @param nom Le nom de la crypte
     * @param superficie La superficie de la crypte
     * @param capaciteMax La capacité maximale d'accueil des créatures
     * @param budget Le budget alloué à la crypte
     * @param niveauVentilation Le niveau de ventilation dans la crypte
     * @param temperature La température de la crypte
     */
    public Crypte(String nom, float superficie, int capaciteMax, String budget, int niveauVentilation, float temperature) {
        super(nom, superficie, capaciteMax, budget);  // Appel du constructeur de la classe parente (ServiceMedical)
        this.niveauVentilation = niveauVentilation;
        this.temperature = temperature;
    }

    /**
     * Getter pour le niveau de ventilation
     * @return Le niveau de ventilation
     */
    public int getNiveauVentilation() {
        return niveauVentilation;
    }

    /**
     * Setter pour le niveau de ventilation
     * @param niveauVentilation Le nouveau niveau de ventilation
     */
    public void setNiveauVentilation(int niveauVentilation) {
        this.niveauVentilation = niveauVentilation;
    }

    /**
     * Getter pour la température
     * @return La température actuelle de la crypte
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Setter pour la température
     * @param temperature La nouvelle température de la crypte
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * Méthode pour ajouter une créature dans la crypte
     * Seules les créatures de type MortVivant peuvent être ajoutées à la crypte.
     * @param creature La créature à ajouter
     * @return true si la créature a été ajoutée, false sinon
     */
    @Override
    public boolean ajouterCreature(CreaturePatient creature) {
        // Vérifie si la créature est de type MortVivant
        if (creature instanceof MortVivant) {
            // Vérifie si la capacité maximale n'est pas dépassée
            if (getListeCreatures().size() < getCapaciteMax()){
                super.ajouterCreature(creature);  // Appel de la méthode de la classe parente pour ajouter la créature
                return true;
            }
            return false;  // Retourne false si la capacité est dépassée
        }
        else return false;  // Retourne false si la créature n'est pas de type MortVivant
    }
}
