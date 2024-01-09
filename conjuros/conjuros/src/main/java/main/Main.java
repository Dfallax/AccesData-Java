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
					"SELECT (p.coste*count(u.unidades)) as costeTotal, m.alias from magos m "
					+ "inner join pocimas p on m.id = p.id "
						+ "inner JOIN magos_pocimas u on u.idMago=p.id "
							+ "GROUP BY m.id ORDER by costeTotal DESC"

			);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
//SELECT sum(u.unidades), (p.coste*sum(u.unidades)) as costeTotal, m.alias from magos m inner join pocimas p on m.id = p.id inner JOIN magos_pocimas u on u.idMago=p.id GROUP BY m.alias

	public static void printSQL(Connection con, String query) {
		

		try (PreparedStatement ps = con.prepareStatement(query)) {
			
			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					
					String alias = rs.getString("alias");
					float costo = rs.getFloat("costeTotal");
						
					System.out.println(
						"ALIAS: " + alias
						+ ", COSTE: " +costo
					);
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
