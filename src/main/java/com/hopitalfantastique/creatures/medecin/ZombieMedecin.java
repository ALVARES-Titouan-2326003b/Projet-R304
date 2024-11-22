package java.com.hopitalfantastique.creatures.medecin;

import java.com.hopitalfantastique.creatures.CreatureMedecin;
import java.com.hopitalfantastique.creatures.especesInterface.ZombieInterface;

public class ZombieMedecin extends CreatureMedecin implements ZombieInterface {
    public ZombieMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
