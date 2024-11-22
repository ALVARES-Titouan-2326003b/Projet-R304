package java.com.hopitalfantastique.creatures.patient;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.especesInterface.VampireInterface;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public class VampirePatient extends CreaturePatient implements VampireInterface {
    public VampirePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
