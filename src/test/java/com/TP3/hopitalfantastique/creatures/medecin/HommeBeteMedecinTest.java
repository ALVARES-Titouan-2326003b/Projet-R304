package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HommeBeteMedecinTest {
    @Test
    void testGetRace() {
        CreatureMedecin medecin = new HommeBeteMedecin("Medecin", "M", 38);
        assertEquals("HommeBete", medecin.getRace());
    }
}