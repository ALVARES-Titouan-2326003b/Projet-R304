package java.com.hopitalfantastique.creatures.comportements;

import java.com.hopitalfantastique.creatures.CreaturePatient;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;
import java.util.Random;

public interface Bestial {
    public default void contamine(CreaturePatient creature) {
        Random rd = new Random();
        ArrayList<Maladie> listeMaladies = creature.getListeMaladie();
        String nomMaladie = listeMaladies.get(rd.nextInt(listeMaladies.size())).getNomComplet();
        ArrayList<CreaturePatient> listeCreatures = creature.getService().getListeCreature();
        CreaturePatient aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        while (aContaminer.possedeMaladie(nomMaladie)) {
            listeCreatures.remove(aContaminer);
            if (listeCreatures.size() == 0) return;
            aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        }
        aContaminer.tombeMalade(new Maladie(nomMaladie));
    }


}
