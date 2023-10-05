package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

	public static void main(String[] args) {

		try {
			int tamRegistro = 39;
			byte[] texto = new byte[tamRegistro];
			RandomAccessFile registro = new RandomAccessFile("persona.txt","rw");
			System.out.println(registro.length());
			
			//registro.read(texto);
			//System.out.println(new String(texto));
			
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
//ssssdaslkldsasasas
			
			registro.seek(0);
			
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			System.out.println((char) registro.read());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
