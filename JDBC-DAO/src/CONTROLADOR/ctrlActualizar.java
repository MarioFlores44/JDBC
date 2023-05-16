package CONTROLADOR;

import MODELO.*;
import VISTA.*;

public class ctrlActualizar {
    public static void actualizarRegistro(int taula) {
        vst.actualizar();
        int id;
        switch (taula){
            case 1:
                ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                id = vst.pedirId();
                ComunitatAutonoma ca = vstCA.crearComunitatAutonoma();
                try {
                    caDao.update(ca, id);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 2:
                ProvinciaDAODB provDao = new ProvinciaDAODB();
                id = vst.pedirId();
                Provincia prov = vstProv.crearProvincia();
                try {
                    provDao.update(prov, id);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 3:
                MunicipiDAODB munDao = new MunicipiDAODB();
                id = vst.pedirId();
                Municipi mun = vstMun.crearMunicipi();
                try {
                    munDao.update(mun, id);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 4:
                PersonaDAODB perDao = new PersonaDAODB();
                id = vst.pedirId();
                Persona per = vstPer.crearPersona();
                try {
                    perDao.update(per, id);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 5:
                CandidaturaDAODB canDao = new CandidaturaDAODB();
                id = vst.pedirId();
                Candidatura can = vstCandidatura.crearCandidatura();
                try {
                    canDao.update(can, id);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 6:
                CandidatDAODB candDao = new CandidatDAODB();
                id = vst.pedirId();
                Candidat cand = vstCandidat.crearCandidat();
                try {
                    candDao.update(cand, id);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }
    }
}
