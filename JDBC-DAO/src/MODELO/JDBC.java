package MODELO;

import java.sql.*;
import java.util.LinkedList;

public class JDBC {
    public static Connection con;


    public static Connection openCon(String ip, String bd, String usuari, String pswd) {
        con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + bd + "?serverTimezone=UTC", usuari, pswd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }


    public static void closeCon() {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
