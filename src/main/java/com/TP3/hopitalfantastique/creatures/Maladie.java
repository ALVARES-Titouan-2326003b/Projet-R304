package com.TP3.hopitalfantastique.creatures;

public class Maladie {
    // Valeurs par défaut pour les maladies
    private static final String nomDefaut = "Nouvelle Maladie"; // Nom par défaut de la maladie
    private static final int lvlLetalDefaut = 5;  // Niveau létal par défaut
    private static final int lvlActuelDefaut = 1; // Niveau actuel par défaut

    // Attributs de la maladie
    private String nomComplet;  // Nom complet de la maladie
    private String nomAbrege;   // Nom abrégé de la maladie
    private int lvlLetal;       // Niveau de létalité de la maladie
    private int lvlActuel;      // Niveau actuel de la maladie

    /**
     * Constructeur par défaut, crée une maladie avec les valeurs par défaut.
     */
    public Maladie() {
        this(nomDefaut, lvlLetalDefaut);  // Appelle le constructeur avec le nom et niveau létal par défaut
    }

    /**
     * Constructeur avec un nom complet et un niveau létal spécifié.
     * @param nomComplet Nom complet de la maladie
     * @param lvlLetal Niveau létal de la maladie
     */
    public Maladie(String nomComplet, int lvlLetal) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomComplet;  // Par défaut, le nom abrégé est le même que le nom complet
        if (lvlLetal <= 0) this.lvlLetal = lvlLetalDefaut;  // Si le niveau létal est invalide, on attribue la valeur par défaut
        else this.lvlLetal = lvlLetal;
        this.lvlActuel = lvlActuelDefaut;  // Niveau actuel par défaut
    }

    /**
     * Constructeur avec un nom complet, un nom abrégé et un niveau létal.
     * @param nomComplet Nom complet de la maladie
     * @param nomAbrege Nom abrégé de la maladie
     * @param lvlLetal Niveau létal de la maladie
     */
    public Maladie(String nomComplet, String nomAbrege, int lvlLetal) {
        this(nomComplet, lvlLetal);  // Appel au constructeur avec nom complet et niveau létal
        this.nomAbrege = nomAbrege;  // Spécifie le nom abrégé
    }

    /**
     * Constructeur avec un nom complet, un niveau létal et un niveau actuel.
     * @param nomComplet Nom complet de la maladie
     * @param lvlLetal Niveau létal de la maladie
     * @param lvlActuel Niveau actuel de la maladie
     */
    public Maladie(String nomComplet, int lvlLetal, int lvlActuel) {
        this(nomComplet, lvlLetal);  // Appel au constructeur avec nom complet et niveau létal
        // Vérifie que le niveau actuel est valide
        if (lvlActuel > this.lvlLetal || lvlActuel <= 0) this.lvlActuel = lvlActuelDefaut;  // Si niveau actuel invalide, utilise la valeur par défaut
        else this.lvlActuel = lvlActuel;
    }

    /**
     * Constructeur avec un nom complet, un nom abrégé, un niveau létal et un niveau actuel.
     * @param nomComplet Nom complet de la maladie
     * @param nomAbrege Nom abrégé de la maladie
     * @param lvlLetal Niveau létal de la maladie
     * @param lvlActuel Niveau actuel de la maladie
     */
    public Maladie(String nomComplet, String nomAbrege, int lvlLetal, int lvlActuel) {
        this(nomComplet, lvlLetal, lvlActuel);  // Appel au constructeur avec nom complet, niveau létal et actuel
        this.nomAbrege = nomAbrege;  // Spécifie le nom abrégé
    }

    // Getters et Setters pour chaque attribut

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNomAbrege() {
        return nomAbrege;
    }

    public void setNomAbrege(String nomAbrege) {
        this.nomAbrege = nomAbrege;
    }

    public int getLvlLetal() {
        return lvlLetal;
    }

    public void setLvlLetal(int lvlLetal) {
        this.lvlLetal = lvlLetal;
    }

    public int getLvlActuel() {
        return lvlActuel;
    }

    public void setLvlActuel(int lvlActuel) {
        this.lvlActuel = lvlActuel;
    }

    /**
     * Vérifie si la maladie est létale en comparant le niveau actuel avec le niveau létal.
     * @return true si la maladie est létale (niveau actuel >= niveau létal), sinon false.
     */
    public boolean estLetal(){
        if (lvlLetal <= lvlActuel) {
            return true;  // Si le niveau actuel est supérieur ou égal au niveau létal, la maladie est létale
        }
        return false;  // Sinon, elle n'est pas létale
    }
}
