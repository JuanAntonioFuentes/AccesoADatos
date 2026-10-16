package Ejercicio3;

import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio3 {
    public static void main(String[] args) {
        StreamTokenizer st = new StreamTokenizer(new StringReader("Pan 1.5 Leche 1 Huevos 2.25"));


        String texto;

        while ((st.nextToken()!=StreamTokenizer.TT_EOF)) {
            
        }
    }
}
