package com.hopitalfantastique.services;

import com.hopitalfantastique.creatures.CreaturePatient;
import java.util.ArrayList;

public class ServiceMedical {
    private String nom;
    private float superficie;
    private int capaciteMax;
    private int nombreCreature;
    private ArrayList<CreaturePatient> listeCreatures;
    private String budget;

    public ServiceMedical(String nom, float superficie, int capaciteMax, String budget) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        nombreCreature = 0;
        this.budget = budget;
    }

    public ArrayList<CreaturePatient> getListeCreatures() {
        return listeCreatures;
    }

    public void ajouterCreature(CreaturePatient creature) {
        listeCreatures.add(creature);
    }

    public void enleverCreature(CreaturePatient creature) {
        listeCreatures.remove(creature);
    }

    public void soignerCreature(CreaturePatient creature, String maladie) {
        creature.estSoignee(maladie);
    }

    public void reviserBudget(String budget) {
        this.budget = budget;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Service Médical :\n");
        sb.append("Nom : ").append(nom).append("\n");
        sb.append("Superficie : ").append(superficie).append(" m²\n");
        sb.append("Capacité maximale : ").append(capaciteMax).append("\n");
        sb.append("Nombre de créatures présentes : ").append(nombreCreature).append("\n");
        sb.append("Budget : ").append(budget).append("\n");

        sb.append("Créatures présentes :\n");
        if (listeCreatures.isEmpty()) {
            sb.append("Aucune créature présente.\n");
        }
        else {
            for (CreaturePatient creature : listeCreatures) {
                sb.append(creature.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
