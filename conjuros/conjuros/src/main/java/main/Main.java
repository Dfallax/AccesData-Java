package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class Main {

	public static void main(String[] args) {

		try (Connection con = Conexion.open()) {
			printSQL(con,
				"SELECT * from magos where nombre = ? and telefono = ?", "Gonzalo", "666777888"
			);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static void printSQL(Connection con, String query, String nombre, String telefono) {
		

		try (PreparedStatement ps = con.prepareStatement(query)) {
				
			ps.setString(1, nombre);
			ps.setString(2, telefono);
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					
					String alias = rs.getString("alias");
					String telefonos = rs.getString("telefono");
					
					
					System.out.println(
						"ALIAS: " + alias
						+ ", UNIDADES: " +telefonos
					);
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
