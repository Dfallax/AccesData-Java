package mainSerializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	public static void main(String[] args) {

		if (new File("listaPersonas.ser").exists()) {
			System.out.println("Archivo de guardado detectado. Cargando el array...");
			deserializar();
		} else {
			System.out.println("Archivo de guardado no encontrado. Generando array...");
			listaPersonas.add(new Persona("María", "García", "912512242"));
			listaPersonas.add(new Persona("Luis", "Fernández", "652241234"));
			listaPersonas.add(new Persona("Eusebio", "Luna", "623771822"));
		}

		System.out.println(listaPersonas);

		serializar();
	}

	public static void serializar() {
		String path = "listaPersonas.ser";

		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(listaPersonas);

			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deserializar() {
		String path = "listaPersonas.ser";

		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);

			listaPersonas = (ArrayList<Persona>) ois.readObject();

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
