package com.hopitalfantastique.creatures.patient;

import com.hopitalfantastique.creatures.CreaturePatient;
import com.hopitalfantastique.creatures.especesInterface.VampireInterface;
import com.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public class VampirePatient extends CreaturePatient implements VampireInterface {
    public VampirePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
