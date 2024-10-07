
package ma.projet.beans;

public class Personne {

    private int id;
    private String nom;
    private double salaire;

    public Personne(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }
    public Personne(int id,String nom, double salaire) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
    }

    // Getters et setters
    public int getId() {
        return id;
    }
    public void setId(int id) { 
        this.id = id;
    }

    public String getNom() {
        return nom; 
    }
    public void setNom(String nom) {
        this.nom = nom; 
    }

    public double getSalaire() { 
        return salaire; 
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire; 
    }

    void add(Personne developpeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
