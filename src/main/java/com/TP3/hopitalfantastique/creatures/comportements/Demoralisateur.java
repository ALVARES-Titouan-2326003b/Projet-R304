package java.com.TP3.hopitalfantastique.creatures.comportements;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.services.ServiceMedical;
import java.util.ArrayList;
import java.util.Random;

public interface Demoralisateur {

    /**
     * Méthode par défaut qui permet de démoraliser les créatures dans un service médical.
     * La créature qui appelle cette méthode démoralise un certain nombre de créatures
     * dans son service en diminuant leur moral.
     *
     * @param creature La créature qui va démoraliser d'autres créatures.
     */
    public default void demoralise(CreaturePatient creature) {
        ServiceMedical service = creature.getService();  // Récupère le service médical auquel appartient la créature
        ArrayList<CreaturePatient> listeCreatures = service.getListeCreatures();  // Récupère la liste des créatures du service médical
        Random rd = new Random();  // Création d'un générateur de nombres aléatoires
        listeCreatures.remove(creature);  // Retire la créature qui appelle la méthode de la liste des créatures à démoraliser

        // La boucle démoralise un certain nombre de créatures au hasard
        CreaturePatient aDemoraliser;
        for (int i = 0; i < rd.nextInt(listeCreatures.size() + 1); i++) {
            // Choisit un index au hasard dans la liste des créatures restantes
            int index_creature = rd.nextInt(listeCreatures.size());

            // Récupère la créature à démoraliser à partir de l'index choisi
            aDemoraliser = listeCreatures.get(rd.nextInt(index_creature));

            // Si la créature à démoraliser a un moral positif, on peut diminuer son moral
            if (aDemoraliser.getIndMoral() > 0) {
                // Diminue le moral de la créature d'un nombre aléatoire entre 1 et 3, sans aller en dessous de 0
                aDemoraliser.setIndMoral(aDemoraliser.getIndMoral() - Math.min(rd.nextInt(3) + 1, aDemoraliser.getIndMoral()));
            }

            // Retire la créature démoralisée de la liste pour éviter de la sélectionner à nouveau
            listeCreatures.remove(index_creature);
        }
    }
}
