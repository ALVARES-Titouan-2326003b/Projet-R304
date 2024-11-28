package java.com.TP3.hopitalfantastique.creatures.medecin;

import java.com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import java.com.TP3.hopitalfantastique.creatures.especesInterface.ZombieInterface;

public class ZombieMedecin extends CreatureMedecin implements ZombieInterface {
    public ZombieMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
