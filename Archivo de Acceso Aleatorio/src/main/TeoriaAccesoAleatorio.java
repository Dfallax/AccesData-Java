package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TeoriaAccesoAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	

			try {
				int tamRegistro = 41;
				byte[] texto = new byte[tamRegistro];
				RandomAccessFile registros = new RandomAccessFile("persona.txt", "rw");

				System.out.println((char) registros.read());
				System.out.println((char) registros.read());
				System.out.println((char) registros.read());
				System.out.println((char) registros.read());
				
				registros.seek(2);

				System.out.println((char) registros.read());
				System.out.println((char) registros.read());
				System.out.println((char) registros.read());
				System.out.println((char) registros.read());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		
	}

}
