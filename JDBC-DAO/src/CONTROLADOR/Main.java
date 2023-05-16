package CONTROLADOR;

import MODELO.*;
import VISTA.*;

public class Main {

    static int opcionMenu;
    static int opcioSubMenu;
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
        do {
            opcionMenu = vst.menu();
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
            switch (opcioSubMenu){
                case 1:
                    crearRegistro(taula);
                    break;
                case 2:
                    leerRegistro(taula);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
        } while (opcioSubMenu >= 1 && opcioSubMenu <= 7);
    }

    public static void crearRegistro(int taula) {
        switch (taula) {
            case 1:
                ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                ComunitatAutonoma ca = vstCA.crearComunitatAutonoma();
                try {
                    caDao.create(ca);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 2:
                ProvinciaDAODB provDao = new ProvinciaDAODB();
                Provincia prov = vstProv.crearProvincia();
                try {
                    provDao.create(prov);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 3:
                MunicipiDAODB munDao = new MunicipiDAODB();
                Municipi mun = vstMun.crearMunicipi();
                try {
                    munDao.create(mun);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 4:
                PersonaDAODB perDao = new PersonaDAODB();
                Persona per = vstPer.crearPersona();
                try {
                    perDao.create(per);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 5:
                CandidaturaDAODB canDao = new CandidaturaDAODB();
                Candidatura can = vstCandidatura.crearCandidatura();
                try {
                    canDao.create(can);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 6:
                CandidatDAODB candDao = new CandidatDAODB();
                Candidat cand = vstCandidat.crearCandidat();
                try {
                    candDao.create(cand);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }
    }

        // TODO: Resto de opciones del subMenu

        public static void leerRegistro (int taula) {
            switch (taula) {
                case 1:
                    ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                    caDao.read(vst.pedirId());
                    break;
                case 2:
                    ProvinciaDAODB provDao = new ProvinciaDAODB();
                    provDao.read(vst.pedirId());
                    break;
                case 3:
                    MunicipiDAODB munDao = new MunicipiDAODB();
                    munDao.read(vst.pedirId());
                    break;
                case 4:
                    PersonaDAODB perDao = new PersonaDAODB();
                    perDao.read(vst.pedirId());
                    break;
                case 5:
                    CandidaturaDAODB canDao = new CandidaturaDAODB();
                    canDao.read(vst.pedirId());
                    break;
                case 6:
                    CandidatDAODB candDao = new CandidatDAODB();
                    candDao.read(vst.pedirId());
                    break;
            }
        }
}

