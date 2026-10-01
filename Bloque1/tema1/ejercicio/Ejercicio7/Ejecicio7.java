package Ejercicio7;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejecicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la posición inicial del rango: ");
        int inicio = scanner.nextInt();
        System.out.print("Introduce cuántos asientos quieres consultar: ");
        int cantidad = scanner.nextInt();

        if (inicio < 0 || cantidad <= 0 || (inicio + cantidad) > 20) {
            System.out.println("Error: El rango especificado no es válido.");
        } else {
            try {
                RandomAccessFile archivo = new RandomAccessFile("./Ejercicio6/asientos.txt", "r");
                archivo.seek(inicio);

                byte[] bloque = new byte[cantidad];
                archivo.read(bloque, 0, cantidad);

                String mensaje = "rango de asientos disponibles";

                for (int i = 0; i < cantidad; i++) {
                    int numeroAsiento = inicio + i;
                    char estado = (char) bloque[i];

                    if (estado == 'C') {
                        mensaje = "lo siento el rango no sera posible ocuparlo ya que hay gente en el asiento " + numeroAsiento;
                        i = cantidad;
                    }
                }

                System.out.println(mensaje);

                archivo.close();
            } catch (IOException e) {
            }
        }
        scanner.close();
    }
}
