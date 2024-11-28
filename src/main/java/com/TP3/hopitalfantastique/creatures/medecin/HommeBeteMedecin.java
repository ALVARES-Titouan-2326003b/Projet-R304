package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.HommeBeteInterface;

public class HommeBeteMedecin extends CreatureMedecin implements HommeBeteInterface {
    public HommeBeteMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
