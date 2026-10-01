package ejercicio.Ejercicio1;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            
        
        FileReader lector = new FileReader("./ejercicio/Ejercicio1/texto.txt");
            
        FileWriter escritor = new FileWriter("./ejercicio/Ejercicio1/copia.txt");
        
        int datos;

        while ((datos = lector.read()) != -1) {
            escritor.write(datos);
        }

        System.out.println("Archivos copiados correctamente");
        
        lector.close();
        escritor.close();
    } catch (Exception e) {
            System.out.println("Algo salio mal");
        }
    }
}
