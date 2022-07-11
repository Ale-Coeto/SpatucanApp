package proyecto;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel implements MouseListener{
	static JPanel pnlButtons;
	JPanel pnlPiePagina;
	JLabel lblSpatucan, lblFecha;
	static JLabel lblAgregarCliente;
	static JLabel lblVerClientes;
	static JLabel lblVerEstadisticas;
	static JLabel lblCalendario;
	static PanelAgregarCliente pnlAgregarCliente;
	static PanelBuscarClientes pnlBuscarClientes;
	static PanelCalendario pnlCalendario;
	static PanelBuscarEstadistica pnlEstadisticas;
	static Color cyan = new Color(0x2ad9f7);
	static Color darkBlue = new Color(0x2559c2);
	static ImageIcon schedule;
	ImageIcon schedule2;
	ImageIcon paw;
	static ImageIcon paw2;
	static ImageIcon search;
	ImageIcon search2;
	static ImageIcon chart;
	ImageIcon chart2;
	
	PanelPrincipal(){
		
	//Propiedades del panel
	this.setBounds(0,0,1000,640);
	this.setBackground(Color.WHITE);
	this.setVisible(false);
	this.setLayout(null);
	
	
	//Pie de página
	pnlPiePagina = new JPanel();
	pnlPiePagina.setBounds(0,580,1000,40);
	pnlPiePagina.setBackground(darkBlue);
	pnlPiePagina.setLayout(null);
	
	lblSpatucan = new JLabel ("Spatucan");
	lblSpatucan.setBounds(20,10,200,20);
	lblSpatucan.setForeground(Color.WHITE);
	
	//Fecha
	int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
	int año = Calendar.getInstance().get(Calendar.YEAR);	
	String fecha = Integer.toString(dia) + "/" + Spatucan.mesAString(mes) + "/" + Integer.toString(año);
	
	lblFecha = new JLabel (fecha);
	lblFecha.setBounds(800,10,200,20);
	lblFecha.setForeground(Color.WHITE);	
	
	pnlPiePagina.add(lblSpatucan);
	pnlPiePagina.add(lblFecha);
		
	//Paneles
	pnlButtons = new JPanel();
	pnlButtons.setVisible(false);
	pnlButtons.setBounds(900,0,100,580);
	pnlButtons.setBackground(cyan);
	pnlButtons.setLayout(new GridLayout(4,1));
	pnlButtons.addMouseListener(this);
	
	pnlAgregarCliente = new PanelAgregarCliente();
	pnlBuscarClientes = new PanelBuscarClientes();
	pnlCalendario = new PanelCalendario();
	pnlEstadisticas = new PanelBuscarEstadistica();
		
	//Íconos --> icons size 48	
	schedule = new ImageIcon(VentanaInicio.class.getResource("/proyecto/schedule2.png"));
	paw = new ImageIcon(VentanaInicio.class.getResource("/proyecto/paw2.png"));
	search = new ImageIcon(VentanaInicio.class.getResource("/proyecto/search2.png"));
	chart = new ImageIcon(VentanaInicio.class.getResource("/proyecto/chart2.png"));
	
	schedule2 = new ImageIcon(VentanaInicio.class.getResource("/proyecto/schedule.png"));
	paw2 = new ImageIcon(VentanaInicio.class.getResource("/proyecto/paw.png"));
	search2 = new ImageIcon(VentanaInicio.class.getResource("/proyecto/search.png"));
	chart2 = new ImageIcon(VentanaInicio.class.getResource("/proyecto/chart.png"));
	
	

	//Botones
	lblCalendario = new JLabel();
	lblCalendario.addMouseListener(this);
	lblCalendario.setIcon(schedule);
	lblCalendario.setHorizontalTextPosition(JLabel.RIGHT);
	lblCalendario.setHorizontalAlignment(JLabel.CENTER);
	pnlButtons.add(lblCalendario);
	
	lblAgregarCliente = new JLabel();
	lblAgregarCliente.addMouseListener(this);
	lblAgregarCliente.setIcon(paw);
	lblAgregarCliente.setHorizontalTextPosition(JLabel.RIGHT);
	lblAgregarCliente.setHorizontalAlignment(JLabel.CENTER);
	pnlButtons.add(lblAgregarCliente);
	
	lblVerClientes = new JLabel();
	lblVerClientes.addMouseListener(this);
	lblVerClientes.setIcon(search);
	lblVerClientes.setHorizontalTextPosition(JLabel.RIGHT);
	lblVerClientes.setHorizontalAlignment(JLabel.CENTER);
	pnlButtons.add(lblVerClientes);
	
	lblVerEstadisticas = new JLabel();
	lblVerEstadisticas.addMouseListener(this);
	lblVerEstadisticas.setIcon(chart);
	lblVerEstadisticas.setHorizontalTextPosition(JLabel.RIGHT);
	lblVerEstadisticas.setHorizontalAlignment(JLabel.CENTER);
	pnlButtons.add(lblVerEstadisticas);
	
	
	this.add(pnlPiePagina);
	this.add(pnlButtons);
	this.add(pnlBuscarClientes);
	this.add(pnlAgregarCliente);
	this.add(pnlCalendario);
	this.add(pnlEstadisticas);
	
	
	}

	//Muestra botones reducidos
	public static void BotonesLogo () {
		pnlButtons.setBounds(900,0,100,580);
		lblAgregarCliente.setText("");
		lblVerClientes.setText("");
		lblVerEstadisticas.setText("");
		lblCalendario.setText("");
		
		lblCalendario.setHorizontalAlignment(JLabel.CENTER);
		lblAgregarCliente.setHorizontalAlignment(JLabel.CENTER);
		lblVerClientes.setHorizontalAlignment(JLabel.CENTER);
		lblVerEstadisticas.setHorizontalAlignment(JLabel.CENTER);
			

	}
	
	//Muestra botones completos
	public void BotonesTexto () {
		pnlButtons.setBounds(700,0,300,580);
		
		lblVerClientes.setText("Ver Clientes");
		lblVerEstadisticas.setText("Ver Estadísticas");
		lblCalendario.setText("Agenda");
		
	 	lblAgregarCliente.setText("Agregar Cliente");
		lblVerClientes.setText("Ver Clientes");
		lblVerEstadisticas.setText("Ver Estadísticas");
		lblCalendario.setText("Agenda");
		
		lblCalendario.setHorizontalAlignment(JLabel.LEFT);
		lblAgregarCliente.setHorizontalAlignment(JLabel.LEFT);
		lblVerClientes.setHorizontalAlignment(JLabel.LEFT);
		lblVerEstadisticas.setHorizontalAlignment(JLabel.LEFT);
		
	}
	
	public static void agregarCliente() {
		BotonesLogo();
		pnlAgregarCliente.setVisible(true);
		pnlBuscarClientes.setVisible(false);
		pnlCalendario.setVisible(false);
		pnlEstadisticas.setVisible(false);

		
		lblCalendario.setIcon(schedule);
		lblAgregarCliente.setIcon(paw2);
		lblVerClientes.setIcon(search);
		lblVerEstadisticas.setIcon(chart);
		
		
		lblCalendario.setBackground(cyan);
		lblCalendario.setOpaque(true);
		lblAgregarCliente.setBackground(Color.white);
		lblAgregarCliente.setOpaque(true);
		lblVerClientes.setBackground(cyan);
		lblVerClientes.setOpaque(true);
		lblVerEstadisticas.setBackground(cyan);
		lblVerEstadisticas.setOpaque(true);
	}
	
	//De acuerdo con la opción del menú seleccionada, se ocultan los demás paneles y cambia el formato
	@Override
	public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == lblCalendario) {
				BotonesLogo();
				pnlAgregarCliente.setVisible(false);
				pnlBuscarClientes.setVisible(false);
				pnlCalendario.setVisible(true);
				pnlEstadisticas.setVisible(false);

				
				lblCalendario.setIcon(schedule2);
				lblAgregarCliente.setIcon(paw);
				lblVerClientes.setIcon(search);
				lblVerEstadisticas.setIcon(chart);
				
				lblCalendario.setBackground(Color.white);
				lblCalendario.setOpaque(true);
				lblAgregarCliente.setBackground(cyan);
				lblAgregarCliente.setOpaque(true);
				lblVerClientes.setBackground(cyan);
				lblVerClientes.setOpaque(true);
				lblVerEstadisticas.setBackground(cyan);
				lblVerEstadisticas.setOpaque(true);
				
			}
		
			  if(e.getSource() == lblAgregarCliente) {
				agregarCliente();
				
				
			} if (e.getSource() == lblVerClientes) {
				BotonesLogo();
				pnlBuscarClientes.setVisible(true);
				pnlAgregarCliente.setVisible(false);
				pnlCalendario.setVisible(false);
				pnlEstadisticas.setVisible(false);

				
				lblCalendario.setIcon(schedule);
				lblAgregarCliente.setIcon(paw);
				lblVerClientes.setIcon(search2);
				lblVerEstadisticas.setIcon(chart);

				
				lblCalendario.setBackground(cyan);
				lblCalendario.setOpaque(true);
				lblAgregarCliente.setBackground(cyan);
				lblAgregarCliente.setOpaque(true);
				lblVerClientes.setBackground(Color.white);
				lblVerClientes.setOpaque(true);
				lblVerEstadisticas.setBackground(cyan);
				lblVerEstadisticas.setOpaque(true);
				
			} if (e.getSource() == lblVerEstadisticas) {
				BotonesLogo();
				pnlBuscarClientes.setVisible(false);
				pnlAgregarCliente.setVisible(false);
				pnlCalendario.setVisible(false);
				pnlEstadisticas.setVisible(true);
				
				lblCalendario.setIcon(schedule);
				lblAgregarCliente.setIcon(paw);
				lblVerClientes.setIcon(search);
				lblVerEstadisticas.setIcon(chart2);
				
				
				lblCalendario.setBackground(cyan);
				lblCalendario.setOpaque(true);
				lblAgregarCliente.setBackground(cyan);
				lblAgregarCliente.setOpaque(true);
				lblVerClientes.setBackground(cyan);
				lblVerClientes.setOpaque(true);
				lblVerEstadisticas.setBackground(Color.white);
				lblVerEstadisticas.setOpaque(true);
				
			}
			
			
	}
		
		
	
	//Métodos del menú
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	//Si el mouse entra sobre el menú, se activa el método "Botones Texto"
	@Override
	public void mouseEntered(MouseEvent e) {
		
			if  (e.getSource() == pnlButtons) {
			 	BotonesTexto();
				
			} if (e.getSource() == lblCalendario) {
				lblCalendario.setForeground(darkBlue);
				BotonesTexto();
				
		 	} if (e.getSource() == lblAgregarCliente) {
				lblAgregarCliente.setForeground(darkBlue);
				BotonesTexto();
				
			} if (e.getSource() == lblVerClientes) {
				lblVerClientes.setForeground(darkBlue);
				BotonesTexto();
				
			} if (e.getSource() == lblVerEstadisticas) {
				lblVerEstadisticas.setForeground(darkBlue);
				BotonesTexto();
			}
			
		
	}

	//Si el botón sale del menú, se activa el método "BotonesLogo"
	@Override
	public void mouseExited(MouseEvent e) {
		 if  (e.getSource() == pnlButtons) {
			 BotonesLogo();
			  
		 	} if (e.getSource() == lblCalendario) {
		 		lblCalendario.setForeground(Color.BLACK);
		 		BotonesLogo();
		 
		 		
		 	} if (e.getSource() == lblAgregarCliente) {
				lblAgregarCliente.setForeground(Color.BLACK);
				BotonesLogo();
			
				
			} if (e.getSource() == lblVerClientes) {
				lblVerClientes.setForeground(Color.BLACK);
				BotonesLogo();
				
				
			} if (e.getSource() == lblVerEstadisticas) {
				lblVerEstadisticas.setForeground(Color.BLACK);
				BotonesLogo();
			}		
	}
}

