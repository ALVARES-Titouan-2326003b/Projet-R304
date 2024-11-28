package java.com.TP4;

public class Lycanthrope {
    private String sexe;
    private String catAge;
    private int force;
    private int facteureDomination;
    private String rang;
    private int niveau;
    private int impetuosite;
    private Meute meute;
    private String lieu;

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Lycanthrope(String sexe, String catAge, int force, Meute meute) {
        this.sexe = sexe;
        this.catAge = catAge;
        this.force = force;
        this.facteureDomination = 0;
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

    public int calculDomination(){
        return 0; // a reflechir
    }

    public int calculNiveau(){
        niveau = 0;
        if (this.catAge == "jeune"){
            niveau += 1;
        } else if (this.catAge == "adulte") {
            niveau += 10;
        }
        else if (this.catAge == "vieux") {
            niveau += 5;
        }
        niveau += 24-"αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(this.getRang());
        return niveau + this.facteureDomination + force;
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
        return facteureDomination;
    }

    public void setFacteureDomination(int facteureDomination) {
        this.facteureDomination = facteureDomination;
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

    public Meute getMeute(){
        return this.meute;
    }

    public void setMeute(Meute meute){
        this.meute = meute;
    }

    public void veillir(){
        switch (this.catAge){
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

    @Override
    public String toString() {
        return "Lycantrope{" +
                "sexe='" + sexe + '\'' +
                ", catAge='" + catAge + '\'' +
                ", force=" + force +
                ", facteureDomination=" + facteureDomination +
                ", rang='" + rang + '\'' +
                ", niveau=" + niveau +
                ", impetuosite='" + impetuosite + '\'' +
                ", nomMeute='" + meute.getNom() + '\'' +
                '}';
    }

    public void domination(Lycanthrope lycanthrope){
        if (this.getForce()*this.impetuosite >= lycanthrope.getForce() && !(lycanthrope.getSexe() == "femelle" && lycanthrope.getRang() == "α")){
            if (this.getForce() > lycanthrope.getForce() || lycanthrope.getRang() == "ω"){
                if("αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(this.rang) <= "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(lycanthrope.getRang())) {
                    Meute tmp = this.meute;
                    this.setMeute(lycanthrope.getMeute());
                    lycanthrope.setMeute(tmp);
                    this.calculDomination();
                    lycanthrope.calculDomination();
                }
            }
            else {
                this.setFacteureDomination(this.getFacteureDomination()+1);
                lycanthrope.setFacteureDomination(lycanthrope.getFacteureDomination()-1);
            }
        }
    }



    public void hurler(String type){
        switch (type){
            case "appartenance":
                this.meute.hurlement();
                System.out.println(this.toString() + " a hurlé d'appartenance");
                break;
            case "domination":
                System.out.println(this.toString() + " a hurlé de domination");
                break;
            case "soumission":
                System.out.println(this.toString() + " a hurlé de soumission");
                break;
            case "agressivite":
                System.out.println(this.toString() + " a hurlé d'agressivité");
                break;
            case "reponse":
                System.out.println(this.toString() + " a hurlé en réponse");
                break;
        }
    }

    public void quitteMeute(){
        this.meute = null;
        this.rang = null;
        this.facteureDomination = 0;
    }

    public void transforme() {
        if (niveau >= 100){
            // this.   a faire
        }

    }
}
