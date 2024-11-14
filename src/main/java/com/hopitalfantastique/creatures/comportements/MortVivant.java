package java.com.hopitalfantastique.creatures.comportements;

import java.com.hopitalfantastique.creatures.Creature;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public interface MortVivant {
    public default void regenere(Creature creature) {
        creature.setListeMaladie(new ArrayList<Maladie>());
        creature.setIndMoral(0);
    }
}
