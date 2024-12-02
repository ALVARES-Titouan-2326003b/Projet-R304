package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.NainInterface;

public class NainMedecin extends CreatureMedecin implements NainInterface {
    public NainMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
