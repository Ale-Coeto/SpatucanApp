package proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelBuscarEstadistica extends JPanel implements ListSelectionListener, ActionListener{
	
	private JLabel lblTitulo, lblSeleccione;
	private JScrollPane scroll;
	private JButton btnSiguiente, btnBuscar;
	private JTextField txtBuscar;
	VentanaVerEstadistica frmVerEstadistica;
	public static int lstSize;
	static Estadistica estadisticaEncontrada;
	static JList<Object> lstEstadisticas;
	static DefaultListModel<Object> listModelEstadisticas;
	

	
	PanelBuscarEstadistica(){
		//Propiedad del panel
		this.setBounds(0,0,1000, 600);
		this.setBackground(Color.WHITE);
		this.setVisible(false);
		this.setLayout(null);
		
		//Lista, textos, scroll y botón
		
		lblTitulo = new JLabel("Buscar Estadísticas");
		lblTitulo.setBounds(0,80,800,40);
		lblTitulo.setFont(Spatucan.titles);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lblTitulo);
		
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
				Estadistica.filtrarEstadisticas(txtBuscar.getText());	
				//Estadistica.updateFilteredStack();
			}			
			});
		this.add(btnBuscar);
		this.add(txtBuscar);
		

		lstEstadisticas = new JList<Object>();
		//Estadistica.crearEstadisticas();
		Estadistica.updateLstEstadisticas();

		lstEstadisticas.setVisibleRowCount(12);
		lstEstadisticas.setFont(new Font("Sans Serif", Font.PLAIN,16));
		this.add(lstEstadisticas);
		lstEstadisticas.addListSelectionListener(this);
		
		scroll = new JScrollPane(lstEstadisticas) ;
		scroll.setBounds(220,250,430,300);	
		this.add(scroll);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(660,500,150,50);
		btnSiguiente.addActionListener(this);
		btnSiguiente.setVisible(false);
		this.add(btnSiguiente);		
		
		lblSeleccione = new JLabel("Seleccione una fecha");
		lblSeleccione.setBounds(220, 210, 430, 40);
		lblSeleccione.setFont(new Font("Helvetica", Font.BOLD,18));
		lblSeleccione.setForeground(PanelPrincipal.darkBlue);
		this.add(lblSeleccione);
		
	}
	
	//Si se selecciona un elemento, el botón siguiente será visible
	@Override
	public void valueChanged(ListSelectionEvent e) {
		btnSiguiente.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Se busca la estadística seleccionada y se crea la ventana estadística
		
		//Si se selecciona un elemento directamente
		if(lstSize == Estadistica.getStackSize()) {
		int index = Estadistica.getStackSize() - lstEstadisticas.getSelectedIndex()-1;
		estadisticaEncontrada = Estadistica.searchStackItem(index);
		
		//Si se selecciona un elemento desde la lista filtrada
		} else {
			Object seleccionado = lstEstadisticas.getSelectedValue();
			
			estadisticaEncontrada = Estadistica.searchStackItem2(seleccionado);
			System.out.println(Spatucan.mesAString(estadisticaEncontrada.getMes()) + "/siu " + estadisticaEncontrada.getAño());
		}
		frmVerEstadistica = new VentanaVerEstadistica();

	}
		
	
	}
	

