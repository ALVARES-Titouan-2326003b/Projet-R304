package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VampireMedecinTest {
    @Test
    public void testGetRace() {
        CreatureMedecin medecin = new VampireMedecin("Medecin", "M", 38);
        assertEquals("Vampire", medecin.getRace());
    }
}