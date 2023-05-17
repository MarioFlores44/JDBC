package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipiDAODB implements DAODB<Municipi>{
    @Override
    public boolean create(Municipi c) {
        String query = "INSERT INTO municipis (nom,codi_ine,provincia_id,districte) " +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setString(1, c.getNom());
            preparedStmt.setString(2, c.getCodi_ine());
            preparedStmt.setInt(3, c.getProvincia());
            preparedStmt.setString(4, c.getDistricte());
            preparedStmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Municipi read(int id) {
        String query = "SELECT * FROM municipis WHERE municipi_id = ?";
        Municipi c = new Municipi();
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("municipi_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                c.setProvincia(rs.getInt("provincia_id"));
                c.setDistricte(rs.getString("districte"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(Municipi c, int id) {
        String query = "UPDATE municipi SET nom = ?, codi_ine = ?, provincia_id = ?, districte = ? WHERE municipi_id=?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setString(1, c.getNom());
            preparedStmt.setString(2, c.getCodi_ine());
            preparedStmt.setInt(3, c.getProvincia());
            preparedStmt.setString(4, c.getDistricte());
            preparedStmt.setInt(5, id);
            preparedStmt.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM municipis WHERE municipi_id = ?";

        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);
            preparedStmt.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        String query = "SELECT * FROM municipis WHERE municipi_id = ?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM municipis";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else return 0;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<Municipi> all() {
        List<Municipi> registros = new ArrayList<>();
        String query = "SELECT * FROM municipis";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Municipi c = new Municipi();
                c.setId(rs.getInt("municipi_id"));
                c.setProvincia(rs.getInt("provincia_id"));
                c.setNom(rs.getString("nom"));
                c.setCodi_ine(rs.getString("codi_ine"));
                c.setDistricte(rs.getString("districte"));
                registros.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return registros;
    }

}
