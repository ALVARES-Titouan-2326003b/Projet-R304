package java.com.hopitalfantastique.creatures.patient;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.especesInterface.ReptilienInterface;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public class ReptilienPatient extends CreaturePatient implements ReptilienInterface {
    public ReptilienPatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        super(nom, sexe, poids, taille, age, listeMaladie, indMoral);
    }
}
