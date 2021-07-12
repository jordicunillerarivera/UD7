import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ud7_03App {

	public static void main(String[] args) {
		
		Hashtable<String, Double> inventario = inicioHashtable();
		menu(inventario);

	}
	
	public static void menu(Hashtable<String, Double> inventario) {
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione que desea hacer:\n1. Consultar el inventario\n2. Consultar el precio de un articulo\n3. Introducir un articulo"));
		
		switch (opcion) {
			case 1:
				System.out.println("-----------------------------");
				recorrerHashtable(inventario);
				break;
			case 2:
				System.out.println("-----------------------------");
				consultaPrecio(inventario);
				break;
			case 3:
				introduccionDatos(inventario);
				break;
	
			default:
				JOptionPane.showMessageDialog(null, "Introduzca una respuesta valida");
				menu(inventario);
				break;
		}
		
	}
	
	// Metodo para crear un hastable
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
	
	public static void introduccionDatos(Hashtable<String, Double> hash) {
		
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del articulo");
		Double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del articulo"));
		
		hash.put(articulo, precio);
		
		menu(hash);
		
	}
	
	public static void consultaPrecio(Hashtable<String, Double> hash) {
		
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del articulo a buscar");
		
		System.out.println("El precio de " + articulo + " es " + hash.get(articulo));
		
		menu(hash);
		
	}
	
	// Metodo para recorrer un hashtable
	public static void recorrerHashtable(Hashtable<String, Double> hash) {
		
		Enumeration<String> llave = hash.keys();
		Enumeration<Double> valor = hash.elements();
		while (llave.hasMoreElements()) {
			System.out.println(llave.nextElement() + ": " + valor.nextElement());
			
		}
		
		menu(hash);
		
	}

}
