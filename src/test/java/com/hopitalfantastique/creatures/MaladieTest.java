package com.hopitalfantastique.creatures;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaladieTest {
    Maladie maladie;

    @Test
    public void testConstruct() {
        // constructeur par défaut
        maladie = new Maladie();
        assertEquals("Nouvelle Maladie", maladie.getNomComplet());
        assertEquals("Nouvelle Maladie", maladie.getNomAbrege());
        assertEquals(5, maladie.getLvlLetal());
        assertEquals(1, maladie.getLvlActuel());

        // constructeur avec nom complet et niveau létal
        maladie = new Maladie("Maladie qui fait mal", 10);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie qui fait mal", maladie.getNomAbrege());
        assertEquals(10, maladie.getLvlLetal());
        assertEquals(1, maladie.getLvlActuel());

        // constructeur avec nom complet, nom abrégé et niveau létal
        maladie = new Maladie("Maladie qui fait mal", "Maladie", 10);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie", maladie.getNomAbrege());
        assertEquals(10, maladie.getLvlLetal());
        assertEquals(1, maladie.getLvlActuel());

        // constructeur avec nom complet, niveau létal et niveau actuel
        maladie = new Maladie("Maladie qui fait mal", 10, 5);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie qui fait mal", maladie.getNomAbrege());
        assertEquals(10, maladie.getLvlLetal());
        assertEquals(5, maladie.getLvlActuel());

        // constructeur avec nom complet, nom abrégé, niveau létal et niveau actuel
        maladie = new Maladie("Maladie qui fait mal", "Maladie", 10, 5);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie", maladie.getNomAbrege());
        assertEquals(10, maladie.getLvlLetal());
        assertEquals(5, maladie.getLvlActuel());

        // constructeur complet avec un niveau létal négatif
        maladie = new Maladie("Maladie qui fait mal", "Maladie", -10, 3);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie", maladie.getNomAbrege());
        assertEquals(5, maladie.getLvlLetal());
        assertEquals(3, maladie.getLvlActuel());

        // constructeur complet avec un niveau actuel négatif
        maladie = new Maladie("Maladie qui fait mal", "Maladie", 10, -3);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie", maladie.getNomAbrege());
        assertEquals(10, maladie.getLvlLetal());
        assertEquals(1, maladie.getLvlActuel());

        // constructeur complet avec un niveau actuel supérieur au niveau létal
        maladie = new Maladie("Maladie qui fait mal", "Maladie", 3, 5);
        assertEquals("Maladie qui fait mal", maladie.getNomComplet());
        assertEquals("Maladie", maladie.getNomAbrege());
        assertEquals(3, maladie.getLvlLetal());
        assertEquals(1, maladie.getLvlActuel());
    }

    @Test
    public void testNomComplet() {
        maladie = new Maladie("Maladie 1", 10);
        assertEquals("Maladie 1", maladie.getNomComplet());
        maladie.setNomComplet("2 Maladie");
        assertEquals("2 Maladie", maladie.getNomComplet());
    }

    @Test
    public void testNomAbrege() {
        maladie = new Maladie("Maladie", "Maladie 1", 10);
        assertEquals("Maladie 1", maladie.getNomAbrege());
        maladie.setNomAbrege("2 Maladie");
        assertEquals("2 Maladie", maladie.getNomAbrege());
    }

    @Test
    public void testLvlLetal() {
        maladie = new Maladie("Maladie", 10);
        assertEquals(10, maladie.getLvlLetal());
        maladie.setLvlLetal(5);
        assertEquals(5, maladie.getLvlLetal());
    }

    @Test
    public void testLvlActuel() {
        maladie = new Maladie("Maladie", 10, 3);
        assertEquals(3, maladie.getLvlActuel());
        maladie.setLvlActuel(5);
        assertEquals(5, maladie.getLvlActuel());
    }

    @Test
    public void testEstLetal() {
        maladie = new Maladie("Maladie", 10, 9);
        // lvlActuel < lvlLetal
        assertFalse(maladie.estLetal());

        // lvlActuel == lvlLetal
        maladie.setLvlActuel(10);
        assertTrue(maladie.estLetal());

        // lvlActuel > lvlLetal
        maladie.setLvlActuel(11);
        assertTrue(maladie.estLetal());
    }
}