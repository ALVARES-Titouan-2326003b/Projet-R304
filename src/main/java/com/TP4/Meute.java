package com.TP4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Meute {
    private String nom;
    private String hurlement;
    private CoupleAlpha couple;
    private ArrayList<Lycanthrope> lycanthropes;

    public Meute(String nom, String hurlement, CoupleAlpha couple){
        this.couple = couple;
        this.nom = nom;
        this.hurlement = hurlement;
        this.lycanthropes = new ArrayList();
    }

    public String getNom(){
        return nom;
    }

    public CoupleAlpha getCouple() {
        return couple;
    }
    public void setCouple(CoupleAlpha couple) {
        this.couple = couple;
    }

    public void ajouterLycanthrope(Lycanthrope idv){
        lycanthropes.add(idv);
    }
    public void enleverLycanthrope(Lycanthrope idv){
        lycanthropes.remove(idv);
        idv.setMeute(null);
    }

    public ArrayList<Lycanthrope> getLycanthropes() {
        return lycanthropes;
    }

    public void reproduction(){
        Random random = new Random();
        int porte = random.nextInt(7) + 1;
        String sexe = random.nextBoolean() ? "M" : "F";
        int force = random.nextInt(15) + 1 ;
        String rang = "γ";

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < porte; i++) {
            System.out.print("Lycanthrope ("+ sexe +" n°" + (i+1));
            System.out.print("Force : " + force);
            System.out.print("Rang : " + rang);
            System.out.print("Nom :");
            String nom = sc.nextLine();
            Lycanthrope jeuneLycanthrope = new Lycanthrope(nom, sexe, "jeune", force);
            this.ajouterLycanthrope(jeuneLycanthrope);
            lycanthropes.add(jeuneLycanthrope);
        }
    }

    public void quicksortMeute(int gauche, int droite) {
        if (gauche < droite) {
            int pivotIndex = partition(gauche, droite);
            quicksortMeute(gauche, pivotIndex - 1);
            quicksortMeute(pivotIndex + 1, droite);
        }
    }

    private int partition(int gauche, int droite) {
        String pivot = lycanthropes.get(droite).getRang();
        int i = gauche - 1;
        for (int j = gauche; j < droite; j++) {
            if (compareRang(lycanthropes.get(j).getRang(), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, droite);
        return i + 1;
    }

    private void swap(int i, int j) {
        Lycanthrope temp = lycanthropes.get(i);
        lycanthropes.set(i, lycanthropes.get(j));
        lycanthropes.set(j, temp);
    }

    private int compareRang(String rang1, String rang2) {
        String rang = "αβγδεζηθικλμνξοπρσςτυφχψω";
        return Integer.compare(rang.indexOf(rang1), rang.indexOf(rang2));
    }

    public void faitVieillir(){
        for (Lycanthrope lycanthrope : lycanthropes) {
            lycanthrope.vieillir();
        }
    }


    public void hurlement(Lycanthrope initial){
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope != initial){
                lycanthrope.hurler("reponse");
            }
        }
    }



}
