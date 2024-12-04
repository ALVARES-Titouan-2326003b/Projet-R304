package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NainMedecinTest {
    @Test
    public void testGetRace() {
        CreatureMedecin medecin = new NainMedecin("Medecin", "M", 38);
        assertEquals("Nain", medecin.getRace());
    }
}