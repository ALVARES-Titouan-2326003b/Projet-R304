package com.TP3.hopitalfantastique.creatures;

import com.TP3.hopitalfantastique.creatures.patient.ZombiePatient;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreatureMedecinTest {
    CreatureMedecin creatureMedecin;

    @BeforeEach
    public void setUp() {
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

    @Test
    public void testExamineService() {
        ServiceMedical service = new ServiceMedical("Service", 100f, 150, "Faible");
        assertEquals(creatureMedecin.examineService(service), service.toString());
    }

    @Test
    public void testReviseBudget() {
        ServiceMedical service = new ServiceMedical("Service", 100f, 150, "Faible");
        assertEquals("Faible", service.getBudget());
        creatureMedecin.reviseBudget(service, "Insuffisant");
        assertEquals("Insuffisant", service.getBudget());
    }

    @Test
    public void testTransfereCreature() {
        ServiceMedical service = new ServiceMedical("Service", 100f, 150, "Faible");
        CreaturePatient patient = new ZombiePatient("Zom", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        assertFalse(service.getListeCreatures().contains(patient));
        creatureMedecin.transfereCreature(service, patient);
        assertTrue(service.getListeCreatures().contains(patient));
    }

    @Test
    public void testLibereCreature() {
        ServiceMedical service = new ServiceMedical("Service", 100f, 150, "Faible");
        CreaturePatient patient = new ZombiePatient("Zom", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        creatureMedecin.transfereCreature(service, patient);
        assertTrue(service.getListeCreatures().contains(patient));
        creatureMedecin.libereCreature(patient);
        assertFalse(service.getListeCreatures().contains(patient));
    }

    @Test
    public void testSoigneCreature() {
        CreaturePatient patient = new ZombiePatient("Zom", "M", 70f, 180f, 27, new ArrayList<>(), 10);

        // le médecin n'est pas de la bonne race donc il ne peut jamais le soigner
        patient.tombeMalade(new Maladie("Maladie méchante", 5));
        assertTrue(patient.possedeMaladie("Maladie méchante"));

        creatureMedecin.soigneCreature(patient, "Maladie gentille");
        assertTrue(patient.possedeMaladie("Maladie méchante"));

        creatureMedecin.soigneCreature(patient, "Maladie méchante");
        assertTrue(patient.possedeMaladie("Maladie méchante"));


        creatureMedecin = new CreatureMedecin("Creature Medecin", "Homme?", 51) {
            @Override
            public String getRace() {
                return patient.getRace();
            }
        };
        // maintenant le médecin est de la bonne race
        patient.tombeMalade(new Maladie("Maladie méchante", 5));
        assertTrue(patient.possedeMaladie("Maladie méchante"));

        creatureMedecin.soigneCreature(patient, "Maladie gentille");
        assertTrue(patient.possedeMaladie("Maladie méchante"));

        creatureMedecin.soigneCreature(patient, "Maladie méchante");
        assertFalse(patient.possedeMaladie("Maladie méchante"));
    }
}