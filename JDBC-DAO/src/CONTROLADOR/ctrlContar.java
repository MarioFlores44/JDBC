package CONTROLADOR;

import MODELO.*;
import VISTA.vst;

public class ctrlContar {
    public static void contarRegistro(int taula) {
        switch (taula){
            case 1:
                ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                vst.contar(caDao.count());
                break;
            case 2:
                ProvinciaDAODB provDao = new ProvinciaDAODB();
                vst.contar(provDao.count());
                break;
            case 3:
                MunicipiDAODB munDao = new MunicipiDAODB();
                vst.contar(munDao.count());
                break;
            case 4:
                PersonaDAODB perDao = new PersonaDAODB();
                vst.contar(perDao.count());
                break;
            case 5:
                CandidaturaDAODB canDao = new CandidaturaDAODB();
                vst.contar(canDao.count());
                break;
            case 6:
                CandidatDAODB candDao = new CandidatDAODB();
                vst.contar(candDao.count());
                break;
        }
    }
}
