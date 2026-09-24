import java.io.RandomAccessFile;

public class Ejemplo6 {
    public static void main(String[] args) {
        try {
            
        
        RandomAccessFile file = new RandomAccessFile("./Bloque1/tema1/casoPractico/abecedario.txt", "rw");
        file.seek(5);

        System.out.println("Puntero Antes de leer: " + file.getFilePointer());

        int unbyte = file.read();
        
        
        System.out.println("Puntero Despues de leer: " + file.getFilePointer());
        System.out.println((char)unbyte);

        file.write('F'); //Escribirá la letra F
            System.out.println("Puntero DESPUES de escribir: " + file.getFilePointer()); // te dirá 7
            file.close();
        } catch (Exception e) {
            System.out.println("Algo esta mal");
        }
    }
}
