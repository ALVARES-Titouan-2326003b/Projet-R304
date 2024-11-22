package java.com.hopitalfantastique.services;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.comportements.MortVivant;
import java.com.hopitalfantastique.services.ServiceMedical;

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
    public void ajouterCreature(CreaturePatient creature) {
        if (creature instanceof MortVivant) {
            super.ajouterCreature(creature);
        }
    }

}
