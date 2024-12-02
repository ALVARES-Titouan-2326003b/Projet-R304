package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface VampireInterface extends Race {

    // Définition d'une constante représentant la race du Vampire
    String race = "Vampire";

    /**
     * Méthode par défaut pour obtenir la race du Vampire.
     * @return La chaîne "Vampire" représentant la race du Vampire
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Vampire"
    }
}
