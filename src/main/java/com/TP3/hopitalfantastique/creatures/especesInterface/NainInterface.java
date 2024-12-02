package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface NainInterface extends Race {
    String race = "Nain";
    default String getRace() {
        return race;
    }
}
