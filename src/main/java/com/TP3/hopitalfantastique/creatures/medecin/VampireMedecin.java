package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.VampireInterface;

public class VampireMedecin extends CreatureMedecin implements VampireInterface {
    public VampireMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
