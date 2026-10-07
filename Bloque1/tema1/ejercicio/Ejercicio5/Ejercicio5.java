
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./Ejercicio5/foto.jpg");
            FileOutputStream fos = new FileOutputStream("./Ejercicio5/filefoto.jpg");

            int data;
            long inicio1 = System.currentTimeMillis();
            while ((data=fis.read())!=-1) {
                fos.write(data);

            }
            long final1 = System.currentTimeMillis();
            System.err.println("El file imput stream a tardado " + (final1-inicio1) + " milisegundos");
            fis.close();
            fos.close();

            
        } catch (Exception e) {
        }
        try {
            
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./Ejercicio5/foto.jpg"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./Ejercicio5/bufferfoto.jpg"));

            long inicio2 = System.currentTimeMillis();
            byte[] tamanio = new byte[4096];
            
            int leidos;
            while ((leidos=bis.read(tamanio))!=-1) { 
                bos.write(tamanio,0,leidos);
            }
            long final2 = System.currentTimeMillis();

            System.out.println("El tiempo pasado con el buffered es = "+(final2-inicio2) + " milisegungos");
            bis.close();
            bos.close();
        } catch (Exception e) {
        }
    }
}
