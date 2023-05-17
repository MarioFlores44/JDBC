package CONTROLADOR;

import MODELO.*;
import VISTA.*;

import java.util.Scanner;

public class ctrl {
    static Scanner scan = new Scanner(System.in);

    static int opcionMenu;
    static int opcioSubMenu;

    public static void programa() {
        conexion();
        menu();
    }

    public static void conexion() {
        String ip = vst.pedirConexion();
        String bd = vst.pedirBD();
        String usuari = vst.pedirUsuario();
        String pswd = vst.pedirPassword();
        JDBC.openCon(ip, bd, usuari, pswd);
    }

    public static void menu() {
        do {
            opcionMenu = vst.menu();
            System.out.println();
            switch (opcionMenu) {
                case 1:
                    subMenu(1);
                    break;
                case 2:
                    subMenu(2);
                    break;
                case 3:
                    subMenu(3);
                    break;
                case 4:
                    subMenu(4);
                    break;
                case 5:
                    subMenu(5);
                    break;
                case 6:
                    subMenu(6);
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

    public static void subMenu(int taula) {
        do {
            opcioSubMenu = vst.subMenu();
            System.out.println();
            switch (opcioSubMenu){
                case 1:
                    ctrlCrear.crearRegistro(taula);
                    break;
                case 2:
                    ctrlLeer.leerRegistro(taula);
                    break;
                case 3:
                    ctrlActualizar.actualizarRegistro(taula);
                    break;
                case 4:
                    ctrlBorrar.borrarRegistro(taula);
                    break;
                case 5:
                    ctrlExiste.existeRegistro(taula);
                    break;
                case 6:
                    ctrlContar.contarRegistro(taula);
                    break;
                case 7:
                    ctrlListar.listarRegistro(taula);
                    break;
                case 8:
                    break;
                case 0:
                    vst.cerrarConexion();
                    JDBC.closeCon();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            System.out.println();
            System.out.println("----------------------------------------------");
            if (opcioSubMenu != 8) {
                System.out.println("\n\tPulsa ENTER para continuar");
                scan.nextLine();
            }
            System.out.println();
        } while (opcioSubMenu >= 1 && opcioSubMenu <= 7);
    }
}

