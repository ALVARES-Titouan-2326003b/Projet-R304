package java.com.hopitalfantastique.creatures.maladies;

public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int lvlLetal;
    private int lvlActuel;

    public Maladie(String nomComplet, String nomAbrege, int lvlLetal, int lvlActuel) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
        this.lvlLetal = lvlLetal;
        this.lvlActuel = lvlActuel;
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
        if (lvlLetal == lvlActuel){
            return true;
        }
        return false;
    }
}
