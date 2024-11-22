package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.ReptilienInterface;

public class ReptilienMedecin extends CreatureMedecin implements ReptilienInterface {
    public ReptilienMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
