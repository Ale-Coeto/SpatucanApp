package proyecto;

import java.util.Hashtable;

import com.mindfusion.common.DateTime;
import com.mindfusion.common.Duration;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.scheduling.model.Appointment;
import com.mindfusion.scheduling.model.Recurrence;
import com.mindfusion.scheduling.model.RecurrencePattern;

public class Baño extends Cita{

	//Atributos
	private byte hora;
	private byte minutos;
	private boolean baño;
	private boolean corte;
	private boolean rasurado;	
	private boolean am;
	private boolean pm;
	private boolean frecuencia;
	private String details;
	private Appointment app;
	
	private static Hashtable <String,Baño> hashtableBaño = new Hashtable<>();
	
	
	//Constructor 1
	public Baño (Mascota mascota, byte dia, byte mes, short año, boolean baño, 
			boolean rasurado, boolean corte, String tag) {
		super(mascota, dia, mes, año);
		
		this.baño = baño;
		this.rasurado = rasurado;
		this.corte = corte;
		this.am = false;
		this.setPm(false);	
		this.frecuencia = false;
		
		/*	Si el tag está vacío es porque se trata de una nueva 
		mascota (no leída del archivo de excel) y se le asigna un tag */
			if(tag.equals("")) {
				tag = "B" + mascota.getNombreMascota() + dia + mes + año + "c2";
				Cita.addTag(tag);
			}
		
		//Se crea un objeto Appointment en el calendario de la librería
		app = new Appointment();
		app.setSubject("Baño " + mascota.getNombreMascota());
		app.setStartTime(new DateTime(año, mes, dia));
		app.setEndTime(new DateTime(año, mes, dia));
		app.setTag(tag);
		app.getStyle().setBrush(Brushes.LightSkyBlue);
		app.getSelectedStyle().setBrush(Brushes.LemonChiffon);
		setDetails();
		PanelCalendario.getCalendar().getSchedule().getItems().add(app);
		
		//Se agrega el baño a las estadísticas
		Estadistica.nuevoBaño(mes, año);	
	
		//Se agrega al hastable con su tag
		hashtableBaño.put(tag,this);
		
	}
	
	//Constructor 2
	public Baño (Mascota mascota, byte dia, byte mes, short año, byte hora, byte minutos,
			boolean am, boolean pm, boolean baño, boolean rasurado, boolean corte, String tag) {
		
		super(mascota, dia, mes, año);
		
		this.baño = baño;
		this.rasurado = rasurado;
		this.corte = corte;
		this.am = am;
		this.pm = pm;
		this.minutos = minutos;
		this.frecuencia = false;	
		
			if(hora>12)
				this.hora = (byte) (hora - 12);
			else if(hora==0)
				this.hora = 12;
			else
				this.hora = hora;
			
			if(tag.equals("")) {
				tag = "B" + mascota.getNombreMascota() + dia + mes + año + hora + minutos;
				Cita.addTag(tag);
			}
		
		app = new Appointment();
		app.setSubject("Baño " + mascota.getNombreMascota());
		app.setStartTime(new DateTime(año, mes, dia, hora, minutos, 0));
		app.setTag(tag);
		setDetails();
		app.setEndTime(new DateTime (año, mes, dia, hora+getTiempo(), minutos, 0));
		app.getStyle().setBrush(Brushes.LightSkyBlue);
		app.getSelectedStyle().setBrush(Brushes.LemonChiffon);

		Estadistica.nuevoBaño(mes, año);
		PanelCalendario.getCalendar().getSchedule().getItems().add(app);
		hashtableBaño.put(tag,this);
	}
	
	//Constructor 2
	
	
	//Getters	
	public byte getHora() {
		return hora;
	}

	public byte getMinutos() {
		return minutos;
	}

	public boolean isBaño() {
		return baño;
	}
	
	public boolean isCorte() {
		return corte;
	}
	
	public boolean isRasurado() {
		return rasurado;
	}

	public Appointment getApp() {
		return app;
	}

	public String getDetails() {
		return details;
	}
	
	public static Baño getBaño(String tag) {
		return hashtableBaño.get(tag);
	}
	
	public boolean isAm() {
		return am;
	}

	public boolean isPm() {
		return pm;
	}
	
	public static Hashtable<String, Baño> getHashtableBaño(){
		return hashtableBaño;
	}
	
	public String getTextMinutos() {
		String min = "";
		if(minutos<10)
			min = "0" + minutos;
		else
			min = "" + minutos;
		
		return min;
	}
	
	public int getTiempo() {
		int tiempo = 0;
		if(baño) 
			tiempo++;		
		
		if(corte) 
			tiempo++;
		
		if(rasurado) 
			tiempo++;
		
		return tiempo;
	}
	
	//Setters
	
	public void setMinutos(byte minutos) {
		this.minutos = minutos;
	}
	
	public void setBaño(boolean baño) {
		this.baño = baño;
	}

	public void setCorte(boolean corte) {
		this.corte = corte;
	}

	public void setRasurado(boolean rasurado) {
		this.rasurado = rasurado;
	}

	public void setAm(boolean am) {
		this.am = am;
	}

	public void setPm(boolean pm) {
		this.pm = pm;
	}
	
	public void setHora(byte hora) {	
		app.setStartTime(new DateTime(año, mes, dia, hora, minutos, 0));
		app.setEndTime(new DateTime (año, mes, dia, hora+getTiempo(), minutos, 0));

		
		if(hora>12)
			this.hora = (byte) (hora - 12);
		else if(hora==0)
			this.hora = 12;
		else
		this.hora = hora;
		
	}
	
	public void setDetails() {
		details = "";
		if(baño) 
			details += "- Baño -\n";
		
		if(corte) 
			details += "- Corte -\n";
		
		if(rasurado) 
			details += "- Rasurado -\n";
		
		app.setDetails(details);

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
	

	//Muestra la información para el panel del Calendario
	@Override
	public String showInfo() {
		String info = "";
		if(hora == 0)
			info = "Baño " + getMascota().getNombreMascota() + "\n Hora no indicada \n" + details;

		else
			info = "Baño " + getMascota().getNombreMascota() + "\n " + hora + ": " + getTextMinutos() + "\n" + details;
		
		return info;
	}

	public boolean isFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(boolean frecuencia) {
		this.frecuencia = frecuencia;
		if(frecuencia) {

			 Recurrence rec = new Recurrence();
			 
			 rec.setPattern(RecurrencePattern.ByTimeInterval);
			 int tiempo = this.getMascota().getFrecuenciaBaños();

		if(this.getMascota().getDias()) 
			 rec.setInterval(new Duration(24*tiempo,0,0));

		else 
			rec.setInterval(new Duration(tiempo*168,0,0));
		 System.out.println("true");

		
		 rec.setStartDate(new DateTime(this.getAño(), this.getMes(), this.getDia(), 0, 0, 0));

			 app.setRecurrence(rec);
		}
		
		else {
			app.setRecurrence(null);
			System.out.println(false);
		}
		
		
	
			
			
	}

	
	

}
