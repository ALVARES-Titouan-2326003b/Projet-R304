package com.hopitalfantastique.creatures.patient;

import com.hopitalfantastique.creatures.CreaturePatient;
import com.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;
import com.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class LycanthropePatient extends CreaturePatient implements LycanthropeInterface {
    public LycanthropePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
