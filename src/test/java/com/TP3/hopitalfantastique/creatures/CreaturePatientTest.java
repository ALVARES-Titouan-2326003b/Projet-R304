package com.TP3.hopitalfantastique.creatures;

import com.TP3.hopitalfantastique.services.ServiceMedical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CreaturePatientTest {
    CreaturePatient creaturePatient;

    @BeforeEach
    void setUp() {
        creaturePatient = new CreaturePatient("Creature Patient", "Homme?", 72.1f, 182.15f, 51, new ArrayList<>(), 10) {
            @Override
            public String getRace() {
                return "Patient";
            }
        };
    }

    @Test
    public void testNom() {
        assertEquals("Creature Patient", creaturePatient.getNom());
        creaturePatient.setNom("Patient");
        assertEquals("Patient", creaturePatient.getNom());
    }

    @Test
    public void testSexe() {
        assertEquals("Homme?", creaturePatient.getSexe());
        creaturePatient.setSexe("Femme?");
        assertEquals("Femme?", creaturePatient.getSexe());
    }

    @Test
    public void testPoids() {
        assertEquals(72.1f, creaturePatient.getPoids());
        creaturePatient.setPoids(70.9f);
        assertEquals(70.9f, creaturePatient.getPoids());
    }

    @Test
    public void testTaille() {
        assertEquals(182.15f, creaturePatient.getTaille());
        creaturePatient.setTaille(182.51f);
        assertEquals(182.51f, creaturePatient.getTaille());
    }

    @Test
    public void testAge() {
        assertEquals(51, creaturePatient.getAge());
        creaturePatient.setAge(25);
        assertEquals(25, creaturePatient.getAge());
    }

    @Test
    public void testMaladies() {
        ArrayList<Maladie> liste1 = new ArrayList<>(Arrays.asList(new Maladie("Maladie1", 10)));
        creaturePatient.setListeMaladie(liste1);
        assertEquals(liste1, creaturePatient.getListeMaladie());

        ArrayList<Maladie> liste2 = new ArrayList<>(Arrays.asList(new Maladie("Maladie2", 10)));
        creaturePatient.setListeMaladie(liste2);
        assertEquals(liste2, creaturePatient.getListeMaladie());

        assertNotEquals(liste1, liste2);
    }

    @Test
    public void testIndMoral() {
        assertEquals(10, creaturePatient.getIndMoral());
        creaturePatient.setIndMoral(2);
        assertEquals(2, creaturePatient.getIndMoral());
    }

    @Test
    public void testHurlement() {
        assertEquals(0, creaturePatient.getNumHurlement());
        creaturePatient.setNumHurlement(2);
        assertEquals(2, creaturePatient.getNumHurlement());
    }

    @Test
    public void testService() {
        assertNull(creaturePatient.getService());
        ServiceMedical service = new ServiceMedical("Service1", 120f, 50, "Insuffisant");
        creaturePatient.setService(service);
        assertEquals(service, creaturePatient.getService());
    }

    @Test
    public void testTombeMalade() {
        assertEquals(0, creaturePatient.getListeMaladie().size());
        Maladie maladie = new Maladie("Maladie complexe", 10);
        creaturePatient.tombeMalade(maladie);
        assertEquals(1, creaturePatient.getListeMaladie().size());
        assertEquals(maladie, creaturePatient.getListeMaladie().get(0));
    }

    @Test
    public void testPossedeMaladie() {
        assertFalse(creaturePatient.possedeMaladie("Maladie complexe"));
        creaturePatient.tombeMalade(new Maladie("Maladie complexe", 10));
        assertTrue(creaturePatient.possedeMaladie("Maladie complexe"));
    }

    @Test
    public void testToString() {
        assertEquals("Creature Patient Homme? 72.1 182.15 10 51 []", creaturePatient.toString());
    }

    @Test
    public void testMeurt() {
        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        service.ajouterCreature(creaturePatient);
        assertEquals(service, creaturePatient.getService());
        assertEquals(1, service.getNombreCreature());
        creaturePatient.meurt();
        assertNull(creaturePatient.getService());
        assertEquals(0, service.getNombreCreature());
    }

    // plus qu'à tester attend()
}