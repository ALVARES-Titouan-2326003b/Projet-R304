package com.hopitalfantastique.creatures.comportements;

import com.hopitalfantastique.creatures.CreaturePatient;
import com.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;
import java.util.Random;

public interface Bestial {
    public default void contamine(CreaturePatient creature) {
        Random rd = new Random();
        ArrayList<Maladie> listeMaladies = creature.getListeMaladie();
        Maladie maladie = listeMaladies.get(rd.nextInt(listeMaladies.size()));
        ArrayList<CreaturePatient> listeCreatures = creature.getService().getListeCreatures();
        CreaturePatient aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        // si le monstre a déjà la maladie alors on en choisit un autre
        while (aContaminer.possedeMaladie(maladie.getNomComplet())) {
            listeCreatures.remove(aContaminer);
            // si tous les monstres ont déjà la maladie, alors on prend le dernier choisi et on augmente le niveau de sa maladie de 1
            if (listeCreatures.size() == 0) {
                for (Maladie maladie1 : aContaminer.getListeMaladie()) {
                    if (maladie1.getNomComplet().equals(maladie.getNomComplet())) {
                        maladie1.setLvlActuel(maladie.getLvlActuel() + 1);
                        return;
                    }
                }
            }
            aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        }
        aContaminer.tombeMalade(new Maladie(maladie.getNomComplet(), maladie.getNomAbrege(), maladie.getLvlLetal()));
    }


}
