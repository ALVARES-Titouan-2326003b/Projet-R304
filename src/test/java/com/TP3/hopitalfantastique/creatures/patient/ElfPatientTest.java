package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ElfPatientTest {
    @Test
    public void testGetRace() {
        CreaturePatient patient = new ElfPatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals("Elf", patient.getRace());
    }

    @Test
    public void meurt() {
        CreaturePatient patient = new ElfPatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        ServiceMedical service = new ServiceMedical("Service", 120f, 50, "Insuffisant");
        service.ajouterCreature(patient);

        CreaturePatient patient1 = new ElfPatient("Elf1", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient2 = new ElfPatient("Elf2", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        CreaturePatient patient3 = new ElfPatient("Elf3", "M", 70f, 180f, 27, new ArrayList<>(), 10);
        service.ajouterCreature(patient1);
        service.ajouterCreature(patient2);
        service.ajouterCreature(patient3);
        assertEquals(10, patient1.getIndMoral());
        assertEquals(10, patient2.getIndMoral());
        assertEquals(10, patient3.getIndMoral());

        assertEquals(service, patient.getService());
        assertEquals(4, service.getNombreCreature());
        patient.meurt();
        assertNull(patient.getService());
        assertEquals(3, service.getNombreCreature());

        int cpt = 0;
        if (patient1.getIndMoral() < 10) cpt += 10 - patient1.getIndMoral();
        if (patient2.getIndMoral() < 10) cpt += 10 - patient2.getIndMoral();
        if (patient3.getIndMoral() < 10) cpt += 10 - patient3.getIndMoral();
        System.out.println("Nombre de démoralisations : " + cpt);
        assertTrue(cpt <= 3*service.getNombreCreature() && cpt > 0);
    }
}