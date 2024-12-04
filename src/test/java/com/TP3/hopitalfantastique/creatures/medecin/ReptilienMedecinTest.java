package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReptilienMedecinTest {
    @Test
    public void testGetRace() {
        CreatureMedecin medecin = new ReptilienMedecin("Medecin", "M", 38);
        assertEquals("Reptilien", medecin.getRace());
    }
}