package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.HommeBeteInterface;

public class HommeBeteMedecin extends CreatureMedecin implements HommeBeteInterface {
    public HommeBeteMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
