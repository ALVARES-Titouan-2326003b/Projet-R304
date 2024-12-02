package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;

public class LycanthropeMedecin extends CreatureMedecin implements LycanthropeInterface {
    public LycanthropeMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
