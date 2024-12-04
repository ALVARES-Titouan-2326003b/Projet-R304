package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.HommeBeteInterface;

public class HommeBeteMedecin extends CreatureMedecin implements HommeBeteInterface {
    /**
     * Constructeur de la classe HommeBeteMedecin.
     * @param nom Nom du médecin
     * @param sexe Sexe du médecin
     * @param age Age du médecin
     */
    public HommeBeteMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
