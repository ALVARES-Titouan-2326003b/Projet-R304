package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;

public class LycanthropeMedecin extends CreatureMedecin implements LycanthropeInterface {
    public LycanthropeMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
