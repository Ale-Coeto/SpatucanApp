package proyecto;

import java.util.Hashtable;

import com.mindfusion.common.DateTime;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.scheduling.model.Appointment;

public class Pension extends Cita{
	private byte diasPension;
	private Appointment app;
	
	private static Hashtable<String,Pension> hashtablePension = new Hashtable<>();


	//Constructor 
	public Pension(Mascota mascota, byte dia, byte mes, short año, byte diasPension, String tag) {
		super(mascota, dia, mes, año);
		this.diasPension = diasPension;
		
		app = new Appointment();
		app.setSubject("Pensión: " + mascota.getNombreMascota());
		app.setStartTime(new DateTime(año, mes, dia));		
		app.setEndTime(new DateTime(año, mes, dia).addDays(diasPension));
		
		if(tag.equals("")) {
			 tag =  "P" + mascota.getNombreMascota() + dia + mes + año + diasPension;
			 Cita.addTag(tag);
			}
		
		app.setTag(tag);
		app.getStyle().setBrush(Brushes.LightSalmon);
		app.getSelectedStyle().setBrush(Brushes.LemonChiffon);
		Estadistica.nuevaPension(mes, año);
		PanelCalendario.getCalendar().getSchedule().getItems().add(app);
		hashtablePension.put(tag,this);

	}
	
	
	//Getters
	public byte getDiasPension() {
		return diasPension;
	}
	
	public Appointment getApp() {
		return app;
	}
	
	public static Pension getPension(String tag) {
		return hashtablePension.get(tag);
	}
	
	//Setters
	public static Hashtable<String,Pension> getHashtablePension() {
		return hashtablePension;
	}

	public void setDiasPension(byte diasPension) {
		this.diasPension = diasPension;
		app.setEndTime(new DateTime(año, mes, dia).addDays(diasPension));
	}
	
	@Override
	public void setDia(byte dia) {
		if(dia!=this.dia) {
			this.dia = dia;
			app.setStartTime(new DateTime(año, mes, dia));
			app.setEndTime(new DateTime(año, mes, dia).addDays(diasPension));
		}
	}
	
	@Override
	public void setMes(byte mes) {
		if(mes!=this.mes) {
			this.mes = mes;
			app.setStartTime(new DateTime(año, mes, dia));
			app.setEndTime(new DateTime(año, mes, dia).addDays(diasPension));
		}
	}
	@Override
	public void setAño(short año) {
		if(año!=this.año) {
			this.año = año;
			app.setStartTime(new DateTime(año, mes, dia));
			app.setEndTime(new DateTime(año, mes, dia).addDays(diasPension));
		}
	}
	@Override
	public String showInfo() {
		String info = "Pensión " + getMascota().getNombreMascota() + "\n Días en pensión:" + " " + diasPension;
		return info;
	}
	
	
}
