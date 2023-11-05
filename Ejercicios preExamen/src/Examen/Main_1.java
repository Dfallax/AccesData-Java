package Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pathCoche = "coches.txt";
		String pathPersona = "personas.txt";
		File coche = new File(pathCoche);
		File persona = new File(pathPersona);

		ArrayList<Coche> coches = new ArrayList<Coche>();
		ArrayList<Persona> personas = new ArrayList<Persona>();

		if (!coche.exists() || !persona.exists()) {

			try {
				coche.createNewFile();
				persona.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			FileReader fr = new FileReader(persona);
			BufferedReader br = new BufferedReader(fr);
			String read;

			while ((read = br.readLine()) != null) {

				String[] datos = read.split(",");
				Persona newP = new Persona(datos[0], datos[1], datos[2]);
				personas.add(newP);

			}
			FileReader fr_coche = new FileReader(coche);
			BufferedReader br_coche = new BufferedReader(fr_coche);

			while ((read = br_coche.readLine()) != null) {

				String[] datos = read.split(",");
				int idPropietario = Integer.parseInt(datos[3]);
				int pos = 0;

				for (int i = 0; i < personas.size(); i++) {
					if (idPropietario == personas.get(i).getId()) {
						pos = i;
						break;
					}
				}

				Coche newC = new Coche(datos[0], datos[1], datos[2], personas.get(pos));
				coches.add(newC);

			}
			for (int i = 0; i < coches.size(); i++) {

				System.out.println("coche " + (i + 1) + ": " + coches.get(i).toString());
			}
			for (int i = 0; i < personas.size(); i++) {

				System.out.println("persona " + (i + 1) + ": " + personas.get(i).toString());
			}
			fr.close();
			br.close();
			fr_coche.close();
			br_coche.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File xml = new  File("personas_coches.xml");
		
		
		try {
			FileWriter fr = new FileWriter(xml);
			PrintWriter pw = new PrintWriter(fr,true);
			String write;
			
			
			for(int i = 0 ; i< personas.size(); i++) {
				
				pw.println("<Persona><id>"+personas.get(i).getId()+"</id><nombre>"
						+personas.get(i).getNombre()+"</nombre><telefono>"+ personas.get(i).getTelefono()+"</telefono>"+"<vehiculos>");
				
				for(int x = 0; x< coches.size(); x++) {
				if(personas.get(i).getId()==coches.get(x).getIdPropietario().getId()) {
					
					
					pw.println(coches.get(x).xml());

				}
				
				
				
				}
				
				pw.println("</vehiculos></Persona>");
			}
			
			fr.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
