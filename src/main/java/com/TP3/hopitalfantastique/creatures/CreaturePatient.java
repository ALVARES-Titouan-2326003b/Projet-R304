package java.com.TP3.hopitalfantastique.creatures;

import java.com.TP3.hopitalfantastique.creatures.especesInterface.Race;
import java.com.TP3.hopitalfantastique.creatures.maladies.Maladie;
import java.com.TP3.hopitalfantastique.services.ServiceMedical;
import java.util.ArrayList;
import java.util.Random;

public abstract class CreaturePatient implements Race {
    private String nom;
    private String sexe;
    private float poids;
    private float taille;
    private int age;
    private int indMoral;
    private int numHurlement;
    private ArrayList<Maladie> listeMaladie;
    private ServiceMedical service;

    public CreaturePatient(String nom, String sexe, float poids, float taille, int age, ArrayList<Maladie> listeMaladie, int indMoral) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.listeMaladie = listeMaladie;
        this.indMoral = indMoral;
        this.numHurlement = 0;
        this.service = null;
    }

    public int getNumHurlement() {
        return numHurlement;
    }

    public void setNumHurlement(int numHurlement) {
        this.numHurlement = numHurlement;
    }

    public ServiceMedical getService() {
        return service;
    }

    public void setService(ServiceMedical service) {
        this.service = service;
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
    }

    public void hurler() {
        if (numHurlement > 3) {
            semporte();
        } else {
            numHurlement++;
        }
    }

    public void semporte() {
        ArrayList <CreaturePatient> listeAContaminer = null;
        Random rand = new Random();
        int nombreAContaminer = rand.nextInt(5);
        ArrayList <CreaturePatient> listeCreatureService = service.getListeCreatures();
        for (int i = 0; i < nombreAContaminer; i++) {
            listeAContaminer.add(listeCreatureService.get(rand.nextInt(listeCreatureService.size())));
        }
        for (int i = 0; i < listeAContaminer.size(); i++) {
            contamine(listeAContaminer.get(i));
        }
    }

    public void contamine(CreaturePatient creaturePatient) {
        Random rand = new Random();
        Maladie maladieATransmetre = listeMaladie.get(rand.nextInt(listeMaladie.size()));
        if (listeMaladie.size() != 0) {
            if (creaturePatient.possedeMaladie(maladieATransmetre.getNomComplet())){
                for (Maladie maladie : creaturePatient.listeMaladie){
                    if (maladie.getNomComplet().equals(maladieATransmetre.getNomComplet())){
                        maladie.setLvlActuel(maladie.getLvlActuel() + 1);
                    }
                }
            }
            else {
                creaturePatient.tombeMalade(new Maladie(maladieATransmetre.getNomComplet(), maladieATransmetre.getNomAbrege(), maladieATransmetre.getLvlLetal(), 1));
            }
        }

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
        service.enleverCreature(this);
    }
}
