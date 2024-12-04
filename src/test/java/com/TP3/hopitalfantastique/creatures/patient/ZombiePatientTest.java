package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.Maladie;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ZombiePatientTest {
    @Test
    public void testGetRace() {
        CreaturePatient patient = new ZombiePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals("Zombie", patient.getRace());
    }

    @Test
    public void meurt() {
        CreaturePatient patient = new ZombiePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        patient.tombeMalade(new Maladie("Maladie1", 10));
        patient.tombeMalade(new Maladie("Maladie2", 10));
        patient.tombeMalade(new Maladie("Maladie3", 10));
        assertEquals(10, patient.getIndMoral());
        assertFalse(patient.getListeMaladie().isEmpty());

        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        service.ajouterCreature(patient);

        assertEquals(service, patient.getService());
        assertEquals(1, service.getNombreCreature());
        patient.meurt();
        assertEquals(service, patient.getService());
        assertEquals(1, service.getNombreCreature());
        assertEquals(0, patient.getIndMoral());
        assertTrue(patient.getListeMaladie().isEmpty());
    }
}