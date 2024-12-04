package com.TP4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ColonieTest {

    private Colonie colonie;
    private Meute meute1;
    private Meute meute2;

    @BeforeEach
    void setUp() {
        Lycanthrope m1 = new Lycanthrope("Alpha1", "M", "adulte", 10, null);
        Lycanthrope f1 = new Lycanthrope("AlphaF1", "F", "adulte", 8, null);
        CoupleAlpha c1 = new CoupleAlpha(m1,f1);
        meute1 = new Meute("Meute1", "bouh", c1 );
        m1.setMeute(meute1);
        f1.setMeute(meute1);

        Lycanthrope m2 = new Lycanthrope("Alpha2", "M", "adulte", 12, null);
        Lycanthrope f2 = new Lycanthrope("AlphaF2", "F", "adulte", 9, null);
        CoupleAlpha c2 = new CoupleAlpha(m2,f2);
        meute2 = new Meute("Meute2", "wouh", c2);
        m2.setMeute(meute2);
        f2.setMeute(meute2);

        ArrayList<Meute> meutes = new ArrayList<>();
        meutes.add(meute1);
        colonie = new Colonie(meutes, "ete");
    }

    @Test
    void testAjouteMeute() {
        colonie.ajouteMeute(meute2);

        assertEquals(2, colonie.getMeute().size());
        assertTrue(colonie.getMeute().contains(meute2));
    }

    @Test
    void testSupprMeute() {
        colonie.supprMeute(meute1);

        assertEquals(0, colonie.getMeute().size());
        assertFalse(colonie.getMeute().contains(meute1));
    }

    @Test
    void testToString() {
        String result = colonie.toString();

        assertTrue(result.contains("Colonie{"));
        assertTrue(result.contains("Meute1"));
    }

    @Test
    void testPasseSaisonEte() {
        colonie.passeSaison();

        assertEquals("automne", colonie.getSaison());
        assertEquals("Alpha1", meute1.getCouple().getMaleAlpha().getNom());
    }

    @Test
    void testPasseSaisonAutomne() {
        colonie.setSaison("automne");
        colonie.passeSaison();

        assertEquals("hiver", colonie.getSaison());
        assertTrue(meute1.getLycanthropes().stream().allMatch(l -> l.getCatAge().equals("adulte") || l.getCatAge().equals("vieux")));
    }

    @Test
    void testPasseSaisonHiver() {
        colonie.setSaison("hiver");
        colonie.passeSaison();

        assertEquals("printemps", colonie.getSaison());
        assertNotNull(meute1.getCouple().getMaleAlpha());
    }



}