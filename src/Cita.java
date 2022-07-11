package proyecto;

import java.util.ArrayList;

public class Cita {
	
	//Atributos
	protected byte dia;
	protected byte mes;
	protected short año;
	protected String id;
	protected Mascota mascota;

	private static ArrayList<String> listaTags = new ArrayList<String>();
		
	
	//Método constructor
	public Cita (Mascota mascota, byte dia, byte mes, short año) {
		this.mascota = mascota;
		this.dia = dia;
		this.mes = mes;
		this.año = año;		
				
	}
	
	//Getters
	public  Cita getCita() {
		return null;
	}
	
	public Mascota getMascota() {
		return mascota;
	}
	
	public byte getDia() {
		return dia;
	}
	
	public byte getMes() {
		return mes;
	}
	
	public short getAño() {
		return año;
	}
	
	public String getId() {
		return id;
	}
	
	public static ArrayList<String> getListaTags() {
		return listaTags;
	}

	
	//Setters
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	public void setDia(byte dia) {
		this.dia = dia;
		
	}
	
	public void setMes(byte mes) {
		this.mes = mes;
	}
	
	public void setAño(short año) {
		this.año = año;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	//Agrega un tag a la lista
	public static void addTag(String tag) {
		listaTags.add(tag);
	}
	
	//Mostrar información para el panel del calendario
	public String showInfo() {
		return "";
	}
	
	
}