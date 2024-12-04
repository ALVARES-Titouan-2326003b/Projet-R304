package com.TP3.hopitalfantastique.creatures.patient;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReptilienPatientTest {
    @Test
    public void testGetRace() {
        CreaturePatient patient = new ReptilienPatient("Patient", "M", 77f, 182f, 38, new ArrayList<>(), 10);
        assertEquals("Reptilien", patient.getRace());
    }
}