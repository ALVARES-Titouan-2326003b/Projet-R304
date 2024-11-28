package java.com.TP4;

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
        for (Lycanthrope lycanthrope : lycanthropes) {
            lycanthropes.remove(idv);
        }
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
            Lycanthrope jeuneLycanthrope = new Lycanthrope(nom, sexe, "jeune", force, this);
            lycanthropes.add(jeuneLycanthrope);
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
