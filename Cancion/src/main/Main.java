package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Cancion;

public class Main {

	private static ArrayList<Cancion> ArrayCanciones = new ArrayList<Cancion>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("\tMENU");
		System.out.println("1). Añadir cancion nueva\n2). Borrar cancion\n3). Modificar cancion");
		Cancion nuevaCancion = new Cancion();

		int id = 0;
		File canciones = new File("Canciones.txt");

		if (!canciones.exists()) {

			try {
				canciones.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// CArgardatos de canciones en el array list
		try {
			FileReader fr = new FileReader("Canciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String leer;
			String[] informacion;

			while ((leer = br.readLine()) != null) {
				informacion = leer.split(",");
				id=Integer.parseInt(informacion[0]);
				ArrayCanciones.add(nuevaCancion = new Cancion(id,informacion[1], informacion[2], informacion[3],
						informacion[4], informacion[5]));
				
			}
			id++;
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (s.nextInt()) {
		case 1:

			s.nextLine();
			nuevaCancion.setId(id);
			System.out.print("Titulo: ");
			nuevaCancion.setTitulo(s.nextLine());
			File letra = new File(nuevaCancion.getTitulo() + "_Lyrics.txt");
			System.out.print("Artista: ");
			nuevaCancion.setArtista(s.nextLine());
			System.out.print("Duracion: ");
			nuevaCancion.setDuracion(s.nextLine());
			System.out.print("Album: ");
			nuevaCancion.setAlbum(s.nextLine());
			nuevaCancion.setLetra(letra.getAbsolutePath());
			System.out.print("letra: ");

			if (!letra.exists()) {

				try {
					letra.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ArrayCanciones.add(nuevaCancion);
			try {

				FileWriter fwLetra = new FileWriter(nuevaCancion.getTitulo() + "_Lyrics.txt");
				PrintWriter pwLetra = new PrintWriter(fwLetra, true);
				pwLetra.print(s.nextLine());

				FileWriter fwCancion = new FileWriter("Canciones.txt", true);
				PrintWriter pwCancion = new PrintWriter(fwCancion, true);
				pwCancion.println(nuevaCancion.toString());

				pwLetra.close();
				pwCancion.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(ArrayCanciones.size());
			break;
		case 2:
			if (ArrayCanciones.size() > 0) {
				MostrarCanciones();
				
				int opcion = s.nextInt();
				letra = new File(ArrayCanciones.get(opcion - 1).getLetra());
				letra.delete();
				ArrayCanciones.remove(opcion - 1);
				System.out.println(ArrayCanciones.size());

				try {

					FileWriter fwCancion = new FileWriter("Canciones.txt");
					PrintWriter pwCancion = new PrintWriter(fwCancion, true);

					if (ArrayCanciones.size() == 0) {
						pwCancion.print("");

					} else {
						for (int i = 0; i < ArrayCanciones.size(); i++) {
							pwCancion.println(ArrayCanciones.get(i).toString());
						}

					}

					pwCancion.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("No hay ningun registro de canciones");
			}

			break;
		case 3:

			
			break;

		}

	}
	private static void MostrarCanciones() {	
			for (int i = 0; i < ArrayCanciones.size(); i++) {
				System.out.println((i + 1) + "). " + ArrayCanciones.get(i).getTitulo());	
		}
	}

}
