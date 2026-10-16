import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class Ejercicio1 {
    public static void main(String[] args)  {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File("..\\CasoPractico\\fichero.xml");
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/libraries/library";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            int contador;
            for(int i=0;i<nodeList.getLength();i++){
                Node nNode = nodeList.item(i);

                if(nNode.getNodeType()== Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    System.out.println("Biblioteca: " +eElement.getElementsByTagName("name").item(0).getTextContent()+"("+eElement.getAttribute("location")+")");
                    

                    String bookExpression = "books/book";
                    NodeList bookNodeList = (NodeList) xPath.compile(bookExpression).evaluate(nNode, XPathConstants.NODESET);

                    for (int j = 0; j < bookNodeList.getLength(); j++) {
                        Node bookNode = bookNodeList.item(j);
                        if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element bookElement = (Element) bookNode;
                            String titulo =bookElement.getElementsByTagName("title").item(0).getTextContent();
                            String autor =bookElement.getElementsByTagName("author").item(0).getTextContent();
                            String anio =bookElement.getElementsByTagName("year").item(0).getTextContent();
                            System.out.println(autor+" ("+titulo+", "+anio+")");
                        }
                    }
                    System.out.println("Total de libros "+ bookNodeList.getLength());
                    System.out.println(" \n\n");
                }
            }

        } catch (ParserConfigurationException e) {
      System.err.println("Error de configuración del analizador XML: PARSER CONFIGURATION EXCEPTION " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Error de lectura del archivo XML: " + e.getMessage());
    } catch (XPathExpressionException e) {
      System.err.println("Error en la expresión XPath: " + e.getMessage());
    } catch (SAXException e) {
      System.err.println(
        "Error SAX durante el análisis XML: " + e.getMessage());
    }
    }
}