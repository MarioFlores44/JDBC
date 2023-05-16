package CONTROLADOR;

import MODELO.*;
import VISTA.vst;

import java.util.List;

public class ctrlListar {
    public static void listarRegistro(int taula) {
        switch (taula) {
            case 1:
                ComunitatAutonomaDAODB caDao = new ComunitatAutonomaDAODB();
                List<ComunitatAutonoma> listaCA = caDao.all();
                if (listaCA.size() == 0) {
                    vst.listaVacia();
                } else {
                    listaCA.forEach(ca -> ca.toString());
                }
                break;
            case 2:
                ProvinciaDAODB provDao = new ProvinciaDAODB();
                List<Provincia> listaProv = provDao.all();
                if (listaProv.size() == 0) {
                    vst.listaVacia();
                } else {
                    listaProv.forEach(prov -> prov.toString());
                }
                break;
            case 3:
                MunicipiDAODB munDao = new MunicipiDAODB();
                List<Municipi> listaMun = munDao.all();
                if (listaMun.size() == 0) {
                    vst.listaVacia();
                } else {
                    listaMun.forEach(mun -> mun.toString());
                }
                break;
            case 4:
                PersonaDAODB perDao = new PersonaDAODB();
                List<Persona> listaPer = perDao.all();
                if (listaPer.size() == 0) {
                    vst.listaVacia();
                } else {
                    listaPer.forEach(per -> per.toString());
                }
                break;
            case 5:
                CandidaturaDAODB canDao = new CandidaturaDAODB();
                List<Candidatura> listaCan = canDao.all();
                if (listaCan.size() == 0) {
                    vst.listaVacia();
                } else {
                    listaCan.forEach(can -> can.toString());
                }
                break;
            case 6:
                CandidatDAODB candDao = new CandidatDAODB();
                List<Candidat> listaCand = candDao.all();
                if (listaCand.size() == 0) {
                    vst.listaVacia();
                } else {
                    listaCand.forEach(cand -> cand.toString());
                }
                break;
        }
    }
}
