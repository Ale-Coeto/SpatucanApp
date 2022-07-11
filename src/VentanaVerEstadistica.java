package proyecto;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaVerEstadistica extends JFrame{
	
	JLabel lblTitulo, lblNumeroClientes, lblNumeroCitas, lblNuevosClientes, lblBaños, lblGuarderia, lblPension, lblTotal;
	
	VentanaVerEstadistica(){
		
		//Propiedades de la ventana
		this.setBounds(0,0,700,500);
		this.setVisible(true);
		this.setLayout(null);
		this.setTitle("Estadísticas");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().setBackground(Color.white);

		//Labels, textfields
		int mes = PanelBuscarEstadistica.estadisticaEncontrada.getMes();	
		
		lblTitulo = new JLabel(Spatucan.mesAString(mes));
		lblTitulo.setFont(Spatucan.titles);
		lblTitulo.setBounds(0, 20, 700, 50);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		
		lblNumeroClientes = new JLabel("Número de Clientes");
		lblNumeroClientes.setBounds(80, 90,300,50);
		lblNumeroClientes.setFont(Spatucan.subtitles);
		lblNumeroClientes.setForeground(PanelPrincipal.darkBlue);

		
		lblNuevosClientes = new JLabel("Nuevas mascotas este mes: " + PanelBuscarEstadistica.estadisticaEncontrada.getNuevasMascotas());
		lblNuevosClientes.setBounds(130,130, 400,50);
		lblNuevosClientes.setFont(Spatucan.regular);
		
		lblNumeroCitas = new JLabel("Número de Citas");
		lblNumeroCitas.setBounds(80, 220, 350,50);
		lblNumeroCitas.setFont(Spatucan.subtitles);	
		lblNumeroCitas.setForeground(PanelPrincipal.darkBlue);


		lblBaños = new JLabel("Baños: " + PanelBuscarEstadistica.estadisticaEncontrada.getNuevosBaños());
		lblBaños.setBounds(130,260, 450,50);
		lblBaños.setFont(Spatucan.regular);
		
		lblGuarderia = new JLabel("Guardería: "+ PanelBuscarEstadistica.estadisticaEncontrada.getNuevasGuarderias());
		lblGuarderia.setBounds(130,300, 450,50);
		lblGuarderia.setFont(Spatucan.regular);
		
		lblPension = new JLabel("Pensión: "+ PanelBuscarEstadistica.estadisticaEncontrada.getNuevasPensiones());
		lblPension.setBounds(130,340, 450,50);
		lblPension.setFont(Spatucan.regular);
		
		lblTotal = new JLabel("Total: "+ PanelBuscarEstadistica.estadisticaEncontrada.getTotal());
		lblTotal.setBounds(130,390, 450, 50);
		lblTotal.setFont(Spatucan.regular);
		
		
		this.add(lblTitulo);
		this.add(lblNumeroCitas);
		this.add(lblNumeroClientes);
		this.add(lblNuevosClientes);
		this.add(lblBaños);
		this.add(lblGuarderia);
		this.add(lblPension);
		this.add(lblTotal);
		
		
		
		
	}
}
