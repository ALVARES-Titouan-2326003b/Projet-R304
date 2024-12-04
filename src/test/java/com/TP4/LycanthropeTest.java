package com.TP4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*class LycanthropeTest {
        private Lycanthrope lycanthrope;
        private Meute meute;

        @BeforeEach
        void setUp() {
            meute = new Meute("meute1", "bouh", null);
            lycanthrope = new Lycanthrope("Thomas", "M", "jeune", 10);
            lycanthrope.setMeute(meute);
        }

        @Test
        void testInitialAttributes() {
            assertEquals("Thomas", lycanthrope.getNom());
            assertEquals("M", lycanthrope.getSexe());
            assertEquals("jeune", lycanthrope.getCatAge());
            assertEquals(10, lycanthrope.getForce());
            assertEquals("ω", lycanthrope.getRang());
            assertEquals(0, lycanthrope.getFacteureDomination());
            assertEquals(meute, lycanthrope.getMeute());
        }

        @Test
        void testSetters() {
            lycanthrope.setSexe("F");
            lycanthrope.setCatAge("adulte");
            lycanthrope.setForce(20);
            lycanthrope.setFacteureDomination(5);
            lycanthrope.setRang("β");

            assertEquals("F", lycanthrope.getSexe());
            assertEquals("adulte", lycanthrope.getCatAge());
            assertEquals(20, lycanthrope.getForce());
            assertEquals(5, lycanthrope.getFacteureDomination());
            assertEquals("β", lycanthrope.getRang());
        }

        @Test
        void testCalculNiveau() {
            assertEquals(1 + (24 - "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf("ω")) + 10, lycanthrope.calculNiveau());
            lycanthrope.setCatAge("adulte");
            lycanthrope.setForce(20);
            lycanthrope.setFacteureDomination(5);
            assertEquals(10 + (24 - "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf("ω")) + 20 + 5, lycanthrope.calculNiveau());
        }

        @Test
        void testVieillir() {
            assertEquals("jeune", lycanthrope.getCatAge());
            lycanthrope.vieillir();
            assertEquals("adulte", lycanthrope.getCatAge());

            lycanthrope.vieillir();
            assertEquals("vieux", lycanthrope.getCatAge());

            lycanthrope.vieillir();
            assertNull(lycanthrope.getMeute());
        }

        @Test
        void testQuitteMeute() {
            assertNotNull(lycanthrope.getMeute());
            lycanthrope.quitteMeute();
            assertNull(lycanthrope.getMeute());
            assertNull(lycanthrope.getRang());
            assertEquals(0, lycanthrope.getFacteureDomination());
        }

        @Test
        void testDomination() {
            Lycanthrope autre = new Lycanthrope("Casimir", "F", "jeune", 8);
            autre.setMeute(meute);

            lycanthrope.domination(autre);
            assertEquals(1, lycanthrope.getFacteureDomination());
            assertEquals(-1, autre.getFacteureDomination());
        }
/**
        @Test
        void testHurler() {
            lycanthrope.hurler("domination");
            // Vérification manuelle : le test devrait appeler la méthode et afficher le comportement
        }

        @Test
        void testTransformation() {
            lycanthrope.setNiveau(100);
            lycanthrope.transforme();

            // Ajoutez les assertions une fois que la logique est implémentée
        }

**/
//}