package java.com.hopitalfantastique.creatures.patient;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public class LycanthropePatient extends CreaturePatient implements LycanthropeInterface {
    public LycanthropePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
