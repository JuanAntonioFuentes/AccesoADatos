package Ejercicios.Ejercicio1;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader("./Ejercicio1/entrada.txt"));
        
            String linea;

            while ((linea = lnr.readLine())!=null) {
                int palabra =0;
                int numeros=0;

                StreamTokenizer st = new StreamTokenizer(new StringReader(linea));


                while ((st.nextToken())!= StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        palabra++;
                    }else if (st.ttype == StreamTokenizer.TT_NUMBER){
                        numeros++;
                    }
                    
                }

            lnr.close();
                System.out.println("Linea " + lnr.getLineNumber()+": "+ linea);
                System.out.println("Palabras: " + palabra + ", Numeros: " + numeros+"\n");
            }
        } catch (Exception e) {
            System.out.println("Algo fallo");
        }
    }
}
