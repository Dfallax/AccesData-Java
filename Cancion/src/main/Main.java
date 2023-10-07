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
import java.util.InputMismatchException;
import java.util.Scanner;

import clases.Cancion;

public class Main {

	private static ArrayList<Cancion> ArrayCanciones = new ArrayList<Cancion>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("\tMENU");
		System.out.println("1). Añadir cancion nueva\n2). Borrar cancion\n3). Modificar cancion");
		Cancion nuevaCancion;

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
				id = Integer.parseInt(informacion[0]);
				ArrayCanciones.add(nuevaCancion = new Cancion(id, informacion[1], informacion[2], informacion[3],
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
			nuevaCancion = new Cancion();
			s.nextLine();
			nuevaCancion.setId(id);
			String datos;

			System.out.print("Titulo: ");
			while ((datos = s.nextLine()).trim().isEmpty()) {
				System.err.print("Error. Introduzca el dato adecuado: ");
			}
			nuevaCancion.setTitulo(datos);
			File letra = new File(nuevaCancion.getTitulo() + "_Lyrics.txt");

			System.out.print("Artista: ");
			while ((datos = s.nextLine()).trim().isEmpty()) {
				System.err.print("Error. Introduzca el dato adecuado: ");
			}
			nuevaCancion.setArtista(datos);

			System.out.print("Duracion: ");
			do {
				int duracion = s.nextInt();
				s.nextLine();
				if (duracion > 0) {
					nuevaCancion.setDuracion(duracion);
					break;
				} else {
					System.err.println("Error: Por favor, introduce un número entero válido. Intenta de nuevo.");
				}
			} while (true);

			System.out.print("Album: ");
			while ((datos = s.nextLine()).trim().isEmpty()) {
				System.err.print("Error. Introduzca el dato adecuado: ");
			}
			nuevaCancion.setAlbum(datos);
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
				pwLetra.println(s.nextLine());

				FileWriter fwCancion = new FileWriter("Canciones.txt", true);
				PrintWriter pwCancion = new PrintWriter(fwCancion, true);
				pwCancion.println(nuevaCancion.toString());

				pwLetra.close();
				pwCancion.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(ArrayCanciones.size());
			MostrarCanciones();
			break;
		case 2:
			if (ArrayCanciones.size() > 0) {
				MostrarCanciones();
				int opcion = s.nextInt();
				letra = new File(ArrayCanciones.get(opcion - 1).getLetra());
				letra.delete();
				ArrayCanciones.remove(opcion - 1);
				System.out.println(ArrayCanciones.size());

			} else {
				System.out.println("No hay ningun registro de canciones");
			}
			ActualizarCambios();
			break;
		case 3:
			if (ArrayCanciones.size() > 0) {
				MostrarCanciones();
				int opcionCancion = s.nextInt() - 1;
				boolean continuar = true;
				while(continuar) {
				System.out.println("\n\t ¿Que deseas cambiar?");
				System.out.println("1). Titulo: " + ArrayCanciones.get(opcionCancion).getTitulo());
				System.out.println("2). Artista: " + ArrayCanciones.get(opcionCancion).getArtista());
				System.out.println("3). Duracion: " + ArrayCanciones.get(opcionCancion).getDuracion() + " minutos");
				System.out.println("4). Album: " + ArrayCanciones.get(opcionCancion).getAlbum());
				System.out.println("5). Letra");
				
				int	opcionAtributo=s.nextInt();
				s.nextLine();
				
					continuar = false;
					switch (opcionAtributo) {
					case 1:
						System.out.print("Titulo: ");
						while ((datos = s.nextLine()).trim().isEmpty()) {
							System.err.print("Error. Introduzca el dato adecuado: ");
						}
						ArrayCanciones.get(opcionCancion).setTitulo(datos);
						// File letra = new File(nuevaCancion.getTitulo() + "_Lyrics.txt");

						break;
					case 2:
						System.out.print("Artista: ");
						while ((datos = s.nextLine()).trim().isEmpty()) {
							System.err.print("Error. Introduzca el dato adecuado: ");
						}
						ArrayCanciones.get(opcionCancion).setArtista(datos);

						break;
					case 3:
						System.out.print("Duracion: ");

						do {

							int duracion = s.nextInt();
							s.nextLine();
							if (duracion > 0) {
								ArrayCanciones.get(opcionCancion).setDuracion(duracion);
								break;
							} else {
								System.err.println(
										"Error: Por favor, introduce un número entero válido. Intenta de nuevo.");
							}
						} while (true);

						break;
					case 4:
						System.out.print("Album: ");
						while ((datos = s.nextLine()).trim().isEmpty()) {
							System.err.print("Error. Introduzca el dato adecuado: ");
						}
						ArrayCanciones.get(opcionCancion).setAlbum(datos);
						break;
					case 5:
						System.out.print("letra: ");
						try {

							FileWriter fwLetra = new FileWriter(
									ArrayCanciones.get(opcionCancion).getTitulo() + "_Lyrics.txt");
							PrintWriter pwLetra = new PrintWriter(fwLetra, true);
							pwLetra.println(s.nextLine());

							pwLetra.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					default:
						System.err.println("ERROR: opcion erronea. Vuelva a seleccionar");
						continuar=true;
					}
					if(!continuar) {
						System.out.println("¿ Deseas hacer otro cambio ?\n(S/N): ");
						String decision=s.nextLine();
						
						while (decision.trim().isEmpty() || !((decision.toLowerCase().equals("s")) || (decision.toLowerCase().equals("n")))) {
							System.err.print("Error. Introduzca el dato adecuado: ");
							decision=s.nextLine();
						}
						
						if(decision.toLowerCase().equals("s")) {
							continuar = true;
						}

					}
					
				}
				
					
				 	
					
			} else {
				System.out.println("No hay ningun registro de canciones");
			}
			ActualizarCambios();
			break;
		default:
			System.err.println("ERROR: opcion erronea");
		}
		s.close();

	}

	private static void MostrarCanciones() {
		System.out.println("\tCANCIONES");
		for (int i = 0; i < ArrayCanciones.size(); i++) {
			System.out.println((i + 1) + "). " + ArrayCanciones.get(i).getTitulo());
		}
	}

	private static void ActualizarCambios() {

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
	}
}
