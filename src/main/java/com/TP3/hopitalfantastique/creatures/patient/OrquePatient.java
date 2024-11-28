package java.com.TP3.hopitalfantastique.creatures.patient;

import java.com.TP3.hopitalfantastique.creatures.CreaturePatient;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.OrqueInterface;
import java.com.TP3.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public class OrquePatient extends CreaturePatient implements OrqueInterface {
    public OrquePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
