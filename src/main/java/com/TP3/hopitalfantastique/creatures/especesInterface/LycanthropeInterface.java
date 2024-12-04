package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface LycanthropeInterface extends Race {

    // Définition d'une constante représentant la race du Lycanthrope
    String race = "Lycanthrope";

    /**
     * Méthode par défaut pour obtenir la race du Lycanthrope.
     * @return La chaîne "Lycanthrope" représentant la race du Lycanthrope
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Lycanthrope"
    }
}
