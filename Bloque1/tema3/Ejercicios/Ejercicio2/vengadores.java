/* 
Mi xml trata sobre las diferentes sagas de los vengadores las cuales su elemento principal es universo_marvel que es el 
comun que engloba todos los nodos de saga, que a su vez tiene un atributo orden que es el que diferencia las diferentes 
sagasdentro de cada saga tenemos el nombre de la saga y el nodo que engloba las peliculas que hay por cada saga, dentro 
de cada pelicula individual tenemos las etiquetas titulo, duracion, director y año.

Otra parte del xml es donde definimos la escructura que va a tener que tener obligatoriamente nuestro xml, en el vamos 
a definir el tipo de datos que tendremos, si esta obligado a tener ciertos atributos, maximo de nodos, el tipo...





*/

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class vengadores {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(".\\vengadores.xml");
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/universo_marvel/saga";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                System.out.println("\nElemento Actual:" + nNode.getNodeName());
                System.out.println("\nElemento Padre:" + nNode.getParentNode().getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Nombre :" + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Orden :" + eElement.getAttribute("orden"));
                    System.out.println("");

                    String movieExpression = "peliculas/pelicula";
                    NodeList movieNodeList = (NodeList) xPath.compile(movieExpression).evaluate(nNode,
                            XPathConstants.NODESET);

                    for (int j = 0; j < movieNodeList.getLength(); j++) {
                        Node movieNode = movieNodeList.item(j);
                        if (movieNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element movieElement = (Element) movieNode;
                            System.out.println("Título de la Película: "
                                    + movieElement.getElementsByTagName("titulo").item(0).getTextContent());
                            System.out.println("Duración de la Película: "
                                    + movieElement.getElementsByTagName("duracion").item(0).getTextContent());
                            System.out.println("Director de la Película: "
                                    + movieElement.getElementsByTagName("director").item(0).getTextContent());
                            System.out.println("Año de la Película: "
                                    + movieElement.getElementsByTagName("ano").item(0).getTextContent());
                            System.out.println("-----");
                        }
                    }
                    System.out.println("==========");
                }
            }

        } catch (ParserConfigurationException e) {
            System.err.println(
                    "Error de configuración del analizador XML: PARSER CONFIGURATION EXCEPTION " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo XML: " + e.getMessage());
        } catch (XPathExpressionException e) {
            System.err.println("Error en la expresión XPath: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("Error SAX durante el análisis XML: " + e.getMessage());
        }
    }
}