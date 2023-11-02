package supermercado;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSupermercado {

	public static void main(String[] args) {
		String pathCatalogo = "catalogo.ser";
		
		ArrayList<Producto> catalogo = cargarCatalogo(pathCatalogo);
		ArrayList<ItemCarrito> carrito = new ArrayList<ItemCarrito>();
		boolean continuarCompra = true;
		Scanner scanner = new Scanner(System.in);
		int opcion, cantidad, indexItem;
		Producto p;
		ItemCarrito item;

		while (continuarCompra) {
			System.out.println("Introduce 0 para salir o el ID del producto que desees:\n0. SALIR");

			for (int i = 0; i < catalogo.size(); i++) {
				p = catalogo.get(i);
				System.out.println((i + 1) + ". " + p.getNombre() + "(" + p.getPrecio() + "€)");
			}

			System.out.print(">> ");

			// Asumo que el usuario introduce bien las cosas...xd
			opcion = scanner.nextInt();

			if (opcion == 0) {
				scanner.close();
				continuarCompra = false;
				System.out.println("Hasta pronto!");
				printTicket(carrito);
			} else {
				p = catalogo.get(opcion - 1);

				System.out.print("¿Cuántas unidades quieres? >> ");
				cantidad = scanner.nextInt();

				for (indexItem = 0; indexItem < carrito.size(); indexItem++) {
					item = carrito.get(indexItem);

					if (item.getProducto().getNombre().equals(p.getNombre())) {
						item.incrementarUnidades(cantidad);
						break;
					}

				}

				if (indexItem == carrito.size()) {
					carrito.add(new ItemCarrito(p, cantidad));
				}

			}

		}

	}

	private static void printTicket(ArrayList<ItemCarrito> carrito) {
		double itemCost, total = 0;
		System.err.println("TICKET----------\n");

		for (ItemCarrito item : carrito) {
			itemCost = item.getProducto().getPrecio() * item.getCantidad();
			total += itemCost;

			System.err.println(
				item.getCantidad() + " x " + item.getProducto().getNombre()
				+ "(" + item.getProducto().getPrecio() + "€) --- "
				+ itemCost + "€"
			);
		}

		System.err.println("----------\nTOTAL: " + total + "€\n----------");
	}

	public static ArrayList<Producto> cargarCatalogo(String path) {
		ArrayList<Producto> catalogo = new ArrayList<Producto>();

		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);

			catalogo = (ArrayList<Producto>) ois.readObject();

			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(
				"Ocurrió un problema durante la lectura del catálogo: "
				+ e.getMessage() + "\nCargando catálogo de prueba..."
			);
			catalogo = crearCatalogoDePrueba(path);
		}

		return catalogo;
	}

	// Esto es sólo para crear el archivo con el catálogo serializado.
	public static ArrayList<Producto> crearCatalogoDePrueba(String path) {
		ArrayList<Producto> catalogo = new ArrayList<Producto>();

		catalogo.add(new Producto("PAN", 0.75));
		catalogo.add(new Producto("CHOCOLATE", 1.5));
		catalogo.add(new Producto("PACK YOGURES", 2.25));

		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(catalogo);

			oos.close();
		} catch (IOException e) {
			System.out.println(
				"Ocurrió un problema durante la escritura del catálogo de prueba: "
				+ e.getMessage()
			);
		}

		return catalogo;
	}

}
