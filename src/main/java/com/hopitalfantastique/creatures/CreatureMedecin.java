package java.com.hopitalfantastique.creatures;

import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public abstract class CreatureMedecin {
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
}
