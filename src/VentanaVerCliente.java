package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaVerCliente extends JFrame implements ActionListener{
	
	JLabel lblMascota, lblCliente, lblNombreMascota, lblAñoNacimiento, lblRaza, lblFrecuenciaBaños, lblNombreCliente, lblTelefono, lblDireccion, lblRedesSociales, lblFacebook, lblTwitter, lblInstagram;
	JTextField txtNombreMascota, txtAñoNacimiento, txtRaza, txtFrecuenciaBaños, txtNombreCliente, txtTelefono, txtDireccion, txtFacebook, txtInstagram, txtTwitter;
	Font regular = new Font("Helvetica",Font.PLAIN,20);
	Font titles = new Font("Helvetica", Font.BOLD,22);
	JButton btnEditar, btnBorrarMascota, btnGuardar;
	JRadioButton rbtnDias, rbtnSemanas;
	ButtonGroup gpDiasSemanas;


	VentanaVerCliente(){
		
		//Propiedades
		this.setBounds(0,0,650,700);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Información del cliente");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		
		//Labels, textfields, botones
		lblMascota = new JLabel("Mascota");
		lblMascota.setBounds(100,60,150,20);
		lblMascota.setFont(titles);
		lblMascota.setForeground(PanelPrincipal.darkBlue);
		
		lblNombreMascota = new JLabel("Nombre:");
		lblNombreMascota.setBounds(100,100,150,20);
		lblNombreMascota.setFont(regular);
		
		txtNombreMascota = new JTextField(PanelBuscarClientes.mascotaEncontrada.getNombreMascota());
		txtNombreMascota.setBounds(300,100,250,20);
		txtNombreMascota.setFont(regular);
		txtNombreMascota.setEditable(false);
		
		lblAñoNacimiento = new JLabel("Año de nacimiento:");
		lblAñoNacimiento.setBounds(100,130, 220, 20);
		lblAñoNacimiento.setFont(regular);
		
		txtAñoNacimiento = new JTextField();
				String A;
				if(PanelBuscarClientes.mascotaEncontrada.getAñoNacimiento()==0)
					A = "";
				else
					A = Integer.toString(PanelBuscarClientes.mascotaEncontrada.getAñoNacimiento());
		txtAñoNacimiento.setText(A);
		txtAñoNacimiento.setBounds(300,130, 250,20);
		txtAñoNacimiento.setFont(regular);
		txtAñoNacimiento.setEditable(false);
		
		lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(100,160,250,20);
		lblRaza.setFont(regular);
				
		txtRaza = new JTextField(PanelBuscarClientes.mascotaEncontrada.getRaza());
		txtRaza.setBounds(300,160,250,20);
		txtRaza.setFont(regular);
		txtRaza.setEditable(false);
		
		lblFrecuenciaBaños = new JLabel("Frecuencia de Baños, cada:");
		lblFrecuenciaBaños.setBounds(100,190,300,20);
		lblFrecuenciaBaños.setFont(regular);
		
		txtFrecuenciaBaños = new JTextField();
			String FB;
				if(PanelBuscarClientes.mascotaEncontrada.getFrecuenciaBaños()==0)
					FB = "";
				else
					FB = Integer.toString(PanelBuscarClientes.mascotaEncontrada.getFrecuenciaBaños());
		txtFrecuenciaBaños.setText(FB);
		txtFrecuenciaBaños.setBounds(360,190,70,20);
		txtFrecuenciaBaños.setFont(regular);
		txtFrecuenciaBaños.setEditable(false);
		
		gpDiasSemanas = new ButtonGroup();
		
		rbtnDias = new JRadioButton("Día/s");
		rbtnDias.setBounds(440,190,90,20);
		rbtnDias.addActionListener(this);

		rbtnSemanas = new JRadioButton("Semana/s");
		rbtnSemanas.setBounds(500,190,100,20);
		rbtnSemanas.addActionListener(this);
		
		if(PanelBuscarClientes.mascotaEncontrada.getDias())
			rbtnDias.setSelected(true);
		else
			rbtnSemanas.setSelected(true);
		
		gpDiasSemanas.add(rbtnDias);
		gpDiasSemanas.add(rbtnSemanas);
		
		lblCliente = new JLabel ("Cliente");
		lblCliente.setBounds(100,250,150,20);
		lblCliente.setFont(titles);
		lblCliente.setForeground(PanelPrincipal.darkBlue);

		
		lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setBounds(100,290, 150,20);
		lblNombreCliente.setFont(regular);
		
		txtNombreCliente = new JTextField(PanelBuscarClientes.mascotaEncontrada.getCliente().getNombreCliente());
		txtNombreCliente.setBounds(300,290,250,20);
		txtNombreCliente.setFont(regular);
		txtNombreCliente.setEditable(false);
		
		lblTelefono = new JLabel ("Teléfono:");
		lblTelefono.setBounds(100,320,150,20);
		lblTelefono.setFont(regular);
		
		txtTelefono = new JTextField();
			String T;
				if(PanelBuscarClientes.mascotaEncontrada.getCliente().getTelefono()==0)
					T = "";
				else
					T = Long.toString(PanelBuscarClientes.mascotaEncontrada.getCliente().getTelefono());
		txtTelefono.setText(T);		
		txtTelefono.setBounds(300,320,250,20);
		txtTelefono.setFont(regular);
		txtTelefono.setEditable(false);
			
		lblDireccion = new JLabel ("Dirección:");
		lblDireccion.setBounds(100,350,150,20);
		lblDireccion.setFont(regular);
		
		txtDireccion = new JTextField(PanelBuscarClientes.mascotaEncontrada.getCliente().getDireccion());
		txtDireccion.setBounds(300,350,250,20);
		txtDireccion.setFont(regular);
		txtDireccion.setEditable(false);
		
		lblRedesSociales = new JLabel ("Redes Sociales:");
		lblRedesSociales.setBounds(100,400,150,20);
		lblRedesSociales.setFont(regular);
		
		lblFacebook = new JLabel("Facebook:");
		lblFacebook.setBounds(130,430,150,20);
		
		txtFacebook = new JTextField(PanelBuscarClientes.mascotaEncontrada.getCliente().getFacebook());
		txtFacebook.setBounds(300,430,250,20);
		txtFacebook.setFont(regular);
		txtFacebook.setEditable(false);
		
		lblInstagram = new JLabel("Instagram:");
		lblInstagram.setBounds(130,460,150,20);
		
		txtInstagram = new JTextField(PanelBuscarClientes.mascotaEncontrada.getCliente().getInstagram());
		txtInstagram.setBounds(300,460,250,20);
		txtInstagram.setFont(regular);
		txtInstagram.setEditable(false);
		
		lblTwitter = new JLabel("Twitter:");
		lblTwitter.setBounds(130,490,150,20);

		txtTwitter = new JTextField(PanelBuscarClientes.mascotaEncontrada.getCliente().getTwitter());
		txtTwitter.setBounds(300,490,250,20);
		txtTwitter.setFont(regular);
		txtTwitter.setEditable(false);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(350,540,150,50);
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(this);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(330,540,150,50);
		btnEditar.addActionListener(this);
		
		btnBorrarMascota = new JButton("Eliminar Mascota");
		btnBorrarMascota.setBounds(170,540,150,50);
		btnBorrarMascota.addActionListener(this);
		
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
		this.add(lblFacebook);
		this.add(lblInstagram);
		this.add(lblTwitter);
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
		this.add(btnBorrarMascota);
		this.add(btnEditar);
		this.add(btnGuardar);
		this.add(rbtnDias);
		this.add(rbtnSemanas);
	
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		//Se activa la posibilidad de poder editar los textfields 
		if(event.getSource()==btnEditar) {
			
		btnEditar.setVisible(false);
		btnBorrarMascota.setVisible(false);
		btnGuardar.setVisible(true);
		
		txtNombreMascota.setEditable(true);
		txtAñoNacimiento.setEditable(true);
		txtRaza.setEditable(true);
		txtFrecuenciaBaños.setEditable(true);
		txtNombreCliente.setEditable(true);
		txtTelefono.setEditable(true);
		txtDireccion.setEditable(true);
		txtFacebook.setEditable(true);	
		txtInstagram.setEditable(true);
		txtTwitter.setEditable(true);
		
		//Opción de borrar cliente
		} if (event.getSource() == btnBorrarMascota) {

			int n = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar la mascota?", "Atención", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(n == JOptionPane.YES_OPTION) {
				
				int eliminar = Mascota.getListaMascotas().indexOf(PanelBuscarClientes.mascotaEncontrada);
				Estadistica.eliminarMascota(Mascota.getListaMascotas().get(eliminar).getMes(), Mascota.getListaMascotas().get(eliminar).getAño());
				Mascota.getListaMascotas().remove(eliminar);				
				Mascota.getListaNombres().remove(eliminar);
				Mascota.eliminarMascota();
				//Cliente.eliminarCliente();
				JOptionPane.showMessageDialog(null,"Cliente eliminado correctamente","",JOptionPane.PLAIN_MESSAGE);
				PanelBuscarClientes.updateLstClientes(PanelBuscarClientes.lstClientes);
				
				this.dispose();
				//System.out.println(Cliente.ListaClientes.get(0).getNombreCliente());
			}
			
		
		} if(event.getSource() == btnGuardar) {
			//Manejo de errores de los textos ingresados
			try {
				
				if(txtNombreMascota.getText().length()==0)
					throw new Exception ("Nombre de la mascota no proporcionado");
				
				if(txtNombreCliente.getText().length()==0)
					throw new Exception ("Nombre del cliente no proporcionado");
				
				if(txtAñoNacimiento.getText().length() > 0 && ((Spatucan.isNumber(txtAñoNacimiento.getText()) == false) || (Integer.parseInt(txtAñoNacimiento.getText())<=1900) ||
							(Integer.parseInt(txtAñoNacimiento.getText())>Calendar.getInstance().get(Calendar.YEAR))))
						throw new Exception ("Año de nacimiento no válido");	
			
				if(txtFrecuenciaBaños.getText().length() > 0) {
					if((Spatucan.isNumber(txtFrecuenciaBaños.getText()) == false || Integer.parseInt(txtFrecuenciaBaños.getText()) < 0) || Integer.parseInt(txtFrecuenciaBaños.getText()) > 99) 			
					throw new Exception ("Frecuencia de baños no válida");
					
				else if ((rbtnDias.isSelected() == false) && (rbtnSemanas.isSelected() == false))
					throw new Exception ("No se ha seleccionado días o semanas para la frecuencia de baños");
				}
				
				if(txtTelefono.getText().length() > 0 && (Spatucan.isNumber(txtTelefono.getText()) == false || Long.parseLong(txtTelefono.getText()) < 0 || txtTelefono.getText().length() < 10))
					throw new Exception ("Teléfono no válido");
				
			//	int n =  Cliente.getListaClientes().indexOf(PanelBuscarClientes.mascotaEncontrada);

				
				PanelBuscarClientes.mascotaEncontrada.getCliente().setNombreCliente(txtNombreCliente.getText());
				PanelBuscarClientes.mascotaEncontrada.setNombreMascota(txtNombreMascota.getText());
				PanelBuscarClientes.mascotaEncontrada.setRaza(txtRaza.getText());
				PanelBuscarClientes.mascotaEncontrada.getCliente().setDireccion(txtDireccion.getText());
				
				if(txtAñoNacimiento.getText().length()>0) 
					PanelBuscarClientes.mascotaEncontrada.setAñoNacimiento(Integer.parseInt(txtAñoNacimiento.getText()));
				
				if(txtFrecuenciaBaños.getText().length()>0) {
					PanelBuscarClientes.mascotaEncontrada.setFrecuenciaBaños(Integer.parseInt(txtFrecuenciaBaños.getText()));
					PanelBuscarClientes.mascotaEncontrada.setDias(rbtnDias.isSelected());
				}
				
				if(txtTelefono.getText().length()>0)
					PanelBuscarClientes.mascotaEncontrada.getCliente().setTelefono(Long.parseLong(txtTelefono.getText()));
				
				if(txtFacebook.getText().length()>0)
					PanelBuscarClientes.mascotaEncontrada.getCliente().setFacebook(txtFacebook.getText());
				
				if(txtInstagram.getText().length()>0)
					PanelBuscarClientes.mascotaEncontrada.getCliente().setInstagram(txtInstagram.getText());
				
				if(txtTwitter.getText().length()>0)
					PanelBuscarClientes.mascotaEncontrada.getCliente().setTwitter(txtTwitter.getText());
				
				btnEditar.setVisible(true);
				btnBorrarMascota.setVisible(true);
				btnGuardar.setVisible(false);
				
				txtNombreMascota.setEditable(false);
				txtAñoNacimiento.setEditable(false);
				txtRaza.setEditable(false);
				txtFrecuenciaBaños.setEditable(false);
				txtNombreCliente.setEditable(false);
				txtTelefono.setEditable(false);
				txtDireccion.setEditable(false);
				txtFacebook.setEditable(false);	
				txtInstagram.setEditable(false);
				txtTwitter.setEditable(false);
				
			//	Mascota.ListaNombres.set(n, txtNombreMascota.getText() + ", " + txtNombreCliente.getText());
				JOptionPane.showMessageDialog(null,"Información guardada correctamente","",JOptionPane.PLAIN_MESSAGE);
				PanelBuscarClientes.updateLstClientes(PanelBuscarClientes.lstClientes);
				Apache.excelMascota();
				Apache.excelCliente();

			}	catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			
			}
		
		
	}
	

}}
