package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.NainInterface;

public class NainMedecin extends CreatureMedecin implements NainInterface {
    public NainMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
