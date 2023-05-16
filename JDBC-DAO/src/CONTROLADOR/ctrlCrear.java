package CONTROLADOR;

import MODELO.*;
import VISTA.*;

public class ctrlCrear {
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
}
