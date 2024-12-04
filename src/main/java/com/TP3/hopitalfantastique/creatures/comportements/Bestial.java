package com.TP3.hopitalfantastique.creatures.comportements;

public interface Bestial {

    // Les créatures bestiales ont plus de chances de contaminer d'autres créatures, on augmente leur facteur de contamination
    double factContamination = 0.3;

    double getFactContamination();
}
