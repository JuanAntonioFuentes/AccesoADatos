
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            
        Scanner sc = new Scanner(System.in);
        LineNumberReader lnr = new LineNumberReader(new FileReader("./Entrada.txt"));
    
        String texto;

        System.out.println("Ingresa numero de linea");
        int linea = Integer.parseInt(sc.nextLine());


        int numeroLineas=0;
        while ((texto = lnr.readLine())!=null) {
            numeroLineas++;
            if(numeroLineas==linea) {
            System.out.println(texto);
        }
        }
        
        
        if (numeroLineas<linea) {
            System.out.println("Numero de linea inferior al numero total de lineas");
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
