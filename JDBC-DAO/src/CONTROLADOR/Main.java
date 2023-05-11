package CONTROLADOR;

import MODELO.*;
import VISTA.vst;
import com.mysql.cj.x.protobuf.MysqlxExpr;

public class Main {

    static CandidaturaDAODB candidaturaDAODB;
    public static void main(String[] args) {
        programa();
    }

    public static void programa() {
        conexion();
        menu();
    }

    public static void conexion() {
        String ip = vst.pedirConexion();
        String bd = vst.pedirBD();
        String usuari = vst.pedirUsuario();
        String pswd = vst.pedirPassword();
    }

    public static void menu() {
        int opcionMenu;
        do {
            opcionMenu = vst.menu();
            switch (opcionMenu) {
                case 1:
                    //ComunintatAutonomeDAODB ca = new ComunintatsAutonomeDAODB();
                    break;
                case 2:
                    //ProvinciaDAODB p = new ProvinciaDAODB();
                    break;
                case 3:
                    //MunicipiDAODB m = new MunicipiDAODB();
                    break;
                case 4:
                    //PersonaDAODB p = new PersonaDAODB();
                    break;
                case 5:
                    CandidaturaDAODB c = new CandidaturaDAODB();

                    break;
                case 6:
                    //CandidateDAODB c = new CandidateDAODB();
                    break;
                case 0:
                    vst.cerrarConexion();
                    JDBC.closeCon();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionMenu >= 1 && opcionMenu <= 6);
    }

    public static void subMenu(Object tabla) {
        int opcioSubMenu;
        do {
            opcioSubMenu = vst.subMenu();
            switch (opcioSubMenu){
                case 1:
                    //tabla.create();
                    //O como contra opcion, crear una funcion con otro Switch
                    break;
            }
        } while (opcioSubMenu >= 1 && opcioSubMenu <= 8);
    }


}
