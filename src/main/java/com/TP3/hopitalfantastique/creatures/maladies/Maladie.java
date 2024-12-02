package com.TP3.hopitalfantastique.creatures.maladies;

/**
 * Classe représentant une maladie.
 * Une maladie possède un nom, un niveau de létalité et un niveau actuel qui évolue avec le temps.
 */
public class Maladie {

    // Valeur par défaut pour le nom de la maladie
    private static final String nomDefaut = "Nouvelle Maladie";
    // Valeur par défaut pour le niveau létal de la maladie
    private static final int lvlLetalDefaut = 5;
    // Valeur par défaut pour le niveau actuel de la maladie
    private static final int lvlActuelDefaut = 1;

    private String nomComplet;
    private String nomAbrege;
    private int lvlLetal;
    private int lvlActuel;

    /**
     * Constructeur par défaut de la classe Maladie.
     * Initialise la maladie avec les valeurs par défaut.
     */
    public Maladie() {
        this(nomDefaut, lvlLetalDefaut);
    }

    /**
     * Constructeur de la classe Maladie avec un nom complet et un niveau létal spécifié.
     * Si le niveau létal est inférieur ou égal à 0, il sera défini avec la valeur par défaut.
     * @param nomComplet Le nom complet de la maladie.
     * @param lvlLetal Le niveau létal de la maladie.
     */
    public Maladie(String nomComplet, int lvlLetal) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomComplet;
        if (lvlLetal <= 0) this.lvlLetal = lvlLetalDefaut;
        else this.lvlLetal = lvlLetal;
        this.lvlActuel = lvlActuelDefaut;
    }

    /**
     * Constructeur de la classe Maladie avec un nom complet, un nom abrégé et un niveau létal.
     * @param nomComplet Le nom complet de la maladie.
     * @param nomAbrege Le nom abrégé de la maladie.
     * @param lvlLetal Le niveau létal de la maladie.
     */
    public Maladie(String nomComplet, String nomAbrege, int lvlLetal) {
        this(nomComplet, lvlLetal);
        this.nomAbrege = nomAbrege;
    }

    /**
     * Constructeur de la classe Maladie avec un nom complet, un niveau létal et un niveau actuel.
     * Si le niveau actuel est supérieur au niveau létal ou inférieur ou égal à 0, il sera défini avec la valeur par défaut.
     * @param nomComplet Le nom complet de la maladie.
     * @param lvlLetal Le niveau létal de la maladie.
     * @param lvlActuel Le niveau actuel de la maladie.
     */
    public Maladie(String nomComplet, int lvlLetal, int lvlActuel) {
        this(nomComplet, lvlLetal);
        if (lvlActuel > this.lvlLetal || lvlActuel <= 0) this.lvlActuel = lvlActuelDefaut;
        else this.lvlActuel = lvlActuel;
    }

    /**
     * Constructeur de la classe Maladie avec un nom complet, un nom abrégé, un niveau létal et un niveau actuel.
     * @param nomComplet Le nom complet de la maladie.
     * @param nomAbrege Le nom abrégé de la maladie.
     * @param lvlLetal Le niveau létal de la maladie.
     * @param lvlActuel Le niveau actuel de la maladie.
     */
    public Maladie(String nomComplet, String nomAbrege, int lvlLetal, int lvlActuel) {
        this(nomComplet, lvlLetal, lvlActuel);
        this.nomAbrege = nomAbrege;
    }

    /**
     * Getter pour le nom complet de la maladie.
     * @return Le nom complet de la maladie.
     */
    public String getNomComplet() {
        return nomComplet;
    }

    /**
     * Setter pour le nom complet de la maladie.
     * @param nomComplet Le nouveau nom complet de la maladie.
     */
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    /**
     * Getter pour le nom abrégé de la maladie.
     * @return Le nom abrégé de la maladie.
     */
    public String getNomAbrege() {
        return nomAbrege;
    }

    /**
     * Setter pour le nom abrégé de la maladie.
     * @param nomAbrege Le nouveau nom abrégé de la maladie.
     */
    public void setNomAbrege(String nomAbrege) {
        this.nomAbrege = nomAbrege;
    }

    /**
     * Getter pour le niveau létal de la maladie.
     * @return Le niveau létal de la maladie.
     */
    public int getLvlLetal() {
        return lvlLetal;
    }

    /**
     * Setter pour le niveau létal de la maladie.
     * @param lvlLetal Le nouveau niveau létal de la maladie.
     */
    public void setLvlLetal(int lvlLetal) {
        this.lvlLetal = lvlLetal;
    }

    /**
     * Getter pour le niveau actuel de la maladie.
     * @return Le niveau actuel de la maladie.
     */
    public int getLvlActuel() {
        return lvlActuel;
    }

    /**
     * Setter pour le niveau actuel de la maladie.
     * @param lvlActuel Le nouveau niveau actuel de la maladie.
     */
    public void setLvlActuel(int lvlActuel) {
        this.lvlActuel = lvlActuel;
    }

    /**
     * Vérifie si la maladie est létale en comparant le niveau actuel avec le niveau létal.
     * @return true si le niveau actuel est supérieur ou égal au niveau létal, sinon false.
     */
    public boolean estLetal(){
        if (lvlLetal <= lvlActuel){
            return true;
        }
        return false;
    }
}
