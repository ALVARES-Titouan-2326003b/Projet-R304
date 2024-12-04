package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.comportements.Bestial;
import com.TP3.hopitalfantastique.creatures.comportements.Triage;
import com.TP3.hopitalfantastique.creatures.especesInterface.OrqueInterface;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class OrquePatient extends CreaturePatient implements OrqueInterface, Bestial, Triage {
    /**
     * Constructeur de la classe OrquePatient.
     * @param nom Nom
     * @param sexe Sexe
     * @param poids Poids
     * @param taille taille
     * @param age âge
     * @param listeMaladie liste des maladies
     * @param indMoral indice de moral
     */
    public OrquePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }

    @Override
    public double getFactContamination() {
        return factContamination;
    }
}
