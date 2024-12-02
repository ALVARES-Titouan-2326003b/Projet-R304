package com.TP3.hopitalfantastique.services;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.maladies.Maladie;
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
        listeCreatures = new ArrayList<>();
    }

    public ArrayList<CreaturePatient> getListeCreatures() {
        return listeCreatures;
    }

    public String getNom() {
        return nom;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public int getNombreCreature() {
        return nombreCreature;
    }

    public void setNombreCreature() {
        this.nombreCreature ++;
    }

    public boolean ajouterCreature(CreaturePatient creature) {
        if (listeCreatures.size() < capaciteMax) {
            listeCreatures.add(creature);
            nombreCreature++;
            return true;
        }
        else return false;
    }

    public void enleverCreature(CreaturePatient creature) {
        listeCreatures.remove(creature);
        nombreCreature--;
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
