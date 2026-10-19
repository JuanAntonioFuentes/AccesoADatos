import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Paso6 {

    public static void main(String[] args) {

        // Constantes para realizar las distintas pruebas del Paso 6
        String fichero   = "marvel.xml"; // Cambiar para Pruebas 1 y 2
        String etiqueta  = "nombre";                      // Cambiar para Prueba 3
        String atributo  = "orden";                       // Cambiar para Prueba 4
        String expresion = "/universo_marvel/saga";       // Cambiar para Pruebas 5 y 6

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fichero));
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList sagas = (NodeList) xPath.compile(expresion).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < sagas.getLength(); i++) {
                Element saga = (Element) sagas.item(i);
                
                // Se extraen la etiqueta y el atributo configurados en las variables
                String nombreSaga = saga.getElementsByTagName(etiqueta).item(0).getTextContent();
                String ordenSaga  = saga.getAttribute(atributo);
                
                System.out.println("Saga: " + nombreSaga + " (Orden: " + ordenSaga + ")");

                // Recorrido de las películas dentro de la saga
                NodeList peliculas = saga.getElementsByTagName("pelicula");
                for (int j = 0; j < peliculas.getLength(); j++) {
                    Element pelicula = (Element) peliculas.item(j);
                    String titulo = pelicula.getElementsByTagName("titulo").item(0).getTextContent();
                    String duracion = pelicula.getElementsByTagName("duracion").item(0).getTextContent();
                    String director = pelicula.getElementsByTagName("director").item(0).getTextContent();
                    String ano = pelicula.getElementsByTagName("ano").item(0).getTextContent();
                    
                    System.out.println("   -> Película: " + titulo + " | " + duracion + " | " + director + " | " + ano);
                }
                System.out.println("--------------------------------------------------");
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del analizador: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero XML (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error SAX (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        } catch (XPathExpressionException e) {
            System.out.println("Error en la expresión XPath: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Otro error (NullPointerException): Etiqueta o elemento no encontrado.");
        } catch (Exception e) {
            System.out.println("Otro error (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        }
    }
}
