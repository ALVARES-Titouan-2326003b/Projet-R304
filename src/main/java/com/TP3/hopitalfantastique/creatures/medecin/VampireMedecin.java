package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.VampireInterface;

public class VampireMedecin extends CreatureMedecin implements VampireInterface {
    /**
     * Constructeur de la classe VampireMedecin.
     * @param nom Nom du médecin
     * @param sexe Sexe du médecin
     * @param age Age du médecin
     */
    public VampireMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
