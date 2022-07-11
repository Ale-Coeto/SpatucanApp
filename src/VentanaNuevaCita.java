package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaNuevaCita extends JFrame implements ActionListener, ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel lblPension, lblHorario, lblHora, lblDots, lblTiempoPension, lblHoras;
	private static JLabel lblTitulo, lblTiempoGuarderia;
	private static JLabel lblCliente;
	private static JLabel lblFecha;
	private static JLabel lblD;
	private static JLabel lblM;
	private static JLabel lblA;
	private static JTextField txtBuscar;
	private static JTextField txtDia, txtHora1, txtMinutos1, txtTiempoPension, txtTiempoGuarderia;
	private static JTextField txtMes;
	private static JTextField txtAño;
	private static JButton btnBuscar;
	private static JButton btnNuevoCliente, btnGuardar;
	private static JButton btnCrear;
	static JList<Object> lstClientes2;
	private static JScrollPane scroll;
	private static JCheckBox cbBaño, cbCorte, cbRasurado, cbFrecuencia;
	private static JRadioButton rbtnAm, rbtnPm;
	private ButtonGroup gpAmPm;
	
	
	VentanaNuevaCita(){
		this.setBounds(800,0,500,600);
		this.setTitle("Nueva Cita");
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		lblTitulo = new JLabel("Nueva Cita");
		lblTitulo.setBounds(0,20,500,50);
		lblTitulo.setFont(Spatucan.titles);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		
		lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(50,70,200,40);
		lblCliente.setFont(Spatucan.regular);
		this.add(lblCliente);
		
		lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(50,280, 200,40);
		lblFecha.setFont(Spatucan.regular);
		this.add(lblFecha);
		
		txtDia = new JTextField("");
		if(PanelCalendario.diaSeleccionado > 0)
			txtDia.setText(Integer.toString(PanelCalendario.diaSeleccionado));
		txtDia.setBounds(130, 285, 60, 25);
		txtDia.setFont(Spatucan.textFields);
		txtDia.setEditable(true);
		this.add(txtDia);
		
		lblD = new JLabel("/");
		lblD.setBounds(190, 285, 80, 25);
		this.add(lblD);
		
		txtMes = new JTextField("");
		if(PanelCalendario.mesSeleccionado > 0)
			txtMes.setText(Integer.toString(PanelCalendario.mesSeleccionado));
		txtMes.setBounds(200, 285, 60, 25);
		txtMes.setFont(Spatucan.textFields);
		txtMes.setEditable(true);
		this.add(txtMes);
		
		lblM = new JLabel("/");
		lblM.setBounds(260, 285, 80, 25);
		this.add(lblM);
		
		txtAño = new JTextField("");
		if(PanelCalendario.añoSeleccionado > 0)
			txtAño.setText(Integer.toString(PanelCalendario.añoSeleccionado));
		txtAño.setBounds(270, 285, 60, 25);
		txtAño.setFont(Spatucan.textFields);
		txtAño.setEditable(true);
		this.add(txtAño);
				
		lblA = new JLabel("dd/mm/aaaa");
		lblA.setBounds(335, 280, 100, 30);
		this.add(lblA);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(300, 490, 150, 50);
		btnCrear.addActionListener(this);
		this.add(btnCrear);
		
		txtBuscar = new JTextField("");
		txtBuscar.setBounds(50, 110, 210, 30);
		txtBuscar.setFont(Spatucan.textFields);
		txtBuscar.setEditable(true);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(275,110,80,30);
		btnBuscar.addActionListener(new ActionListener() {

			//Si el botón es seleccionado, se filtra la lista
			@Override
			public void actionPerformed(ActionEvent e) {
				Mascota.filtrarMascotas(Spatucan.formatoNombre(txtBuscar.getText()));	
				PanelBuscarClientes.updateFilteredJList(lstClientes2);
			}			
			});
		btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.setBounds(365,110,120,30);
		btnNuevoCliente.addActionListener(new ActionListener() {

			//Si el botón es seleccionado, se filtra la lista
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelPrincipal.agregarCliente();
			}			
			});
		
		this.add(btnNuevoCliente);
		lstClientes2 = new JList<Object>();
		lstClientes2.addListSelectionListener(this);
		PanelBuscarClientes.updateLstClientes(lstClientes2);
		this.add(lstClientes2);
		
		scroll = new JScrollPane(lstClientes2) ;
		scroll.setBounds(100,150,300,100);	
		this.add(scroll);	
		
		this.add(lblTitulo);
		this.add(txtBuscar);
		this.add(btnBuscar);
		
		//Baño
		lblHora = new JLabel("Hora: ");
		lblHora.setBounds(50, 325, 100, 30);
		lblHora.setFont(Spatucan.regular);
		lblHora.setVisible(false);
		this.add(lblHora);
		
		txtHora1 = new JTextField("");
		txtHora1.setBounds(130, 325, 60, 25);
		txtHora1.setFont(Spatucan.textFields);
		txtHora1.setVisible(false);;
		this.add(txtHora1);
		
		lblDots = new JLabel(":");
		lblDots.setBounds(193, 314, 20, 40);
		lblDots.setVisible(false);
		this.add(lblDots);
		
		txtMinutos1 = new JTextField("");
		txtMinutos1.setBounds(200, 325, 60, 25);
		txtMinutos1.setFont(Spatucan.textFields);
		txtMinutos1.setVisible(false);;
		this.add(txtMinutos1);
		
		rbtnAm = new JRadioButton("AM");
		rbtnAm.setBounds(280, 320, 80, 30);
		rbtnAm.setVisible(false);
		this.add(rbtnAm);
		
		rbtnPm = new JRadioButton("PM");
		rbtnPm.setBounds(350, 320, 80, 30);
		rbtnPm.setVisible(false);
		this.add(rbtnPm);
		
		gpAmPm = new ButtonGroup();
		gpAmPm.add(rbtnAm);
		gpAmPm.add(rbtnPm);		
		
		cbBaño = new JCheckBox("Baño");
		cbBaño.setBounds(50, 370, 100, 40);
		cbBaño.setFont(Spatucan.regular);
		cbBaño.setVisible(false);
		this.add(cbBaño);
		
		cbCorte = new JCheckBox("Corte");
		cbCorte.setBounds(170, 370, 100, 40);
		cbCorte.setFont(Spatucan.regular);
		cbCorte.setVisible(false);
		this.add(cbCorte);
		
		cbRasurado = new JCheckBox("Rasurado");
		cbRasurado.setBounds(290, 370, 180, 40);
		cbRasurado.setFont(Spatucan.regular);
		cbRasurado.setVisible(false);
		this.add(cbRasurado);
		
		cbFrecuencia = new JCheckBox();
		cbFrecuencia.setBounds(50, 390, 450, 100);
		cbFrecuencia.setFont(new Font("Sans Serif", Font.PLAIN,15));
		cbFrecuencia.setVisible(false);
		
		this.add(cbFrecuencia);
		
		//Pensión
		lblPension = new JLabel("Dias");
		lblPension.setBounds(350, 325, 100, 30);
		lblPension.setVisible(false);
		this.add(lblPension);
		
		lblTiempoPension = new JLabel("Tiempo en pensión: ");
		lblTiempoPension.setBounds(50, 325, 220, 30);
		lblTiempoPension.setFont(Spatucan.regular);
		lblTiempoPension.setVisible(false);
		this.add(lblTiempoPension);
		
		txtTiempoPension = new JTextField("");
		txtTiempoPension.setBounds(240, 325, 90, 30);
		txtTiempoPension.setFont(Spatucan.textFields);
		txtTiempoPension.setVisible(false);;
		this.add(txtTiempoPension);
		
		
		
		//Guardería
		lblHorario = new JLabel("Hora: ");
		lblHorario.setBounds(50, 325, 100, 30);
		lblHorario.setFont(Spatucan.regular);
		lblHorario.setVisible(false);
		this.add(lblHorario);
		
		lblTiempoGuarderia = new JLabel("Tiempo en guardería:");
		lblTiempoGuarderia.setBounds(50, 360, 220, 30);
		lblTiempoGuarderia.setFont(Spatucan.regular);
		lblTiempoGuarderia.setVisible(false);
		this.add(lblTiempoGuarderia);
	
		txtTiempoGuarderia = new JTextField("");
		txtTiempoGuarderia.setBounds(260, 360, 60, 30);
		txtTiempoGuarderia.setFont(Spatucan.textFields);
		txtTiempoGuarderia.setVisible(false);
		this.add(txtTiempoGuarderia);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(330, 360, 100, 30);
		lblHoras.setVisible(false);
		this.add(lblHoras);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(300, 500, 150, 50);
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(this);
		this.add(btnGuardar);
		
		
	}
	
	public static void setDia(int dia) {
		try {
		txtDia.setText(Integer.toString(dia));
		} catch (Exception e) {
			
		}
	}
	
	public static void setMes (int mes) {
		try {
		txtMes.setText(Integer.toString(mes));
		} catch (Exception e) {
			
		}
	}
	
	public static void setAño (int año) {
		try {
		txtAño.setText(Integer.toString(año));
		} catch (Exception e) {
		}
		
	}
	
	public static void citaBaño() {
		PanelCalendario.frmNuevaCita.getContentPane().setBackground(new Color(0xc2e7fc));	
		
		lblTitulo.setText("Nueva Cita: Baño");
		lblTitulo.setForeground(new Color(0x0075e3));
		lblHora.setVisible(true);
		txtHora1.setVisible(true);
		txtMinutos1.setVisible(true);
		lblDots.setVisible(true);
		cbBaño.setVisible(true);
		cbCorte.setVisible(true);
		cbRasurado.setVisible(true);
		rbtnPm.setVisible(true);
		rbtnAm.setVisible(true);
		
	}
	
	public static void citaPension() {
		PanelCalendario.frmNuevaCita.getContentPane().setBackground(new Color(0xffbea8));
		PanelCalendario.frmNuevaCita.setSize(500,500);

		btnCrear.setBounds(300, 390, 150, 50);
		lblTitulo.setText("Nueva Cita: Pensión");
		lblTitulo.setForeground(new Color(0xf75128));
		lblPension.setVisible(true);
		lblTiempoPension.setVisible(true);
		txtTiempoPension.setVisible(true);
	}
	
	public static void citaGuarderia() {
		PanelCalendario.frmNuevaCita.getContentPane().setBackground(new Color(0xcbff94));
		PanelCalendario.frmNuevaCita.setSize(500,550);

		lblTitulo.setText("Nueva Cita: Guardería");
		lblTitulo.setForeground(new Color(0x4dba09));
		
		lblHorario.setVisible(true);
		btnCrear.setBounds(300, 430, 150, 50);
		txtHora1.setVisible(true);
		txtMinutos1.setVisible(true);
		lblDots.setVisible(true);
		rbtnAm.setVisible(true);
		rbtnPm.setVisible(true);
		txtTiempoGuarderia.setVisible(true);
		lblTiempoGuarderia.setVisible(true);
		lblHoras.setVisible(true);
		
	}
	//----------------------------------------------------------------------------
	public static void editar() {
		btnBuscar.setVisible(false);
		txtBuscar.setVisible(false);
		scroll.setVisible(false);
		btnNuevoCliente.setVisible(false);
		btnCrear.setVisible(false);
		btnGuardar.setVisible(true);
		lblCliente.setBounds(50,80,400,40);
		lblFecha.setBounds(50,160, 200,40);
		lblA.setBounds(335, 160, 100, 30);
		lblM.setBounds(260, 165, 80, 25);
		lblD.setBounds(190, 165, 80, 25);	
		txtMes.setBounds(200, 165, 60, 25);
		txtDia.setBounds(130, 165, 60, 25);
		txtAño.setBounds(270, 165, 60, 25);
		
		
	}
	
	public static void citaBañoEditar(Baño baño) {
		PanelCalendario.frmNuevaCita.setSize(500,470);
		editar();
		rbtnPm.setBounds(350, 190, 80, 30);
		rbtnAm.setBounds(280, 190, 80, 30);
		txtMinutos1.setBounds(200, 195, 60, 25);
		lblDots.setBounds(193, 184, 20, 40);
		txtHora1.setBounds(130, 195, 60, 25);
		lblHora.setBounds(50, 195, 100, 30);
		cbFrecuencia.setBounds(50, 260, 450, 100);
		cbRasurado.setBounds(290, 240, 180, 40);
		cbCorte.setBounds(170, 240, 100, 40);
		cbBaño.setBounds(50, 240, 100, 40);
		btnGuardar.setBounds(300, 350, 150, 50);
		
		lblCliente.setText("Cliente: " + baño.getMascota().getNombreMascota() + ", " + baño.getMascota().getCliente().getNombreCliente());
		txtDia.setText(Byte.toString(baño.getDia()));
		txtMes.setText(Byte.toString(baño.getMes()));
		txtAño.setText(Short.toString(baño.getAño()));	
		cbBaño.setSelected(baño.isBaño());
		cbCorte.setSelected(baño.isCorte());
		cbRasurado.setSelected(baño.isRasurado());
		
		try {
			int frecuencia = baño.getMascota().getFrecuenciaBaños();
			if(frecuencia>0) {
				String dias = "";
					if(baño.getMascota().getDias())
						dias = " Dia/s";
					else
						dias = " Semana/s";
				
				cbFrecuencia.setText("Activar frecuencia de baños: \n Cada " + frecuencia + dias);
				if(baño.isFrecuencia())
					cbFrecuencia.setSelected(true);
				cbFrecuencia.setVisible(true);
				}
				
				else 
					cbFrecuencia.setVisible(false);
		}catch(Exception e) {
		
	}
		
		if(baño.isAm() || baño.isPm()) {
			rbtnAm.setSelected(baño.isAm());
			rbtnPm.setSelected(baño.isPm());
			txtHora1.setText(Byte.toString(baño.getHora()));
			txtMinutos1.setText(baño.getTextMinutos());
		}
		
	}
	
	public static void citaGuarderiaEditar(Guarderia guarderia) {
		PanelCalendario.frmNuevaCita.setSize(500,450);
		editar();
		lblHorario.setBounds(50, 195, 100, 30);
		rbtnPm.setBounds(350, 190, 80, 30);
		rbtnAm.setBounds(280, 190, 80, 30);
		txtMinutos1.setBounds(200, 195, 60, 25);
		lblDots.setBounds(193, 184, 20, 40);
		txtHora1.setBounds(130, 195, 60, 25);
		btnGuardar.setBounds(300, 500, 150, 50);
		lblHoras.setBounds(330, 235, 100, 30);
		txtTiempoGuarderia.setBounds(260, 235, 60, 30);
		lblTiempoGuarderia.setBounds(50, 235, 220, 30);	
		btnGuardar.setBounds(300, 330, 150, 50);
		
		lblCliente.setText("Cliente: " + guarderia.getMascota().getNombreMascota() + "," + guarderia.getMascota().getCliente().getNombreCliente());
		txtDia.setText(Byte.toString(guarderia.getDia()));
		txtMes.setText(Byte.toString(guarderia.getMes()));
		txtAño.setText(Short.toString(guarderia.getAño()));	
		if(guarderia.isAm())
			rbtnAm.setSelected(true);
		else
			rbtnPm.setSelected(true);
		txtHora1.setText(Byte.toString(guarderia.getHoraLlegada()));
		txtMinutos1.setText(guarderia.getTextMinutos());
		txtTiempoGuarderia.setText(Byte.toString(guarderia.getHorasGuarderia()));
		
	}
	
	public static void citaPensionEditar(Pension pension) {
		PanelCalendario.frmNuevaCita.setSize(500,370);

		editar();
		btnGuardar.setBounds(300, 260, 150, 50);
		txtTiempoPension.setBounds(240, 195, 90, 30);
		lblTiempoPension.setBounds(50, 195, 220, 30);
		lblPension.setBounds(350, 195, 100, 30);
		
		lblCliente.setText("Cliente: " + pension.getMascota().getNombreMascota() + "," + pension.getMascota().getCliente().getNombreCliente());
		txtDia.setText(Byte.toString(pension.getDia()));
		txtMes.setText(Byte.toString(pension.getMes()));
		txtAño.setText(Short.toString(pension.getAño()));	
		txtTiempoPension.setText(Byte.toString(pension.getDiasPension()));
		
		
	}
	
	public Mascota getMascota() {
		String elegido = lstClientes2.getSelectedValuesList().toString();
		 elegido = elegido.substring(1,elegido.length()-1);
		Mascota mascota = Mascota.buscarMascota(Mascota.cutNombreMascota(elegido), Mascota.cutNombreCliente(elegido));
		return mascota;
	}
	
	public void updateBaño() {
		Baño.getBaño(PanelCalendario.getTag()).setDia(Byte.parseByte(txtDia.getText()));
		Baño.getBaño(PanelCalendario.getTag()).setMes(Byte.parseByte(txtMes.getText()));
		Baño.getBaño(PanelCalendario.getTag()).setAño(Short.parseShort(txtAño.getText()));
		Baño.getBaño(PanelCalendario.getTag()).setBaño(cbBaño.isSelected());
		Baño.getBaño(PanelCalendario.getTag()).setRasurado(cbRasurado.isSelected());
		Baño.getBaño(PanelCalendario.getTag()).setCorte(cbCorte.isSelected());
		Baño.getBaño(PanelCalendario.getTag()).setDetails();
		if(cbFrecuencia.isSelected()) { 
			Baño.getBaño(PanelCalendario.getTag()).setFrecuencia(true);
		}
		else
			Baño.getBaño(PanelCalendario.getTag()).setFrecuencia(false);
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		try {
			int frecuencia = getMascota().getFrecuenciaBaños();
			if(frecuencia>0 && lblHora.isVisible()) {
				String dias = "";
					if(getMascota().getDias())
						dias = " Dia/s";
					else
						dias = " Semana/s";
				
				cbFrecuencia.setText("Activar frecuencia de baños: \n Cada " + frecuencia + dias);
				cbFrecuencia.setVisible(true);
			
				}
				
				else 
					cbFrecuencia.setVisible(false);
				
		
		} catch(Exception ex) {
			System.out.println("nop");
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCrear || e.getSource() == btnGuardar) {
			boolean editar = false;
		if(e.getSource()==btnCrear)
			editar = false;
		if(e.getSource()==btnGuardar)
			editar=true;
		
		//Mascota mascota = new Mascota();
			try {
				if(editar==false) {			
				if(lstClientes2.getSelectedIndex() == -1)
					throw new Exception ("Cliente no seleccionado");				
				}
				
				if(txtDia.getText().length() == 0 || Spatucan.isNumber(txtDia.getText()) == false || Integer.parseInt(txtDia.getText())> 31 || Integer.parseInt(txtDia.getText()) <0)
					throw new Exception ("Día no válido");
				
				if(txtMes.getText().length() == 0 || Spatucan.isNumber(txtMes.getText()) == false || Integer.parseInt(txtMes.getText())>12 || Integer.parseInt(txtMes.getText()) <0)
					throw new Exception ("Mes no válido");
				
				if(txtAño.getText().length() != 4 || Spatucan.isNumber(txtAño.getText()) == false || Integer.parseInt(txtAño.getText())<Calendar.getInstance().get(Calendar.YEAR) || Integer.parseInt(txtAño.getText()) <0)
					throw new Exception ("Año no válido");
				
				
				
				//Para Baño o guardería
			//	if(lblHora.isVisible() || lblHorario.isVisible())
					
				
				//Baño		
				if(lblHora.isVisible()) {
					if(cbBaño.isSelected()==false && cbCorte.isSelected()==false && cbRasurado.isSelected()==false)
						throw new Exception("No se ha seleccionado baño, corte o rasurado");
					
					Baño baño;
				
					//Si se ingresa una hora y minutos
					if(txtHora1.getText().length()>0) {
						if(Spatucan.isNumber(txtHora1.getText()) == false || Integer.parseInt(txtHora1.getText()) <0)
							throw new Exception ("Hora no válida");
					
						if( Integer.parseInt(txtHora1.getText()) >12 )
							throw new Exception("Hora no válida, debe estar en formato de 12 horas");
						
						if(txtMinutos1.getText().length() == 0 || Spatucan.isNumber(txtMinutos1.getText()) == false|| Integer.parseInt(txtMinutos1.getText()) >= 60 || Integer.parseInt(txtMinutos1.getText()) < 0)
							throw new Exception ("Minutos no válidos");
						
						if(rbtnAm.isSelected()==false && rbtnPm.isSelected()==false)
							throw new Exception("No se ha seleccionado AM o PM");
					
						
						byte hora;
						if (rbtnPm.isSelected() && txtHora1.getText().equals("12"))
							hora = 0;
						
						else if(rbtnAm.isSelected())
							hora = Byte.parseByte(txtHora1.getText());
						
						else {
							hora = 12;
							hora +=  Byte.parseByte(txtHora1.getText());
						}
						
						if(editar==false) {
						 baño = new Baño(getMascota(), Byte.parseByte(txtDia.getText()), Byte.parseByte(txtMes.getText()), Short.parseShort(txtAño.getText()), hora , Byte.parseByte(txtMinutos1.getText()), rbtnAm.isSelected(), rbtnPm.isSelected(), cbBaño.isSelected(), cbRasurado.isSelected(), cbCorte.isSelected(), "");
						 if(cbFrecuencia.isVisible() && cbFrecuencia.isSelected()) 
								baño.setFrecuencia(true);
							else
								baño.setFrecuencia(false);
						}
						
					 else if(editar){
							
							updateBaño();
							Baño.getBaño(PanelCalendario.getTag()).setMinutos(Byte.parseByte(txtMinutos1.getText()));
							Baño.getBaño(PanelCalendario.getTag()).setHora(hora);
							Baño.getBaño(PanelCalendario.getTag()).setAm(rbtnAm.isSelected());
							Baño.getBaño(PanelCalendario.getTag()).setPm(rbtnPm.isSelected());
							
					}
					
					} else { 
						if(editar==false) {
						baño = new Baño(getMascota(), Byte.parseByte(txtDia.getText()), Byte.parseByte(txtMes.getText()), Short.parseShort(txtAño.getText()), cbBaño.isSelected(), cbRasurado.isSelected(), cbCorte.isSelected(), "");
					
					if(cbFrecuencia.isVisible() && cbFrecuencia.isSelected()) 
						baño.setFrecuencia(true);
					else
						baño.setFrecuencia(false);
						}
						
						else
							updateBaño();
						
					}
				} 
				
				//Pension
				if(lblPension.isVisible()) {
					Pension nuevaPension;

					if(txtTiempoPension.getText().length() == 0)
						throw new Exception ("Tiempo en pensión no indicado");
					
					if(Integer.parseInt(txtTiempoPension.getText()) <0 || Integer.parseInt(txtTiempoPension.getText()) > 30 || Spatucan.isNumber(txtTiempoPension.getText()) == false)
						throw new Exception ("Tiempo en pensión no válido");
					
					if(editar==false)
					nuevaPension = new Pension(getMascota(), Byte.parseByte(txtDia.getText()), Byte.parseByte(txtMes.getText()), Short.parseShort(txtAño.getText()),Byte.parseByte(txtTiempoPension.getText()),"");
					
					else {
						Pension.getPension(PanelCalendario.getTag()).setDia(Byte.parseByte(txtDia.getText()));
						Pension.getPension(PanelCalendario.getTag()).setMes(Byte.parseByte(txtMes.getText()));
						Pension.getPension(PanelCalendario.getTag()).setAño(Short.parseShort(txtAño.getText()));
						Pension.getPension(PanelCalendario.getTag()).setDiasPension(Byte.parseByte(txtTiempoPension.getText()));

					}
				}
				
				//Guardería
				if(lblHorario.isVisible()) {
					Guarderia nuevaGuarderia;
					if(txtHora1.getText().length()==0 || Spatucan.isNumber(txtHora1.getText()) == false || Integer.parseInt(txtHora1.getText()) <0)
						throw new Exception ("Hora no válida");

					if(Integer.parseInt(txtHora1.getText()) >12 )
						throw new Exception("Hora no válida, debe estar en formato de 12 horas");
				
					if(txtMinutos1.getText().length() == 0 || Spatucan.isNumber(txtMinutos1.getText()) == false|| Integer.parseInt(txtMinutos1.getText()) > 60 || Integer.parseInt(txtMinutos1.getText()) < 0)
						throw new Exception ("Minutos no válidos");
					
					if((rbtnAm.isSelected()==false && rbtnPm.isSelected()==false))
						throw new Exception("No se ha seleccionado AM o PM");
				
					if(txtTiempoGuarderia.getText().length()==0)
						throw new Exception ("No se ha indicado el tiempo en guardería");
					
					if(Integer.parseInt(txtTiempoGuarderia.getText()) <0 ||  Spatucan.isNumber(txtTiempoGuarderia.getText()) == false || Integer.parseInt(txtTiempoGuarderia.getText()) > 24)
						throw new Exception ("Tiempo en guardería no válido");
					
					byte hora;
					if (rbtnPm.isSelected() && txtHora1.getText().equals("12"))
						hora = 0;
					
					else if(rbtnAm.isSelected())
						hora = Byte.parseByte(txtHora1.getText());
					
					else {
						hora = 12;
						hora += + Byte.parseByte(txtHora1.getText());
					}
					
					if(editar==false)
					 nuevaGuarderia = new Guarderia(getMascota(),  Byte.parseByte(txtDia.getText()), Byte.parseByte(txtMes.getText()), Short.parseShort(txtAño.getText()), hora, Byte.parseByte(txtMinutos1.getText()), Byte.parseByte(txtTiempoGuarderia.getText()), rbtnAm.isSelected(), "");
				
					else {
						Guarderia.getGuarderia(PanelCalendario.getTag()).setDia(Byte.parseByte(txtDia.getText()));
						Guarderia.getGuarderia(PanelCalendario.getTag()).setMes(Byte.parseByte(txtMes.getText()));
						Guarderia.getGuarderia(PanelCalendario.getTag()).setAño(Short.parseShort(txtAño.getText()));
						Guarderia.getGuarderia(PanelCalendario.getTag()).setHoraLlegada(Byte.parseByte(txtHora1.getText()));
						Guarderia.getGuarderia(PanelCalendario.getTag()).setMinutosLlegada(Byte.parseByte(txtMinutos1.getText()));
						boolean am;
						if(rbtnAm.isSelected())
							am = true;
						else 
							am = false;
						Guarderia.getGuarderia(PanelCalendario.getTag()).setAm(am);
						Guarderia.getGuarderia(PanelCalendario.getTag()).setHorasGuarderia(Byte.parseByte(txtTiempoGuarderia.getText()));


					}
				
				}	
					
				
				
				if(editar ==false)
					JOptionPane.showMessageDialog(null,"Cita agregada correctamente","Agregado",JOptionPane.PLAIN_MESSAGE);
				else
					JOptionPane.showMessageDialog(null,"Información guardada correctamente","Guardado",JOptionPane.PLAIN_MESSAGE);
				Apache.excelCitas();

				this.dispose();
				
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			
		}
		
			
		
		
	}
	}}
