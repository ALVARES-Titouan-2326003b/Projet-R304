package com.TP3.hopitalfantastique.creatures.comportements;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.Maladie;
import java.util.ArrayList;
import java.util.Random;

public interface Bestial {

    /**
     * Méthode par défaut qui permet de contaminer une créature avec une maladie.
     * Elle choisit aléatoirement une maladie d'une créature et essaie de la transmettre
     * à une autre créature qui ne possède pas encore cette maladie.
     * Si la créature choisie a déjà la maladie, la méthode réessaie jusqu'à ce qu'elle en trouve une autre.
     * Si toutes les créatures ont déjà la maladie, la méthode augmente le niveau de la maladie de la créature choisie.
     *
     * @param creature La créature qui va infecter une autre créature avec une maladie.
     */
    public default void contamine(CreaturePatient creature) {
        Random rd = new Random();  // Création d'un générateur de nombres aléatoires

        // Récupère la liste des maladies de la créature
        ArrayList<Maladie> listeMaladies = creature.getListeMaladie();

        // Choisit une maladie aléatoire parmi celles de la créature
        Maladie maladie = listeMaladies.get(rd.nextInt(listeMaladies.size()));

        // Récupère la liste des créatures dans le même service médical
        ArrayList<CreaturePatient> listeCreatures = creature.getService().getListeCreatures();

        // Choisit une créature aléatoire parmi les autres créatures du service
        CreaturePatient aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));

        // Si la créature choisie possède déjà la maladie, on en choisit une autre
        while (aContaminer.possedeMaladie(maladie.getNomComplet())) {
            listeCreatures.remove(aContaminer);  // Retire la créature de la liste des choix

            // Si toutes les créatures ont déjà la maladie, on augmente le niveau de la maladie de la créature choisie
            if (listeCreatures.size() == 0) {
                for (Maladie maladie1 : aContaminer.getListeMaladie()) {
                    if (maladie1.getNomComplet().equals(maladie.getNomComplet())) {
                        maladie1.setLvlActuel(maladie.getLvlActuel() + 1);  // Augmente le niveau de la maladie
                        return;  // Fin de la méthode
                    }
                }
            }

            // Si une autre créature peut être choisie, on le fait
            aContaminer = listeCreatures.get(rd.nextInt(listeCreatures.size()));
        }

        // Si la créature choisie n'a pas la maladie, elle la contracte
        aContaminer.tombeMalade(new Maladie(maladie.getNomComplet(), maladie.getNomAbrege(), maladie.getLvlLetal()));
    }
}
