package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.ReptilienInterface;

public class ReptilienMedecin extends CreatureMedecin implements ReptilienInterface {
    public ReptilienMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
