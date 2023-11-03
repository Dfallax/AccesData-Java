package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class compararEjem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Hacer un programa que pida al usuario la ruta de un archivo y copie el contenido en un archivo nuevo 
		//(llamado igual solo que con "_inver" al final)
		//cambiando las letras minúsculas por mayúsculas y viceversa. Los caracteres que no sean letras se mantienen igual.
		
		Scanner s = new Scanner(System.in);
		List<String> lineasArchivo;

		String path="hola";
		path+=".txt";
		File archivo = new File(path);
		
		if(!archivo.exists()) {
			try {
				System.out.println("Creando...");

				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			
			lineasArchivo = Files.readAllLines(Path.of(path));
			System.out.println(lineasArchivo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
