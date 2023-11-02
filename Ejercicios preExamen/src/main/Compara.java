package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Compara {

	public static void main(String[] args) {
		String path1 = "archivo1.txt";
		String path2 = "archivo2.txt";
		boolean iguales = true;
		List<String> lineasArchivo1;
		List<String> lineasArchivo2;
		int menosLineas;

		try {
			//lee todo el archivo y lo guarda en la List
			lineasArchivo1 = Files.readAllLines(Path.of(path1));
			lineasArchivo2 = Files.readAllLines(Path.of(path2));
//toma el numero de lineas que conciden 
			menosLineas = Math.min(lineasArchivo1.size(), lineasArchivo2.size());
			System.out.println(menosLineas);
			
			for (int i = 0; i < menosLineas; i++) {
				
				if (!lineasArchivo1.get(i).equals(lineasArchivo2.get(i))) {
					iguales = false;
					break;
				}

			}

			if (iguales)
				System.out.println("Son iguales");
			else
				System.err.println("Son distintos");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
