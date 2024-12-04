package com.TP3.hopitalfantastique.services;

import com.TP3.hopitalfantastique.creatures.CreaturePatient;
import com.TP3.hopitalfantastique.creatures.comportements.Bestial;
import java.util.ArrayList;

/**
 * Représente un centre de quarantaine spécialisé dans les créatures de type "Bestial".
 * Les créatures peuvent être isolées dans ce centre pour éviter la propagation de maladies.
 */
public class CentreQuarantaine extends ServiceMedical {
    private ArrayList<CreaturePatient> creaturesEnIsolation = new ArrayList<>();

    /**
     * Constructeur de la classe CentreQuarantaine.
     * @param nom Le nom du centre de quarantaine.
     * @param superficie La superficie du centre.
     * @param capaciteMax La capacité maximale du centre en nombre de créatures.
     * @param budget Le budget alloué au centre.
     */
    public CentreQuarantaine(String nom, float superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    /**
     * Méthode pour ajouter une créature au centre de quarantaine.
     * La créature ne sera ajoutée que si le centre a de la place et si elle est de type Bestial.
     * @param creature La créature à ajouter.
     * @return true si la créature a été ajoutée, false sinon.
     */
    @Override
    public boolean ajouterCreature(CreaturePatient creature) {
        if (getListeCreatures().size() < getCapaciteMax()) {
            if (creature instanceof Bestial) {
                super.ajouterCreature(creature);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Getter pour obtenir la liste des créatures en quarantaine.
     * @return La liste des créatures en quarantaine.
     */
    public ArrayList<CreaturePatient> getCreaturesEnIsolation() {
        return creaturesEnIsolation;
    }

    /**
     * Ajoute une créature à la liste des créatures en isolation.
     * @param creature La créature à ajouter en isolation.
     */
    public void ajouterCreaturesEnIsolation(CreaturePatient creature) {
        this.creaturesEnIsolation.add(creature);
    }

    /**
     * Enlève une créature de la liste des créatures en isolation.
     * @param creature La créature à retirer de l'isolation.
     */
    public void enleverCreaturesEnIsolation(CreaturePatient creature) {
        this.creaturesEnIsolation.remove(creature);
    }
}
