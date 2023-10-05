package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class BuscarMaria {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Introduzca el nombre: ");
		String name = s.nextLine();
		name += " "; //la concatenación de un espacio sirve
		//evitar el error estar encontrando el nombre "Maria" dentro de "Mariano" en el archivo
		String palabra;
		
		try {
			int tamRegistro = 41;//la longitud de los bytes del archivo que se va a leer
			byte[] texto = new byte[tamRegistro];
			RandomAccessFile registro = new RandomAccessFile("persona.txt", "rw");
			

			for (int x = 0; x < 4; x++) {	//este for son los saltos de linea que existe el archivo
				palabra = "";
				registro.seek(tamRegistro * x); //cada vez que el bucle da la vuelta, el resgistro.read leerá en 
				//el siguiente salto de linea por la variable x
				
				for (int i = 0; i < name.length(); i++) { //el bucle sirve para buscar caracter por caracter 

					if ((char) registro.read() == name.charAt(i)) {
						palabra += name.charAt(i); //se va creando la palabra

						if (name.equals(palabra)) {
							registro.seek(tamRegistro * x); // se reinicia el seek para descontar el recorrido el read();
							registro.read(texto);
							System.out.println(new String(texto));

						}

					} else {
						//cuando no hay ninguna coincidencia, se rompe el bucle y vuelve al bucle de los saltos de linea
						break;
					}

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
