package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import com.TP3.hopitalfantastique.creatures.especesInterface.ZombieInterface;

public class ZombieMedecin extends CreatureMedecin implements ZombieInterface {
    /**
     * Constructeur de la classe ZombieMedecin.
     * @param nom Nom du médecin
     * @param sexe Sexe du médecin
     * @param age Age du médecin
     */
    public ZombieMedecin(String nom, String sexe, int age) {
        super(nom, sexe, age);
    }
}
