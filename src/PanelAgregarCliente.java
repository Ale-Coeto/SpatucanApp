package proyecto;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelAgregarCliente extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo, lblMascota, lblCliente, lblNombreMascota, lblAñoNacimiento, lblRaza, lblFrecuenciaBaños, lblNombreCliente, lblTelefono, lblDireccion, lblRedesSociales, lblFacebook, lblTwitter, lblInstagram;
	private Color darkBlue = new Color(0x2559c2);
	private Color gray = new Color(0x3f424a);
	private JTextField txtNombreMascota, txtAñoNacimiento, txtRaza, txtFrecuenciaBaños, txtNombreCliente, txtTelefono, txtDireccion, txtFacebook, txtInstagram, txtTwitter;
	private JButton btnAgregar;
	private JRadioButton rbtnDias, rbtnSemanas, rbtnSi, rbtnNo;
	private ButtonGroup gpDiasSemanas, gpSiNo;
	static JComboBox<String> cbxClientes;
	
	PanelAgregarCliente (){
		
		//Propiedades del panel
		this.setBounds(30,30,800,570);
		this.setBackground(Color.WHITE);
		this.setVisible(false);
		this.setLayout(null);
		
		//Labels, botones y textfields
		lblTitulo = new JLabel("Agregar Cliente");
		lblTitulo.setFont(Spatucan.titles);
		lblTitulo.setBounds(0,50,800,40);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		
		lblMascota = new JLabel("Mascota");
		lblMascota.setBounds(100,80,150,20);
		lblMascota.setFont(Spatucan.subtitles);
		lblMascota.setForeground(darkBlue);
		
		lblNombreMascota = new JLabel("Nombre:");
		lblNombreMascota.setBounds(100,120,150,20);
		lblNombreMascota.setFont(Spatucan.regular);
		
		txtNombreMascota = new JTextField();
		txtNombreMascota.setBounds(300,120,250,20);
		txtNombreMascota.setFont(Spatucan.textFields);
		txtNombreMascota.setCaretColor(darkBlue);
		txtNombreMascota.setForeground(gray);
		
		lblAñoNacimiento = new JLabel("Año de nacimiento:");
		lblAñoNacimiento.setBounds(100,150, 220, 20);
		lblAñoNacimiento.setFont(Spatucan.regular);
		
		txtAñoNacimiento = new JTextField();
		txtAñoNacimiento.setBounds(300,150, 250,20);
		txtAñoNacimiento.setFont(Spatucan.textFields);
		txtAñoNacimiento.setForeground(gray);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(100,180,250,20);
		lblRaza.setFont(Spatucan.regular);
				
		txtRaza = new JTextField();
		txtRaza.setBounds(300,180,250,20);
		txtRaza.setFont(Spatucan.textFields);
		txtRaza.setCaretColor(darkBlue);
		txtRaza.setForeground(gray);
		
		lblFrecuenciaBaños = new JLabel("Frecuencia de Baños, cada:");
		lblFrecuenciaBaños.setBounds(100,210,300,20);
		lblFrecuenciaBaños.setFont(Spatucan.regular);
		
		txtFrecuenciaBaños = new JTextField();
		txtFrecuenciaBaños.setBounds(470,210,80,20);
		txtFrecuenciaBaños.setFont(Spatucan.textFields);
		txtFrecuenciaBaños.setCaretColor(darkBlue);
		txtFrecuenciaBaños.setForeground(gray);
		
		gpDiasSemanas = new ButtonGroup();
		rbtnDias = new JRadioButton("Día/s");
		rbtnDias.setBounds(580,210,90,20);
		rbtnDias.addActionListener(this);

		rbtnSemanas = new JRadioButton("Semana/s");
		rbtnSemanas.setBounds(660,210,100,20);
		rbtnSemanas.addActionListener(this);
		
		gpDiasSemanas.add(rbtnDias);
		gpDiasSemanas.add(rbtnSemanas);
		
		lblCliente = new JLabel ("Cliente");
		lblCliente.setBounds(100,270,150,20);
		lblCliente.setFont(Spatucan.subtitles);
		lblCliente.setForeground(darkBlue);
		
		Cliente.actualizarNombresClientes();
		cbxClientes = new JComboBox<String>(Cliente.getNombresClientes());
		cbxClientes.setBounds(300, 270, 250, 30);
		cbxClientes.addActionListener(this);
		
		
		lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setBounds(100,310, 150,20);
		lblNombreCliente.setFont(Spatucan.regular);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(300,310,250,20);
		txtNombreCliente.setFont(Spatucan.textFields);
		txtNombreCliente.setCaretColor(darkBlue);
		txtNombreCliente.setForeground(gray);
		
		lblTelefono = new JLabel ("Teléfono:");
		lblTelefono.setBounds(100,340,150,20);
		lblTelefono.setFont(Spatucan.regular);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(300,340,250,20);
		txtTelefono.setFont(Spatucan.textFields);txtTelefono.setCaretColor(darkBlue);
		txtTelefono.setForeground(gray);
			
		lblDireccion = new JLabel ("Dirección:");
		lblDireccion.setBounds(100,370,150,20);
		lblDireccion.setFont(Spatucan.regular);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(300,370,250,20);
		txtDireccion.setFont(Spatucan.regular);
		txtDireccion.setCaretColor(darkBlue);
		txtDireccion.setForeground(gray);
		
		lblRedesSociales = new JLabel ("Redes Sociales:");
		lblRedesSociales.setBounds(100,400,150,20);
		lblRedesSociales.setFont(Spatucan.regular);
		
		rbtnSi = new JRadioButton("Sí");
		rbtnSi.setBounds(300,400,100,20);
		rbtnSi.addActionListener(this);
		
		rbtnNo = new JRadioButton("No");
		rbtnNo.setBounds(430,400,100,20);
		rbtnNo.setSelected(true);
		rbtnNo.addActionListener(this);		
		
		gpSiNo = new ButtonGroup();
		gpSiNo.add(rbtnSi);
		gpSiNo.add(rbtnNo);
			
		
		lblFacebook = new JLabel("Facebook:");
		lblFacebook.setBounds(130,430,150,20);
		
		txtFacebook = new JTextField();
		txtFacebook.setBounds(300,430,250,20);
		txtFacebook.setFont(Spatucan.textFields);
		txtFacebook.setCaretColor(darkBlue);
		txtFacebook.setForeground(gray);
		
		lblInstagram = new JLabel("Instagram:");
		lblInstagram.setBounds(130,460,150,20);
		
		txtInstagram = new JTextField();
		txtInstagram.setBounds(300,460,250,20);
		txtInstagram.setFont(Spatucan.textFields);
		txtInstagram.setCaretColor(darkBlue);
		txtInstagram.setForeground(gray);
		
		lblTwitter = new JLabel("Twitter:");
		lblTwitter.setBounds(130,490,150,20);

		txtTwitter = new JTextField();
		txtTwitter.setBounds(300,490,250,20);
		txtTwitter.setFont(Spatucan.textFields);
		txtTwitter.setCaretColor(darkBlue);
		txtTwitter.setForeground(gray);

		
		btnAgregar = new JButton ("Agregar Cliente");
		btnAgregar.setBounds(600,460,150,50);
		btnAgregar.addActionListener(this);

		lblFacebook.setVisible(false);
		lblInstagram.setVisible(false);
		lblTwitter.setVisible(false);
		txtFacebook.setVisible(false);
		txtInstagram.setVisible(false);
		txtTwitter.setVisible(false);
		
		this.add(lblTitulo);
		this.add(lblMascota);
		this.add(lblCliente);
		this.add(lblNombreMascota);
		this.add(lblAñoNacimiento);
		this.add(lblRaza);
		this.add(lblFrecuenciaBaños);
		this.add(lblNombreCliente);
		this.add(lblTelefono);
		this.add(lblDireccion);
		this.add(lblRedesSociales);
		this.add(btnAgregar);
		this.add(txtNombreMascota);
		this.add(txtAñoNacimiento);
		this.add(txtRaza);
		this.add(txtFrecuenciaBaños);
		this.add(txtNombreCliente);
		this.add(txtTelefono);
		this.add(txtDireccion);
		this.add(txtFacebook);
		this.add(txtInstagram);
		this.add(txtTwitter);
		this.add(rbtnDias);
		this.add(rbtnSemanas);
		this.add(lblFacebook);
		this.add(lblInstagram);
		this.add(lblTwitter);
		this.add(rbtnSi);
		this.add(rbtnNo);
		this.add(cbxClientes);
				
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//Si no es un nuevo cliente, se ocultan los campos para agregar info de un nuevo cliente
		if(event.getSource() == cbxClientes) {
			if(!(cbxClientes.getSelectedItem().toString().equals("Nuevo Cliente"))) {
				lblNombreCliente.setVisible(false);
				txtNombreCliente.setVisible(false);
				lblTelefono.setVisible(false);
				txtTelefono.setVisible(false);
				lblDireccion.setVisible(false);
				txtDireccion.setVisible(false);
				lblRedesSociales.setVisible(false);
				rbtnSi.setVisible(false);
				rbtnNo.setVisible(false);
			}
			
			//Si es un nuevo cliente, se muestran los campos para agregar info
			else if (cbxClientes.getSelectedItem().toString().equals("Nuevo Cliente")){
				lblNombreCliente.setVisible(true);
				txtNombreCliente.setVisible(true);
				lblTelefono.setVisible(true);
				txtTelefono.setVisible(true);
				lblDireccion.setVisible(true);
				txtDireccion.setVisible(true);
				lblRedesSociales.setVisible(true);
				rbtnSi.setVisible(true);
				rbtnNo.setVisible(true);
			}
		}
		
		//Mostrar más opciones de redes sociales 
		if(event.getSource() == rbtnSi) {
			lblFacebook.setVisible(true);
			lblInstagram.setVisible(true);
			lblTwitter.setVisible(true);
			txtFacebook.setVisible(true);
			txtInstagram.setVisible(true);
			txtTwitter.setVisible(true);
		}
		
		//No mostrar más opciones de redes sociales
		if(event.getSource() == rbtnNo) {
			lblFacebook.setVisible(false);
			lblInstagram.setVisible(false);
			lblTwitter.setVisible(false);
			txtFacebook.setVisible(false);
			txtInstagram.setVisible(false);
			txtTwitter.setVisible(false);
		}
		
		if(event.getSource() == btnAgregar) {
		
		//Manejo de errores de los textos ingresados
			try {
			
				if(txtNombreMascota.getText().length()==0)
					throw new Exception ("Nombre de la mascota no proporcionado");
				
				if(txtAñoNacimiento.getText().length() > 0 && ((Spatucan.isNumber(txtAñoNacimiento.getText()) == false) 
						|| (Integer.parseInt(txtAñoNacimiento.getText())<=1950) ||
							(Integer.parseInt(txtAñoNacimiento.getText())>Calendar.getInstance().get(Calendar.YEAR))))
						throw new Exception ("Año de nacimiento no válido");	
			
				if(txtFrecuenciaBaños.getText().length() > 0) {
					if((Spatucan.isNumber(txtFrecuenciaBaños.getText()) == false || Integer.parseInt(txtFrecuenciaBaños.getText()) < 0) 
							|| Integer.parseInt(txtFrecuenciaBaños.getText()) > 99) 			
							throw new Exception ("Frecuencia de baños no válida");
					
				else if ((rbtnDias.isSelected() == false) && (rbtnSemanas.isSelected() == false))
							throw new Exception ("No se ha seleccionado días o semanas para la frecuencia de baños");
				}
				
				//Para nuevos clientes
					if(cbxClientes.getSelectedItem().toString().equals("Nuevo Cliente")) {
						
						if(txtNombreCliente.getText().length()==0)
							throw new Exception ("Nombre del cliente no proporcionado");
						
						if(txtTelefono.getText().length() > 0 && (Spatucan.isNumber(txtTelefono.getText()) == false 
								|| Long.parseLong(txtTelefono.getText()) < 0 || txtTelefono.getText().length() < 10 || txtTelefono.getText().length() > 10))
							throw new Exception ("Teléfono no válido");
					
						if(Cliente.buscarCliente2(Spatucan.formatoNombre(txtNombreCliente.getText())) != null)	
							throw new Exception ("Cliente ya existente, por favor busque y seleccione el cliente");
						
						if(txtAñoNacimiento.getText().length() == 0 || txtRaza.getText().length()==0 || txtFrecuenciaBaños.getText().length() == 0 
								|| txtTelefono.getText().length() == 0 || txtDireccion.getText().length() == 0) {				
		
						int n = JOptionPane.showConfirmDialog(null, "Seguro que quiere agregar el cliente sin todos los datos?", "Atención",
								JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
							if(n == JOptionPane.YES_OPTION) 
								crearCliente();			
					}} else 
						crearCliente();					
			}	catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);				
			}}
		
		
	}
	
	public void crearCliente () {
	Mascota nuevaMascota;
	
	//crear cliente	
	if(cbxClientes.getSelectedItem().equals("Nuevo Cliente")) {
	Cliente nuevoCliente = new Cliente(Spatucan.formatoNombre(txtNombreCliente.getText()), txtDireccion.getText());
	
		
	if(txtTelefono.getText().length()>0)
			nuevoCliente.setTelefono(Long.parseLong(txtTelefono.getText()));
		
		if(txtFacebook.getText().length()>0)
			nuevoCliente.setFacebook(txtFacebook.getText());
		
		if(txtInstagram.getText().length()>0)
			nuevoCliente.setInstagram(txtInstagram.getText());
		
		if(txtTwitter.getText().length()>0)
			nuevoCliente.setTwitter(txtTwitter.getText());
			
	nuevaMascota = new Mascota(Spatucan.formatoNombre(txtNombreMascota.getText()), txtRaza.getText(), nuevoCliente);
	Cliente.agregarCliente(nuevoCliente);
	
	
	
	} else {
		Cliente cliente = Cliente.buscarCliente(cbxClientes.getSelectedItem().toString(),0,Cliente.getNumeroClientes());
		System.out.println("Cliente: " + cliente.getNombreCliente());
		nuevaMascota = new Mascota(Spatucan.formatoNombre(txtNombreMascota.getText()), txtRaza.getText(), cliente);
		
	}
	
	
	//agregar añoNacimiento, frecuencia baños o telefono
	if(txtAñoNacimiento.getText().length()>0)
		nuevaMascota.setAñoNacimiento(Integer.parseInt(txtAñoNacimiento.getText()));
	
	if(txtFrecuenciaBaños.getText().length()>0) {
		nuevaMascota.setFrecuenciaBaños(Integer.parseInt(txtFrecuenciaBaños.getText()));
		nuevaMascota.setDias(rbtnDias.isSelected());
	}
	

	//agregar cliente a la lista
	Mascota.agregarMascota(nuevaMascota);
	nuevaMascota.setMes(Calendar.getInstance().get(Calendar.MONTH) + 1);
	nuevaMascota.setAño(Calendar.getInstance().get(Calendar.YEAR));
	Estadistica.nuevaMascota(nuevaMascota.getMes(), nuevaMascota.getAño());	
	

	//Mostrar que fue agregado y borrar los textos de los textfields
	JOptionPane.showMessageDialog(null,"Cliente agregado correctamente","Agregado",JOptionPane.PLAIN_MESSAGE);
	txtNombreMascota.setText("");
	txtAñoNacimiento.setText("");
	txtRaza.setText("");
	txtFrecuenciaBaños.setText("");
	
	txtNombreCliente.setText("");
	txtTelefono.setText("");
	txtDireccion.setText("");
	txtFacebook.setText("");
	txtInstagram.setText("");
	txtTwitter.setText("");
	cbxClientes.setSelectedIndex(0);
	
	rbtnNo.setSelected(true);
	lblFacebook.setVisible(false);
	lblInstagram.setVisible(false);
	lblTwitter.setVisible(false);
	txtFacebook.setVisible(false);
	txtInstagram.setVisible(false);
	txtTwitter.setVisible(false);
	gpDiasSemanas.clearSelection();
	
	PanelBuscarClientes.updateLstClientes(PanelBuscarClientes.lstClientes);
	try {
	PanelBuscarClientes.updateLstClientes(VentanaNuevaCita.lstClientes2);
	} catch (Exception e) {
		
	}
	setComboBoxModel();
	
	
	//setComboBoxModel();

	}
	
	public static void setComboBoxModel() {
		Cliente.actualizarNombresClientes();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(Cliente.getNombresClientes());
		cbxClientes.setModel(model);
		//System.out.println(Arrays.toString( Cliente.getNombresClientes()));
	}
}
