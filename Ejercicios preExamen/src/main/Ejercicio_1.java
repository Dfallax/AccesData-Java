package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Haz un programa que lea un archivo con muchos caracteres y devuelva el
		// recuento
		// de líneas (textos separados por '\n' del archivo).

		File archivo = new File("Ejecicio 1.txt");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//forma de contar las lineas de un archivo
		FileReader fr;
		try {
			
			fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			int cont=0;
			
				while (( br.readLine()) != null) {
				cont++;
				
			} 
				
			System.out.println(cont);
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
