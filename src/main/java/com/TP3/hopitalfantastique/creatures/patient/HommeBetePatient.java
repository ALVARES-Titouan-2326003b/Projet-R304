package java.com.TP3.hopitalfantastique.creatures.patient;

import java.com.TP3.hopitalfantastique.creatures.CreaturePatient;
import java.com.TP3.hopitalfantastique.creatures.maladies.Maladie;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.HommeBeteInterface;
import java.util.ArrayList;

public class HommeBetePatient extends CreaturePatient implements HommeBeteInterface {
    public HommeBetePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
