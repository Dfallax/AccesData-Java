package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ejercicio_1 {

	static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
	static final String PATH = "mascotas.txt";
	static File archivo_txt = new File(PATH);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String PATH_XML = "mascotas.xml";

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db;
		Document document;
		XPath xPath;
		NodeList nodeList;

		if (!archivo_txt.exists()) {

			try {
				File archivo = new File(PATH_XML);

				db = dbf.newDocumentBuilder();
				xPath = XPathFactory.newInstance().newXPath();
				String consulta;

				// La consulta
				consulta = "//mascota";
				document = db.parse(archivo);
				document.normalizeDocument();
				// Los nodos resultantes de la consulta

				nodeList = (NodeList) xPath.compile(consulta).evaluate(document, XPathConstants.NODESET);
				for (int i = 0; i < nodeList.getLength(); i++) {
					Element elemento = (Element) nodeList.item(i);
					ArrayList<Cita> citas = new ArrayList<Cita>();

					NodeList nodosCita = elemento.getElementsByTagName("cita");
					for (int a = 0; a < nodosCita.getLength(); a++) {// sacar los apellidos
						Element cita = (Element) nodosCita.item(a);
						citas.add(new Cita(cita.getElementsByTagName("fecha").item(0).getTextContent(),
								cita.getElementsByTagName("motivo").item(0).getTextContent()));
					}

					mascotas.add(new Mascota(
							Integer.parseInt(elemento.getElementsByTagName("id").item(0).getTextContent()),
							elemento.getElementsByTagName("nombre").item(0).getTextContent(),
							elemento.getElementsByTagName("especie").item(0).getTextContent(),
							elemento.getElementsByTagName("sexo").item(0).getTextContent(),
							Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent()), citas));

				}
				System.out.println(mascotas.toString());
				serializar();

			} catch (Exception e) {

			}
		} else {

			deserializar();
			System.out.println("deserializar: " + mascotas.toString());
		}

	}

	public static void serializar() {

		try {
			FileOutputStream fos = new FileOutputStream(archivo_txt);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(mascotas);

			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deserializar() {

		try {
			FileInputStream fis = new FileInputStream(archivo_txt);
			ObjectInputStream ois = new ObjectInputStream(fis);

			mascotas = (ArrayList<Mascota>) ois.readObject();

			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
