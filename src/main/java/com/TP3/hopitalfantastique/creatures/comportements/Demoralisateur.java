package java.com.TP3.hopitalfantastique.creatures.comportements;

import java.com.TP3.hopitalfantastique.creatures.CreaturePatient;
import java.com.TP3.hopitalfantastique.services.ServiceMedical;
import java.util.ArrayList;
import java.util.Random;

public interface Demoralisateur {
    public default void demoralise(CreaturePatient creature) {
        ServiceMedical service = creature.getService();
        ArrayList<CreaturePatient> listeCreatures = service.getListeCreatures();
        Random rd = new Random();
        listeCreatures.remove(creature);
        CreaturePatient aDemoraliser;
        for (int i = 0; i < rd.nextInt(listeCreatures.size()+1); i++) {
            int index_creature = rd.nextInt(listeCreatures.size());
            aDemoraliser = listeCreatures.get(rd.nextInt(index_creature));
            if (aDemoraliser.getIndMoral() > 0) {
                aDemoraliser.setIndMoral(aDemoraliser.getIndMoral() - Math.min(rd.nextInt(3)+1, aDemoraliser.getIndMoral()));
            }
            listeCreatures.remove(index_creature);
        }
    }
}
