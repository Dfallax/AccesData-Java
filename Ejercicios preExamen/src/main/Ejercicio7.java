package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {

		// Hacer un programa que pida al usuario la ruta de un archivo y copie el
		// contenido en un archivo nuevo
		// (llamado igual solo que con "_inver" al final)
		// cambiando las letras minúsculas por mayúsculas y viceversa. Los caracteres
		// que no sean letras se mantienen igual.

		Scanner s = new Scanner(System.in);
		String path = "ejercicio7";
		File archivo = new File(path + ".txt");

		File archivoInvertido = new File(path + "_inver.txt");

		if (!archivo.exists() && !archivoInvertido.exists()) {
			try {
				System.out.println("Creando...");
				archivoInvertido.createNewFile();
				archivo.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
// forma de escribir en un archivo y a la vez esccribir en otro archuvo a la vez
		try {
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw, true);
			FileWriter fw_inver = new FileWriter(archivoInvertido);
			PrintWriter pw_inver = new PrintWriter(fw_inver, true);

			String texto;
			String textoInvertido = "";

			while (!(texto = s.nextLine()).isBlank()) {

				for(int i = 0; i < texto.length(); i++) {
					
					if(texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z')  {
						
						textoInvertido+=texto.substring(i,i+1).toLowerCase();
						
					}
					
					else if(texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
						
						textoInvertido+=texto.substring(i,i+1).toUpperCase();

					}else {
						textoInvertido+=texto.charAt(i);
					}
				}

				pw.println(texto);
				pw_inver.println(textoInvertido);
				textoInvertido="";

			}
			fw.close();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//manera de mostrar por consola el contenido de un archivo
		try {
			
			FileReader fr = new FileReader(archivoInvertido);
			BufferedReader br = new BufferedReader(fr);

			String linea;

			while ((linea = br.readLine()) != null) {

				System.out.println(linea);

			}

			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//forma de poder guarder en un string todas las letras del archivo usando un array de byte
		try {
			InputStream is = new FileInputStream(archivo);
			byte[] bytesLeidos = new byte[(int) archivo.length()];

			is.read(bytesLeidos);

			System.out.println(Arrays.toString(bytesLeidos));
			System.out.println(new String(bytesLeidos));

			System.out.println(is.read());

			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//forma de escribir byte por byte
	try {
		
		
		OutputStream os;
		byte[] bytesEscribir = "Esto se va a escribir".getBytes();

		
			// Si usamos "true" como 2º argumento entonces se añade al final del archivo.
			// En caso contrario, se sobreescribe.
			os = new FileOutputStream(archivo, true);

			os.write(49); //os.write((int) '1')
			os.write(50);
			os.write(51);
			os.write('\n');
			os.write(bytesEscribir);

			os.flush();
			os.close();
		} catch (IOException e) {
			System.err.println("No se pudo crear el archivo.");
		}
		
	}

}
