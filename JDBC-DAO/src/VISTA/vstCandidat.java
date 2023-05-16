package VISTA;

import MODELO.Candidat;

import java.util.Scanner;

public class vstCandidat {
    static Scanner scan = new Scanner(System.in);
    public static Candidat crearCandidat() {
        Candidat c = new Candidat();
        System.out.println("Introduce el ID de la candidatura del candidato");
        c.setCandidatura(scan.nextInt());
        scan.nextLine();
        System.out.println("Introduce el ID de la persona del candidato");
        c.setPersona(scan.nextInt());
        scan.nextLine();
        System.out.println("Introduce el ID de la provincia del candidato");
        c.setProvincia(scan.nextInt());
        scan.nextLine();
        System.out.println("Introduce el número de orden del candidato");
        c.setNumOrdre(scan.nextInt());
        scan.nextLine();
        System.out.println("Introduce el tipo (T titular/S suplente) del candidato");
        c.setTipus(scan.nextLine());
        return c;
    }
}
