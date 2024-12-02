package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.ReptilienInterface;

public class ReptilienMedecin extends CreatureMedecin implements ReptilienInterface {
    /**
     * Constructeur de la classe ReptilienMedecin.
     * @param nom Nom du médecin
     * @param sexe Sexe du médecin
     * @param age Age du médecin
     */
    public ReptilienMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
