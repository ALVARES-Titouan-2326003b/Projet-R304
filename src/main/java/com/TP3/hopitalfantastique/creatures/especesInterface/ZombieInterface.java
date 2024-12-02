package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface ZombieInterface extends Race {

    // Définition d'une constante représentant la race du Zombie
    String race = "Zombie";

    /**
     * Méthode par défaut pour obtenir la race du Zombie.
     * @return La chaîne "Zombie" représentant la race du Zombie
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Zombie"
    }
}
