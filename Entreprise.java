
package ma.projet.test;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.beans.Personne;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

public class Entreprise {
    public static void main(String[] args) {
        // Création des services
        DeveloppeurService ds = new DeveloppeurService();
        ManagerService ms = new ManagerService();

        // Création des développeurs
        Developpeur dev1 = new Developpeur("Ali", 3000);
        Developpeur dev2 = new Developpeur("Fatima", 3200);
        ds.create(dev1);
        ds.create(dev2);

        // Création du manager
        Manager manager = new Manager("Mohamed", 5000);
        manager.ajouterDeveloppeur(dev1);
        manager.ajouterDeveloppeur(dev2);
        ms.create(manager);

        // Création d'un 3ème développeur
        Developpeur dev3 = new Developpeur("Ahmed", 3500);
        ds.create(dev3);

        // Création du directeur général
        Manager directeur = new Manager("Khalid", 7000);
        directeur.ajouterDeveloppeur(dev3);
        directeur.ajouterManager(manager);
        ms.create(directeur);

        // Affichage de la hiérarchie
        afficherHierarchie(directeur);
    }

    public static void afficherHierarchie(Manager directeur) {
        System.out.println("Directeur : " + directeur.getNom() + ", Salaire : " + directeur.getSalaire());
        for (Personne p : directeur.getDeveloppeurs()) {
            if (p instanceof Manager) {
                afficherHierarchie((Manager) p); // Récursion pour afficher la hiérarchie
            } else {
                System.out.println(" - Developpeur : " + p.getNom() + ", Salaire : " + p.getSalaire());
            }
        }
    }
}