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
		System.out.println("1). Añadir cancion nueva\n2). Borrar cancion\n3). Modificar cancion");// MENU
		Cancion nuevaCancion;
		int id = 0; // El id lo vamos utilizando para asiganrle a los objetos de clase cancion
		File canciones = new File("Canciones.txt");
		
//creamos el file  canciones si es la primera inicializacion del programa
		if (!canciones.exists()) {
			try {
				canciones.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//si de antemano el archivo ya estaba creado y contiene contenido con los registros de canciones
		//cargamos el arraY list
		// Cargar datos de canciones en el array list
		try {
			FileReader fr = new FileReader("Canciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String leer;
			String[] informacion;

			while ((leer = br.readLine()) != null) {
				informacion = leer.split(",");
				id = Integer.parseInt(informacion[0]);// De esta manera podemos mantener el id borrado de una cancion borrada
														//Pero no podrá guardar el id de la cancion del ultimo datos ingresado
														//Pero si guarda el id de una cancion que fue borrada entre otras canciones
				ArrayCanciones.add(nuevaCancion = new Cancion(id, informacion[1], informacion[2], informacion[3],
						informacion[4], informacion[5]));
			}
			id++;//le sumamos el id 
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		switch (s.nextInt()) {
		case 1://Añadir cancion
			nuevaCancion = new Cancion();
			s.nextLine();//evitar la entrada del teclado Enter 
			nuevaCancion.setId(id); // se añade el id al nuevo ojbjeto clase
			String datos; 

			System.out.print("Titulo: ");
			while ((datos = s.nextLine()).trim().isEmpty()) { //evita los errores de colocar solos espacios o dejar el contenido vacio
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
		            try {
		            	//evita los errores de colocar solos espacios o dejar el contenido vacio
		                // y la entrada de caracteres
		            	int duracion = s.nextInt();
		                if (duracion <=0) {
							throw new InputMismatchException();
						} 
						nuevaCancion.setDuracion(duracion);
		                break;
		            } catch (InputMismatchException ex) {
		                System.err.print("ERROR. Dato incorrecto. Intenta de nuevo: ");
		                
		            }finally {
		            	s.nextLine();
		            }
		        } while (true);
		    

			System.out.print("Album: ");
			while ((datos = s.nextLine()).trim().isEmpty()) {
				System.err.print("Error. Introduzca el dato adecuado: ");
			}
			nuevaCancion.setAlbum(datos);
			nuevaCancion.setLetra(letra.getAbsolutePath()); //guardamos la ruta del archivo letra 

			System.out.print("letra: ");

			if (!letra.exists()) {

				try {
					letra.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			ArrayCanciones.add(nuevaCancion); // depues de haber ingreasado los datos lo añadimos al array list.

			try {

				FileWriter fwLetra = new FileWriter(nuevaCancion.getTitulo() + "_Lyrics.txt");
				PrintWriter pwLetra = new PrintWriter(fwLetra, true);
				pwLetra.println(s.nextLine());//escribimos  el contenido en el archivo letra 

				FileWriter fwCancion = new FileWriter("Canciones.txt", true);
				PrintWriter pwCancion = new PrintWriter(fwCancion, true);
				pwCancion.println(nuevaCancion.toString());//usamos el metodo toString para guardar los datos en el archivo canciones

				pwLetra.close();
				pwCancion.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case 2://BORRAR CANCION
			//SI anterioirmente no se ha añadido ninguna cancion
			if (ArrayCanciones.size() > 0) {
				MostrarCanciones();
				int opcion = s.nextInt();
				letra = new File(ArrayCanciones.get(opcion - 1).getLetra());
				letra.delete();//borramos el archivo letra
				ArrayCanciones.remove(opcion - 1);
				System.out.println(ArrayCanciones.size());

			} else {
				System.out.println("No hay ningun registro de canciones");
				
			}
			ActualizarCambios(); //actualizo los cambios despues de haber borrado la cancion
			break;
		case 3:// MODIFICAR CANCION
			//SI anterioirmente no se ha añadido ninguna cancion
			if (ArrayCanciones.size() > 0) {
				MostrarCanciones();
				int opcionCancion = s.nextInt() - 1; // El -1 srive para poder accerder a las posiciones correctamente en el arrayList
				boolean continuar = true;
				
				while (continuar) {//EL bucle proporciona que se repita la accion cada vez el usuario escoja un opcion diferente del Swicth 
					// O cuando el usuario quiera volver a cambiar otro dato
					continuar = false;
					System.out.println("\n\t ¿Que deseas cambiar?");
					System.out.println("1). Titulo: " + ArrayCanciones.get(opcionCancion).getTitulo());
					System.out.println("2). Artista: " + ArrayCanciones.get(opcionCancion).getArtista());
					System.out.println("3). Duracion: " + ArrayCanciones.get(opcionCancion).getDuracion() + " minutos");
					System.out.println("4). Album: " + ArrayCanciones.get(opcionCancion).getAlbum());
					System.out.println("5). Letra");

					int opcionAtributo = s.nextInt(); 
					s.nextLine();

					switch (opcionAtributo) {//el swicth está relacionado con las opciones de los atributos de una clase
					
					case 1:
						System.out.print("Titulo: ");
						while ((datos = s.nextLine()).trim().isEmpty()) {
							System.err.print("Error. Introduzca el dato adecuado: ");
						}
						ArrayCanciones.get(opcionCancion).setTitulo(datos);// con la vaiable opcionCancion accedo con mas facilidad a la posicion
						//del arrayList de la cancion seleccionada.
				        File oldfile = new File(ArrayCanciones.get(opcionCancion).getLetra());//creamos un file que tengo la ruta del archivo con el nombre anterioir al cambio
				        File newfile = new File
				        		("C:\\diego\\IFP\\GitHub\\AccesData-Java\\Cancion\\"+ datos +"_Lyrics.txt");//le asignamos el nuevo nombre al archivo con la ruta completa
				       
				        if (oldfile.renameTo(newfile)) {//comprobamos de que el cambio ha sido exitoso
				            System.out.println("archivo renombrado");
				        } else {
				            System.out.println("error");
				        }
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
					            try {
					               
					                int duracion = s.nextInt();
					                if (duracion <=0) {
										throw new InputMismatchException();
									} 
									ArrayCanciones.get(opcionCancion).setDuracion(duracion);
					                break;
					            } catch (InputMismatchException ex) {
					                System.err.print("ERROR. Dato incorrecto. Intenta de nuevo: ");
					                
					            }finally {
					            	s.nextLine();
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
						//Aqui directamente sobreescribimos en el archivo del contenido de la letra de esa cancion
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
						continuar = true;// para que no entre en la condicionar siguiente sino que directamente de la vuelta al bucle y vuleva al inicio
					}
					if (!continuar) {
						System.out.println("¿ Deseas hacer otro cambio ?\n(S/N): ");//dependidendo de la opcion qu escoja salimos del bucle o repetimos el bucle
						String decision = s.nextLine();

						while (decision.trim().isEmpty()//evitar los errores de espacio, contenido vacio y de colocar otro caracter.
								//el usuario puede coloar la letra en minuscula o mayuscula
								|| !((decision.toLowerCase().equals("s")) || (decision.toLowerCase().equals("n")))) {
							System.err.print("Error. Introduzca el dato adecuado: ");
							decision = s.nextLine();
						}

						if (decision.toLowerCase().equals("s")) {
							continuar = true;// si la opcion es "S" volverá a dar una vuelta al bucle
						}

					}

				}

			} else {
				System.out.println("No hay ningun registro de canciones"); // Si no hay ningun registro en el contenido de archivo canciones
				//se mostrara este mensaje
			}
			ActualizarCambios();// se eactualiza el archivo canciones despues de que el usuario escogio la opcion "N"
			break;
		default:
			System.err.println("ERROR: opcion erronea");// este mensaje aparece cuando escoja una opcion fuera de los limmites del MENU 
		}
		s.close();// cerramos el scanner despues de acabar el programa
	}

	private static void MostrarCanciones() {
		System.out.println("\tCANCIONES");
		for (int i = 0; i < ArrayCanciones.size(); i++) {
			System.out.println((i + 1) + "). " + ArrayCanciones.get(i).getTitulo());
		}
	}

	private static void ActualizarCambios() {//
//metdodo en donde encargar de realizar un toString de la posicion del arraYlist
		//de esta manera el archivo canciones, se ira actualizando 
		
		try {
			FileWriter fwCancion = new FileWriter("Canciones.txt");
			PrintWriter pwCancion = new PrintWriter(fwCancion, true);

			if (ArrayCanciones.size() == 0) {//para cuando borramos una cancion y no queda mas canciones en el archivo
												//sirve para vaciar el contenido del archivo
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
