package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface LycanthropeInterface extends Race {
    String race = "Lycanthrope";
    default String getRace() {
        return race;
    }
}
