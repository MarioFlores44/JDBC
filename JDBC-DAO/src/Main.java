import CONTROLADOR.ctrl;
import MODELO.Candidatura;
import MODELO.CandidaturaDAODB;
import MODELO.JDBC;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ctrl.programa();
        /*
        try {
            JDBC.openCon("192.168.56.103", "prog_UF6", "perepi", "pastanaga");
            CandidaturaDAODB candidaturaDAODB = new CandidaturaDAODB();
            Candidatura cand = new Candidatura(1, "1", "CA", "Candidatura", "1", "1", "1");
            candidaturaDAODB.create(cand);
            if (candidaturaDAODB.exists(1)) System.out.println("Existe");
            Candidatura cand2 = new Candidatura(2, "1", "C2", "Candidatura 2", "2" ,"2" ,"2");
            candidaturaDAODB.create(cand2);
            Candidatura read = candidaturaDAODB.read(1);
            read.toString();
            int x = candidaturaDAODB.count();
            System.out.println(x);
            Candidatura update = new Candidatura(2, "2", "C2", "Candidatura 2", "2" ,"2" ,"2");
            candidaturaDAODB.update(update, 2);
            List<Candidatura> lista = candidaturaDAODB.all();
            lista.forEach(c -> c.toString());
            candidaturaDAODB.delete(2);
            if (candidaturaDAODB.exists(2)) System.out.println("Existe 2");
            else System.out.println("No existe 2");
            JDBC.closeCon();
        } catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}
