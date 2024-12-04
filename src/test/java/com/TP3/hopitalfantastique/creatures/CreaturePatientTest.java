package com.TP3.hopitalfantastique.creatures;

import com.TP3.hopitalfantastique.creatures.patient.HommeBetePatient;
import com.TP3.hopitalfantastique.creatures.patient.LycanthropePatient;
import com.TP3.hopitalfantastique.creatures.patient.OrquePatient;
import com.TP3.hopitalfantastique.creatures.patient.ZombiePatient;
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
    public void testFactContamination() {
        assertEquals(0.15, creaturePatient.getFactContamination());
        creaturePatient.setFactContamination(0.2);
        assertEquals(0.2, creaturePatient.getFactContamination());
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

    @Test
    public void testContamine() {
        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        CreaturePatient patient1 = new ZombiePatient("Zom1", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient2 = new ZombiePatient("Zom2", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient3 = new ZombiePatient("Zom3", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        service.ajouterCreature(patient1);
        service.ajouterCreature(patient2);
        service.ajouterCreature(patient3);
        assertEquals(0, patient1.getListeMaladie().size());
        assertEquals(0, patient2.getListeMaladie().size());
        assertEquals(0, patient3.getListeMaladie().size());

        creaturePatient.tombeMalade(new Maladie("Maladie contagieuse", 10));
        creaturePatient.setService(service);
        assertTrue(creaturePatient.possedeMaladie("Maladie contagieuse"));
        creaturePatient.contamine();
        int cpt = 0;
        if (patient1.getListeMaladie().size() == 1 && patient1.possedeMaladie("Maladie contagieuse") && patient1.getListeMaladie().get(0).getLvlActuel() == 1) ++cpt;
        if (patient2.getListeMaladie().size() == 1 && patient2.possedeMaladie("Maladie contagieuse") && patient2.getListeMaladie().get(0).getLvlActuel() == 1) ++cpt;
        if (patient3.getListeMaladie().size() == 1 && patient3.possedeMaladie("Maladie contagieuse") && patient3.getListeMaladie().get(0).getLvlActuel() == 1) ++cpt;
        assertEquals(1, cpt);
    }

    @Test
    public void testSemporte() {
        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        CreaturePatient patient1 = new ZombiePatient("Zom1", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient2 = new ZombiePatient("Zom2", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient3 = new ZombiePatient("Zom3", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        service.ajouterCreature(patient1);
        service.ajouterCreature(patient2);
        service.ajouterCreature(patient3);
        assertEquals(0, patient1.getListeMaladie().size());
        assertEquals(0, patient2.getListeMaladie().size());
        assertEquals(0, patient3.getListeMaladie().size());

        creaturePatient.tombeMalade(new Maladie("Maladie contagieuse", 10));
        creaturePatient.setService(service);
        assertTrue(creaturePatient.possedeMaladie("Maladie contagieuse"));
        creaturePatient.semporte();
        int cpt = 0;
        if (patient1.getListeMaladie().size() == 1 && patient1.possedeMaladie("Maladie contagieuse")) cpt += patient1.getListeMaladie().get(0).getLvlActuel();
        if (patient2.getListeMaladie().size() == 1 && patient2.possedeMaladie("Maladie contagieuse")) cpt += patient2.getListeMaladie().get(0).getLvlActuel();
        if (patient3.getListeMaladie().size() == 1 && patient3.possedeMaladie("Maladie contagieuse")) cpt += patient3.getListeMaladie().get(0).getLvlActuel();
        assertTrue(cpt <= 3 && cpt > 0);
        System.out.println("Nombre de contaminations : " + cpt);
    }

    @Test
    public void testHurler() {
        creaturePatient.setNumHurlement(0);
        assertEquals(0, creaturePatient.getNumHurlement());
        creaturePatient.hurler();
        assertEquals(1, creaturePatient.getNumHurlement());

        // s'emporte et contamine entre 1 et 3 fois les créatures de son service si la créature en a un
        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        CreaturePatient patient1 = new ZombiePatient("Zom1", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient2 = new ZombiePatient("Zom2", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient3 = new ZombiePatient("Zom3", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        service.ajouterCreature(patient1);
        service.ajouterCreature(patient2);
        service.ajouterCreature(patient3);
        assertEquals(0, patient1.getListeMaladie().size());
        assertEquals(0, patient2.getListeMaladie().size());
        assertEquals(0, patient3.getListeMaladie().size());

        creaturePatient.setNumHurlement(4);
        creaturePatient.tombeMalade(new Maladie("Maladie contagieuse", 10));
        creaturePatient.setService(service);
        assertEquals(4, creaturePatient.getNumHurlement());
        assertTrue(creaturePatient.possedeMaladie("Maladie contagieuse"));
        creaturePatient.hurler();
        assertEquals(4, creaturePatient.getNumHurlement());
        int cpt = 0;
        if (patient1.getListeMaladie().size() == 1 && patient1.possedeMaladie("Maladie contagieuse")) cpt += patient1.getListeMaladie().get(0).getLvlActuel();
        if (patient2.getListeMaladie().size() == 1 && patient2.possedeMaladie("Maladie contagieuse")) cpt += patient2.getListeMaladie().get(0).getLvlActuel();
        if (patient3.getListeMaladie().size() == 1 && patient3.possedeMaladie("Maladie contagieuse")) cpt += patient3.getListeMaladie().get(0).getLvlActuel();
        assertTrue(cpt <= 3 && cpt > 0);
        System.out.println("Nombre de contaminations : " + cpt);
    }

    @Test
    public void testAttendre() {
        // baisse l'indicateur moral de 1
        creaturePatient.setIndMoral(5);
        assertEquals(5, creaturePatient.getIndMoral());
        creaturePatient.attendre();
        assertEquals(4, creaturePatient.getIndMoral());

        // fait hurler la créature
        creaturePatient.setIndMoral(0);
        creaturePatient.setNumHurlement(0);
        assertEquals(0, creaturePatient.getIndMoral());
        assertEquals(0, creaturePatient.getNumHurlement());
        creaturePatient.attendre();
        assertEquals(0, creaturePatient.getIndMoral());
        assertEquals(1, creaturePatient.getNumHurlement());

        // s'emporte et contamine entre 1 et 3 fois les créatures de son service si la créature en a un
        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        CreaturePatient patient1 = new ZombiePatient("Zom1", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient2 = new ZombiePatient("Zom2", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient3 = new ZombiePatient("Zom3", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        service.ajouterCreature(patient1);
        service.ajouterCreature(patient2);
        service.ajouterCreature(patient3);
        assertEquals(0, patient1.getListeMaladie().size());
        assertEquals(0, patient2.getListeMaladie().size());
        assertEquals(0, patient3.getListeMaladie().size());

        creaturePatient.setIndMoral(0);
        creaturePatient.setNumHurlement(4);
        creaturePatient.tombeMalade(new Maladie("Maladie contagieuse", 10));
        creaturePatient.setService(service);
        assertEquals(0, creaturePatient.getIndMoral());
        assertEquals(4, creaturePatient.getNumHurlement());
        assertTrue(creaturePatient.possedeMaladie("Maladie contagieuse"));
        creaturePatient.attendre();
        assertEquals(0, creaturePatient.getIndMoral());
        assertEquals(4, creaturePatient.getNumHurlement());
        int cpt = 0;
        if (patient1.getListeMaladie().size() == 1 && patient1.possedeMaladie("Maladie contagieuse")) cpt += patient1.getListeMaladie().get(0).getLvlActuel();
        if (patient2.getListeMaladie().size() == 1 && patient2.possedeMaladie("Maladie contagieuse")) cpt += patient2.getListeMaladie().get(0).getLvlActuel();
        if (patient3.getListeMaladie().size() == 1 && patient3.possedeMaladie("Maladie contagieuse")) cpt += patient3.getListeMaladie().get(0).getLvlActuel();
        assertTrue(cpt <= 3 && cpt > 0);
        System.out.println("Nombre de contaminations : " + cpt);
    }
}