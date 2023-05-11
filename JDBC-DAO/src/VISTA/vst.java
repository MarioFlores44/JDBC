package VISTA;

import java.util.Scanner;

public class vst {
    static Scanner scan = new Scanner(System.in);
    public static String pedirConexion() {
        System.out.println("Introduce la IP del servidor");
        return scan.nextLine();
    }

    public static String pedirBD() {
        System.out.println("Introduce el nombre de la base de datos");
        return scan.nextLine();
    }

    public static String pedirUsuario() {
        System.out.println("Introduce el nombre de usuario");
        return scan.nextLine();
    }

    public static String pedirPassword() {
        System.out.println("Introduce la contraseña");
        return scan.nextLine();
    }

    public static void separador() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    public static int menu() {
        System.out.println("Escoge la tabla a tratar:");
        System.out.println();
        System.out.println("1. Comunitats Autonomes");
        System.out.println("2. Provincies (con FK apuntando a Comunitats Autonomes)");
        System.out.println("3. Municipis (con FK apuntando a Provincies)");
        System.out.println("4. Persones");
        System.out.println("5. Candidatures");
        System.out.println("6. Candidats (con FK apuntando a Candidatures, Persones y Provincies)");
        System.out.println("0. Cerrar conexión");
        System.out.println("-------------------------");
        System.out.print("Tabla: ");
        return scan.nextInt();
    }

    public static int subMenu() {
        System.out.println("Escoge la opción a realizar:");
        System.out.println();
        System.out.println("1. Crear");
        System.out.println("2. Leer");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("5. Existe");
        System.out.println("6. Contar");
        System.out.println("7. Listar");
        System.out.println("8. Volver a la selección de tablas");
        System.out.println("0. Cerrar conexión");
        System.out.println("-------------------------");
        System.out.print("Opción: ");
        return scan.nextInt();
    }

    public static void cerrarConexion() {
        System.out.println("Cerrando conexión...");
    }
}
