package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrquePatientTest {
    @Test
    public void testGetRace() {
        CreaturePatient patient = new OrquePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals("Orque", patient.getRace());
    }

    @Test
    public void testGetFactContamination() {
        CreaturePatient patient = new OrquePatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals(0.3, patient.getFactContamination());
    }
}