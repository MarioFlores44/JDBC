package VISTA;

import MODELO.Provincia;

import java.util.Scanner;

public class vstProv {
    static Scanner scan = new Scanner(System.in);
    public static Provincia crearProvincia() {
        Provincia p = new Provincia();
        System.out.println("Introduce el ID de la comunidad autonoma de la provincia");
        p.setCA(scan.nextInt());
        scan.nextLine();
        System.out.println("Introduce el nombre de la provincia");
        p.setNom(scan.nextLine());
        System.out.println("Introduce el código INE de la provincia");
        p.setCodi_ine(scan.nextLine());
        System.out.println("Introduce el número de escons de la provincia");
        p.setNumEscons(scan.nextInt());
        return p;
    }

}
