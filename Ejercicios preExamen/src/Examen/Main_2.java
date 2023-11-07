package Examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_2 {
	private static ArrayList<Cancion> canciones = new ArrayList<Cancion>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// TODO Auto-generated method stub

		if (new File("canciones.txt").exists()) {
			System.out.println("Archivo de guardado detectado. Cargando el array...");
			deserializar();
		} else {
			System.out.println("Archivo de guardado no encontrado. Generando array...");
			canciones.add(new Cancion("lluvia", "diego", "invierno", 3));
			canciones.add(new Cancion("lluvia_2", "diego_2", "invierno_2", 4));
			canciones.add(new Cancion("lluvia_3", "diego_3", "invierno_3", 5));
			serializar();
		}

		System.out.println("1). añadir\n2).borrar");
		int opcion = s.nextInt();
		if (opcion == 1) {
			s.nextLine();
			Cancion newC = new Cancion();
			System.out.println("titulo");
			String datos;
			newC.setTitulo(datos= s.nextLine());
			System.out.println("Album");
			newC.setAlbum(datos = s.nextLine());
			System.out.println("Artista");
			newC.setArtista(datos = s.nextLine());

			System.out.println("Duracion");
			newC.setDuracion(datos = s.nextLine());
			canciones.add(newC);
			serializar();

		} else {
			s.nextLine();
			System.out.println("Canciones");

			for (int i = 0; i < canciones.size(); i++) {
				System.out.println((i + 1) + ")." + canciones.get(i).getTitulo());
			}
			opcion = s.nextInt() - 1;

			canciones.remove(opcion);
			serializar();
		}

	}

	public static void serializar() {
		String path = "canciones.txt";

		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(canciones);

			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void deserializar() {
		String path = "canciones.txt";

		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);

			canciones = (ArrayList<Cancion>) ois.readObject();

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
