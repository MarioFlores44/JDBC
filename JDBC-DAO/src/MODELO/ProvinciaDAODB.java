package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDAODB implements DAODB<Provincia>{
    @Override
    public boolean create(Provincia c) {
        String query = "INSERT INTO provincies (comunitat_aut_id,nom,codi_ine,num_escons) " +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, c.getCA());
            preparedStmt.setString(2, c.getNom());
            preparedStmt.setString(3, c.getCodi_ine());
            preparedStmt.setInt(4, c.getNumEscons());
            preparedStmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Provincia read(int id) {
        String query = "SELECT * FROM provincies WHERE provincia_id = ?";
        Provincia c = new Provincia();
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("provincia_id"));
                c.setCA(rs.getInt("comunitat_aut_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                c.setNumEscons(rs.getInt("num_escons"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(Provincia c, int id) {
        String query = "UPDATE provincies SET nom = ?, codi_ine = ? WHERE comunitat_aut_id=?";
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
        String query = "DELETE FROM provincies WHERE provincia_id = ?";

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
        String query = "SELECT * FROM provincies WHERE provincia_id = ?";
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
        String query = "SELECT COUNT(*) FROM provincies";
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
    public List<Provincia> all() {
        List<Provincia> registros = new ArrayList<>();
        String query = "SELECT * FROM provincies";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Provincia c = new Provincia();
                c.setId(rs.getInt("provincia_id"));
                c.setCA(rs.getInt("comunitat_aut_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                c.setNumEscons(rs.getInt("num_escons"));
                registros.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registros;
    }

}
