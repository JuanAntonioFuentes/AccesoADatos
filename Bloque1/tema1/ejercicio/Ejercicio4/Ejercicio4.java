
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class Ejercicio4 {
    public static void main(String[] args) {
        int tamanio = 1024;

        byte[] buffer = new byte[tamanio];
        
        try {
            BufferedInputStream entrada = new BufferedInputStream(new FileInputStream("./Ejercicio4/foto.jpg"));

            BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream("./Ejercicio4/fotoCopia.jpg"));

            int bytesleidos;
            while ((bytesleidos=entrada.read(buffer))!=-1) {
                salida.write(buffer,0,bytesleidos);
            }
            entrada.close();
            salida.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
