package Ejercicio8;

    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- MENÚ -----");
        System.out.println("1. Guardar");
        System.out.println("2. Imprimir");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Nombre y Apellidos: ");
            String nombre = scanner.nextLine();


            System.out.print("Email: ");
            String email = scanner.nextLine();


            System.out.print("Fecha de Nacimiento: ");
            String fechaNacimiento = scanner.nextLine();


            System.out.print("Género (Masculino / Femenino): ");
            String genero = scanner.nextLine();


            System.out.print("Titulación de Acceso (FP Grado Medio / FP Grado Superior / Bachillerato): ");
            String titulacion = scanner.nextLine();


            System.out.print("Observaciones: ");
            String observaciones = scanner.nextLine();

            String ficha = "----- Formulario de Matriculación -----\n" +
                    "Nombre y Apellidos: " + nombre + "\n" +
                    "Email: " + email + "\n" +
                    "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                    "Género: " + genero + "\n" +
                    "Titulación de Acceso: " + titulacion + "\n" +
                    "Observaciones:\n" + observaciones + "\n" +
                    "------------------------------------\n";

            try {
                FileWriter fw = new FileWriter("./Ejercicio8/matriculas.txt", true);
                fw.write(ficha);
                fw.close();
                System.out.println("Datos guardados con éxito.");
            } catch (IOException e) {
            }

        } else if (opcion == 2) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("matricula.txt"));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();
            } catch (IOException e) {
            }
        }

        scanner.close();
    }
}

