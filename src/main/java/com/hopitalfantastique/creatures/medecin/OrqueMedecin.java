package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.OrqueInterface;

public class OrqueMedecin extends CreatureMedecin implements OrqueInterface {
    public OrqueMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
