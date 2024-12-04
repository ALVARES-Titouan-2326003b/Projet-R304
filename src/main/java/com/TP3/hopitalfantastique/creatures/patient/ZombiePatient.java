package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.comportements.MortVivant;
import com.TP3.hopitalfantastique.creatures.comportements.Triage;
import com.TP3.hopitalfantastique.creatures.especesInterface.ZombieInterface;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class ZombiePatient extends CreaturePatient implements ZombieInterface, MortVivant, Triage {
    /**
     * Constructeur de la classe ZombiePatient.
     * @param nom Nom
     * @param sexe Sexe
     * @param poids Poids
     * @param taille taille
     * @param age âge
     * @param listeMaladie liste des maladies
     * @param indMoral indice de moral
     */
    public ZombiePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }

    @Override
    public void meurt() {
        meurt(this);
    }
}
