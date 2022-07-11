package proyecto;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

public class Spatucan {
	public static Font regular = new Font("Helvetica",Font.PLAIN,20);
	public static Font titles = new Font("SansSerif",Font.BOLD,25);
	public static Font subtitles = new Font("Helvetica", Font.BOLD,22);
	public static Font textFields = new Font("Helvetica", Font.PLAIN,16);

	
	//Main		
		public static void main(String[] args) {

			VentanaInicio Inicio = new VentanaInicio();
			
			
		}
		
		
	//Convierte un mes de número a palabra
	public static String mesAString(int mes) {		
		switch (mes) {
			case 1: return "Enero";
			case 2: return "Febrero";
			case 3: return "Marzo";
			case 4: return "Abril";
			case 5: return "Mayo";
			case 6: return "Junio";
			case 7: return "Julio";
			case 8: return "Agosto";
			case 9: return "Septiembre";
			case 10: return "Octubre";
			case 11: return "Noviembre";
			case 12: return "Diciembre";
			
		}
		return null;
	}
	
	//Verifica si un String contiene un número
	public static boolean isNumber (String data) {
		try {
			Long.parseLong(data);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	//Recive un nombre que puede estar en minúsculas o mayúsculas y lo convierte a un formato con mayúsculas al inicio de cada palabra
	public static String formatoNombre (String nombre) {
		String nombreCorrecto = nombre.toLowerCase();
		
		if(nombre.length() > 0)
		nombreCorrecto = nombre.substring(0,1).toUpperCase();
		
		
		for (int i = 1; i<nombre.length(); i++) {
				
			if(nombre.charAt(i-1) == ' ') {
				nombreCorrecto += nombre.substring(i, i+1).toUpperCase();
			} else
				nombreCorrecto += nombre.charAt(i);
			
		}
		return nombreCorrecto;
	}
	

}
