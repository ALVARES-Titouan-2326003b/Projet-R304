package java.com.TP4;

import java.util.ArrayList;

public class Colonie {
    private ArrayList<Meute> listMeute;
    private String saison;

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public Colonie(ArrayList<Meute> listMeute, String saison) {
        this.listMeute = listMeute;
        this.saison = saison;
    }

    public ArrayList<Meute> getMeute() {
        return listMeute;
    }

    public void ajouteMeute(Meute meute){
        listMeute.add(meute);
    }

    public void supprMeute(Meute meute){
        listMeute.remove(meute);
    }

    public String toString(){
        String s = "Colonie{";
        for(Meute meute: listMeute){
            s += meute.toString() + ";";
        }
        s +="}";
        return s;
    }

    public void passeSaison(){
        switch (saison){
            case "ete":
                setSaison("automne");
                for (Meute meute: listMeute){
                    meute.hurlement();
                }
                break;
            case "automne":
                setSaison("hiver");
                for (Meute meute: listMeute){
                    meute.faitVeillir();
                }
                break;
            case "hiver":
                for (Meute meute: listMeute){
                    meute.evolutionHiérarchie;
                    meute.faitHumain();
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
