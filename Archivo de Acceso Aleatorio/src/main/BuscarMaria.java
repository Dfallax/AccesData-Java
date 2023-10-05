package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class BuscarMaria {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("INtroduzca el nombre: ");
		String name = s.nextLine();
		String palabra = "";

		try {
			int tamRegistro = 39;
			RandomAccessFile registro = new RandomAccessFile("persona.txt", "rw");
			

			for (int i = 0; i < registro.length() ; i++) {
				byte[] texto = new byte[(int) registro.length()];
				
				for(int x=0; x<name.length();x++) {
					
					if ((char)registro.read() == name.charAt(x)) {
						palabra += name.charAt(x);
						
						if (palabra.equals(name)) {
							registro.seek(0);
							registro.read(texto);
							System.out.println(new String(texto));
							i+=39-name.length();
							palabra="";
                              
						}

					} else {
						palabra = "";
						
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
