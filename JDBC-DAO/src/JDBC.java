import java.sql.*;
import java.util.LinkedList;

public class JDBC {

    /**
     * Connectar amb una BD indicada en el paràmetre 'url'.
     * @param url Protocol i ruta cap a la BD<br>Exemple: "dbviewer:sqlite:prova.db"
     * @return Connexió amb la BD o 'null' si no s'ha pogut connectar
     */
    public static Connection openCon(String url) {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }

    /**
     * Desconnectar d'una BD.
     * @param con Connexió amb la BD
     */
    public static void closeCon(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Fer una sentència que modifica la base de dades.
     * @param db Path de la base de dades
     * @param query Sentència SQL
     * @return Valor que retorna executeUpdate(query)
     */
    public static int update(String db, String query) {
        Connection con = JDBC.openCon("jdbc:sqlite:" + db);
        if (con == null) return -1;

        int r = -1;

        try {
            Statement stmt = con.createStatement();
            r = stmt.executeUpdate(query);
            System.out.println(r);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBC.closeCon(con);
        }

        return r;
    }

    /**
     * Fer una sentència de consulta a la base de dades.
     * @param db Path de la base de dades
     * @param query Sentència SQL
     * @return ResultSet que retorna executeQuery(query)
     */
    public static ResultSet select(String db, String query) {
        Connection con = JDBC.openCon("jdbc:sqlite:" + db);
        if (con == null) return null;

        ResultSet rs = null;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBC.closeCon(con);
        }

        return rs;
    }

    /**
     * Fer una sentència o sentències SQL genèriques.
     * @param db Path de la base de dades
     * @param query Sentència SQL
     */
    public static void execute(String db, String query) {
        Connection con = JDBC.openCon("jdbc:sqlite:" + db);
        if (con == null) return;

        try {
            Statement stmt = con.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JDBC.closeCon(con);
        }
    }

    /**
     * Obtenir els valors de tots els camps de cada registre de la consulta
     * @param rs Conjunt de registres retornats per la consulta
     * @return Array amb els valors en forma d'String
     */
    public static String[][] getRsValues(ResultSet rs) {
        LinkedList<String[]> regList = new LinkedList<>();
        int nRows = 0;
        int nCols = 0;
        int i;

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            nCols = rsmd.getColumnCount();

            while(rs.next()) {
                String[] s = new String[nCols];
                for (i = 0; i < nCols; i++) {
                    // TODO: obtenir valor segons el tipus de dada (int, float...) ???
                    s[i] =  rs.getString(i + 1);
                }
                regList.add(s);
                nRows++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        i = 0;
        String[][] registres = new String[nRows][nCols];
        while (!regList.isEmpty()) {
            registres[i] = regList.remove();
            ++i;
        }

        return registres;
    }

    /**
     * Obtenir el nom i el tipus de cada camp d'una consulta.
     * @param rs Conjunt de registres retornats per la consulta
     * @return Array amb el nom i el tipus de cada camp: [][0] --> nom; [][1] --> tipus
     */
    public static String[][] getRsFields(ResultSet rs) {
        String[][] s = null;

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int nCols = rsmd.getColumnCount();
            s = new String[nCols][2];
            for (int i = 0; i < nCols; i++) {
                s[i][0] =  rsmd.getColumnName(i + 1);
                s[i][1] =  rsmd.getColumnTypeName(i + 1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return s;
    }

    /**
     * Obtenir el màxim de caràcters que hi ha en cada camp.
     * @param data Conjunt de dades
     * @return Array d'enters amb l'amplada màxima en caràcters de cada camp
     */
    public static int[] getMaxChars(String[][] data, String[] fields, boolean includeFields) {
        int[] w = null;
        int c;
        int i;

        if (includeFields && fields != null) {
            c = fields.length;
            w = new int[c];
            for (i = 0; i < c; ++i) {
                w[i] = (fields[i]).length();
            }
        }

        if (data != null && data.length > 0) {
            c = data[0].length;
            if (w == null) w = new int[c];
            for (String[] d : data) {
                for (i = 0; i < c; ++i) {
                    if (d[i] != null && w[i] < (d[i]).length()) {
                        w[i] = (d[i]).length();
                    }
                }
            }
        }

        return w;
    }

}
