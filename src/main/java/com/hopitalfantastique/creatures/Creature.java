package java.com.hopitalfantastique.creatures;

import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;

public abstract class Creature {
    private String nom;
    private String sexe;
    private float poids;
    private float taille;
    private int age;
    private int indMoral;
    private int numHurlement;
    private ArrayList<Maladie> listeMaladie;

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

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndMoral() {
        return indMoral;
    }

    public void setIndMoral(int indMoral) {
        this.indMoral = indMoral;
    }

    public void setListeMaladie(ArrayList<Maladie> listeMaladie) {
        this.listeMaladie = listeMaladie;
    }

    public ArrayList<Maladie> getListeMaladie() {
        return listeMaladie;
    }


    public void attendre() {
        if (indMoral > 0) {
            indMoral--;
        } else {
            hurler();
        }
        //a revoir
    }

    public void hurler() {
        if (numHurlement > 3) {
            semporte();
        } else {
            numHurlement++;
        }
    }

    public void semporte() {
        return; // je sais pas quoi mettre
    }

    public void tombeMalade(Maladie maladie) {
        for (Maladie maladie1 : listeMaladie) {
            if (maladie1.getNomComplet().equals(maladie.getNomComplet())) {
                return;
            }
        }
        listeMaladie.add(maladie);
    }

    public void estSoignee(String nomMaladieComplet) {
        for (Maladie maladie1 : listeMaladie) {
            if (maladie1.getNomComplet().equals(nomMaladieComplet)) {
                listeMaladie.remove(maladie1);
            }
        }
    }

    public boolean possedeMaladie(String nomMaladieComplet) {
        for (Maladie maladie1 : listeMaladie) {
            if (maladie1.getNomComplet().equals(nomMaladieComplet)) {
                return true;
            }
        }
        return false;
    }


    public String toString () {
        return nom + " " + sexe + " " + poids + " " + taille + " " + indMoral + " " + age + " " + listeMaladie.toString();
    }

    public void meurt() {
        return; //on fait quoi ???
    }
}
