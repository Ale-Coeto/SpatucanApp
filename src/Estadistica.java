package proyecto;

import java.util.Calendar;
import java.util.Stack;

import javax.swing.DefaultListModel;

public class Estadistica {

	//Atributos
	private int mes;
	private int año;
	private int nuevasMascotas;
	private int nuevosBaños;
	private int nuevasGuarderias;
	private int nuevasPensiones;
	private static Stack <Estadistica> stackEstadisticas = new Stack<>();
	private static Stack <Estadistica> stackFiltrado = new Stack<>();
	
	//Método constructor
	Estadistica(int mes, int año){
		this.mes = mes;
		this.año = año;		
	}
	
	//Método constructor 2 --> para crear desde Excel
	Estadistica(int mes, int año, int nuevosBaños, int nuevasMascotas, int nuevasGuarderias, int nuevasPensiones){
		this.mes = mes;
		this.año = año;
		this.nuevasMascotas = nuevasMascotas;
		this.nuevosBaños = nuevosBaños;
		this.nuevasGuarderias = nuevasGuarderias;
		this.nuevasPensiones = nuevasPensiones;
		
	}
	
	//Getters
	public int getMes() {
		return mes;
	}
	
	public int getAño() {
		return año;
	}
	
	public static int getStackSize() {
		return stackEstadisticas.size();
	}
	
	public int getNuevasMascotas() {
		return this.nuevasMascotas;
	}
	
	public int getNuevosBaños() {
		return nuevosBaños;
	}
	
	public int getNuevasGuarderias() {
		return nuevasGuarderias;
	}
	
	public int getNuevasPensiones() {
		return nuevasPensiones;
	}
	
	public static Stack<Estadistica> getStack(){
		return stackEstadisticas;
	}
	
	public int getTotal() {
		int total = nuevosBaños + nuevasGuarderias + nuevasPensiones;
		return total;
	}
	
	//Setters	
	public void setNuevasMascotas(int nuevasMascotas) {
		this.nuevasMascotas = nuevasMascotas;
	}
	
	public void setNuevosBaños(int nuevosBaños) {
		this.nuevosBaños = nuevosBaños;
	}

	public void setNuevasGuarderias(int nuevasGuarderias) {
		this.nuevasGuarderias = nuevasGuarderias;
	}

	public void setNuevasPensiones(int nuevasPensiones) {
		this.nuevasPensiones = nuevasPensiones;
	}
	
	//Métodos para agregar datos a las estadísticas
	public static void nuevaMascota(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
		stackEstadisticas.peek().nuevasMascotas++;
	}
	
	public static void eliminarMascota(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevasMascotas--;
	}
	
	public static void nuevoBaño(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevosBaños++;
	}
	
	public static void eliminarBaño(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevosBaños--;
	}
	
	public static void nuevaGuarderia(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevasGuarderias++;
	}
	
	public static void eliminarGuarderia(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevasGuarderias--;
	}
	
	public static void nuevaPension(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevasPensiones++;
	}
	
	public static void eliminarPension(int mes, int año) {
		if(stackEstadisticas.peek().getMes() == mes && stackEstadisticas.peek().getAño() == año)
			stackEstadisticas.peek().nuevasPensiones--;
	}	
	
	//Métodos
	
	//Agrega un objeto al stackEstadisticas
	public static void addStackMeses(Estadistica nuevoMes) {
		stackEstadisticas.push(nuevoMes);
	}
	
	//Primero lee el archivo Excel y después agrega un mes al stack de estadísticas en caso de ser necesario
	public static void crearEstadisticas(){
		Apache.leerStack();
		
		if(stackEstadisticas.isEmpty()) {
			Estadistica nuevoMes = new Estadistica(Calendar.getInstance().get(Calendar.MONTH)+1,
					Calendar.getInstance().get(Calendar.YEAR));			
			addStackMeses(nuevoMes);
			Apache.excelEstadistica(stackEstadisticas.peek());
		}
		
		int mesActual = (Calendar.getInstance().get(Calendar.MONTH)+1);
			
		if (stackEstadisticas.peek().getMes() != mesActual) {
			 
			Estadistica nuevoMes = new Estadistica(Calendar.getInstance().get(Calendar.MONTH)+1,
					Calendar.getInstance().get(Calendar.YEAR));			
			stackEstadisticas.push(nuevoMes);
			Apache.excelEstadistica(stackEstadisticas.peek());
			updateLstEstadisticas();
		 }
		}
	
		
	public static Stack<Estadistica> copiarStack(Stack<Estadistica> copia) {
		for (int i=0; i<stackEstadisticas.size(); i++) {
			copia.push(stackEstadisticas.get(i));
		}
		return copia;
	}
	
