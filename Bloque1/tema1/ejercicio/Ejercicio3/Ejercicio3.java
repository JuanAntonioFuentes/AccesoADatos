package ejercicio.Ejercicio3;

import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            
        Scanner sc = new Scanner(System.in);
        FileWriter escribir = new FileWriter("./ejercicio/Ejercicio3/abecedario.txt");
        
        for (char c ='A'; c <= 'Z'; c++) {
            escribir.write(c);
        }
        escribir.close();

        System.out.println("Indique la posición en la que desea escreibir");
        int posicion = Integer.parseInt(sc.nextLine());

        System.out.println("Escriba el caracter que desea escribir");
        char caracter = sc.next().charAt(0);


        

        RandomAccessFile sobreExcribir = new RandomAccessFile("./ejercicio/Ejercicio3/abecedario.txt", "rw");

        sobreExcribir.seek(posicion);

        sobreExcribir.write(caracter);


        sc.close();sobreExcribir.close();
        } catch (Exception e) {
                // TODO: handle exception
        }
    }
}
