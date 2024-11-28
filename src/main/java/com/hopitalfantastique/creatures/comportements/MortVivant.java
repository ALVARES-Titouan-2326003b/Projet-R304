package com.hopitalfantastique.creatures.comportements;

import com.hopitalfantastique.creatures.CreaturePatient;
import com.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public interface MortVivant {
    public default void meurt(CreaturePatient creature) {
        creature.setListeMaladie(new ArrayList<Maladie>());
        creature.setIndMoral(0);
    }
}
