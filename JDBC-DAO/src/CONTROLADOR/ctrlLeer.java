package CONTROLADOR;

import MODELO.*;
import VISTA.vst;

public class ctrlLeer {
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
