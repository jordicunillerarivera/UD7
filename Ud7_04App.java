import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ud7_04App {
	
	public static void main(String[] args) {
		
		ArrayList<Double> lista = crearArrayList();
		mostrar(lista);
		pagar(lista);
		
	}
	
	public static ArrayList<Double> crearArrayList() {
		
		ArrayList<Double> lista = new ArrayList<>();
		
		double precio;
		
		do {
			
			precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca un uevo precio (0 para salir)"));
			lista.add(precio);
			
		} while (precio != 0);
		
		return lista;
		
	}
	
	public static void mostrar(ArrayList<Double> lista) {
		
		double precioBruto = precioBruto(lista);
		double precioIva = precioIva(lista);
		int numeroArticulos = numeroArticulos(lista);
		
		JOptionPane.showMessageDialog(null, "Iva aplicado 21%\nPrecio bruto " + precioBruto + "€, precio con IVA " + precioIva + "€.\n"
				+ "Numero de artículos comprados: " + numeroArticulos);
		
	}
	
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
	
	public static double precioBruto(ArrayList<Double> lista) {
		
		Iterator<Double> it = lista.iterator();
		double precio = 0;
		while (it.hasNext()) {
			precio += it.next();
		}
		
		return precio;
		
	}
	
	public static double precioIva(ArrayList<Double> lista) {
		
		double precioBruto = precioBruto(lista);
		return precioBruto + (precioBruto * 0.21);
		
	}
	
	public static int numeroArticulos(ArrayList<Double>lista ) {
		
		return lista.size() - 1;
		
	}

}
