package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CandidatDAODB implements DAODB<Candidat>{
    @Override
    public boolean create(Candidat c) {
        String query = "INSERT INTO candidats (candidatura_id,persona_id,provincia_id,num_ordre,tipus) " +
                "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, c.getCandidatura());
            preparedStmt.setInt(2, c.getPersona());
            preparedStmt.setInt(3, c.getProvincia());
            preparedStmt.setInt(4, c.getNumOrdre());
            preparedStmt.setString(5, c.getTipus());
            preparedStmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Candidat read(int id) {
        String query = "SELECT * FROM candidats WHERE candidat_id = ?";
        Candidat c = new Candidat();
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("candidat_id"));
                c.setCandidatura(rs.getInt("candidatura_id"));
                c.setPersona(rs.getInt("persona_id"));
                c.setProvincia(rs.getInt("provincia_id"));
                c.setNumOrdre(rs.getInt("num_ordre"));
                c.setTipus(rs.getString("tipus"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(Candidat c, int id) {
        String query = "UPDATE candidats SET candidatura_id = ?, persona_id = ?, provincia_id = ?, num_ordre = ?, tipus = ? WHERE candidat_id=?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, c.getCandidatura());
            preparedStmt.setInt(2, c.getPersona());
            preparedStmt.setInt(3, c.getProvincia());
            preparedStmt.setInt(4, c.getNumOrdre());
            preparedStmt.setString(5, c.getTipus());
            preparedStmt.setInt(6, id);
            preparedStmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM candidats WHERE candidat_id = ?";

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
        String query = "SELECT * FROM candidats WHERE candidat_id = ?";
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
        String query = "SELECT COUNT(*) FROM candidats";
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
    public List<Candidat> all() {
        List<Candidat> registros = new ArrayList<>();
        String query = "SELECT * FROM candidats";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Candidat c = new Candidat();
                c.setId(rs.getInt("candidat_id"));
                c.setCandidatura(rs.getInt("candidatura_id"));
                c.setPersona(rs.getInt("persona_id"));
                c.setProvincia(rs.getInt("provincia_id"));
                c.setNumOrdre(rs.getInt("num_ordre"));
                c.setTipus(rs.getString("tipus"));
                registros.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registros;
    }

}
