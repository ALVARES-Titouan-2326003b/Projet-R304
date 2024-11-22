package java.com.hopitalfantastique.creatures.comportements;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;
import java.util.Random;

public interface Bestial {
    public default void contamine(CreaturePatient creature) {
        Random rd = new Random();
        ArrayList<Maladie> listeMaladies = creature.getListeMaladie();
        Maladie maladie = listeMaladies.get(rd.nextInt(listeMaladies.size()));
        ArrayList<CreaturePatient> listeCreatures = creature.getService().getListeCreatures();
        CreaturePatient aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        while (aContaminer.possedeMaladie(maladie.getNomComplet())) {
            listeCreatures.remove(aContaminer);
            if (listeCreatures.size() == 0) return;
            aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        }
        aContaminer.tombeMalade(new Maladie(maladie.getNomComplet(), maladie.getNomAbrege(), maladie.getLvlLetal(), 1));
    }


}
