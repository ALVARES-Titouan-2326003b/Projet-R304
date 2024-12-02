package com.TP4;

public class CoupleAlpha {
    // Attributs représentant le couple Alpha : un mâle et une femelle Lycanthrope
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;
    private Meute meute;  // Référence à la Meute à laquelle appartient ce couple alpha

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
     * Le mâle Alpha est défini par l'argument et la femelle Alpha est choisie dans la Meute en fonction de la force.
     * La femelle la plus forte est choisie parmi les Lycanthropes de sexe féminin de la Meute.
     *
     * @param maleAlpha Le nouveau Lycanthrope mâle Alpha à affecter au couple.
     */
    public void setNewCouple(Lycanthrope maleAlpha){
        this.maleAlpha = maleAlpha;  // Définition du nouveau mâle Alpha

        int tempForce = 0;  // Variable pour stocker la force maximale d'une femelle
        int indice = 0;     // Index de la femelle Alpha choisie

        // Recherche de la femelle la plus forte dans la Meute
        for (int i = 0; i < meute.getLycanthropes().size(); i++){
            // Vérifie si la créature est une femelle et si sa force est supérieure à celle de la précédente femelle
            if (meute.getLycanthropes().get(i).getForce() > tempForce && meute.getLycanthropes().get(i).getSexe() == "F"){
                tempForce = meute.getLycanthropes().get(i).getForce();  // Met à jour la force maximale
                indice = i;  // Met à jour l'indice de la femelle la plus forte
            }
        }

        // Affecte la femelle la plus forte comme femelle Alpha
        this.femelleAlpha = meute.getLycanthropes().get(indice);
    }
}
