package com.hopitalfantastique.creatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureMedecinTest {
    CreatureMedecin creatureMedecin;

    @BeforeEach
    void setUp() {
        creatureMedecin = new CreatureMedecin("Creature Medecin", "Homme?", 51) {
            @Override
            public String getRace() {
                return "Medecin";
            }
        };
    }

    @Test
    public void testNom() {
        assertEquals("Creature Medecin", creatureMedecin.getNom());
        creatureMedecin.setNom("Juste Medecin");
        assertEquals("Juste Medecin", creatureMedecin.getNom());
    }

    @Test
    public void testSexe() {
        assertEquals("Homme?", creatureMedecin.getSexe());
        creatureMedecin.setSexe("Femme?");
        assertEquals("Femme?", creatureMedecin.getSexe());
    }

    @Test
    public void testAge() {
        assertEquals(51, creatureMedecin.getAge());
        creatureMedecin.setAge(23);
        assertEquals(23, creatureMedecin.getAge());
    }

    @Test
    public void testToString() {
        assertEquals("Creature Medecin Homme? 51", creatureMedecin.toString());
    }

    @Test
    public void testGetRace() {
        assertEquals("Medecin", creatureMedecin.getRace());
    }

    /* FAIRE LE RESTE DES TESTS AVEC LES CREATURES ET LES SERVICES */
}