package java.com.hopitalfantastique.creatures.comportements;

import java.com.hopitalfantastique.creatures.Creature;
import java.com.hopitalfantastique.creatures.maladies.Maladie;
import java.util.ArrayList;
import java.util.Random;

public interface Bestial {
    public default void contamine(Creature creature) {
        Random rd = new Random();
        ArrayList<Maladie> listeMaladies = creature.getListeMaladie();
        String nomMaladie = listeMaladies.get(rd.nextInt(listeMaladies.size())).getNomComplet();
        ArrayList<Creature> listeCreatures = creature.getService().getListeCreature();
        Creature aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        while (aContaminer.estDejaMalade(nomMaladie)) {
            listeCreatures.remove(aContaminer);
            if (listeCreatures.size() == 0) return;
            aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        }
        aContaminer.tombeMalade(new Maladie(nomMaladie));
    }


}
