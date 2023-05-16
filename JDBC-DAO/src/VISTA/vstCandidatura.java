package VISTA;

import MODELO.Candidatura;

import java.util.Scanner;

public class vstCandidatura {
    static Scanner scan = new Scanner(System.in);
    public static Candidatura crearCandidatura() {
        Candidatura c = new Candidatura();
        System.out.println("Introduce el ID de la elección de la candidatura");
        c.setEleccioId(scan.nextInt());
        System.out.println("Introduce el código de la candidatura");
        c.setCodiCandidatura(scan.nextLine());
        System.out.println("Introduce el nombre corto de la candidatura");
        c.setNomCurt(scan.nextLine());
        System.out.println("Introduce el nombre completo de la candidatura");
        c.setNomLlarg(scan.nextLine());
        System.out.println("Introduce el ID de acumulación provincial de la candidatura");
        c.setCodiAcProvincia(scan.nextLine());
        System.out.println("Introduce el ID de acumulación  de la candidatura");
        c.setCodiAcCA(scan.nextLine());
        System.out.println("Introduce el ID de acumulación nacional de la candidatura");
        c.setCodiAcNacional(scan.nextLine());
        return c;
    }
}
