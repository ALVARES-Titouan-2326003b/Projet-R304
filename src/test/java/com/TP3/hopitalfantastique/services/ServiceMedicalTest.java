package com.TP3.hopitalfantastique.services;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.Maladie;
import com.TP3.hopitalfantastique.creatures.patient.ElfPatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ServiceMedicalTest {
    ServiceMedical service;

    @BeforeEach
    public void setUp() {
        service = new ServiceMedical("Service", 120f, 150, "Insuffisant");
    }

    @Test
    public void testGetters() {
        assertEquals("Service", service.getNom());
        assertEquals(150, service.getCapaciteMax());
        assertEquals("Insuffisant", service.getBudget());
    }

    @Test
    public void testListeCreatures() {
        ArrayList<CreaturePatient> patients = new ArrayList<>();
        service.setListeCreatures(patients);
        assertEquals(patients, service.getListeCreatures());
    }

    @Test
    public void testNombreCreature() {
        service.setNombreCreature(10);
        assertEquals(10, service.getNombreCreature());
    }

    @Test
    public void testAjouterCreature() {
        CreaturePatient patient = new ElfPatient("Elf", "M", 70f, 182f, 379, new ArrayList<>(), 10);
        assertEquals(0, service.getNombreCreature());
        assertFalse(service.getListeCreatures().contains(patient));
        assertNull(patient.getService());
        assertTrue(service.ajouterCreature(patient));
        assertEquals(1, service.getNombreCreature());
        assertTrue(service.getListeCreatures().contains(patient));
        assertEquals(service, patient.getService());
    }

    @Test
    public void testEnleverCreature() {
        CreaturePatient patient = new ElfPatient("Elf", "M", 70f, 182f, 379, new ArrayList<>(), 10);
        assertTrue(service.ajouterCreature(patient));
        assertEquals(1, service.getNombreCreature());
        assertTrue(service.getListeCreatures().contains(patient));
        assertEquals(service, patient.getService());
        assertTrue(service.enleverCreature(patient));
        assertEquals(0, service.getNombreCreature());
        assertFalse(service.getListeCreatures().contains(patient));
        assertNull(patient.getService());
    }

    @Test
    public void testSoignerCreature() {
        CreaturePatient patient = new ElfPatient("Elf", "M", 70f, 182f, 379, new ArrayList<>(), 10);
        patient.tombeMalade(new Maladie("Maladie", 10));
        assertTrue(patient.possedeMaladie("Maladie"));
        service.soignerCreature(patient, "Maladie");
        assertFalse(patient.possedeMaladie("Maladie"));
    }
}