package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.VampireInterface;

public class VampireMedecin extends CreatureMedecin implements VampireInterface {
    public VampireMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
