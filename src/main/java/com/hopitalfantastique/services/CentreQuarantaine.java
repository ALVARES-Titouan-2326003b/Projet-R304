package java.com.hopitalfantastique.services;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.comportements.Bestial;

public class CentreQuarantaine extends ServiceMedical{
    public CentreQuarantaine(String nom, float superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public void ajouterCreature(CreaturePatient creature) {
        if (creature instanceof Bestial) {}
        super.ajouterCreature(creature);
    }
}
