package com.TP4;

import java.util.ArrayList;

public class Colonie {
    private ArrayList<Meute> listMeute;
    private String saison;

    /**
     * Méthode pour définir la saison actuelle de la colonie.
     *
     * @param saison La nouvelle saison de la colonie.
     */
    public void setSaison(String saison) {
        this.saison = saison;
    }

    /**
     * Méthode pour récupérer la saison actuelle de la colonie.
     */
    public String getSaison() {
        return saison;
    }

    /**
     * Constructeur de la classe Colonie qui initialise les attributs listMeute et saison.
     *
     * @param listMeute Liste des Meutes présentes dans la colonie.
     * @param saison Saison actuelle de la colonie.
     */
    public Colonie(ArrayList<Meute> listMeute, String saison) {
        this.listMeute = listMeute;
        this.saison = saison;
    }

    /**
     * Méthode pour obtenir la liste des Meutes de la colonie.
     *
     * @return La liste des Meutes.
     */
    public ArrayList<Meute> getMeute() {
        return listMeute;
    }

    /**
     * Méthode pour ajouter une Meute à la colonie.
     *
     * @param meute La Meute à ajouter à la colonie.
     */
    public void ajouteMeute(Meute meute){
        listMeute.add(meute);
    }

    /**
     * Méthode pour supprimer une Meute de la colonie.
     *
     * @param meute La Meute à supprimer de la colonie.
     */
    public void supprMeute(Meute meute){
        listMeute.remove(meute);
    }

    /**
     * Méthode pour obtenir une représentation sous forme de chaîne de caractères de la colonie.
     *
     * @return La représentation de la colonie avec toutes ses Meutes.
     */
    public String toString(){
        String s = "Colonie{";
        for(Meute meute: listMeute){
            s += meute.toString() + ";";
        }
        s +="}";
        return s;
    }

    /**
     * Méthode pour faire évoluer la saison de la colonie, ainsi que d'appliquer les actions spécifiques à chaque saison.
     * Les actions varient en fonction de la saison courante :
     * - En été, la saison change en automne et les Meutes hurlent.
     * - En automne, la saison change en hiver et les Meutes vieillissent.
     * - En hiver, la saison change en printemps et les Meutes subissent une évolution de hiérarchie et un contact avec les humains.
     * - Au printemps, la saison change en été et les Meutes se reproduisent.
     */
    public void passeSaison(){
        switch (saison){
            case "ete":
                setSaison("automne");
                for (Meute meute: listMeute){
                    meute.hurlement(meute.getCouple().getMaleAlpha());
                }
                break;
            case "automne":
                setSaison("hiver");
                for (Meute meute: listMeute){
                    meute.faitVieillir();
                }
                break;
            case "hiver":
                for (Meute meute: listMeute){
                   meute.evolutionHierarchie();
                }
                setSaison("printemps");
                break;
            case "printemps":
                for (Meute meute: listMeute){
                    meute.reproduction();
                }
                setSaison("ete");
                break;
            default:
                setSaison("ete");
                this.passeSaison();
        }
    }
}
