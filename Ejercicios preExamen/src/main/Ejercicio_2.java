package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Ejercicio_2 {

	public static void main(String[] args) {


		//Haz un programa que lea un archivo y cree otro con el mismo nombre y "_cifrado"
		//al final que encripte el texto original. La tabla de cifrado es la que está debajo. 
		//Los caracteres que no sean los de la tabla se ignoran. Después, si el archivo termina en
		//"_cifrado", que la aplicación lo detecte y lo descifre, mostrándonos por consola el mensaje verdadero.
		
	
		File archivo = new File("Ejercicio 2.txt");
	File cifrado = new File("Ejercicio 2_cifrado.txt");
	
		if(!archivo.exists() && !cifrado.exists()) {
			try {
				archivo.createNewFile();
				cifrado.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			InputStream is = new FileInputStream(archivo);
			long size = archivo.length();
			int byteLeido;
			
			while(size != 0) {
				
					byteLeido = is.read();
				 System.out.println((char) byteLeido);
				 
				 size--;
			}
			
			is.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
		
		
	}

}
