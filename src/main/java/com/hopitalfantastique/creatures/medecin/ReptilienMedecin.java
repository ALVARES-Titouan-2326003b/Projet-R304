package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.ReptilienInterface;

public class ReptilienMedecin extends CreatureMedecin implements ReptilienInterface {
    public ReptilienMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
