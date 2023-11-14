package lectura;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerXML {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db;
		Document document;
		File file;
		XPath xPath; 
		NodeList nodeList;
		String path;
		
		try {
			
			db = dbf.newDocumentBuilder();
			file = new File("personas.xml");
			document = db.parse(file);
			
			document.normalizeDocument();
			
			xPath = XPathFactory.newInstance().newXPath();
			
			//LA CONSULTA
			path = "//persona";
			
			//Los nodos resultantes de la consulta
			nodeList = (NodeList) xPath.compile(path).evaluate(document, XPathConstants.NODESET);
			
			for(int i = 0; i < nodeList.getLength(); i++) {
					
			Element elemento = (Element) nodeList.item(i);
			
		
			System.out.print(elemento.getElementsByTagName("nombre").item(0).getTextContent()+" ");
			
			try {
				
				System.out.print(elemento.getElementsByTagName("nombre").item(1).getTextContent()+" ");

			}catch(Exception e){
				
			}
			

			System.out.print(elemento.getElementsByTagName("apellido").item(0).getTextContent()+" ");
			System.out.println(elemento.getElementsByTagName("apellido").item(1).getTextContent());
			System.out.println("-------------------------------------------");


			
			// leer los datos del xml
			//System.err.println(elemento.getTagName());
			//System.out.println(elemento.getTextContent());
			
				}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
