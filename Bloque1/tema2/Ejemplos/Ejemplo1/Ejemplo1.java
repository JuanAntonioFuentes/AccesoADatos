package tema2.Ejemplos.Ejemplo1;

import java.io.FileReader;
import java.io.StreamTokenizer;

public class Ejemplo1 {
    public static void main(String[] args) {
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("./datos.txt"));
            
            streamTokenizer.eolIsSignificant(true); 

            int palabras = 0;

            int numero =0;

            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Palabra "+streamTokenizer.sval); // token de tipo palabra

                    palabras++;
                    
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Numero "+streamTokenizer.nval); // token de tipo número

                    numero ++;
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println(); // fin de línea
                }
                
            }
            System.out.println("Hay " + palabras + " palabras\nHay " + numero + " numeros.");
        } catch (Exception e) {
            System.out.println("Algo fallo");
        }
    }
}
