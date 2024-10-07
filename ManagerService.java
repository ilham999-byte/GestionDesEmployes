
package ma.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ma.projet.beans.Manager;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;


public class ManagerService implements IDao<Manager> {

  private Connection connection;

    
    public ManagerService() {
        this.connection = Connexion.getConnection(); // Obtenir la connexion
    }


    @Override
    public boolean create(Manager m) {
        String sql = "INSERT INTO manager (nom, salaire) VALUES ( ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, m.getNom());
            ps.setDouble(2, m.getSalaire());
           

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Manager m) {
        String sql = "UPDATE manager SET nom = ?, salaire = ?  WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, m.getNom());
            ps.setDouble(2, m.getSalaire());
           
            ps.setInt(3, m.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Manager m) {
        String sql = "DELETE FROM manager WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, m.getId());

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Manager getById(int id) {
        String sql = "SELECT * FROM manager WHERE id = ?";
        Manager manager = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                double salaire = rs.getDouble("salaire");
               
                manager = new Manager(id, nom, salaire);
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Override
    public List<Manager> getAll() {
        String sql = "SELECT * FROM manager";
        List<Manager> managers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double salaire = rs.getDouble("salaire");
                

                Manager manager = new Manager(id, nom, salaire);
               
                managers.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }
}