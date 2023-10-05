package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

	public static void main(String[] args) {

		try {
			int tamRegistro = 15;
			byte[] texto = new byte[tamRegistro];
			RandomAccessFile registro = new RandomAccessFile("persona.txt","rw");
			System.out.println(registro.length());
			
			registro.read(texto);
			new String(texto).trim();
			System.out.println(texto);
			
			registro.read(texto,0,15);
			System.out.println(new String(texto));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
