import java.io.RandomAccessFile;

public class Ejemplo7 {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("./casoPractico/abecedario.txt", "r");

            file.seek(5);
            byte[] arrayBytes = new byte[3];

            file.read(arrayBytes,0,3);

            System.out.println("Bytes leidos: " + arrayBytes.length);
            System.out.println("Puntero Despues de read: "+ file.getFilePointer());

            for (int i = 0; i < arrayBytes.length; i++) {
                System.out.println("\n ArrayByte[" + i + "] =" + arrayBytes[i] + " --> " + (char) arrayBytes[i]);
            }
        } catch (Exception e) {
            System.out.println("Algo fallo");
        }
    }
}
