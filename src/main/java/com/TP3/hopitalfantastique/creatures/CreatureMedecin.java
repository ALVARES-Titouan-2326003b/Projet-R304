package com.TP3.hopitalfantastique.creatures;

import com.TP3.hopitalfantastique.creatures.especesInterface.Race;
import com.TP3.hopitalfantastique.services.ServiceMedical;

public abstract class CreatureMedecin implements Race {
    private String nom;
    private String sexe;
    private int age;

    public CreatureMedecin(String nom, String sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString () {
        return (nom + " " + sexe + " " + age).toString();
    }

    public String examineService (ServiceMedical nomService) {
        return nomService.toString();
    }

    public void reviseBudget (ServiceMedical nomService, String nouveauBudget) {
        nomService.reviserBudget(nouveauBudget);
    }

    public void transfereCreature (ServiceMedical nouveauService, CreaturePatient creaturePatient) {
        nouveauService.ajouterCreature(creaturePatient);
    }

    public void libereCreature (CreaturePatient creaturePatient) {
        creaturePatient.getService().enleverCreature(creaturePatient);
    }

    public void soigneCreature (CreaturePatient creaturePatient, String maladie) {
        if (this.getRace() == creaturePatient.getRace()) {
            creaturePatient.getService().soignerCreature(creaturePatient, maladie);
        }
    }
}
