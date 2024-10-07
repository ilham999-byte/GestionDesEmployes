
package ma.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ma.projet.beans.Developpeur;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;


public class DeveloppeurService implements IDao<Developpeur> {

    private Connection connection;

    
    public DeveloppeurService() {
        this.connection = Connexion.getConnection(); // Obtenir la connexion
    }


    @Override
    public boolean create(Developpeur d) {
        String sql = "INSERT INTO developpeur (id,nom, salaire) VALUES ( ?,?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getId());
            ps.setString(2, d.getNom());
            ps.setDouble(3, d.getSalaire());
            
          

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Developpeur d) {
        String sql = "UPDATE developpeur SET nom = ?, salaire = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, d.getNom());
            ps.setDouble(2, d.getSalaire());
        
            ps.setInt(3, d.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Developpeur d) {
        String sql = "DELETE FROM developpeur WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getId());

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Developpeur getById(int id) {
        String sql = "SELECT * FROM developpeur WHERE id = ?";
        Developpeur developpeur = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                double salaire = rs.getDouble("salaire");
                
                developpeur = new Developpeur(id, nom, salaire);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developpeur;
    }

    @Override
    public List<Developpeur> getAll() {
        String sql = "SELECT * FROM developpeur";
        List<Developpeur> developpeurs = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double salaire = rs.getDouble("salaire");
                

                Developpeur developpeur = new Developpeur(id, nom, salaire);
                
                developpeurs.add(developpeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developpeurs;
    }
}