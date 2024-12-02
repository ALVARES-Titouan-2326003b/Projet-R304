package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class LycanthropePatient extends CreaturePatient implements LycanthropeInterface {
    /**
     * Constructeur de la classe LycanthropePatient.
     * @param nom Nom
     * @param sexe Sexe
     * @param poids Poids
     * @param taille taille
     * @param age âge
     * @param listeMaladie liste des maladies
     * @param indMoral indice de moral
     */
    public LycanthropePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
