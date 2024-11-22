package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;

public class LycanthropeMedecin extends CreatureMedecin implements LycanthropeInterface {
    public LycanthropeMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
