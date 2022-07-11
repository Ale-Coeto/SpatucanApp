package proyecto;

import java.util.ArrayList;
import java.util.Calendar;

public class Mascota {
	
	//Atributos
	private boolean dias;
	private int añoNacimiento;
	private int frecuenciaBaños;
	private int mes;
	private int año;
	private String nombreMascota;
	private String raza;
	private Cliente cliente;
	private static int numeroMascotas;
	
	private static ArrayList <Mascota> ListaMascotas = new ArrayList<Mascota>();
	private static ArrayList<String> ListaNombres = new ArrayList<String>();
	private static ArrayList<String> MascotasFiltradas;
	
	
	//Método constructor
	Mascota (String nombreMascota, String raza, Cliente cliente) {
		this.nombreMascota = nombreMascota;
		this.raza = raza;
		this.cliente = cliente;		
		
		numeroMascotas++;
		
	}
	
	//Getters
	public Cliente getCliente() {
		return cliente;
	}
	
	public int getFrecuenciaBaños () {
		return frecuenciaBaños;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAño() {
		return año;
	}
	
	public String getNombreMascota () {
		return nombreMascota;
	}
	
	public int getAñoNacimiento () {
		return añoNacimiento;
	}
	
	public String getRaza () {
		return raza;
	}
	
	public boolean getDias () {
		return dias;
	}
		
	public static ArrayList<String> getListaNombres(){
		return ListaNombres;
	}
	
	public static ArrayList<String> getMascotasFiltradas(){
		return MascotasFiltradas;
	}
	
	public static ArrayList<Mascota> getListaMascotas(){
		return ListaMascotas;
	}
	
	public static int getNumeroMascotas () {
		return numeroMascotas;
	}
	
	//Setters
	public void setNombreMascota (String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	
	public void setAñoNacimiento (int añoNacimiento) {
		this.añoNacimiento = añoNacimiento;
	}
	
	public void setRaza (String raza) {
		this.raza = raza;
	}
	public void setDias (boolean años) {
		this.dias = años;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setAño(int año) {
		this.año = año;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setFrecuenciaBaños (int frecuenciaBaños) {
		this.frecuenciaBaños = frecuenciaBaños;
	}
	
	//Métodos
	public static void eliminarMascota() {
		numeroMascotas--;
		Apache.excelMascota();

	}
	
	//Agrega un cliente al Array de clientes y a la lista de nombres que tiene un formato (nombreMascota, nombreCliente)
	public static void agregarMascota(Mascota nuevaMascota){
		ListaMascotas.add(nuevaMascota);
		ListaNombres.add(nuevaMascota.getNombreMascota() + ", " + nuevaMascota.getCliente().getNombreCliente());
		ordenarListas();
		Apache.excelMascota();
		
	}
	
	//Algorítmo de ordenamiento para odenar alfabéticamente
		public static void ordenarListas() {
			boolean flagswap = true;
			
			if(numeroMascotas > 1) {
				for(int i = ListaNombres.size()-1; i > 0 && flagswap; i--) {
					String uno = ListaNombres.get(i);
					String dos = ListaNombres.get(i-1);
					
					 if (uno.compareTo(dos) < 0) {
						String temp = ListaNombres.get(i-1);
						Mascota temp2 = ListaMascotas.get(i-1);
						
						ListaMascotas.set(i-1,ListaMascotas.get(i));
						ListaNombres.set(i-1, ListaNombres.get(i));
						
						ListaMascotas.set(i, temp2);
						ListaNombres.set(i, temp);
						
						flagswap = true;
						
					} else 
						flagswap = false;
				}
			}
		}
		
	//Actualiza la lista ClientesFiltrados con los elementos que coinciden con el texto de la barra de búsqueda
			public static void filtrarMascotas(String letras){			
				MascotasFiltradas = new ArrayList<String>();
				
				if(letras.equals("")) {
					MascotasFiltradas = ListaNombres;
					return;
				}
				
				for(int i = 0; i < numeroMascotas; i++) {	
					String nombre = "";
					if(ListaNombres.get(i).length() >= letras.length())
					nombre = ListaNombres.get(i).substring(0,letras.length());
					
					
					if(letras.equals(nombre) || letras.equals(cutNombreMascota(ListaNombres.get(i))) || letras.equals(cutNombreCliente(ListaNombres.get(i))) 
							|| letras.equals(cutPrimerNombre(cutNombreCliente(ListaNombres.get(i)))) || letras.equals(cutApellido(cutNombreCliente(ListaNombres.get(i))))){
						MascotasFiltradas.add(ListaNombres.get(i));
					}				
				}			 
			}
			
			
			//Regresa el nombre de la mascota de un String "nombreMascota, nombreCliente"
			public static String cutNombreMascota(String elegido) {
				String nombreMascota = "";
				boolean found = false;
				
				for (int i = 0; i < elegido.length() && found == false; i++) {
					if(elegido.charAt(i) == ',') {
						nombreMascota = elegido.substring(0,i);
						found = true;
					}
				}
				return nombreMascota;
			}
			
			//Regresa el nombre del cliente de un String "nombreMascota, nombreCliente"
			public static String cutNombreCliente(String elegido) {
				String nombreCliente = "";
				boolean found = false;
				
				for (int i = 0; i < elegido.length() && found == false; i++) {
					if(elegido.charAt(i) == ',') {
						nombreCliente = elegido.substring(i+2,elegido.length());
						found = true;
					}
				}
				return nombreCliente;
			}
			
			//Regresa el primer nombre
			public static String cutPrimerNombre(String elegido) {
				String primerNombre = "";
				
				for(int i=0; i<elegido.length(); i++) {
					if(elegido.charAt(i) == ' ') {
					primerNombre = elegido.substring(0,i);
					return primerNombre;
					}
				}
				return primerNombre;
			}
			
			//Regresa el apellido
			public static String cutApellido(String elegido) {
				String apellido = "";
				
				for(int i=0; i<elegido.length(); i++) {
					if(elegido.charAt(i)==' ') {
						apellido = elegido.substring(i+1, elegido.length());
						return apellido;
					}
				}
				return apellido;
			}
			
			//Algorítmo de búsqueda secuencial para buscar el nombre de una mascota y cliente
			public static Mascota buscarMascota(String nombreMascota,String nombreCliente) {
				for(int i = 0; i < numeroMascotas; i++) {
					if(ListaMascotas.get(i).getNombreMascota().equals(nombreMascota) && 
							ListaMascotas.get(i).getCliente().getNombreCliente().equals(nombreCliente)) {
						Mascota uno = ListaMascotas.get(i);
						return uno;
					}
				}
				return null;
			}
			
			//Algorítmo de búsqueda secuencial para buscar el nombre de una mascota
			public static Mascota buscarMascota2(String nombreMascota) {
				for(int i = 0; i < numeroMascotas; i++) {
					if(ListaMascotas.get(i).getNombreMascota().equals(nombreMascota)) {
						Mascota uno = ListaMascotas.get(i);
						return uno;
					}
				}
				return null;
			}
			
			//Algoritmo de búsqueda binaria
			public static Mascota buscarMascota3(String target, int begin, int end) {
					
					//En caso de que solo haya 1 elemento
					if(begin+end == 1 || end == 0 )
						return getListaMascotas().get(0);
					
					int mid = (begin+end)/2;
					
					//Posibles excepciones
					if(begin>end || mid>=end || mid>=numeroMascotas || (begin==end && 
							!(getListaMascotas().get(mid).getNombreMascota().equals(target)))) 
						return null;
					
					//Caso base
					if(getListaMascotas().get(mid).getNombreMascota().equals(target))
						return getListaMascotas().get(mid);
						
					//Si target es mayor a mid
					if(getListaMascotas().get(mid).getNombreMascota().compareTo(target) < 0)
						return buscarMascota3(target, mid+1, end);
					
					//Si target es menor a mid
					if(getListaMascotas().get(mid).getNombreMascota().compareTo(target) > 0)
						return buscarMascota3(target, begin, mid-1);
						
					return null;
					
				}

				public static void crearListaMascotas() {
					ListaMascotas = new ArrayList<>();					
				}
	
}
