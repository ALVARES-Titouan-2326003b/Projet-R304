package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.LycanthropeInterface;

public class LycanthropeMedecin extends CreatureMedecin implements LycanthropeInterface {
    /**
     * Constructeur de la classe LycanthropeMedecin.
     * @param nom Nom du médecin
     * @param sexe Sexe du médecin
     * @param age Age du médecin
     */
    public LycanthropeMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
