package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.ElfInterface;

public class ElfMedecin extends CreatureMedecin implements ElfInterface {
    /**
     * Constructeur de la classe ElfMedecin.
     * @param nom Nom du médecin
     * @param sexe Sexe du médecin
     * @param age Age du médecin
     */
    public ElfMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
