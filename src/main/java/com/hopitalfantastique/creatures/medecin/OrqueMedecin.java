package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.OrqueInterface;

public class OrqueMedecin extends CreatureMedecin implements OrqueInterface {
    public OrqueMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
