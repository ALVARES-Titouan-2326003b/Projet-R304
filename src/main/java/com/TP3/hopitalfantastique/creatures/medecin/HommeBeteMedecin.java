package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.HommeBeteInterface;

public class HommeBeteMedecin extends CreatureMedecin implements HommeBeteInterface {
    public HommeBeteMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
