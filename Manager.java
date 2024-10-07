
package ma.projet.beans;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Personne {
    private List<Developpeur> developpeurs;
    private List<Manager> managers; // Changer le type de la liste en Manager

    public Manager(String nom, double salaire) {
        super(nom, salaire);
        developpeurs = new ArrayList<>();
        managers = new ArrayList<>(); // Initialisation de la liste des managers
    }

    public Manager(int id, String nom, double salaire) {
        super(id, nom, salaire);
        developpeurs = new ArrayList<>(); // Initialisation de la liste des développeurs
        managers = new ArrayList<>(); // Initialisation de la liste des managers
    }

    // Ajoute un développeur à la liste des développeurs
    public void ajouterDeveloppeur(Developpeur dev) {
        if (dev != null) {
            developpeurs.add(dev); // Ajout à la liste
        } else {
            throw new IllegalArgumentException("Le développeur ne peut pas être null");
        }
    }

    // Ajoute un manager à la liste des managers
    public void ajouterManager(Manager manager) { // Renommer la méthode pour plus de clarté
        if (manager != null) {
            managers.add(manager); // Ajout à la liste des managers
        } else {
            throw new IllegalArgumentException("Le manager ne peut pas être null");
        }
    }

    // Getter pour obtenir la liste des développeurs
    public List<Developpeur> getDeveloppeurs() {
        return developpeurs;
    }

    // Getter pour obtenir la liste des managers
    public List<Manager> getManagers() {
        return managers;
    }

    public void ajouterDeveloppeur(Manager manager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}