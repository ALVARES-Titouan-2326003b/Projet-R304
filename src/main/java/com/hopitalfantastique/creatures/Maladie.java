package com.hopitalfantastique.creatures;

public class Maladie {
    private static final String nomDefaut = "Nouvelle Maladie";
    private static final int lvlLetalDefaut = 5;
    private static final int lvlActuelDefaut = 1;
    private String nomComplet;
    private String nomAbrege;
    private int lvlLetal;
    private int lvlActuel;

    public Maladie() {
        this(nomDefaut, lvlLetalDefaut);
    }

    public Maladie(String nomComplet, int lvlLetal) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomComplet;
        if (lvlLetal <= 0) this.lvlLetal = lvlLetalDefaut;
        else this.lvlLetal = lvlLetal;
        this.lvlActuel = lvlActuelDefaut;
    }

    public Maladie(String nomComplet, String nomAbrege, int lvlLetal) {
        this(nomComplet, lvlLetal);
        this.nomAbrege = nomAbrege;
    }

    public Maladie(String nomComplet, int lvlLetal, int lvlActuel) {
        this(nomComplet, lvlLetal);
        if (lvlActuel > this.lvlLetal || lvlActuel <= 0) this.lvlActuel = lvlActuelDefaut;
        else this.lvlActuel = lvlActuel;
    }

    public Maladie(String nomComplet, String nomAbrege, int lvlLetal, int lvlActuel) {
        this(nomComplet, lvlLetal, lvlActuel);
        this.nomAbrege = nomAbrege;
    }

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

    public boolean estLetal(){
        if (lvlLetal <= lvlActuel){
            return true;
        }
        return false;
    }
}
