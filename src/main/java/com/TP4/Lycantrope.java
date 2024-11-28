package java.com.TP4;

public class Lycantrope {
    private String sexe;
    private String catAge;
    private int force;
    private int facteureDomination;
    private String rang;
    private int niveau;
    private int impetuosite;
    private Meute meute;

    public Lycantrope(String sexe, String catAge, int force, Meute meute) {
        this.sexe = sexe;
        this.catAge = catAge;
        this.force = force;
        this.facteureDomination = 0;
        this.rang = "ω";
        this.niveau = 0;
        this.impetuosite = 1;
        this.Meute = meute;
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
                this.getMeute().enleverLycantrope(this);
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

    public void domination(Lycantrope lycantrope){
        if (this.getForce()*this.impetuosite >= lycantrope.getForce() && !(lycantrope.getSexe() == "femelle" && lycantrope.getRang() == "α")){
            if (this.getForce() > lycantrope.getForce() || lycantrope.getRang() == "ω"){
                if("αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(this.rang) <= "αβγδεζηθικλμνξοπρσςτυφχψω".indexOf(lycantrope.getRang()))
                    Meute tmp = this.meute;
                    this.setMeute(lycantrope.getMeute);
                    lycantrope.setMeute(tmp);
                    this.calculDomination();
                    lycantrope.calculDomination();
            }
            else {
                this.setFacteureDomination(this.getFacteureDomination()+1);
                lycantrope.setFacteureDomination(lycantrope.getFacteureDomination()-1);
            }
        }
    }



    public void hurler(String type){
        switch (type){
            case "appartenance":
                this.meute.hurlement();
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
