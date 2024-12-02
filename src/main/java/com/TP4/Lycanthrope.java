package com.TP4;

public class Lycanthrope {
    private String nom;
    private String sexe;
    private String catAge;
    private int force;
    private int facteurDomination;
    private String rang;
    private int niveau;
    private int impetuosite;
    private Meute meute;

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
        niveau += 24 - "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(this.getRang());
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

    public int getFacteureDomination() {
        return facteurDomination;
    }

    public void setFacteureDomination(int facteureDomination) {
        this.facteurDomination = facteureDomination;
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
                if ("αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(this.rang) <= "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(lycanthrope.getRang())) {
                    Meute tmp = this.meute;
                    this.setMeute(lycanthrope.getMeute());
                    lycanthrope.setMeute(tmp);
                    this.calculDomination();
                    lycanthrope.calculDomination();
                }
            } else {
                this.setFacteureDomination(this.getFacteureDomination() + 1);
                lycanthrope.setFacteureDomination(lycanthrope.getFacteureDomination() - 1);
            }
        }
    }


    /**
     * Fait hurler le Lycanthrope en fonction du type de hurlement.
     * Cela peut être pour marquer l'appartenance à la meute, la domination, la soumission ou l'agressivité.
     *
     * @param type Le type de hurlement ("appartenance", "domination", "soumission", "agressivité").
     */
    public void hurler(String type) {
        switch (type) {
            case "appartenance":
                this.meute.hurlement(this);
                this.toString();
                break;
            case "domination":
                this.toString();
                break;
            case "soumission":
                this.toString();
                break;
            case "agressivité":
                this.toString();
                break;
        }
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

    /**
     * Méthode qui retourne une représentation textuelle du Lycanthrope.
     * Cela inclut son sexe, sa catégorie d'âge, sa force, son rang, son niveau, et la meute à laquelle il appartient.
     *
     * @return La représentation textuelle du Lycanthrope.
     */
    @Override
    public String toString() {
        return "Lycantrope{" +
                "sexe='" + sexe + '\'' +
                ", catAge='" + catAge + '\'' +
                ", force=" + force +
                ", facteureDomination=" + facteurDomination +
                ", rang='" + rang + '\'' +
                ", niveau=" + niveau +
                ", impetuosite='" + impetuosite + '\'' +
                ", nomMeute='" + meute.getNom() + '\'' +
                '}';
    }
}
