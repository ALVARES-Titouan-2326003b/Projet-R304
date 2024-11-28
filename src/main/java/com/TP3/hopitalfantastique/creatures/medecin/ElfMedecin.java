package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.ElfInterface;

public class ElfMedecin extends CreatureMedecin implements ElfInterface {
    public ElfMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
