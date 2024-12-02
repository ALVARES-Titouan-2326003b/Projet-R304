package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.VampireInterface;

public class VampireMedecin extends CreatureMedecin implements VampireInterface {
    public VampireMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
