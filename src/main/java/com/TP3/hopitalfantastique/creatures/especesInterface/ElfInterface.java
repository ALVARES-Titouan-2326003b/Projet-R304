package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface ElfInterface extends Race {

    // Définition d'une constante représentant la race de l'elfe
    String race = "Elf";

    /**
     * Méthode par défaut pour obtenir la race de l'elfe.
     * @return La chaîne "Elf" représentant la race de l'elfe
     */
    default String getRace() {
        return race;  // Retourne la constante 'race' qui est "Elf"
    }
}
