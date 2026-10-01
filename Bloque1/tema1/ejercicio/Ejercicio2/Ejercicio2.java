package ejercicio.Ejercicio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            FileInputStream origen = new FileInputStream("./ejercicio/Ejercicio2/foto.jpg");

            FileOutputStream destino = new FileOutputStream("./ejercicio/Ejercicio2/foto_copia.jpg");

            int copiados = 0;


            int leidos;

            while ((leidos = origen.read())!=-1) {
                destino.write(leidos);
                copiados++;             
            }

            System.out.println("Tamaño total del archivo copiado es de " + copiados);
        } catch (Exception e) {
            System.out.println("Algo fallo");
        }
    }
}
