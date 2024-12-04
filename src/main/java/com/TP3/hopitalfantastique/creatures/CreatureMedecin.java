package com.TP3.hopitalfantastique.creatures;

import com.TP3.hopitalfantastique.creatures.especesInterface.Race;
import com.TP3.hopitalfantastique.services.ServiceMedical;

public abstract class CreatureMedecin implements Race {
    private String nom;      // Nom de la créature médecin
    private String sexe;     // Sexe de la créature médecin
    private int age;         // Âge de la créature médecin

    /**
     * Constructeur pour initialiser les attributs de la créature médecin
     * @param nom Le nom de la créature médecin
     * @param sexe Le sexe de la créature médecin
     * @param age L'âge de la créature médecin
     */
    public CreatureMedecin(String nom, String sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    // Getter et Setter pour le nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour le sexe
    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    // Getter et Setter pour l'âge
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Méthode pour afficher les informations d'un médecin sous forme de chaîne de char
     * @return Une chaîne représentant la créature médecin avec son nom, sexe et âge
     */
    public String toString () {
        return (nom + " " + sexe + " " + age).toString();
    }

    /**
     * Méthode pour examiner un service médical
     * @param nomService Le service médical à examiner
     * @return La représentation sous forme de chaîne du service médical
     */
    public String examineService (ServiceMedical nomService) {
        return nomService.toString();
    }

    /**
     * Méthode pour réviser le budget d'un service médical
     * @param nomService Le service médical dont le budget est révisé
     * @param nouveauBudget Le nouveau budget à affecter au service
     */
    public void reviseBudget (ServiceMedical nomService, String nouveauBudget) {
        nomService.reviserBudget(nouveauBudget);
    }

    /**
     * Méthode pour transférer une créature vers un autre service médical
     * @param nouveauService Le service médical vers lequel la créature est transférée
     * @param creaturePatient La créature à transférer
     */
    public void transfereCreature (ServiceMedical nouveauService, CreaturePatient creaturePatient) {
        nouveauService.ajouterCreature(creaturePatient);
    }

    /**
     * Méthode pour libérer une créature d'un service médical
     * @param creaturePatient La créature à libérer
     */
    public void libereCreature (CreaturePatient creaturePatient) {
        creaturePatient.getService().enleverCreature(creaturePatient);
    }

    /**
     * Méthode pour soigner une créature malade
     * @param creaturePatient La créature malade à soigner
     * @param maladie La maladie à traiter
     */
    public void soigneCreature (CreaturePatient creaturePatient, String maladie) {
        // Vérifie si la créature médecin et la créature malade appartiennent à la même race avant de soigner
        if (this.getRace() == creaturePatient.getRace()) {
            creaturePatient.estSoignee(maladie);
        }
    }
}
