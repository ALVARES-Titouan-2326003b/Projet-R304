package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.OrqueInterface;

public class OrqueMedecin extends CreatureMedecin implements OrqueInterface {
    public OrqueMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
