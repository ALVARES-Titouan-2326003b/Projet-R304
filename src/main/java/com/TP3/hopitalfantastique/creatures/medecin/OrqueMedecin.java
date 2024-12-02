package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.OrqueInterface;

public class OrqueMedecin extends CreatureMedecin implements OrqueInterface {
    public OrqueMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
