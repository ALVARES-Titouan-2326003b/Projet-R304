package com.TP3.hopitalfantastique.creatures.medecin;

import com.TP3.hopitalfantastique.creatures.CreatureMedecin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfMedecinTest {
    @Test
    void testGetRace() {
        CreatureMedecin medecin = new ElfMedecin("Medecin", "M", 38);
        assertEquals("Elf", medecin.getRace());
    }
}