package java.com.hopitalfantastique.creatures.comportements;

import java.com.hopitalfantastique.creatures.Creature;
import java.util.ArrayList;
import java.util.Random;

public interface Demoralisateur {
    public default void demoralise(Creature creature) {
        ServiceMedical service = creature.getService();
        ArrayList<Creature> listeCreatures = service.getListeCreature();
        Random rd = new Random();
        listeCreatures.remove(creature);
        for (int i = 0; i < rd.nextInt(listeCreatures.size()+1); i++) {
            int index_creature = rd.nextInt(listeCreatures.size());
            listeCreatures.get(rd.nextInt(index_creature)).diminueMoral();
            listeCreatures.remove(index_creature);
        }
    }
}