package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class caracter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File archivo = new File("archivo1.txt");
			InputStream is = new FileInputStream(archivo);
			long i = archivo.length();
			int byteLeido;
			int recuento = 0;
			int caracter;

			while (i != 0) {
				byteLeido = is.read();
				caracter = byteLeido;
				System.out.println(caracter);
				if (caracter >= 'A' && caracter <= 'Z' || caracter >= 'a' && caracter <= 'z') {
					recuento++;
				}

				i--;
			}

			System.out.println("Hay " + recuento + " letras en total.");
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
