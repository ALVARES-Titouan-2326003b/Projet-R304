package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.comportements.Demoralisateur;
import com.TP3.hopitalfantastique.creatures.comportements.Prioritaire;
import com.TP3.hopitalfantastique.creatures.especesInterface.ElfInterface;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class ElfPatient extends CreaturePatient implements ElfInterface, Demoralisateur, Prioritaire {

    /**
     * Constructeur de la classe ElfPatient.
     * @param nom Nom
     * @param sexe Sexe
     * @param poids Poids
     * @param taille taille
     * @param age âge
     * @param listeMaladie liste des maladies
     * @param indMoral indice de moral
     */

    public ElfPatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
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