	//Actualiza la Jlist de estadísticas para que el último mes sea mostrado hasta arriba
	public static void updateLstEstadisticas() {
		//System.out.println(stackEstadisticas.size());
		PanelBuscarEstadistica.listModelEstadisticas = new DefaultListModel<Object>();
		Stack <Estadistica> copia = new Stack<>();
		copia = copiarStack(copia);
		PanelBuscarEstadistica.lstSize = 0;
		
		for(int i = 0; i < stackEstadisticas.size(); i++) {
			Estadistica elemento1 = copia.pop();
			int mes = elemento1.getMes();
			int año = elemento1.getAño();
			String elemento = Integer.toString(mes) + " / " + Integer.toString(año);
			System.out.println(elemento);
			PanelBuscarEstadistica.listModelEstadisticas.addElement(elemento);
			PanelBuscarEstadistica.lstSize++;
		}
			
		
			PanelBuscarEstadistica.lstEstadisticas.setModel(PanelBuscarEstadistica.listModelEstadisticas);
			System.out.println("Logrado");


		}
	
	//Crea un Stack con los elementos filtrados
	public static void filtrarEstadisticas(String letras){			
		stackFiltrado = new Stack<Estadistica>();
		
		if(letras.equals("")) {
			stackFiltrado = copiarStack(stackFiltrado);
			updateFilteredStack();
			return;
		}
		
		for(int i = 0; i < stackEstadisticas.size(); i++) {	
			String text = "";
			text = stackEstadisticas.get(i).getMes() + "/" + stackEstadisticas.get(i).getAño();
			
			if(letras.equals(Integer.toString(stackEstadisticas.get(i).getMes())) || letras.equals(Integer.toString(stackEstadisticas.get(i).getAño())) || letras.equals(text)){
				stackFiltrado.push(stackEstadisticas.get(i));
			}				
		}	
		updateFilteredStack();
	}
	
	//Actualiza la JList de estadísticas de acuerdo al stack filtrado
	public static void updateFilteredStack() {		
		DefaultListModel<Object> lstModel = new DefaultListModel<Object>();
		int size = stackFiltrado.size();
		PanelBuscarEstadistica.lstSize = 0;
		
		for(int i = 0; i < size; i++) {
			Estadistica elemento1 = stackFiltrado.pop();
			int mes = elemento1.getMes();
			int año = elemento1.getAño();
			String elemento = Integer.toString(mes) + " / " + Integer.toString(año);
			System.out.println(elemento);
			lstModel.addElement(elemento);
			PanelBuscarEstadistica.lstSize++;
			
		}
		PanelBuscarEstadistica.lstEstadisticas.setModel(lstModel);
	
	}
	
	//Regresa el objeto del stack del índice indicado
	public static Estadistica searchStackItem(int index) {
		Estadistica seleccionado = stackEstadisticas.get(index);
		return seleccionado;
		
	}
	
	//Realiza una búsqueda secuencial del objeto seleccionado
	public static Estadistica searchStackItem2 (Object seleccionado) {
		for(int i = 0; i<stackEstadisticas.size(); i++) {
			if (cutMes(seleccionado) == stackEstadisticas.get(i).getMes() && cutAño(seleccionado) == stackEstadisticas.get(i).getAño()) 
				return stackEstadisticas.get(i);
			
		}
		return null;
	}
	
	//Retorna el mes del objeto seleccionado, ya que este se encuentra en formato "mes/año"
	public static int cutMes(Object seleccionado) {
		String texto = seleccionado.toString();
		String mes = "";
		boolean found = false;
		
		for (int i = 0; i < texto.length() && found == false; i++) {
			if(texto.charAt(i) == ' ') {
				mes = texto.substring(0,i);
				found = true;
			}
		}
		int mesInt = Integer.parseInt(mes);
		return mesInt;
	}
	
	//Retorna el año del objeto seleccionado, ya que este se encuentra en formato "mes/año"
	public static int cutAño(Object seleccionado) {
		String texto = seleccionado.toString();
		
		String año = "";
		boolean found = false;
		
		for (int i = 0; i < texto.length() && found == false; i++) {
			if(texto.charAt(i) == '/') {
				año = texto.substring(i+2,texto.length());
				found = true;
				
			}
		}
		int añoInt = Integer.parseInt(año);
		System.out.println(año);
		return añoInt;
	}

	
	
	
}
