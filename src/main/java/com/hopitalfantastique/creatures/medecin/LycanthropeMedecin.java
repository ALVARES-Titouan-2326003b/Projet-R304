package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;

public class LycanthropeMedecin extends CreatureMedecin implements LycanthropeInterface {
    public LycanthropeMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
