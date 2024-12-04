package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.Maladie;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VampirePatientTest {
    @Test
    public void testGetRace() {
        CreaturePatient patient = new VampirePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals("Vampire", patient.getRace());
    }

    @Test
    public void testGetFactContamination() {
        CreaturePatient patient = new VampirePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals(0.3, patient.getFactContamination());
    }

    @Test
    public void meurt() {
        CreaturePatient patient = new VampirePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        patient.tombeMalade(new Maladie("Maladie1", 10));
        patient.tombeMalade(new Maladie("Maladie2", 10));
        patient.tombeMalade(new Maladie("Maladie3", 10));
        assertEquals(10, patient.getIndMoral());
        assertFalse(patient.getListeMaladie().isEmpty());

        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        service.ajouterCreature(patient);

        CreaturePatient patient1 = new VampirePatient("Vampire1", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient2 = new VampirePatient("Vampire2", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient3 = new VampirePatient("Vampire3", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        service.ajouterCreature(patient1);
        service.ajouterCreature(patient2);
        service.ajouterCreature(patient3);
        assertEquals(10, patient1.getIndMoral());
        assertEquals(10, patient2.getIndMoral());
        assertEquals(10, patient3.getIndMoral());

        assertEquals(service, patient.getService());
        assertEquals(4, service.getNombreCreature());
        patient.meurt();
        assertEquals(service, patient.getService());
        assertEquals(4, service.getNombreCreature());
        assertEquals(0, patient.getIndMoral());
        assertTrue(patient.getListeMaladie().isEmpty());

        int cpt = 0;
        if (patient1.getIndMoral() < 10) cpt += 10 - patient1.getIndMoral();
        if (patient2.getIndMoral() < 10) cpt += 10 - patient2.getIndMoral();
        if (patient3.getIndMoral() < 10) cpt += 10 - patient3.getIndMoral();
        System.out.println("Nombre de démoralisations : " + cpt);
        assertTrue(cpt <= 3*service.getNombreCreature() && cpt > 0);
    }
}