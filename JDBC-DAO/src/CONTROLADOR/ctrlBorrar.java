package CONTROLADOR;

import MODELO.*;
import VISTA.vst;

public class ctrlBorrar {
    public static void borrarRegistro(int taula) {
        switch (taula) {
            case 1:
                ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                try {
                    caDao.delete(vst.pedirId());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 2:
                ProvinciaDAODB provDao = new ProvinciaDAODB();
                try {
                    provDao.delete(vst.pedirId());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 3:
                MunicipiDAODB munDao = new MunicipiDAODB();
                try {
                    munDao.delete(vst.pedirId());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 4:
                PersonaDAODB perDao = new PersonaDAODB();
                try {
                    perDao.delete(vst.pedirId());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 5:
                CandidaturaDAODB canDao = new CandidaturaDAODB();
                try {
                    canDao.delete(vst.pedirId());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 6:
                CandidatDAODB candDao = new CandidatDAODB();
                try {
                    candDao.delete(vst.pedirId());
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }
    }
}
