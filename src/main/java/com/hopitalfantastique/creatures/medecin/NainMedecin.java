package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.NainInterface;

public class NainMedecin extends CreatureMedecin implements NainInterface {
    public NainMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
