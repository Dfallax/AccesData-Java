package main2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File html = new File("Persona.html");
		final String PATH_TXT= "datos_persona.txt";
		
		
		try {
			
			if(!html.exists()) {			
					html.createNewFile();		
			}
			
			FileReader fr = new FileReader(PATH_TXT);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter(html);
			PrintWriter pw = new PrintWriter(fw,true);
			
			String read;
			
			while((read=br.readLine())!=null) {
				
				final String DATOS[]= read.split(","); 
				
				pw.println("<div class='persona' id='"+DATOS[0]+"'>");
				pw.println("<div class='avatar'><img src='"+DATOS[5]+"'></div>");
				pw.println("<div><span class='resaltar'>Nombre:</span>"+DATOS[1]+"</div>");
				pw.println("<div><span class='resaltar'>Apellidos:</span>"+DATOS[2]+" "+DATOS[3]+"</div>");
				pw.println("<div><span class='resaltar'>Edad:</span>"+DATOS[4]+"</div>");
				pw.println("<div class='eliminar'><button onclick='this.parentElement.parentElement.remove();'>Borrar</button></div>");
				pw.println("</div>");
				
				
			}
							
				fr.close();
				br.close();
				fw.close();
				pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
