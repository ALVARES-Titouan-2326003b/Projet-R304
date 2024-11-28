package com.hopitalfantastique.creatures.especesInterface;

public interface OrqueInterface extends Race {
    String race = "Orque";
    default String getRace() {
        return race;
    }
}
