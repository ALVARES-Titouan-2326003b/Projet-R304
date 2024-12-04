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
            lycanthrope = new Lycanthrope("Thomas", "M", "jeune", 10, null);
            lycanthrope.setMeute(meute);
        }

        @Test
        void testInitialAttributes() {
            assertEquals("Thomas", lycanthrope.getNom());
            assertEquals("M", lycanthrope.getSexe());
            assertEquals("jeune", lycanthrope.getCatAge());
            assertEquals(10, lycanthrope.getForce());
            assertEquals("ω", lycanthrope.getRang());
            assertEquals(0, lycanthrope.getFacteurDomination());
            assertEquals(meute, lycanthrope.getMeute());
        }

        @Test
        void testSetters() {
            lycanthrope.setSexe("F");
            lycanthrope.setCatAge("adulte");
            lycanthrope.setForce(20);
            lycanthrope.setFacteurDomination(5);
            lycanthrope.setRang("β");

            assertEquals("F", lycanthrope.getSexe());
            assertEquals("adulte", lycanthrope.getCatAge());
            assertEquals(20, lycanthrope.getForce());
            assertEquals(5, lycanthrope.getFacteurDomination());
            assertEquals("β", lycanthrope.getRang());
        }

        @Test
        void testCalculNiveau() {
            assertEquals(1 + (24 - "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf("ω")) + 10, lycanthrope.calculNiveau());
            lycanthrope.setCatAge("adulte");
            lycanthrope.setForce(20);
            lycanthrope.setFacteurDomination(5);
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
            assertEquals(0, lycanthrope.getFacteurDomination());
        }

        @Test
        void testDomination() {
            Lycanthrope autre = new Lycanthrope("Casimir", "F", "jeune", 8, null);
            autre.setMeute(meute);
            lycanthrope.setRang("ξ");

            lycanthrope.domination(autre);
            assertEquals(1, lycanthrope.getFacteurDomination());
            assertEquals(-1, autre.getFacteurDomination());

            autre.setForce(100);
            lycanthrope.setImpetuosite(10);

            lycanthrope.domination(autre);
            //test lycanthrope domine un ω
            assertEquals(2, lycanthrope.getFacteurDomination());
            assertEquals(-2, autre.getFacteurDomination());
            assertEquals("ω", autre.getRang());
            assertEquals("ξ", lycanthrope.getRang());

            autre.setRang("ρ");
            lycanthrope.domination(autre);
            assertEquals(1, lycanthrope.getFacteurDomination());
            assertEquals(-1, autre.getFacteurDomination());
            assertEquals("ξ", autre.getRang());
            assertEquals("ρ", lycanthrope.getRang());



        }


        @Test
        void testHurler() {
            Lycanthrope autre = new Lycanthrope("Casimir", "F", "jeune", 8, null);
            autre.setMeute(meute);
            meute.ajouterLycanthrope(autre);
            assertEquals( "Lycanthrope{nom='Thomas', sexe='M', catAge='jeune', force=10, facteurDomination=0, rang='ω', niveau=0, impetuosite='1', nomMeute='meute1'}", lycanthrope.hurler("domination"));
            assertEquals("Lycanthrope{nom='Thomas', sexe='M', catAge='jeune', force=10, facteurDomination=0, rang='ω', niveau=0, impetuosite='1', nomMeute='meute1'}\n" +
                    "Lycanthrope{nom='Casimir', sexe='F', catAge='jeune', force=8, facteurDomination=0, rang='ω', niveau=0, impetuosite='1', nomMeute='meute1'}", lycanthrope.hurler("appartenance"));
        }
/**
        @Test
        void testTransformation() {
            lycanthrope.setNiveau(100);
            lycanthrope.transforme();

            // Ajoutez les assertions une fois que la logique est implémentée
        }

**/
//}