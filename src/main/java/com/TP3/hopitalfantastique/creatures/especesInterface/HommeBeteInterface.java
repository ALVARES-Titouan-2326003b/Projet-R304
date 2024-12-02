package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface HommeBeteInterface extends Race {

    // Définition d'une constante représentant la race de l'HommeBête
    String race = "HommeBete";

    /**
     * Méthode par défaut pour obtenir la race de l'HommeBête.
     * @return La chaîne "HommeBete" représentant la race de l'HommeBête
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "HommeBete"
    }
}
