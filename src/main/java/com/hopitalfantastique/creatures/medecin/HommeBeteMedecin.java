package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.HommeBeteInterface;

public class HommeBeteMedecin extends CreatureMedecin implements HommeBeteInterface {
    public HommeBeteMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
