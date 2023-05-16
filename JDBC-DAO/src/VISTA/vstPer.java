package VISTA;

import MODELO.Persona;

import java.util.Scanner;

public class vstPer {
    static Scanner scan = new Scanner(System.in);
    public static Persona crearPersona() {
        Persona p = new Persona();
        System.out.println("Introduce el nombre de la persona");
        p.setNom(scan.nextLine());
        System.out.println("Introduce el primer apellido de la persona");
        p.setCog1(scan.nextLine());
        System.out.println("Introduce el segundo apellido de la persona");
        p.setCog2(scan.nextLine());
        System.out.println("Introduce el sexo (M/F) de la persona");
        p.setSexe(Persona.sexe.valueOf(scan.nextLine()));
        System.out.println("Introduce la fecha de nacimiento de la persona (YYYY-MM-DD)");
        p.setData_naixament(scan.nextLine());
        System.out.println("Introduce el DNI de la persona");
        p.setDni(scan.nextLine());
        return p;
    }
}
