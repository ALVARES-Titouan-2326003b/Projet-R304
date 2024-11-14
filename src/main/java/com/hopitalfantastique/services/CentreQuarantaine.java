package main.java.com.hopitalfantastique.services;

import java.com.hopitalfantastique.creatures.Creature;

public class CentreQuarantaine extends ServiceMedical{
    public CentreQuarantaine(String nom, float superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (creature instanceof Bes) {}
        super.ajouterCreature(creature);
    }
}
