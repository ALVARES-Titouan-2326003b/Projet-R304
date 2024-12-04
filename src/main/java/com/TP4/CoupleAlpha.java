package com.TP4;

public class CoupleAlpha {
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;
    private Meute meute;

    /**
     * Constructeur de la classe CoupleAlpha, initialise le couple alpha avec un mâle et une femelle.
     *
     * @param maleAlpha Le Lycanthrope mâle Alpha du couple.
     * @param femelleAlpha Le Lycanthrope femelle Alpha du couple.
     */
    public CoupleAlpha(Lycanthrope maleAlpha, Lycanthrope femelleAlpha){
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    public Meute getMeute(){
        return meute;
    }

    public void setMeute(Meute meute){
        this.meute = meute;
    }

    /**
     * Méthode pour obtenir le Lycanthrope mâle Alpha du couple.
     *
     * @return Le Lycanthrope mâle Alpha.
     */
    public Lycanthrope getMaleAlpha(){
        return maleAlpha;
    }

    /**
     * Méthode pour obtenir le Lycanthrope femelle Alpha du couple.
     *
     * @return Le Lycanthrope femelle Alpha.
     */
    public Lycanthrope getFemelleAlpha(){
        return femelleAlpha;
    }

    /**
     * Méthode pour définir un nouveau couple Alpha.
     * Le mâle Alpha est défini par l'argument et la femelle Alpha est choisie dans la Meute en fonction de la force
     * parmi les Lycanthropes de sexe féminin de la Meute.
     *
     * @param maleAlpha Le nouveau Lycanthrope mâle Alpha à affecter au couple.
     */
    public void setNewCouple(Lycanthrope maleAlpha){
        this.maleAlpha = maleAlpha;
        int tempForce = 0;
        int indice = 0;
        for (int i = 0; i < meute.getLycanthropes().size(); i++){
            if (meute.getLycanthropes().get(i).getForce() > tempForce && meute.getLycanthropes().get(i).getSexe() == "F"){
                tempForce = meute.getLycanthropes().get(i).getForce();
                indice = i;
            }
        }
        this.femelleAlpha = meute.getLycanthropes().get(indice);
    }
}
