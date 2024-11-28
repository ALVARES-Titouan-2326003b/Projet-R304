package com.hopitalfantastique.creatures.medecin;

import com.hopitalfantastique.creatures.CreatureMedecin;
import com.hopitalfantastique.creatures.especesInterface.ElfInterface;

public class ElfMedecin extends CreatureMedecin implements ElfInterface {
    public ElfMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
