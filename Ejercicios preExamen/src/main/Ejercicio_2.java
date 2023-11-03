package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Ejercicio_2 {

	public static void main(String[] args) {

		// Haz un programa que lea un archivo y cree otro con el mismo nombre y
		// "_cifrado"
		// al final que encripte el texto original. La tabla de cifrado es la que está
		// debajo.
		// Los caracteres que no sean los de la tabla se ignoran. Después, si el archivo
		// termina en
		// "_cifrado", que la aplicación lo detecte y lo descifre, mostrándonos por
		// consola el mensaje verdadero.

		File archivo = new File("Ejercicio 2.txt");
		File cifrado = new File("Ejercicio 2_cifrado.txt");
		String decifrado="";
		final char CARACTERES[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		final char CIFRADO[] = { '0', '$','2','&','@','1','?', ':', '=', '6', '/', '3', 'B', 'C', ')', 'E',
				'4', 'G', 'H', 'I', '5', 'K', '9', '8','(', '7' };

		if (!archivo.exists() && !cifrado.exists()) {
			try {
				archivo.createNewFile();
				cifrado.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			InputStream is = new FileInputStream(archivo);
			
			FileWriter fr = new FileWriter(cifrado);	
			PrintWriter pw = new PrintWriter(fr, true);
			long size = archivo.length();
			int byteLeido;
			String cadena = "";

			boolean saltoLinea = false;
			while (size != 0) {
				byteLeido = is.read();

				if (byteLeido == 13) {
					size--;
					byteLeido = is.read();

					if (byteLeido == 10) {
						cadena += "\n";
						size++;
						saltoLinea = true;
					}
				}
				
				if (!saltoLinea) {
					
					for (int i = 0; i < CARACTERES.length; i++) {
						if ((char) byteLeido == CARACTERES[i]) {
							cadena += CIFRADO[i];
							break;
						}
					}
					
				}
				saltoLinea=false;
				size--;
			}
			pw.println(cadena);
			is.close();
			fr.close();
			pw.close();
			cadena="";
			
			InputStream is_decifrar = new FileInputStream(cifrado);
			size = cifrado.length();
			boolean caracterDoble=false;
			
			while (size != 0) {
				byteLeido = is_decifrar.read();

				if (byteLeido == 13) {
					size--;
					byteLeido = is_decifrar.read();

					if (byteLeido == 10) {
						cadena += "\n";
						size++;
						saltoLinea = true;
					}
				}
				
				if (!saltoLinea || !caracterDoble) {
					
					for (int i = 0; i < CIFRADO.length; i++) {
							cadena += CARACTERES[i];
							break;
						
					}
					
				}
				saltoLinea=false;
				size--;
			}
			is_decifrar.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
		
	

}
