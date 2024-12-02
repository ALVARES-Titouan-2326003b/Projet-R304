package com.TP3.hopitalfantastique.creatures.especesInterface;

public interface ReptilienInterface extends Race {
    String race = "Reptilien";
    default String getRace() {
        return race;
    }
}
