package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.ZombieInterface;

public class ZombieMedecin extends CreatureMedecin implements ZombieInterface {
    public ZombieMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
