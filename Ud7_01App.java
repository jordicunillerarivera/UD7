import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ud7_01App {

	public static void main(String[] args) {
		
		Hashtable<String, Integer> notasAlumnos = introduccionDatos();
		recorrerHashtable(notasAlumnos);

	}
	
		// Metodo para crear un hastable y introducir valores dentro del mismo
	public static Hashtable<String, Integer> introduccionDatos(){
		
		int contador = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de alumnos a añadir"));
		Hashtable<String, Integer> notasAlumnos = new Hashtable<>();
		
		for (int i = 0; i < contador; i++) {
			
			String alumno = JOptionPane.showInputDialog("Introduzca el nombre del alumno");
			int nota1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la nota 1"));
			int nota2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la nota 2"));
			int nota3 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la nota 3"));
			
			notasAlumnos.put(alumno, ((nota1 + nota2 + nota3) / 3));
		}
		
		return notasAlumnos;
		
	}
	
		// Metodo para recorrer un hashtable
	public static void recorrerHashtable(Hashtable<String, Integer> hash) {
		
		Enumeration<String> llave = hash.keys();
		Enumeration<Integer> valor = hash.elements();
		while (llave.hasMoreElements()) {
			System.out.println(llave.nextElement() + ": " + valor.nextElement());
			
		}
		
	}

}
