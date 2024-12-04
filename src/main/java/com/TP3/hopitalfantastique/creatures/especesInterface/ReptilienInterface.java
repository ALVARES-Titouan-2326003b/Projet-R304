package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface ReptilienInterface extends Race {

    // Définition d'une constante représentant la race du Reptilien
    String race = "Reptilien";

    /**
     * Méthode par défaut pour obtenir la race du Reptilien.
     * @return La chaîne "Reptilien" représentant la race du Reptilien
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Reptilien"
    }
}
