package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface NainInterface extends Race {

    // Définition d'une constante représentant la race du Nain
    String race = "Nain";

    /**
     * Méthode par défaut pour obtenir la race du Nain.
     * @return La chaîne "Nain" représentant la race du Nain
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Nain"
    }
}
