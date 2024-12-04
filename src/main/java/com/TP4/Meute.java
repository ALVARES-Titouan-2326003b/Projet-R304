package com.TP4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Meute {
    private String nom;
    private String hurlement;
    private CoupleAlpha couple;
    private ArrayList<Lycanthrope> lycanthropes;

    /**
     * Constructeur de la classe Meute.
     * Initialise une meute avec un nom, un hurlement et un couple Alpha.
     *
     * @param nom Le nom de la meute.
     * @param hurlement Le hurlement associé à la meute.
     * @param couple Le couple Alpha de la meute.
     */
    public Meute(String nom, String hurlement, CoupleAlpha couple){
        this.couple = couple;
        this.nom = nom;
        this.hurlement = hurlement;
        this.lycanthropes = new ArrayList();
    }

    /**
     * Récupère le nom de la meute.
     *
     * @return Le nom de la meute.
     */
    public String getNom(){
        return nom;
    }

    /**
     * Récupère le couple Alpha de la meute.
     *
     * @return Le couple Alpha de la meute.
     */
    public CoupleAlpha getCouple() {
        return couple;
    }

    /**
     * Modifie le couple Alpha de la meute.
     *
     * @param couple Le nouveau couple Alpha.
     */
    public void setCouple(CoupleAlpha couple) {
        this.couple = couple;
    }

    /**
     * Ajoute un Lycanthrope à la meute.
     *
     * @param idv Le Lycanthrope à ajouter à la meute.
     */
    public void ajouterLycanthrope(Lycanthrope idv){
        lycanthropes.add(idv);
    }

    /**
     * Enlève un Lycanthrope de la meute.
     * Parcourt la liste des Lycanthropes pour retirer celui spécifié.
     *
     * @param idv Le Lycanthrope à enlever.
     */
    public void enleverLycanthrope(Lycanthrope idv){
        lycanthropes.remove(idv);
        idv.setMeute(null);
    }

    /**
     * Récupère la liste des Lycanthropes dans la meute.
     *
     * @return La liste des Lycanthropes.
     */
    public ArrayList<Lycanthrope> getLycanthropes() {
        return lycanthropes;
    }

    /**
     * Gère la reproduction au sein de la meute.
     * Crée un nombre aléatoire de Lycanthropes jeunes, avec un sexe, une force et un rang aléatoires.
     * Le nom de chaque nouveau Lycanthrope est demandé à l'utilisateur via un scanner.
     */
    public void reproduction(){
        Random random = new Random();
        int porte = random.nextInt(7) + 1;
        String sexe = random.nextBoolean() ? "M" : "F";
        int force = random.nextInt(15) + 1 ;
        String rang = "γ";

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < porte; i++) {
            System.out.print("Lycanthrope (" + sexe + " n°" + (i+1));
            System.out.print(" Force : " + force);
            System.out.print(" Rang : " + rang);
            System.out.print(" Nom :");
            String nom = sc.nextLine();
            Lycanthrope jeuneLycanthrope = new Lycanthrope(nom, sexe, "jeune", force, this);
            lycanthropes.add(jeuneLycanthrope);
        }
    }

    /**
     * Effectue le tri des Lycanthropes de la meute selon leur rang,
     * en utilisant l'algorithme de tri rapide (quicksort).
     *
     * @param gauche L'indice de début de la portion de la liste à trier.
     * @param droite L'indice de fin de la portion de la liste à trier.
     */
    public void quicksortMeute(int gauche, int droite) {
        if (gauche < droite) {
            int pivotIndex = partition(gauche, droite);
            quicksortMeute(gauche, pivotIndex - 1);
            quicksortMeute(pivotIndex + 1, droite);
        }
    }

    /**
     * Partitionne une portion de la liste des Lycanthropes selon le pivot,
     * en déplaçant les éléments plus petits que le pivot à gauche
     * et les éléments plus grands à droite.
     *
     * @param gauche L'indice de début de la portion à partitionner.
     * @param droite L'indice de fin de la portion à partitionner.
     * @return L'indice final du pivot après partitionnement.
     */
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

    /**
     * Permute deux Lycanthropes dans la liste.
     *
     * @param i L'indice du premier Lycanthrope.
     * @param j L'indice du second Lycanthrope.
     */
    private void swap(int i, int j) {
        Lycanthrope temp = lycanthropes.get(i);
        lycanthropes.set(i, lycanthropes.get(j));
        lycanthropes.set(j, temp);
    }

    /**
     * Compare deux rangs de Lycanthropes selon leur position dans l'ordre hiérarchique.
     *
     * @param rang1 Le rang du premier Lycanthrope.
     * @param rang2 Le rang du second Lycanthrope.
     * @return Un entier négatif, nul ou positif si rang1 est respectivement
     *         inférieur, égal ou supérieur à rang2 dans l'ordre hiérarchique.
     */
    private int compareRang(String rang1, String rang2) {
        String rang = "αβγδεζηθικλμνξοπρσςτυφχψω";
        return Integer.compare(rang.indexOf(rang1), rang.indexOf(rang2));
    }

    /**
     * Fait vieillir tous les Lycanthropes de la meute.
     * Chaque Lycanthrope modifie son état en fonction de son âge ou de sa condition.
     */
    public void faitVieillir(){
        for (Lycanthrope lycanthrope : lycanthropes) {
            lycanthrope.vieillir();
        }
    }

    /**
     * Fait hurler tous les Lycanthropes de la meute en réponse à un hurlement initial.
     * Chaque Lycanthrope hurle en réponse à l'initiateur du hurlement, à l'exception de l'initiateur.
     *
     * @param initial Le Lycanthrope à l'origine du hurlement.
     */
    public String hurlement(Lycanthrope initial){
        String hurlementMeute = initial.toString();
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope != initial){
                hurlementMeute += "\n" + lycanthrope.hurler("reponse");
            }
        }
        return hurlementMeute;
    }

    /**
     * Met à jour les rangs des lycanthropes de la meute.
     *
     */
    public void evolutionHierarchie() {
        for (Lycanthrope lycanthrope : lycanthropes) {
            lycanthrope.rangMaj();
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meute{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", hurlement='").append(hurlement).append('\'');
        sb.append(", couple=").append(couple);
        sb.append(", lycanthropes=[");

        for (int i = 0; i < lycanthropes.size(); i++) {
            sb.append(lycanthropes.get(i));
            if (i < lycanthropes.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]}");
        return sb.toString();
    }



}
