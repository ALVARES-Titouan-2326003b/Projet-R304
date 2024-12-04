package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LycanthropeMedecinTest {
    @Test
    void testGetRace() {
        CreatureMedecin medecin = new LycanthropeMedecin("Medecin", "M", 38);
        assertEquals("Lycanthrope", medecin.getRace());
    }
}