package java.com.hopitalfantastique.creatures.comportements;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public interface MortVivant {
    public default void meurt(CreaturePatient creature) {
        creature.setListeMaladie(new ArrayList<Maladie>());
        creature.setIndMoral(0);
    }
}
