package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.NainInterface;

public class NainMedecin extends CreatureMedecin implements NainInterface {
    public NainMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
