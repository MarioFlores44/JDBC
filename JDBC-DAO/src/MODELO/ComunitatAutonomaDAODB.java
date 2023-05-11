package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComunitatAutonomaDAODB implements DAODB<ComunitatAutonoma>{
    @Override
    public boolean create(ComunitatAutonoma c) {
        String query = "INSERT INTO comunitats_autonomes (nom,codi_ine) " +
                "VALUES (?,?,?)";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setString(1, c.getNom());
            preparedStmt.setString(2, c.getCodi_ine());
            preparedStmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public ComunitatAutonoma read(int id) {
        String query = "SELECT * FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
        ComunitatAutonoma c = new ComunitatAutonoma();
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("comunitat_aut_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(ComunitatAutonoma c, int id) {
        String query = "UPDATE comunitats_autonomes SET nom = ?, codi_ine = ? WHERE comunitat_aut_id=?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setString(1, c.getNom());
            preparedStmt.setString(2, c.getCodi_ine());
            preparedStmt.setInt(3, id);
            preparedStmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM comunitats_autonomes WHERE comunitat_aut_id = ?";

        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);
            preparedStmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT * FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM comunitats_autonomes";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<ComunitatAutonoma> all() {
        List<ComunitatAutonoma> registros = new ArrayList<>();
        String query = "SELECT * FROM candidatures";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                ComunitatAutonoma c = new ComunitatAutonoma();
                c.setId(rs.getInt("comunitat_aut_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                registros.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registros;
    }

}
