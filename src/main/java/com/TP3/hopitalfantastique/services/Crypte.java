package java.com.TP3.hopitalfantastique.services;

import java.com.TP3.hopitalfantastique.creatures.CreaturePatient;
import java.com.TP3.hopitalfantastique.creatures.comportements.MortVivant;

public class Crypte extends ServiceMedical {
    private int niveauVentilation;
    private float temperature;

    public Crypte(String nom, float superficie, int capaciteMax, String budget, int niveauVentilation, float temperature) {
        super(nom, superficie, capaciteMax, budget);
        this.niveauVentilation = niveauVentilation;
        this.temperature = temperature;
    }

    public int getNiveauVentilation() {
        return niveauVentilation;
    }
    public void setNiveauVentilation(int niveauVentilation) {
        this.niveauVentilation = niveauVentilation;
    }
    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean ajouterCreature(CreaturePatient creature) {
        if (creature instanceof MortVivant) {
            if (getListeCreatures().size() < getCapaciteMax()){
                super.ajouterCreature(creature);
                return true;
            }
            return false;
        }
        else return false;
    }

}
