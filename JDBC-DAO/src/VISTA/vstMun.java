package VISTA;

import MODELO.Municipi;

import java.util.Scanner;

public class vstMun {
    static Scanner scan = new Scanner(System.in);
    public static Municipi crearMunicipi() {
        Municipi m = new Municipi();
        System.out.println("Introduce el nombre del municipio");
        m.setNom(scan.nextLine());
        System.out.println("Introduce el código INE del municipio");
        m.setCodi_ine(scan.nextLine());
        System.out.println("Introduce el ID de la provincia del municipio");
        m.setProvincia(scan.nextInt());
        scan.nextLine();
        System.out.println("Introduce el distrito del municipio");
        m.setDistricte(scan.nextLine());
        return m;
    }
}
