package com.TP4;

public class Lycanthrope {
    private final String nom;
    private String sexe;
    private String catAge;
    private int force;
    private int facteurDomination;
    private String rang;
    private int niveau;
    private int impetuosite;
    private Meute meute;
    private final String rangs = "αβγδεζηθικλμνξοπρσςτυφχψω";

    /**
     * Constructeur de la classe Lycanthrope.
     * Initialise un Lycanthrope avec les informations de nom, sexe, catégorie d'âge, force et meute.
     *
     * @param nom    Le nom du Lycanthrope.
     * @param sexe   Le sexe du Lycanthrope.
     * @param catAge La catégorie d'âge du Lycanthrope.
     * @param force  La force du Lycanthrope.
     * @param meute  La meute à laquelle appartient le Lycanthrope.
     */
    public Lycanthrope(String nom, String sexe, String catAge, int force, Meute meute) {
        this.nom = nom;
        this.sexe = sexe;
        this.catAge = catAge;
        this.force = force;
        this.facteurDomination = 0;
        this.rang = "ω";
        this.niveau = 0;
        this.impetuosite = 1;
        this.meute = meute;
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * Calcule le niveau de domination du Lycanthrope.
     * Cette méthode devra être affinée en fonction des critères de domination.
     *
     * @return Le niveau de domination.
     */
    public int calculDomination() {
        return 0; // a reflechir
    }

    /**
     * Calcule le niveau d'un Lycanthrope en fonction de son âge, de son rang et de sa force.
     * Le niveau augmente en fonction de la catégorie d'âge et du rang du Lycanthrope.
     *
     * @return Le niveau total du Lycanthrope.
     */
    public int calculNiveau() {
        niveau = 0;
        if (this.catAge == "jeune") {
            niveau += 1;
        } else if (this.catAge == "adulte") {
            niveau += 10;
        } else if (this.catAge == "vieux") {
            niveau += 5;
        }
        niveau += 24 - rangs.indexOf(this.getRang());
        return niveau + this.facteurDomination + force;
    }

    public String getCatAge() {
        return catAge;
    }

    public void setCatAge(String catAge) {
        this.catAge = catAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getFacteurDomination() {
        return facteurDomination;
    }

    public void setFacteurDomination(int facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getImpetuosite() {
        return impetuosite;
    }

    public void setImpetuosite(int impetuosite) {
        this.impetuosite = impetuosite;
    }

    public Meute getMeute() {
        return this.meute;
    }

    public void setMeute(Meute meute) {
        this.meute = meute;
    }

    /**
     * Vieillit le Lycanthrope. Change sa catégorie d'âge ou le retire de la meute si nécessaire.
     */
    public void vieillir() {
        switch (this.catAge) {
            case "jeune":
                this.setCatAge("adulte");
                break;
            case "adulte":
                this.setCatAge("vieux");
                break;
            case "vieux":
                this.getMeute().enleverLycanthrope(this);
                break;
        }
    }


    /**
     * Effectue une tentative de domination entre deux Lycanthropes.
     * Le Lycanthrope actuel tente de dominer un autre Lycanthrope en fonction de leur force et rang.
     *
     * @param lycanthrope Le Lycanthrope que l'on tente de dominer.
     */
    public void domination(Lycanthrope lycanthrope) {
        if (this.getForce() * this.impetuosite >= lycanthrope.getForce() && !(lycanthrope.getSexe() == "femelle" && lycanthrope.getRang() == "α")) {
            if (this.getForce() > lycanthrope.getForce() || lycanthrope.getRang() == "ω") {
                if (rangs.indexOf(this.rang) >= rangs.indexOf(lycanthrope.getRang())) {
                    this.setFacteurDomination(this.getFacteurDomination() + 1);
                    lycanthrope.setFacteurDomination(lycanthrope.getFacteurDomination() - 1);
                    String tmpRang = this.getRang();
                    this.setRang(lycanthrope.getRang());
                    lycanthrope.setRang(tmpRang);
                }
                else {
                    this.setFacteurDomination(this.getFacteurDomination() + 1);
                    lycanthrope.setFacteurDomination(lycanthrope.getFacteurDomination() - 1);
                }
            }
            else {
                if (rangs.indexOf(this.rang) <= rangs.indexOf(lycanthrope.getRang())) {
                    this.setFacteurDomination(this.getFacteurDomination() - 1);
                    lycanthrope.setFacteurDomination(lycanthrope.getFacteurDomination() + 1);
                    String tmpRang = this.getRang();
                    this.setRang(lycanthrope.getRang());
                    lycanthrope.setRang(tmpRang);

                }
                else {
                    this.setFacteurDomination(this.getFacteurDomination() - 1);
                    lycanthrope.setFacteurDomination(lycanthrope.getFacteurDomination() + 1);
                }
            }
        }
        else {
            System.out.println(this.getNom() + " ne peut pas essayer de dominer " + lycanthrope.getNom());
        }
    }


    /**
     * Fait hurler le Lycanthrope en fonction du type de hurlement.
     * Cela peut être pour marquer l'appartenance à la meute, la domination, la soumission ou l'agressivité.
     *
     * @param type Le type de hurlement ("appartenance", "reponse", "domination", "soumission", "agressivité").
     */
    public String hurler(String type) {
        String hurlement = "";
        switch (type) {
            case "appartenance":
                hurlement = this.meute.hurlement(this);
                break;
            case "reponse":
                hurlement = this.toString();
                break;
            case "domination":
                hurlement = this.toString();
                break;
            case "soumission":
                hurlement = this.toString();
                break;
            case "agressivité":
                hurlement = this.toString();
                break;
        }
        return hurlement;
    }

    /**
     * Fait quitter le Lycanthrope de la meute.
     * Cette méthode supprime la référence à la meute et remet à zéro les attributs liés à la domination.
     */
    public void quitteMeute() {
        this.meute = null;
        this.rang = null;
        this.facteurDomination = 0;
    }


    public void rangMaj() {
        if (this.getFacteurDomination() < -3) {
            char baisseRang = rangs.charAt(rangs.indexOf(this.rang+1));
            this.setRang(String.valueOf(baisseRang));
            this.setFacteurDomination(0);
        }
        else if (this.getFacteurDomination() > 3) {
            if (this.getRang() != "α") {
                char monteRang = rangs.charAt(rangs.indexOf(this.rang)-1);
                this.setRang(String.valueOf(monteRang));
                this.setFacteurDomination(0);
            }
        }
    }

    /**
     * Méthode qui retourne une représentation textuelle du Lycanthrope.
     * Cela inclut son sexe, sa catégorie d'âge, sa force, son rang, son niveau, et la meute à laquelle il appartient.
     *
     * @return La représentation textuelle du Lycanthrope.
     */
    @Override
    public String toString() {
        return "Lycanthrope{" +
                "nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", catAge='" + catAge + '\'' +
                ", force=" + force +
                ", facteurDomination=" + facteurDomination +
                ", rang='" + rang + '\'' +
                ", niveau=" + niveau +
                ", impetuosite='" + impetuosite + '\'' +
                ", nomMeute='" + meute.getNom() + '\'' +
                '}';
    }
}
