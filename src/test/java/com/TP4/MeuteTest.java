package com.TP4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MeuteTest {

    private Meute meute;
    private CoupleAlpha coupleAlpha;
    private Lycanthrope alpha1;
    private Lycanthrope alpha2;

    @BeforeEach
    void setUp() {
        alpha1 = new Lycanthrope("Alpha1", "M", "jeune", 20, null);
        alpha2 = new Lycanthrope("Alpha2", "F", "jeune", 18, null);
        coupleAlpha = new CoupleAlpha(alpha1, alpha2);
        meute = new Meute("meute1", "bouh", coupleAlpha);
    }

    @Test
    void testAjouterLycanthrope() {
        Lycanthrope l1 = new Lycanthrope("Beta", "M", "jeune", 15, meute);
        meute.ajouterLycanthrope(l1);

        assertTrue(meute.getLycanthropes().contains(l1));
        assertEquals(meute, l1.getMeute());
    }

    @Test
    void testEnleverLycanthrope() {
        Lycanthrope l1 = new Lycanthrope("Beta", "M", "jeune", 15, meute);
        meute.ajouterLycanthrope(l1);
        meute.enleverLycanthrope(l1);

        assertFalse(meute.getLycanthropes().contains(l1));
        assertNull(l1.getMeute());
    }


    @Test
    void testQuicksortMeute() {
        Lycanthrope gamma = new Lycanthrope("Gamma", "F", "jeune", 10, meute);
        Lycanthrope beta = new Lycanthrope("Beta", "M", "jeune", 15, meute);
        Lycanthrope delta = new Lycanthrope("Delta", "M", "jeune", 8, meute);
        beta.setRang("β");
        gamma.setRang("γ");
        delta.setRang("δ");

        meute.ajouterLycanthrope(gamma);
        meute.ajouterLycanthrope(beta);
        meute.ajouterLycanthrope(delta);

        meute.quicksortMeute(0, meute.getLycanthropes().size() - 1);

        ArrayList<Lycanthrope> meuteTrie = meute.getLycanthropes();
        assertEquals("β", meuteTrie.get(0).getRang());
        assertEquals("γ", meuteTrie.get(1).getRang());
        assertEquals("δ", meuteTrie.get(2).getRang());
    }


    @Test
    void testFaitVieillir() {
        Lycanthrope jeune = new Lycanthrope("Jeune", "M", "jeune", 10, meute);
        meute.ajouterLycanthrope(jeune);

        meute.faitVieillir();
        assertEquals("adulte", jeune.getCatAge());
    }

}
