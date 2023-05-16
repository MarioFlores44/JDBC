package CONTROLADOR;

import MODELO.*;
import VISTA.vst;

public class ctrlExiste {
    public static void existeRegistro(int taula) {
        switch (taula) {
            case 1:
                ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                if (caDao.exists(vst.pedirId())) {
                    vst.existe();
                } else {
                    vst.noExiste();
                }
                break;
            case 2:
                ProvinciaDAODB provDao = new ProvinciaDAODB();
                if (provDao.exists(vst.pedirId())) {
                    vst.existe();
                } else {
                    vst.noExiste();
                }
                break;
            case 3:
                MunicipiDAODB munDao = new MunicipiDAODB();
                if (munDao.exists(vst.pedirId())) {
                    vst.existe();
                } else {
                    vst.noExiste();
                }
                break;
            case 4:
                PersonaDAODB perDao = new PersonaDAODB();
                if (perDao.exists(vst.pedirId())) {
                    vst.existe();
                } else {
                    vst.noExiste();
                }
                break;
            case 5:
                CandidaturaDAODB canDao = new CandidaturaDAODB();
                if (canDao.exists(vst.pedirId())) {
                    vst.existe();
                } else {
                    vst.noExiste();
                }
                break;
            case 6:
                CandidatDAODB candDao = new CandidatDAODB();
                if (candDao.exists(vst.pedirId())) {
                    vst.existe();
                } else {
                    vst.noExiste();
                }
                break;
        }
    }
}
