package java.com.TP4;

import java.util.ArrayList;

public class Lieu {
    private String nom;
    private ArrayList<Colonie> listeColonies;
    private ArrayList<Lycanthrope> listeSolitaire;

    public Lieu(String nom, ArrayList<Colonie> listeColonies) {
        this.nom = nom;
        this.listeColonies = listeColonies;
    }

    private void ajouteColonie(Colonie colonie){
        this.listeColonies.add(colonie);
    }

    private void supprColonie(Colonie colonie){
        this.listeColonies.remove(colonie);
    }

    private void passeTemps(){
        if (this.listeColonies.size() == 0){
            // a faire
            new Colonie(null,"",this.nom);
        }
    }
    private void ajouteLycanthope(Lycanthrope l) {
        listeSolitaire.add(l);
    }
    private void supprLycanthope(Lycanthrope l) {
        listeSolitaire.remove(l);
    }

}
