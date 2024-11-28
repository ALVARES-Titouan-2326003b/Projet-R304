package java.com.TP3.hopitalfantastique.creatures.comportements;

import java.com.TP3.hopitalfantastique.creatures.CreaturePatient;
import java.com.TP3.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public interface MortVivant {
    public default void regenere(CreaturePatient creature) {
        creature.setListeMaladie(new ArrayList<Maladie>());
        creature.setIndMoral(0);
    }
}
