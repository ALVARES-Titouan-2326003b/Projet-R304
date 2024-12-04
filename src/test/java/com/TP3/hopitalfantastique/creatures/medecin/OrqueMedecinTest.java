package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrqueMedecinTest {
    @Test
    void testGetRace() {
        CreatureMedecin medecin = new OrqueMedecin("Medecin", "M", 38);
        assertEquals("Orque", medecin.getRace());
    }
}