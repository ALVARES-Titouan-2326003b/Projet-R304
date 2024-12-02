package com.TP4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Meute {
    private String nom;  // Nom de la meute
    private String hurlement;  // Hurlement de la meute
    private CoupleAlpha couple;  // Couple Alpha de la meute
    private ArrayList<Lycanthrope> lycanthropes;  // Liste des Lycanthropes appartenant à la meute

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
        this.lycanthropes = new ArrayList();  // Initialisation de la liste des Lycanthropes
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
        // Il est préférable d'utiliser une boucle for-each avec un break ou une approche itérative
        // pour éviter les problèmes d'index lors de la modification de la liste pendant l'itération
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope == idv) {
                lycanthropes.remove(idv);
                break;  // Sort de la boucle après avoir trouvé et supprimé le Lycanthrope
            }
        }
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
        int porte = random.nextInt(7) + 1;  // Nombre de Lycanthropes à créer, entre 1 et 7
        String sexe = random.nextBoolean() ? "M" : "F";  // Sexe aléatoire
        int force = random.nextInt(15) + 1 ;  // Force aléatoire entre 1 et 15
        String rang = "γ";  // Rang par défaut

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < porte; i++) {
            // Affichage des informations du nouveau Lycanthrope
            System.out.print("Lycanthrope (" + sexe + " n°" + (i+1));
            System.out.print(" Force : " + force);
            System.out.print(" Rang : " + rang);
            System.out.print(" Nom :");
            String nom = sc.nextLine();  // Demande à l'utilisateur d'entrer le nom
            Lycanthrope jeuneLycanthrope = new Lycanthrope(nom, sexe, "jeune", force, this);
            lycanthropes.add(jeuneLycanthrope);  // Ajoute le nouveau Lycanthrope à la meute
        }
    }

    /**
     * Fait hurler tous les Lycanthropes de la meute en réponse à un hurlement initial.
     * Chaque Lycanthrope hurle en réponse à l'initiateur du hurlement, à l'exception de l'initiateur.
     *
     * @param initial Le Lycanthrope à l'origine du hurlement.
     */
    public void hurlement(Lycanthrope initial){
        for (Lycanthrope lycanthrope : lycanthropes) {
            if (lycanthrope != initial) {
                lycanthrope.hurler("reponse");  // Les autres Lycanthropes hurlent en réponse
            }
        }
    }
}
