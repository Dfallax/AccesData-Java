package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import entidades.Mago;

public class MainInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Mago> magosNuevos = new ArrayList<>();

		magosNuevos.add(new Mago("MagoNUevo1", "Mago Nuevo 1", "6666555501"));
		magosNuevos.add(new Mago("MagoNUevo2", "Mago Nuevo 2", "6666555502"));
		magosNuevos.add(new Mago("MagoNUevo3", "Mago Nuevo 3", "6666555503"));

		// Codigo para hacer un INSERT
		try (Connection con = Conexion.open()) {

			// insertar(con, magosNuevos);
			//actualizarNombre(con, 3, "Naruto");
			borrar(con, 3);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	private static void insertar(Connection con, ArrayList<Mago> magosNuevos) {

		String sql = "INSERT INTO magos VALUES (NULL,?,?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			for (Mago m : magosNuevos) {
				ps.setString(1, m.getAlias());
				ps.setString(2, m.getAlias());
				ps.setString(3, m.getAlias());

				int nFilas = ps.executeUpdate();

				System.out.println("Se han añadido " + nFilas + " filas correctamente");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static void actualizarNombre(Connection con, int primaryKey, String nuevoNombre) {

		String sql = "UPDATE magos SET nombre = ? WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(2, primaryKey);
			ps.setString(1, nuevoNombre);

			int nFilas = ps.executeUpdate();

			
			System.out.println("Se han modificado " + nFilas + " correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void borrar(Connection con, int primaryKey) {
		
		String sql = "DELETE FROM magos WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, primaryKey);
			
			int nFilas = ps.executeUpdate();

			
			System.out.println("Se ha eliminado " + nFilas + " correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
