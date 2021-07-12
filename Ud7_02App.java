import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ud7_02App {
	
	public static void main(String[] args) {
		
		ArrayList<Double> lista = crearArrayList();
		mostrar(lista);
		pagar(lista);
		
	}
	
		// Metodo para crear un ArrayList y rellenarla 
	public static ArrayList<Double> crearArrayList() {
		
		ArrayList<Double> lista = new ArrayList<>();
		
		double precio;
		
		do {
			precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca un precio nuevo (0 para salir)"));
			if (precio != 0) {
				lista.add(precio);
			}
		} while (precio != 0);
		
		return lista;
		
	}
	
		// Metodo para mostrar el ArrayList
	public static void mostrar(ArrayList<Double> lista) {
		
		double precioBruto = precioBruto(lista);
		double precioIva = precioIva(lista);
		int numeroArticulos = numeroArticulos(lista);
		
		JOptionPane.showMessageDialog(null, "Iva aplicado 21%\nPrecio bruto " + precioBruto + "€, precio con IVA " + precioIva + "€.\n"
				+ "Numero de artículos comprados: " + numeroArticulos);
		
	}
	
		// Metodo para introducir cuanto se ha pagado y cuanto hay qeu devolver
	public static void pagar(ArrayList<Double> lista) {
		
		double pagado = Double.parseDouble(JOptionPane.showInputDialog("Cantidad a pagar " + precioIva(lista) + "€. Entra la cantidad pagada"));
		double precioIva = precioIva(lista); 
		
		if (pagado < precioIva) {
			JOptionPane.showMessageDialog(null, "Cantidad pagada menor al precio total, intentalo de nuevo");
			pagar(lista);
		} else if (pagado >= precioIva) {
			JOptionPane.showMessageDialog(null, " el cambio es de " + (pagado - precioIva) + "€");
		}
		
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
