package VISTA;

import MODELO.Candidat;

import java.util.Scanner;

public class vstCandidat {
    static Scanner scan = new Scanner(System.in);
    public static Candidat crearCandidat() {
        Candidat c = new Candidat();
        System.out.println("Introduce el ID de la candidatura del candidato");
        c.setCandidatura(scan.nextInt());
        System.out.println("Introduce el ID de la persona del candidato");
        c.setPersona(scan.nextInt());
        System.out.println("Introduce el ID de la provincia del candidato");
        c.setProvincia(scan.nextInt());
        System.out.println("Introduce el número de orden del candidato");
        c.setNumOrdre(scan.nextInt());
        System.out.println("Introduce el tipo (T titular/S suplente) del candidato");
        c.setTipus(scan.nextLine());
        return c;
    }
}
