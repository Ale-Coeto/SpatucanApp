package proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	//Clase encargada del almacenamiento
	public class Apache {
	
	//Código usado para crear el Excel la primera vez
	public static void crearExcel() {
		XSSFWorkbook wb = new XSSFWorkbook();
		
		//Crear un sheet
		XSSFSheet sheet = wb.createSheet("Mascotas");
		
		//Crear row
		XSSFRow row = sheet.createRow(0);
		
		//Crear cells
		Cell cell0 = row.createCell(0);
		Cell cell1 = row.createCell(1);
		Cell cell2 = row.createCell(2);
		Cell cell3 = row.createCell(3);
		Cell cell4 = row.createCell(4);
		Cell cell5 = row.createCell(5);
		Cell cell6 = row.createCell(6);
		Cell cell7 = row.createCell(7);
		
		
		cell0.setCellValue("Nombre mascota");
		cell1.setCellValue("Año nacimiento");
		cell2.setCellValue("Dias");
		cell3.setCellValue("Raza");
		cell4.setCellValue("Frecuencia baños");
		cell5.setCellValue("Mes");
		cell6.setCellValue("Año");
		cell7.setCellValue("Cliente");
		
		XSSFSheet sheet2 = wb.createSheet("Clientes");
		XSSFRow row2 = sheet2.createRow(0);
			
			//Create cells
			Cell cell02 = row2.createCell(0);
			Cell cell12 = row2.createCell(1);
			Cell cell22 = row2.createCell(2);
			Cell cell32 = row2.createCell(3);
			Cell cell42 = row2.createCell(4);
			Cell cell52 = row2.createCell(5);			
			
			cell02.setCellValue("Nombre cliente");
			cell12.setCellValue("Teléfono");
			cell22.setCellValue("Dirección");
			cell32.setCellValue("Facebook");
			cell42.setCellValue("Instagram");
			cell52.setCellValue("Twitter");


		
			try {
				FileOutputStream out = new FileOutputStream(new File("Spatucan.xlsx"));
				wb.write(out);
				out.close();

			} catch(Exception e) {
				Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		}
			
		
	}
	
	//Actualiza el excel de Mascota que almacena información del objeto Mascota
	public static void excelMascota(){
			
			try {
				
				FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
				XSSFWorkbook wb = new XSSFWorkbook(file);
				XSSFSheet sheetMascotas = wb.getSheetAt(0);
				
				//Se establece el número de filas
				for(int f = 1; f < Mascota.getNumeroMascotas()+1; f++) { 	
					XSSFRow fila = sheetMascotas.getRow(f);
					
					//Se crea una fila en caso de ser necesario
					if(fila==null)
						fila = sheetMascotas.createRow(f); 					
					
					//Se stablece el número de celdas en la fila 
					for(int c = 0; c<8; c++) {
						XSSFCell celda = fila.createCell(c);
						
						//Se almacenan los valores de los atributos en las celdas
						if(c==0)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getNombreMascota()); 		
						if(c==1)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getAñoNacimiento()); 						
						if(c==2)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getDias()); 
						if(c==3)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getRaza()); 						
						if(c==4)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getFrecuenciaBaños()); 
						if(c==5)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getMes()); 					
						if(c==6)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getAño()); 						
						if(c==7)
							celda.setCellValue(Mascota.getListaMascotas().get(f-1).getCliente().getNombreCliente()); 
					}
					
					
				}
				
				//Elimina una fila extra en caso de que haya una
				XSSFRow fila1 = sheetMascotas.getRow(Mascota.getNumeroMascotas()+1);
				
				if(fila1==null) {
					fila1 = sheetMascotas.createRow(Mascota.getNumeroMascotas()+1);
				}
				
				sheetMascotas.removeRow(fila1);
				
				file.close();
				FileOutputStream output = new FileOutputStream("Spatucan.xlsx");
				wb.write(output);
				output.close();
				wb.close();
	
			} catch(FileNotFoundException e) {
				Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);
	
			} catch(Exception e) {
				Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

			}
			
		}
	
	//Actualiza el excel de Cliente que almacena información del objeto Cliente
	public static void excelCliente() {
		
		try {
			FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
			XSSFSheet sheetClientes = wb.getSheetAt(1);
			
			//Establece el número de filas
			for(int f = 1; f < Cliente.getNumeroClientes()+1; f++) {
				XSSFRow fila = sheetClientes.getRow(f);
				if(fila==null)
					fila = sheetClientes.createRow(f);
				
				//Establece el número de celdas por fila y guarda su valor
				for(int c = 0; c<6; c++) {
					XSSFCell celda = fila.createCell(c);
					
					if(c==0)
						celda.setCellValue(Cliente.getListaClientes().get(f-1).getNombreCliente()); 
					
					if(c==1)
						celda.setCellValue(Long.toString(Cliente.getListaClientes().get(f-1).getTelefono())); 
					
					if(c==2)
						celda.setCellValue(Cliente.getListaClientes().get(f-1).getDireccion()); 

					if(c==3)
						celda.setCellValue(Cliente.getListaClientes().get(f-1).getFacebook()); 
					
					if(c==4)
						celda.setCellValue(Cliente.getListaClientes().get(f-1).getInstagram()); 
					
					if(c==5)
						celda.setCellValue(Cliente.getListaClientes().get(f-1).getTwitter()); 
				
				}
			}
			
			
			file.close();
			FileOutputStream output = new FileOutputStream("Spatucan.xlsx");
			wb.write(output);
			output.close();

		} catch(FileNotFoundException e) {
			Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		} catch(Exception e) {
			Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		}
	}
	
	//Actualiza el excel de Citas, baños, pensiones y guarderías y almacena información de los objetos Cita, Baño, Guarderia y Pension
	public static void excelCitas() {
			
			try {
				FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
				XSSFWorkbook wb = new XSSFWorkbook(file);
				//XSSFSheet sheetCitas = wb.createSheet();
				 XSSFSheet sheetCitas = wb.getSheetAt(2);
				
				int baño = 1;
				int guarderia = 1;
				int pension = 1;
				
				//Inicia creando las filas necesarias para el excel de Citas
				for(int f = 1; f < Cita.getListaTags().size()+1; f++) {
					XSSFRow fila = sheetCitas.getRow(f);
					
					if(fila==null)
						fila = sheetCitas.createRow(f);
					
						Cell celda = fila.createCell(0);
						String tag = Cita.getListaTags().get(f-1);
						celda.setCellValue(tag);	
						
						//Si el tag guardado corresponde a un baño, guarda la información de ese objeto en el excel de Baño
						  if(tag.charAt(0) == 'B') {
							XSSFSheet sheetBaño = wb.getSheetAt(3);
							
							XSSFRow filab = sheetBaño.getRow(baño);
							if(filab==null)
								filab = sheetBaño.createRow(baño);
							
								for(int c=0; c<13; c++) {
									
									
									XSSFCell celdab = filab.createCell(c);
									
									if(c==0)
										celdab.setCellValue(Baño.getBaño(tag).getMascota().getNombreMascota());		
									if(c==1)
										celdab.setCellValue(Baño.getBaño(tag).getDia());		
									if(c==2)
										celdab.setCellValue(Baño.getBaño(tag).getMes());	
									if(c==3)
										celdab.setCellValue(Baño.getBaño(tag).getAño());	
									if(c==4)
										celdab.setCellValue(Baño.getBaño(tag).getHora());	
									if(c==5)
										celdab.setCellValue(Baño.getBaño(tag).getMinutos());	
									if(c==6)
										celdab.setCellValue(Baño.getBaño(tag).isBaño());	
									if(c==7)
										celdab.setCellValue(Baño.getBaño(tag).isCorte());	
									if(c==8)
										celdab.setCellValue(Baño.getBaño(tag).isRasurado());
									if(c==9)
										celdab.setCellValue(Baño.getBaño(tag).isAm());	
									if(c==10)
										celdab.setCellValue(Baño.getBaño(tag).isPm());	
									if(c==11)
										celdab.setCellValue(tag);
									if(c==12)
										celdab.setCellValue(Baño.getBaño(tag).isFrecuencia());
								}	
								baño++;
								
								XSSFRow fila1 = sheetBaño.getRow(Baño.getHashtableBaño().size()+1);
								if(fila1==null) {
									fila1 = sheetBaño.createRow(Baño.getHashtableBaño().size()+1);
								}
								sheetBaño.removeRow(fila1);
								

							  
							  
						//Si el tag guardado corresponde a un una guardería, guarda la información de ese objeto en el excel de Guarderia
						} else if(Cita.getListaTags().get(f-1).charAt(0) == 'G') {
							XSSFSheet sheetGuarderia = wb.getSheetAt(4);
							
							XSSFRow filab = sheetGuarderia.getRow(guarderia);
							if(filab==null)
								filab = sheetGuarderia.createRow(guarderia);
							
								for(int c=0; c<9; c++) {
												
									XSSFCell celdab = filab.createCell(c);
									String tagx = Cita.getListaTags().get(f-1);
									if(c==0)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getMascota().getNombreMascota());	
									if(c==1)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getDia());		
									if(c==2)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getMes());	
									if(c==3)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getAño());	
									if(c==4)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getHoraLlegada());	
									if(c==5)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getMinutosLlegada());	
									if(c==6)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).getHorasGuarderia());	
									if(c==7)
										celdab.setCellValue(Guarderia.getGuarderia(tagx).isAm());
									if(c==8)
										celdab.setCellValue(tag);

								}
								guarderia++;
								XSSFRow fila1 = sheetGuarderia.getRow(Guarderia.getHashtableGuarderia().size()+1);
								if(fila1==null) {
									fila1 = sheetGuarderia.createRow(Guarderia.getHashtableGuarderia().size()+1);
								}
								sheetGuarderia.removeRow(fila1);
							
						//Si el tag guardado corresponde a una pensión, guarda la información de ese objeto en el excel de Pension
						} else if(Cita.getListaTags().get(f-1).charAt(0) == 'P') {
							XSSFSheet sheetPension = wb.getSheetAt(5);
							
							XSSFRow filab = sheetPension.getRow(pension);
							if(filab==null)
								filab = sheetPension.createRow(pension);
							
								for(int c=0; c<6; c++) {
												
									XSSFCell celdab = filab.createCell(c);
									String tag2 = Cita.getListaTags().get(f-1);
									if(c==0)
										celdab.setCellValue(Pension.getPension(tag2).getMascota().getNombreMascota());	
									if(c==1)
										celdab.setCellValue(Pension.getPension(tag2).getDia());		
									if(c==2)
										celdab.setCellValue(Pension.getPension(tag2).getMes());	
									if(c==3)
										celdab.setCellValue(Pension.getPension(tag2).getAño());	
									if(c==4)
										celdab.setCellValue(Pension.getPension(tag2).getDiasPension());	
									if(c==5)
										celdab.setCellValue(tag2);	

								}
								pension++;
								XSSFRow fila1 = sheetPension.getRow(Pension.getHashtablePension().size()+1);
								if(fila1==null) {
									fila1 = sheetPension.createRow(Pension.getHashtablePension().size()+1);
								}
								sheetPension.removeRow(fila1);
						}
						
						
						
						
				}
				//Elimina una fila extra en caso de que exista 
				XSSFRow fila1 = sheetCitas.getRow(Cita.getListaTags().size()+1);
				if(fila1==null) {
					fila1 = sheetCitas.createRow(Cita.getListaTags().size()+1);
				}
				sheetCitas.removeRow(fila1);
				
				
				
						
				file.close();
				FileOutputStream output = new FileOutputStream("Spatucan.xlsx");
				wb.write(output);
				output.close();
	
			} catch(FileNotFoundException e) {
				Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);
	
			} catch(Exception e) {
				Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);
	
			}
		}
	
	//Guarda la nueva estadística creada en el excel Estadistica
	public static void excelEstadistica(Estadistica estadistica) {
		
		try {
			FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheetEstadistica = wb.getSheetAt(6);
			
		//Se establece el número de fila en que se debe almacenar la nueva estadística	
		int r = Estadistica.getStackSize();

	         
	         XSSFRow fila = sheetEstadistica.createRow(r);
				for(int c = 0; c<6; c++) {
					XSSFCell celda = fila.createCell(c);
						if(c==0)
							celda.setCellValue(estadistica.getMes());	
						if(c==1)
							celda.setCellValue(estadistica.getAño());	
						if(c==2)
							celda.setCellValue(estadistica.getNuevasMascotas());	
						if(c==3)
							celda.setCellValue(estadistica.getNuevosBaños());
						if(c==4)
							celda.setCellValue(estadistica.getNuevasGuarderias());	
						if(c==5)
							celda.setCellValue(estadistica.getNuevasPensiones());	
						
				}
					
			file.close();
			FileOutputStream output = new FileOutputStream("Spatucan.xlsx");
			wb.write(output);
			output.close();

		} catch(FileNotFoundException e) {
			Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		} catch(Exception e) {
			Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		}
	}
	
	//Lee el excel de Estadisticas para guardar la información en el stack de Estadistica
	public static void leerStack() {
		try {
			FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
		 XSSFSheet sheetEstadisticas = wb.getSheetAt(6);
			
		 Iterator<Row> iterator4 = sheetEstadisticas.iterator();
		 
		 iterator4.next();
        while(iterator4.hasNext()) {
       	 Row fila = iterator4.next();
			 Cell mes = fila.getCell(0);
			 Cell año = fila.getCell(1);
			 Cell mascotas = fila.getCell(2);
			 Cell baños = fila.getCell(3);
			 Cell guarderias = fila.getCell(4);
			 Cell pensiones = fila.getCell(5);
			 
			 int mesActual = (Calendar.getInstance().get(Calendar.MONTH)+1);
			Estadistica estadistica = new Estadistica((int)mes.getNumericCellValue(), (int)año.getNumericCellValue());
			 if(mes.getNumericCellValue()!=mesActual) {
				 estadistica.setNuevasGuarderias((int)guarderias.getNumericCellValue());
				 estadistica.setNuevasPensiones((int)pensiones.getNumericCellValue());
				 estadistica.setNuevosBaños((int)baños.getNumericCellValue());
				 estadistica.setNuevasMascotas((int)mascotas.getNumericCellValue());
			 }
			 	
				 
			System.out.println(estadistica.getMes() + " " + estadistica.getTotal());
			 Estadistica.addStackMeses(estadistica);
			Estadistica.updateLstEstadisticas();
        }
        wb.close();
		}catch (FileNotFoundException e) {
			
		} catch (Exception e) {
			
		}
        
	}
	
	/*	Se lee la información de la hoja de Excel "Clientes" para que
		el programa inicie con la información almacenada la última vez que se usó */
	public static void leerClientes() {
		
		try {
			FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
			//Se selecciona la hoja "Clientes"
			 XSSFSheet sheetClientes = wb.getSheetAt(1);
			 Iterator<Row> iterator = sheetClientes.iterator();
			 iterator.next();
			 
	         while(iterator.hasNext()) {
				 Row fila = iterator.next();
				 
				 //Se asigna un nombre a cada celda
				 Cell nombre = fila.getCell(0);
				 Cell telefono = fila.getCell(1);
				 Cell direccion = fila.getCell(2);
				 Cell facebook = fila.getCell(3);
				 Cell instagram = fila.getCell(4);
				 Cell twitter = fila.getCell(5);

				//Se crea un cliente con los datos de las celdas
				Cliente cliente = new Cliente(nombre.getStringCellValue(), direccion.getStringCellValue());
				long t = Long.parseLong(telefono.getStringCellValue());
				cliente.setTelefono(t);
				cliente.setFacebook(facebook.getStringCellValue());
				cliente.setInstagram(instagram.getStringCellValue());
				cliente.setTwitter(twitter.getStringCellValue());
				Cliente.agregarCliente(cliente);
				PanelAgregarCliente.setComboBoxModel();

	         }
	         
			wb.close();
		 	
		} catch (FileNotFoundException e) {
			
		} catch (Exception e) {
			
		}
	}
	
	
	public static void leerMascotas() {
		try {
			FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
			//Leer Clientes
			XSSFSheet sheetClientes = wb.getSheetAt(0);
			 Iterator<Row> iterator = sheetClientes.iterator();
			 iterator.next();
			 
		    while(iterator.hasNext()) {
		   	 Row fila = iterator.next();
				 Cell nombre = fila.getCell(0);
				 Cell añoNacimiento = fila.getCell(1);
				 Cell dias = fila.getCell(2);
				 Cell raza = fila.getCell(3);
				 Cell fb = fila.getCell(4);
				 Cell mes = fila.getCell(5);
				 Cell año = fila.getCell(6);
				 Cell cliente = fila.getCell(7);
		
				Mascota mascota = new Mascota(nombre.getStringCellValue(), raza.getStringCellValue(), Cliente.buscarCliente(cliente.getStringCellValue(), 0, Cliente.getNumeroClientes()));
				int a = (int)añoNacimiento.getNumericCellValue();
				mascota.setAñoNacimiento(a);
				mascota.setDias(dias.getBooleanCellValue());
				int f = (int)fb.getNumericCellValue();
				mascota.setFrecuenciaBaños(f);
				int m = (int)mes.getNumericCellValue();
				mascota.setMes(m);
				int o = (int)año.getNumericCellValue();
				mascota.setAño(o);
				Mascota.agregarMascota(mascota);
				Estadistica.nuevaMascota(m,o);
				PanelBuscarClientes.updateLstClientes(PanelBuscarClientes.lstClientes);
		        System.out.println(mascota.getNombreMascota());
		
				try {
				PanelBuscarClientes.updateLstClientes(VentanaNuevaCita.lstClientes2);
				
				} catch (Exception e) {
					
				}
		    }
		    
		    wb.close();
		    
		
		} catch (FileNotFoundException e) {
		
		} catch (Exception e) {


    }
	}

		public static void leerCitas() {
			try {
				FileInputStream file = new FileInputStream(new File("Spatucan.xlsx"));
				XSSFWorkbook wb = new XSSFWorkbook(file);
				
				 //Leer Citas
		         String tag1 = "";
		         int cbaño = 1;
		         int cguarderia = 1;
		         int cpension = 1;
		         
					XSSFSheet sheetCitas = wb.getSheetAt(2);
					
					 Iterator<Row> iterator3 = sheetCitas.iterator();
					 iterator3.next();
					 
			 while(iterator3.hasNext()) {
			        	 Row fila0 = iterator3.next();
			        	 
						 Cell tagcell = fila0.getCell(0);
						  tag1 = tagcell.getStringCellValue();
						Cita.addTag(tag1);
					
			         
			         
		         //Leer Baño
						if(tag1.charAt(0) == 'B') {
					XSSFSheet sheetBaño = wb.getSheetAt(3);
					
			        	 XSSFRow fila = sheetBaño.getRow(cbaño);
			        	 
						 Cell mascota = fila.getCell(0);
						 Cell dia = fila.getCell(1);
						 Cell mes = fila.getCell(2);
						 Cell año = fila.getCell(3);
						 Cell horas = fila.getCell(4);
						 Cell minutos = fila.getCell(5);
						 Cell baño = fila.getCell(6);
						 Cell corte = fila.getCell(7);
						 Cell rasurado = fila.getCell(8);
						 Cell am = fila.getCell(9);
						 Cell pm = fila.getCell(10);
						 Cell frecuencia = fila.getCell(12);
						
						 cbaño++;
						 
						
						 if(horas.getNumericCellValue()>0) {
							 System.out.println("bano1");
							Baño baño1 = new Baño(Mascota.buscarMascota2(mascota.getStringCellValue()), (byte)dia.getNumericCellValue(), (byte)mes.getNumericCellValue(), (short)año.getNumericCellValue(), (byte)horas.getNumericCellValue(), (byte)minutos.getNumericCellValue(), am.getBooleanCellValue(), pm.getBooleanCellValue(), baño.getBooleanCellValue(), rasurado.getBooleanCellValue(), corte.getBooleanCellValue(), tag1);
							 System.out.println("baño " + baño1.getMascota().getNombreMascota());

							baño1.setFrecuencia(frecuencia.getBooleanCellValue());
							
						 } else {
							 System.out.println("bano2");

							Baño baño1 = new Baño(Mascota.buscarMascota2(mascota.getStringCellValue()), (byte)dia.getNumericCellValue(), (byte)mes.getNumericCellValue(), (short)año.getNumericCellValue(),baño.getBooleanCellValue(), rasurado.getBooleanCellValue(), corte.getBooleanCellValue(), tag1);
								//System.out.println(frecuencia.getBooleanCellValue() + baño1.getMascota().getNombreMascota());
								 System.out.println("baño " + baño1.getMascota().getNombreMascota());

								baño1.setFrecuencia(frecuencia.getBooleanCellValue());
	
						 }
	
						 }
						
						 //Leer Guarderia
						if(tag1.charAt(0) == 'G') {
							XSSFSheet sheetGuarderia = wb.getSheetAt(4);
							XSSFRow fila = sheetGuarderia.getRow(cguarderia);
			        	 
						 Cell mascota = fila.getCell(0);
						 Cell dia = fila.getCell(1);
						 Cell mes = fila.getCell(2);
						 Cell año = fila.getCell(3);
						 Cell horaLlegada = fila.getCell(4);
						 Cell minutosLlegada = fila.getCell(5);
						 Cell horasGuarderia = fila.getCell(6);
						 Cell am = fila.getCell(7);
						 
						
						 cguarderia++;			

							 Guarderia guarderia = new Guarderia(Mascota.buscarMascota2(mascota.getStringCellValue()), (byte)dia.getNumericCellValue(), (byte)mes.getNumericCellValue(), (short)año.getNumericCellValue(), (byte)horaLlegada.getNumericCellValue(), (byte)minutosLlegada.getNumericCellValue(), (byte)horasGuarderia.getNumericCellValue(), am.getBooleanCellValue(), tag1);
								System.out.println("gueardeiroj");

						 
			         }
						 //Leer Pension
						if(tag1.charAt(0) == 'P') {
							XSSFSheet sheetPension = wb.getSheetAt(5);
					
							XSSFRow fila = sheetPension.getRow(cpension);
			        	 
						 Cell mascota = fila.getCell(0);
						 Cell dia = fila.getCell(1);
						 Cell mes = fila.getCell(2);
						 Cell año = fila.getCell(3);
						 Cell diasPension = fila.getCell(4);
						
						 cpension++;					 
							 Pension pension = new Pension(Mascota.buscarMascota2(mascota.getStringCellValue()), (byte)dia.getNumericCellValue(), (byte)mes.getNumericCellValue(), (short)año.getNumericCellValue(), (byte)diasPension.getNumericCellValue(), tag1);
								 
			         }
			         }
	         wb.close();

			} catch (FileNotFoundException e) {
				
			} catch (Exception e) {


	    }
		}
		}
