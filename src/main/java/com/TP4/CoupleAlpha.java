package com.TP4;

public class CoupleAlpha {
    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;
    private Meute meute;

    public CoupleAlpha(Lycanthrope maleAlpha, Lycanthrope femelleAlpha){
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    public Lycanthrope getMaleAlpha(){
        return maleAlpha;
    }
    public Lycanthrope getFemelleAlpha(){
        return femelleAlpha;
    }

    public void setNewCouple(Lycanthrope maleAlpha){
        this.maleAlpha = maleAlpha;
        int tempForce = 0;
        int indice = 0;
        for (int i = 0; i < meute.getLycanthropes().size(); i++){
            if (meute.getLycanthropes().get(i).getForce()>tempForce && meute.getLycanthropes().get(i).getSexe()=="F"){
                tempForce = meute.getLycanthropes().get(i).getForce();
                indice = i;
            }
        }
        this.femelleAlpha = meute.getLycanthropes().get(indice);
    }



}
