package com.TP3.hopitalfantastique.creatures.comportements;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public interface MortVivant {
    public default void meurt(CreaturePatient creature) {
        creature.setListeMaladie(new ArrayList<Maladie>());
        creature.setIndMoral(0);
    }
}
