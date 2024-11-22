package main.java.com.hopitalfantastique.services;

import java.com.hopitalfantastique.creatures.Creature;
import java.util.ArrayList;

public class CentreQuarantaine extends ServiceMedical{
    private ArrayList<Creature> creaturesEnIsolation = new ArrayList<>();

    public CentreQuarantaine(String nom, float superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (creature instanceof Bestial) {
            super.ajouterCreature(creature);
        }
    }

    public ArrayList<Creature> getCreaturesEnIsolation() {
        return creaturesEnIsolation;
    }

    public void ajouterCreaturesEnIsolation(Creature creaturesEnIsolation) {
        this.creaturesEnIsolation.add(creaturesEnIsolation);
    }

    public void enleverCreaturesEnIsolation(Creature creature) {
        this.creaturesEnIsolation.remove(creature);
    }




}
