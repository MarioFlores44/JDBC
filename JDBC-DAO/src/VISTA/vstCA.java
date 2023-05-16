package VISTA;

import MODELO.ComunitatAutonoma;

import java.util.Scanner;

public class vstCA {
    static Scanner scan = new Scanner(System.in);
    public static ComunitatAutonoma crearComunitatAutonoma() {
        ComunitatAutonoma ca = new ComunitatAutonoma();
        System.out.println("Introduce el nombre de la Comunidad Autónoma");
        ca.setNom(scan.nextLine());
        System.out.println("Introduce el código INE de la Comunidad Autónoma");
        ca.setCodi_ine(scan.nextLine());
        return ca;
    }
}
