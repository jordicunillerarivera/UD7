import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ud7_04App {
	
	public static void main(String[] args) {
		
		Hashtable<String, Double> inventario = inicioHashtable();
		ArrayList<Double> lista = crearArrayList();
		menu(inventario,lista);
		
	}
	
	// Metodo que muestra un menu
	public static void menu(Hashtable<String, Double> inventario, ArrayList<Double> lista) {
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione que desea hacer:\n1. Consultar el inventario\n2. Consultar el precio de un articulo\n3. Comprar producto"
				+ "\n4. Introducir un articulo"));
		
		switch (opcion) {
			case 1:
				System.out.println("-----------------------------");
				recorrerHashtable(inventario, lista);
				break;
			case 2:
				System.out.println("-----------------------------");
				consultaPrecio(inventario, lista);
				break;
			case 3:
				System.out.println("-----------------------------");
				introducirDatosArrayList(lista, inventario);
				mostrar(lista,inventario);
				pagar(lista,inventario);
				break;
			case 4:
				introduccionDatos(inventario,lista);
				break;
	
			default:
				JOptionPane.showMessageDialog(null, "Introduzca una respuesta valida");
				menu(inventario,lista);
				break;
		}
		
	}
	
																// Hashtable
	
	// Metodo para crear un hastable y rellenarlo
	public static Hashtable<String, Double> inicioHashtable(){
		
		Hashtable<String, Double> hash = new Hashtable<>();
		
		hash.put("Tomate", 0.50);
		hash.put("Limones", 0.40);
		hash.put("Manzanas", 1.00);
		hash.put("Leche", 1.00);
		hash.put("Sacarina", 0.20);
		hash.put("Cereales", 1.20);
		hash.put("Galletas", 1.05);
		hash.put("Pan", 0.40);
		hash.put("Agua", 0.50);
		hash.put("Pollo", 2.33);
		
		return hash;
		
	}
	
	// Metodo para introducir un producto nuevo
	public static void introduccionDatos(Hashtable<String, Double> hash, ArrayList<Double>lista) {
		
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del articulo");
		Double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del articulo"));
		
		hash.put(articulo, precio);
		
		menu(hash, lista);
		
	}
	
		// Metodo para consultar el precio de un articulo
	public static void consultaPrecio(Hashtable<String, Double> hash, ArrayList<Double> lista) {
		
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del articulo a buscar");
		
		System.out.println("El precio de " + articulo + " es " + hash.get(articulo));
		
		menu(hash, lista);
		
	}
	
		// Metodo para recorrer un hashtable
	public static void recorrerHashtable(Hashtable<String, Double> hash, ArrayList<Double> lista) {
		
		Enumeration<String> llave = hash.keys();
		Enumeration<Double> valor = hash.elements();
		while (llave.hasMoreElements()) {
			System.out.println(llave.nextElement() + ": " + valor.nextElement());
			
		}
		
		menu(hash, lista);
		
	}
	
															// ArrayList
	
		// Metodo para crear un ArrayList y rellenarla 
	public static ArrayList<Double> crearArrayList() {
		
		ArrayList<Double> lista = new ArrayList<>();
		
		return lista;
		
	}
	
		// Metodo para introducir productos al ArrayList
	public static ArrayList<Double> introducirDatosArrayList(ArrayList<Double> lista, Hashtable<String, Double> hash) {
		
		String precio;
		
		do {
			precio = JOptionPane.showInputDialog("Introduzca el nombre del prducto deseado (0 para salir)");
			if (!precio.equals("0")) {
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de producto (0 para cancelar)"));
				if (cantidad != 0) {
					for (int i = 0; i < cantidad; i++) {
						lista.add(hash.get(precio));
					}
				}
			}
		} while (!precio.equals("0"));
		
		return lista;
		
	}
	
		// Metodo para mostrar el ArrayList
	public static void mostrar(ArrayList<Double> lista, Hashtable<String, Double> hash) {
		
		double precioBruto = precioBruto(lista);
		double precioIva = precioIva(lista);
		int numeroArticulos = numeroArticulos(lista);
		
		JOptionPane.showMessageDialog(null, "Iva aplicado 21%\nPrecio bruto " + precioBruto + "€, precio con IVA " + precioIva + "€.\n"
				+ "Numero de artículos comprados: " + numeroArticulos);
		
	}
	
		// Metodo para introducir cuanto se ha pagado y cuanto hay qeu devolver
	public static void pagar(ArrayList<Double> lista, Hashtable<String, Double> hash) {
		
		double pagado = Double.parseDouble(JOptionPane.showInputDialog("Cantidad a pagar " + precioIva(lista) + "€. Entra la cantidad pagada"));
		double precioIva = precioIva(lista); 
		
		if (pagado < precioIva) {
			JOptionPane.showMessageDialog(null, "Cantidad pagada menor al precio total, intentalo de nuevo");
			pagar(lista, hash);
		} else if (pagado >= precioIva) {
			JOptionPane.showMessageDialog(null, " el cambio es de " + (pagado - precioIva) + "€");
		}
		
		menu(hash, lista);
		
	}
	
		// Metodo para calcular el precio bruto
	public static double precioBruto(ArrayList<Double> lista) {
		
		Iterator<Double> it = lista.iterator();
		double precio = 0;
		while (it.hasNext()) {
			precio += it.next();
		}
		
		return precio;
		
	}
	
		// Metodo para calcular el precio con IVA
	public static double precioIva(ArrayList<Double> lista) {
		
		double precioBruto = precioBruto(lista);
		return precioBruto + (precioBruto * 0.21);
		
	}
	
		// Metodo para calcular el numero de articulos
	public static int numeroArticulos(ArrayList<Double>lista ) {
		
		return lista.size();
		
	}

}
