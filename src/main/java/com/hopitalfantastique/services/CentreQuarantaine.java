package java.com.hopitalfantastique.services;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.util.ArrayList;

public class CentreQuarantaine extends ServiceMedical{
    private ArrayList<CreaturePatient> creaturesEnIsolation = new ArrayList<>();

    public CentreQuarantaine(String nom, float superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public void ajouterCreature(CreaturePatient creature) {
        if (creature instanceof Bestial) {
            super.ajouterCreature(creature);
        }
    }

    public ArrayList<CreaturePatient> getCreaturesEnIsolation() {
        return creaturesEnIsolation;
    }

    public void ajouterCreaturesEnIsolation(CreaturePatient creaturesEnIsolation) {
        this.creaturesEnIsolation.add(creaturesEnIsolation);
    }

    public void enleverCreaturesEnIsolation(CreaturePatient creature) {
        this.creaturesEnIsolation.remove(creature);
    }




}
