package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.VampireInterface;

public class VampireMedecin extends CreatureMedecin implements VampireInterface {
    public VampireMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
