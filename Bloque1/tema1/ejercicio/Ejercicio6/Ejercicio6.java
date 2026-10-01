import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de asiento que quieres comprar (0-19): ");
        int numeroAsiento = scanner.nextInt();

        if (numeroAsiento < 0 || numeroAsiento > 19) {
            System.out.println("Error: El asiento no existe o no está disponible.");
        } else {
            try {
                RandomAccessFile archivo = new RandomAccessFile("./Ejercicio6/asientos.txt", "rw");
                archivo.seek(numeroAsiento);
                char estado = (char) archivo.readByte();

                if (estado == 'C') {
                    System.out.println("El asiento " + numeroAsiento + " ya está ocupado.");
                } else if (estado == 'L') {
                    archivo.seek(numeroAsiento);
                    archivo.writeByte('C');
                    System.out.println("¡Reserva realizada con éxito! Asiento " + numeroAsiento + " marcado como comprado (C).");
                }

                archivo.close();
            } catch (IOException e) {
            }
        }
        scanner.close();
    }
}