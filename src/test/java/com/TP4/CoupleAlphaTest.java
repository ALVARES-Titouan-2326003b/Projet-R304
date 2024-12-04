package com.TP4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CoupleAlphaTest {

    private CoupleAlpha coupleAlpha;
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;
    private Meute meute;

    @BeforeEach
    void setUp() {
        maleAlpha = new Lycanthrope("Alpha1", "M", "jeune", 20, null);
        femelleAlpha = new Lycanthrope("Alpha2", "F", "jeune", 18, null);
        coupleAlpha = new CoupleAlpha(maleAlpha, femelleAlpha);
        meute = new Meute("meute1", "Bouh", coupleAlpha);
        coupleAlpha.setMeute(meute);

        meute.ajouterLycanthrope(new Lycanthrope("Beta", "M", "jeune", 15, meute));
        meute.ajouterLycanthrope(new Lycanthrope("Gamma", "F", "jeune", 22, meute));
        meute.ajouterLycanthrope(new Lycanthrope("Delta", "F", "jeune", 10, meute));
    }

    @Test
    void testGetMaleAlpha() {
        assertEquals(maleAlpha, coupleAlpha.getMaleAlpha());
    }

    @Test
    void testGetFemelleAlpha() {
        assertEquals(femelleAlpha, coupleAlpha.getFemelleAlpha());
    }

    @Test
    void testSetNewCouple() {
        Lycanthrope newMaleAlpha = new Lycanthrope("NewAlpha", "M", "jeune", 25, meute);
        coupleAlpha.setNewCouple(newMaleAlpha);

        assertEquals(newMaleAlpha, coupleAlpha.getMaleAlpha());

        Lycanthrope newFemelleAlpha = null;
        int maxForce = 0;

        for (Lycanthrope lycanthrope : meute.getLycanthropes()) {
            if (lycanthrope.getSexe().equals("F") && lycanthrope.getForce() > maxForce) {
                maxForce = lycanthrope.getForce();
                newFemelleAlpha = lycanthrope;
            }
        }

        assertEquals(newFemelleAlpha, coupleAlpha.getFemelleAlpha());
    }
}