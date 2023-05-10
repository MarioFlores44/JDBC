package MODELO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidaturaDAODB implements DAODB<Candidatura>{
    @Override
    public boolean create(Candidatura c) {
        String query = "INSERT INTO candidatures (eleccioId,codi_candidatura,nom_curt,nom_llarg," +
                "codi_acumulacio_provincia,codi_acumulacio_ca,codi_acumulacio_nacional) " +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, c.getEleccioId());
            preparedStmt.setString(2, c.getCodiCandidatura());
            preparedStmt.setString(3, c.getNomCurt());
            preparedStmt.setString(4, c.getNomLlarg());
            preparedStmt.setString(5, c.getCodiAcNacional());
            preparedStmt.setString(6, c.getCodiAcCA());
            preparedStmt.setString(7, c.getCodiAcNacional());
            preparedStmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Candidatura read(int id) {
        String query = "SELECT * FROM candidatures WHERE id = ?";
        Candidatura c = null;
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                c.setCandidaturaId(rs.getInt("candidatura_id"));
                c.setEleccioId(rs.getInt("eleccio_id"));
                c.setCodiCandidatura(rs.getString("codi_candidatura"));
                c.setNomCurt(rs.getString("nom_curt"));
                c.setNomLlarg(rs.getString("nom_llarg"));
                c.setCodiAcProvincia(rs.getString("codi_acumulacio_provincia"));
                c.setCodiAcCA(rs.getString("codi_acumulacio_ca"));
                c.setCodiAcNacional(rs.getString("codi_acumulacio_nacional"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public boolean update(Candidatura c, int id) {
        String query = "UPDATE candidatures SET eleccio_id = ?, codi_candidatura = ?, nom_curt = ?, nom_llarg = ?, " +
                "codi_acumulacio_provincia = ?, codi_acumuladio_ca = ?, codi_acumulacio_nacional = ? WHERE id=?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, c.getEleccioId());
            preparedStmt.setString(2, c.getCodiCandidatura());
            preparedStmt.setString(3, c.getNomCurt());
            preparedStmt.setString(4, c.getNomLlarg());
            preparedStmt.setString(5, c.getCodiAcProvincia());
            preparedStmt.setString(6, c.getCodiAcCA());
            preparedStmt.setString(7, c.getCodiAcNacional());
            preparedStmt.setInt(8, id);
            preparedStmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM candidatures WHERE id = ?";

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
        String query = "SELECT * FROM candidatures WHERE id = ?";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);

            preparedStmt.setInt(1, id);

            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM candidatures";
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
    public List<Candidatura> all() {
        List<Candidatura> registros = new ArrayList<>();
        String query = "SELECT * FROM candidatures";
        try {
            PreparedStatement preparedStmt = JDBC.con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Candidatura c = null;
                c.setCandidaturaId(rs.getInt("candidatura_id"));
                c.setEleccioId(rs.getInt("eleccio_id"));
                c.setCodiCandidatura(rs.getString("codi_candidatura"));
                c.setNomCurt(rs.getString("nom_curt"));
                c.setNomLlarg(rs.getString("nom_llarg"));
                c.setCodiAcProvincia(rs.getString("codi_acumulacio_provincia"));
                c.setCodiAcCA(rs.getString("codi_acumulacio_ca"));
                c.setCodiAcNacional(rs.getString("codi_acumulacio_nacional"));
                registros.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return registros;
    }

}
