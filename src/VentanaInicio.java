package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame implements ActionListener {

	JButton btnIniciar;
	JLabel lbl1;
	PanelPrincipal pnlPrincipal;
	JPanel pnlIniciar;
	
	VentanaInicio(){
		//Propiedades de la ventana
		this.setVisible(true);
		this.setSize(1000,640);
		this.setResizable(false);
		this.setTitle("Spatucan");
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Panel de inicio
		pnlIniciar = new JPanel();
		pnlIniciar.setBounds(0,0,1000,640);
		pnlIniciar.setBackground(Color.WHITE);
		pnlIniciar.setVisible(true);
		pnlIniciar.setLayout(null);
		this.add(pnlIniciar);
		
		//Título
		lbl1 = new JLabel("");
		lbl1.setBounds(325, 70, 350, 350);
		lbl1.setVerticalTextPosition(JLabel.BOTTOM);
		lbl1.setHorizontalTextPosition(JLabel.CENTER);
		lbl1.setHorizontalAlignment(JLabel.CENTER);
		lbl1.setVerticalAlignment(JLabel.CENTER);		
		pnlIniciar.add(lbl1);
			
		//Botón inicio
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(420,430,160,60);
		btnIniciar.addActionListener(this);
		btnIniciar.setVisible(true);
		//btnIniciar.setBorder(BorderFactory.createLineBorder(new Color(0x2559c2), 2));
		pnlIniciar.add(btnIniciar);
		

		//Logo
		ImageIcon logo = new ImageIcon(VentanaInicio.class.getResource("/proyecto/logo.png"));		
		lbl1.setIcon(logo);
		
		//Panel principal
		
		
	
		
	}

	//Si el botón es presionado, se abre el panel principal
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciar) {
			pnlPrincipal = new PanelPrincipal();
			//	pnlPrincipal.setVisible(false);
				this.add(pnlPrincipal);
			pnlIniciar.setVisible(false);
			try {
			pnlPrincipal.setVisible(true);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			PanelPrincipal.pnlButtons.setVisible(true);
			
			Estadistica.crearEstadisticas();

			Apache.leerClientes();
			Apache.leerMascotas();
			Apache.leerCitas();

						
			
		
			
		}
	}

	


	
}
