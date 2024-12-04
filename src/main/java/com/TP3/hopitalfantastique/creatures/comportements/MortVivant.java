package com.TP3.hopitalfantastique.creatures.comportements;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;

public interface MortVivant {

    /**
     * Méthode par défaut qui permet de simuler la mort d'une créature.
     * Lorsqu'une créature meurt, toutes ses maladies sont supprimées
     * et son moral est réduit à 0.
     *
     * @param creature La créature qui meurt.
     */
    default void meurt(CreaturePatient creature) {
        // Réinitialise la liste des maladies de la créature en la vidant
        creature.setListeMaladie(new ArrayList<Maladie>());

        // Réduit le moral de la créature à 0, indiquant qu'elle est "morale morte"
        creature.setIndMoral(0);
    }
}
