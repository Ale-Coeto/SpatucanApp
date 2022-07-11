package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelBuscarClientes extends JPanel implements ActionListener,ListSelectionListener{

	
	private static final long serialVersionUID = 1L;
	static JList<Object> lstClientes;
	private JScrollPane scroll;
	private JLabel lblTitulo, lblSeleccione;
	static DefaultListModel<Object> listModel;
	JButton btnSiguiente, btnBuscar;
	JTextField txtBuscar;
	VentanaVerCliente frmVerCliente;
	static Mascota mascotaEncontrada;
	
	PanelBuscarClientes(){
		//Propiedades del panel
		this.setBounds(0,0,1000,600);
		this.setBackground(Color.WHITE);
		this.setVisible(false);
		this.setLayout(null);
		
		
		//Botones, textos, scroll y lista
		
		lblTitulo = new JLabel("Buscar Cliente");
		lblTitulo.setBounds(0,80,800,40);
		lblTitulo.setFont(Spatucan.titles);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lblTitulo);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(660,500,150,50);
		btnSiguiente.setVisible(false);
		btnSiguiente.addActionListener(this);
		this.add(btnSiguiente);
		
		txtBuscar = new JTextField("");
		txtBuscar.setBounds(260,150, 230,40);
		txtBuscar.setFont(Spatucan.textFields);
		txtBuscar.setEditable(true);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(500,150,100,40);
		btnBuscar.addActionListener(new ActionListener() {

			//Si el botón es seleccionado, se filtra la lista
			@Override
			public void actionPerformed(ActionEvent e) {
				Mascota.filtrarMascotas(Spatucan.formatoNombre(txtBuscar.getText()));	
				updateFilteredJList(lstClientes);
				if(lstClientes.getFirstVisibleIndex()==-1) {
					JOptionPane.showMessageDialog(null,"No se ha encontrado el cliente","Error",JOptionPane.WARNING_MESSAGE);
					Mascota.filtrarMascotas(Spatucan.formatoNombre(""));	
					updateFilteredJList(lstClientes);
				}
				}			
			});
		
		this.add(btnBuscar);		
		this.add(txtBuscar);
				
		lblSeleccione = new JLabel("Seleccione una mascota");
		lblSeleccione.setBounds(220, 210, 430, 40);
		lblSeleccione.setFont(new Font("Helvetica", Font.BOLD,18));
		lblSeleccione.setForeground(PanelPrincipal.darkBlue);
		this.add(lblSeleccione);
		
		lstClientes = new JList<Object>();
		lstClientes.addListSelectionListener(this);
		lstClientes.setFont(new Font("Sans Serif", Font.PLAIN,16));
		updateLstClientes(lstClientes);
		this.add(lstClientes);
		
		scroll = new JScrollPane(lstClientes) ;
		scroll.setBounds(220,250,430,300);	
		this.add(scroll);		
		
	}
	
	//Se actualiza la lista de clientes
	public static void updateLstClientes(JList<Object> lstClientes) {
		
		listModel = new DefaultListModel<Object>();
		for(int i = 0; i<Mascota.getNumeroMascotas();i++) {
			listModel.addElement(Mascota.getListaNombres().get(i));
		}
	lstClientes.setModel(listModel);
		
	
	}
	
	//Se actualiza la lista de los clientes filtrados
	public static void updateFilteredJList(JList<Object> lstClientes) {
		
		listModel = new DefaultListModel<Object>();
		for(int i = 0; i< Mascota.getMascotasFiltradas().size(); i++) {
			listModel.addElement( Mascota.getMascotasFiltradas().get(i));
		}
	lstClientes.setModel(listModel);
	
	}
	
	//Si un cliente es seleccionado de la lista, se hará visible el botón "siguiente" 
	//y se creará un string "elegido" con el formato "nombreMascota, nombreCliente"
	@Override
	public void valueChanged(ListSelectionEvent e) {
		btnSiguiente.setVisible(true);
		 elegido = lstClientes.getSelectedValuesList().toString();
		 elegido = elegido.substring(1,elegido.length()-1);
		 elegido = Spatucan.formatoNombre(elegido);
		// System.out.println(elegido);
	}
	public String elegido;
	
	//Al presionar "siguiente", se busca el cliente del string "elegido" 
	//y se asigna al cliente "encontrado", creando también una nueva ventana
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSiguiente) {
			 mascotaEncontrada = Mascota.buscarMascota(Mascota.cutNombreMascota(elegido), Mascota.cutNombreCliente(elegido));
		if(lstClientes.isSelectionEmpty() == false)
		frmVerCliente = new VentanaVerCliente();
		
					}
	}

}

	

