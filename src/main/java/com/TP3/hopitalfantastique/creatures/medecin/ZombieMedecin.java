package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.ZombieInterface;

public class ZombieMedecin extends CreatureMedecin implements ZombieInterface {
    public ZombieMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
