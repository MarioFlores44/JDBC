package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAODB implements DAODB<Persona>{
    @Override
    public boolean create(Persona c) {
        String query = "INSERT INTO persones (nom,cog1,cog2,sexe,data_naixement,dni) " +
                "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setString(1, c.getNom());
            preparedStmt.setString(2, c.getCog1());
            preparedStmt.setString(3, c.getCog2());
            preparedStmt.setString(4, c.getSexe());
            preparedStmt.setString(5, c.getData_naixament());
            preparedStmt.setString(6, c.getDni());
            preparedStmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Persona read(int id) {
        String query = "SELECT * FROM persones WHERE persona_id = ?";
        Persona c = new Persona();
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("persona_id"));
                c.setNom(rs.getString("nom"));
                c.setCog1(rs.getString("cog1"));
                c.setCog2(rs.getString("cog2"));
                c.setSexe(Persona.sexe.valueOf(rs.getString("sexe")));
                c.setData_naixament(rs.getString("data_naixement"));
                c.setDni(rs.getString("dni"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(Persona c, int id) {
        String query = "UPDATE persones SET nom = ?, cog1 = ?, cog2 = ?, sexe = ?, data_naixement = ?, dni = ? WHERE persona_id=?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setString(1, c.getNom());
            preparedStmt.setString(2, c.getCog1());
            preparedStmt.setString(3, c.getCog2());
            preparedStmt.setString(4, c.getSexe());
            preparedStmt.setString(5, c.getData_naixament());
            preparedStmt.setString(6, c.getDni());
            preparedStmt.setInt(7, id);
            preparedStmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM persones WHERE persona_id = ?";

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
        String query = "SELECT * FROM persones WHERE persona_id = ?";
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
        String query = "SELECT COUNT(*) FROM persones";
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
    public List<Persona> all() {
        List<Persona> registros = new ArrayList<>();
        String query = "SELECT * FROM persones";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Persona c = new Persona();
                c.setId(rs.getInt("persona_id"));
                c.setNom(rs.getString("nom"));
                c.setCog1(rs.getString("cog1"));
                c.setCog2(rs.getString("cog2"));
                c.setSexe(Persona.sexe.valueOf(rs.getString("sexe")));
                c.setData_naixament(rs.getString("data_naixement"));
                c.setDni(rs.getString("dni"));
                registros.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registros;
    }

}
