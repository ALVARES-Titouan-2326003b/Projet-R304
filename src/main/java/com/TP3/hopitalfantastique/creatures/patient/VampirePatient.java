package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.comportements.Bestial;
import com.TP3.hopitalfantastique.creatures.comportements.Demoralisateur;
import com.TP3.hopitalfantastique.creatures.comportements.MortVivant;
import com.TP3.hopitalfantastique.creatures.comportements.Prioritaire;
import com.TP3.hopitalfantastique.creatures.especesInterface.VampireInterface;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class VampirePatient extends CreaturePatient implements VampireInterface, Demoralisateur, Bestial, MortVivant, Prioritaire {
    /**
     * Constructeur de la classe VampirePatient.
     * @param nom Nom
     * @param sexe Sexe
     * @param poids Poids
     * @param taille taille
     * @param age âge
     * @param listeMaladie liste des maladies
     * @param indMoral indice de moral
     */
    public VampirePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }

    /**
     * Override getFactContamination()
     * @return factContamination, qui vaut 0.3 pour les créatures bestiales
     */
    @Override
    public double getFactContamination() {
        return factContamination;
    }

    /**
     * La créature meurt, démoralise une partie de son service médical, et est retirée du service médical.
     */
    @Override
    public void meurt() {
        if (super.getService() != null) {
            demoralise(this);
            super.getService().enleverCreature(this);  // Si elle est dans un service, elle est enlevée de ce service
            super.setService(null);
        }
    }
}
