package proyecto;

import java.util.Hashtable;

import com.mindfusion.common.DateTime;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.scheduling.model.Appointment;

public class Guarderia extends Cita{
	private Appointment app;
	private byte horaLlegada;
	private byte minutosLlegada;
	private String details;
	private byte horasGuarderia;
	private boolean am;
	
	private static Hashtable <String,Guarderia> hashtableGuarderia = new Hashtable<>(); 				


	//Constructor 1
	Guarderia(Mascota mascota, byte dia, byte mes, short año, byte horaLlegada, byte minutosLlegada, byte horas, boolean am, String tag){
		super(mascota, dia, mes, año);
		
		this.minutosLlegada = minutosLlegada;
		this.setAm(am);
		this.setHorasGuarderia(horas);
		
			if(horaLlegada>12)
				this.horaLlegada = (byte) (horaLlegada - 12);
			else if(horaLlegada==0)
				this.horaLlegada = 12;	
			else
				this.horaLlegada = horaLlegada;
				
			if(tag.equals("")) {
				tag =  "G" + mascota.getNombreMascota() + dia + mes + año + horaLlegada + minutosLlegada;
				Cita.addTag(tag);
			}
		
		app = new Appointment();
		app.setSubject("Guarderia: " + mascota.getNombreMascota());
		app.setStartTime(new DateTime(año, mes, dia, horaLlegada, minutosLlegada, 0));
		app.setTag(tag);	
		app.setEndTime(new DateTime (año, mes, dia, horaLlegada, minutosLlegada, 0).addHours(horas));
		details = "-Tiempo en guarderia: \n"+ horas + " horas-";
		app.setDetails(details);
		app.getSelectedStyle().setBrush(Brushes.LemonChiffon);
		
		Estadistica.nuevaGuarderia(mes, año);
		PanelCalendario.getCalendar().getSchedule().getItems().add(app);
		hashtableGuarderia.put(tag,this);

	}
	


	//Getters
	public byte getHoraLlegada() {
		return horaLlegada;
	}
	
	public byte getMinutosLlegada() {
		return minutosLlegada;
	}
	
	public String getDetails() {
		return details;
	}
	
	public byte getHorasGuarderia() {
		return horasGuarderia;
	}
	
	public boolean isAm() {
		return am;
	}

	public Appointment getApp() {
		return app;
	}
	
	public static Hashtable<String, Guarderia> getHashtableGuarderia(){
		return hashtableGuarderia;
	}
	
	public String getTextMinutos() {
		String min = "";
		if(minutosLlegada<10)
			min = "0" + minutosLlegada;
		else
			min = "" + minutosLlegada;
		
		return min;
	}

	//Setters
	public void setMinutosLlegada(byte minutosLlegada) {
		this.minutosLlegada = minutosLlegada;
	}

	public void setHorasGuarderia(byte horasGuarderia) {
		this.horasGuarderia = horasGuarderia;
	}
	
	public void setAm(boolean am) {
		this.am = am;
	}
	
	public void setHoraLlegada(byte horaLlegada) {
		
		app.setStartTime(new DateTime(año, mes, dia, horaLlegada, minutosLlegada, 0));
		app.setEndTime(new DateTime (año, mes, dia, horaLlegada, minutosLlegada, 0).addHours(horasGuarderia));
		
		if(horaLlegada>12)
			this.horaLlegada = (byte) (horaLlegada - 12);
		else if(horaLlegada==0)
			this.horaLlegada = 12;
		else
		this.horaLlegada = horaLlegada;
	}	
	
	@Override
	public void setDia(byte dia) {
		if(dia!=this.dia) {
		this.dia = dia;
		app.setStartTime(new DateTime(año, mes, dia));
		app.setEndTime(new DateTime(año, mes, dia));
		}
	}
	
	@Override
	public void setMes(byte mes) {
		if(mes!=this.mes) {
		this.mes = mes;
		app.setStartTime(new DateTime(año, mes, dia));
		app.setEndTime(new DateTime(año, mes, dia));
		}
	}
	
	@Override
	public void setAño(short año) {
		if(año!=this.año) {
		this.año = año;
		app.setStartTime(new DateTime(año, mes, dia));
		app.setEndTime(new DateTime(año, mes, dia));
		}
	}


	@Override
	public String showInfo() {
		String info = "Guardería " + getMascota().getNombreMascota() + "\n " + horaLlegada + ": " + getTextMinutos() + "\n" + details;
		return info;
	}
	
	public static Guarderia getGuarderia(String tag) {
		return hashtableGuarderia.get(tag);
	}



}
