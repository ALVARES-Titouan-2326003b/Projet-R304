package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface OrqueInterface extends Race {

    // Définition d'une constante représentant la race de l'Orque
    String race = "Orque";

    /**
     * Méthode par défaut pour obtenir la race de l'Orque.
     * @return La chaîne "Orque" représentant la race de l'Orque
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Orque"
    }
}
