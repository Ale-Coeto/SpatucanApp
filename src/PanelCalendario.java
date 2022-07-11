package proyecto;
import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.*;
import com.mindfusion.scheduling.model.Appointment;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.TimetableSettings;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PanelCalendario extends JPanel implements ActionListener, MouseListener{

	
	private static final long serialVersionUID = 1L;
	static Calendar calendar;
	JComboBox<String> cbxVistas;
	private JButton btnAgendarBaño, btnAgendarPension, btnAgendarGuarderia, btnEliminar, btnEditar;
	static VentanaNuevaCita frmNuevaCita;
	ImageIcon bone, dog, bath;
	JLabel lblBone, lblDog, lblBath;
	JPanel pnlCalendario;
	JTextArea txtAInfo;
	private static String tag;
	static int diaSeleccionado, mesSeleccionado, añoSeleccionado, horaSeleccionada, minutoSeleccionado;
	PanelCalendario() {
		
		//Propiedades del panel
		this.setBounds(0,0,900,600);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.setLayout(null);
		
		btnAgendarBaño = new JButton("Agendar Baño");
		btnAgendarBaño.setBounds(670,50,140,20);
		btnAgendarBaño.addMouseListener(this);
		btnAgendarBaño.setForeground(new Color(0x16a3f5));
		btnAgendarBaño.setBorder(BorderFactory.createLineBorder(new Color(0x16a3f5)));
		this.add(btnAgendarBaño);
		
		btnAgendarPension = new JButton("Agendar Pensión");
		btnAgendarPension.setBounds(670,100,140,20);
		btnAgendarPension.addMouseListener(this);
		btnAgendarPension.setForeground(new Color(0xfa6c41));
		btnAgendarPension.setBorder(BorderFactory.createLineBorder(new Color(0xfa6c41)));
		this.add(btnAgendarPension);
		
		btnAgendarGuarderia = new JButton("Agendar Guardería");
		btnAgendarGuarderia.setBounds(670,150,140,20);
		btnAgendarGuarderia.addMouseListener(this);
		btnAgendarGuarderia.setForeground(new Color(0x83d408));
		btnAgendarGuarderia.setBorder(BorderFactory.createLineBorder(new Color(0x83d408)));
		this.add(btnAgendarGuarderia);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(670, 480, 140, 20);
		btnEditar.addActionListener(this);
		this.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(670, 530, 140, 20);
		btnEliminar.addActionListener(this);
		this.add(btnEliminar);
		
		//icon size --> 32
		bath = new ImageIcon(VentanaInicio.class.getResource("/proyecto/bath.png"));
		bone = new ImageIcon(VentanaInicio.class.getResource("/proyecto/bone.png"));
		dog = new ImageIcon(VentanaInicio.class.getResource("/proyecto/dog.png"));
		
		lblBath = new JLabel();
		lblBath.setBounds(820, 35, 50,50);
		lblBath.setIcon(bath);
		this.add(lblBath);
		
		lblBone = new JLabel();
		lblBone.setBounds(830, 125, 50,50);
		lblBone.setIcon(bone);
		this.add(lblBone);
		
		lblDog = new JLabel();
		lblDog.setBounds(825, 80, 50,50);
		lblDog.setIcon(dog);
		this.add(lblDog);
		

		String[] opciones = {"Mes", "Semana"};
		cbxVistas = new JComboBox<String>(opciones);
		cbxVistas.setBounds(40, 20, 300, 20);
		cbxVistas.setFocusable(false);
		cbxVistas.addActionListener(this);
		this.add(cbxVistas);
		
		txtAInfo = new JTextArea("");
		txtAInfo.setBounds(670, 250, 175, 200);
		txtAInfo.setFont(new Font("Sans Serif", Font.PLAIN,14));
		this.add(txtAInfo);
				
		
		calendar = new Calendar();
		
		calendar.beginInit(); 
		
		pnlCalendario = new JPanel();
		pnlCalendario.setBounds(40,50,600,500);
		pnlCalendario.setLayout(new GridLayout(1,1,0,0));
		this.add(pnlCalendario);
		
		calendar.setCurrentView(CalendarView.SingleMonth);
		calendar.setTheme(ThemeType.Light);
		//calendar.setBounds(40, 50, 600, 500);
		//calendar.setBounds(40,50,600,500);
		calendar.setAllowDrag(false);
		calendar.setAllowInplaceCreate(false);
		calendar.setAllowInplaceEdit(false);
		calendar.setAllowMoveUnselectedItems(false);
		calendar.addCalendarListener(new CalendarAdapter() {
			 
			
				 //Si se selecciona una cita
				 public void itemClick(ItemMouseEvent e) {
					if(e.getClicks() == 1) {
						try {
						 tag = e.getItem().getTag().toString();
						 
						} catch (Exception ex) {
							tag = e.getItem().getRecurrence().getMaster().getTag().toString();
						}
						
						if(tag.charAt(0) == 'B') 
							txtAInfo.setText(Baño.getBaño(tag).showInfo());
					
						if(tag.charAt(0) == 'G') 
							txtAInfo.setText(Guarderia.getGuarderia(tag).showInfo());
						
						if(tag.charAt(0) == 'P') 
							txtAInfo.setText(Pension.getPension(tag).showInfo());
					
					}	
					
					
				 }
				 
				 
				 
				 //Si se selecciona una fecha
				 public void dateClick (ResourceDateEvent e) {
					 if(e.getClicks() == 1) {
						 try {
						 VentanaNuevaCita.setDia(e.getDate().getDay());
						 VentanaNuevaCita.setMes(e.getDate().getMonth());
						 VentanaNuevaCita.setAño(e.getDate().getYear());
						 
						 } catch (NullPointerException e1) {
							 //
						 }
						 diaSeleccionado = e.getDate().getDay();
						 mesSeleccionado = e.getDate().getMonth();
						 añoSeleccionado = e.getDate().getYear();
						 
						 
						 if(calendar.getCurrentView() == CalendarView.Timetable)
							horaSeleccionada = e.getDate().getHour();
						 	minutoSeleccionado = e.getDate().getMinute();
							 System.out.println(e.getDate().getMinute());
					 }
					 
				 }
				 
				 
				 });
		
		
		
		
		
		pnlCalendario.add(calendar);

		 calendar.endInit();
		 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cbxVistas) {
			if(cbxVistas.getSelectedItem().equals("Mes")) {
				calendar.setCurrentView(CalendarView.SingleMonth);
				calendar.setTheme(ThemeType.Light);
			}
			
			else if (cbxVistas.getSelectedItem().equals("Semana")) {
				calendar.setCurrentView(CalendarView.Timetable);
				calendar.setTheme(ThemeType.Standard);
				
				calendar.getTimetableSettings().getDates().clear();
				calendar.getTimetableSettings().setVisibleColumns(3);
				for (int i = 0; i < 3; i++)
			    calendar.getTimetableSettings().getDates().add(DateTime.today().addDays(i));
				
				calendar.getTimetableSettings().setStartTime(420);
				calendar.getTimetableSettings().setEndTime(1260);
				calendar.getTimetableSettings().setCellSize(20);
				calendar.getTimetableSettings().setMinColumnSize(60);
				calendar.getTimetableSettings().setShowNavigationButtons(true);
				calendar.getTimetableSettings().setNowColor(Color.LIGHT_GRAY);
				calendar.getTimetableSettings().setColumnBandSize(10);
				calendar.getTimetableSettings().setMainHeaderSize(40);
				calendar.getTimetableSettings().setShowAM(false);
				calendar.getTimetableSettings().setDayHeaderSize(10);
				
				//calendar.getTimetableSettings().setEnableDayItems(true);
				
			}
		}
		
		
		
		if(e.getSource() == btnEditar) {
			if(tag!=null) {
			frmNuevaCita = new VentanaNuevaCita();
			
			if(tag.charAt(0) == 'B') {
				VentanaNuevaCita.citaBaño();
				VentanaNuevaCita.citaBañoEditar(Baño.getBaño(tag));

			}
			
			if(tag.charAt(0) == 'P') {
				VentanaNuevaCita.citaPension();
				VentanaNuevaCita.citaPensionEditar(Pension.getPension(tag));

			}
			
			if(tag.charAt(0) == 'G') {
			VentanaNuevaCita.citaGuarderia();
			VentanaNuevaCita.citaGuarderiaEditar(Guarderia.getGuarderia(tag));
			
			}
			
			txtAInfo.setText("");
			Apache.excelCitas();
			
			}
		}
		
			if(e.getSource() == btnEliminar) {
				
				if(tag!=null) {
					int n = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar la cita?", 
							"Atención",	JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					
					if (n == JOptionPane.YES_OPTION) {	
						txtAInfo.setText("");
						
						if(tag.charAt(0) == 'B') {
							Estadistica.eliminarBaño(Baño.getBaño(tag).getMes(), Baño.getBaño(tag).getAño());
							Baño.getHashtableBaño().remove(tag);
							int index = Cita.getListaTags().indexOf(tag);
							calendar.getSchedule().getItems().remove(index);
							Cita.getListaTags().remove(tag);			
						}
							
						if(tag.charAt(0) == 'G') {
							Estadistica.eliminarGuarderia(Guarderia.getGuarderia(tag).getMes(),
									Guarderia.getGuarderia(tag).getAño());
							Guarderia.getHashtableGuarderia().remove(tag);
							int index = Cita.getListaTags().indexOf(tag);
							calendar.getSchedule().getItems().remove(index);
							Cita.getListaTags().remove(tag);
						}
						
						if(tag.charAt(0) == 'P') {
							Estadistica.eliminarPension(Pension.getPension(tag).getMes(), 
									Pension.getPension(tag).getAño());
							Pension.getHashtablePension().remove(tag);
							int index = Cita.getListaTags().indexOf(tag);
							calendar.getSchedule().getItems().remove(index);
							Cita.getListaTags().remove(tag);
						}
					}
					Apache.excelCitas();
				}
			}
		}
				
	
	public static Calendar getCalendar() {
		return calendar;
	}
	public static String getTag() {
		return tag;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btnAgendarBaño) {
			frmNuevaCita = new VentanaNuevaCita();
			VentanaNuevaCita.citaBaño();
			
		}
		
		if(e.getSource() == btnAgendarPension) {
			frmNuevaCita = new VentanaNuevaCita();	
			VentanaNuevaCita.citaPension();
		}
		
		if(e.getSource() == btnAgendarGuarderia) {
			frmNuevaCita = new VentanaNuevaCita();
			VentanaNuevaCita.citaGuarderia();
			
		}		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btnAgendarBaño) 
			btnAgendarBaño.setForeground(new Color(0x9edcff));
		
		if(e.getSource() == btnAgendarPension) 
			btnAgendarPension.setForeground(new Color(0xfa9d7f));
			
		if(e.getSource() == btnAgendarGuarderia)
			btnAgendarGuarderia.setForeground(new Color(0xb0fa41));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btnAgendarBaño) 
			btnAgendarBaño.setForeground(new Color(0x16a3f5));	
		
		if(e.getSource() == btnAgendarPension) 
			btnAgendarPension.setForeground(new Color(0xfa6c41));

		if(e.getSource() == btnAgendarGuarderia)
			btnAgendarGuarderia.setForeground(new Color(0x83d408));

	}
}
