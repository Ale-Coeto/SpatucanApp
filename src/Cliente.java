package proyecto;

import java.util.ArrayList;


public class Cliente {
		
		//Atributos	
		private long telefono;
		private String nombreCliente;
		private String direccion;
		private String facebook;
		private String instagram;
		private String twitter;
		
		private static int numeroClientes;
		private static ArrayList <Cliente> ListaClientes = new ArrayList<Cliente>();
		private static String[] NombresClientes;
			
		
		//Método constructor	
		public Cliente (String nombreCliente, String direccion) {
		
			this.nombreCliente = nombreCliente;
			this.direccion = direccion;
			
		}
		
		//Getters		
		public static int getNumeroClientes() {
			return numeroClientes;
		}
		
		public String getNombreCliente () {
			return nombreCliente;
		}
		
		public long getTelefono () {
			return telefono;
		}
		public String getDireccion () {
			return direccion;
		}
		
		public String getFacebook () {
			return facebook;
		}
		
		public String getInstagram () {
			return instagram;
		}
		
		public String getTwitter () {
			return twitter;
		}
		
		public static String[] getNombresClientes() {
			return NombresClientes;
		}
		
		public static ArrayList <Cliente> getListaClientes() {
			return ListaClientes;
		}
		
		//setters	
		public void setTelefono(long telefono) {
			this.telefono = telefono;
		}
		
		public void setNombreCliente (String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}
		
		public void setDireccion (String direccion) {
			this.direccion = direccion;
		}
		
		public void setFacebook (String facebook) {
			this.facebook = facebook;
		}
		
		public void setInstagram (String instagram) {
			this.instagram = instagram;
		}
		
		public void setTwitter (String twitter) {
			this.twitter = twitter;
		}

		public static void setListaClientes(ArrayList <Cliente> listaClientes) {
			ListaClientes = listaClientes;
		}
					
		//Métodos		
		public static void agregarCliente(Cliente cliente) {
			getListaClientes().add(cliente);
			numeroClientes++;
			Apache.excelCliente();
		}
		
		
		public static void crearListaClientes() {
			setListaClientes(new ArrayList<>());
			}
		
		
		public static void actualizarNombresClientes() {
			ordenarClientes();
			int size = getListaClientes().size() + 1;
			NombresClientes = new String[size];
			NombresClientes[0] = "Nuevo Cliente";
			
			for(int i = 1; i < size; i++) {
				NombresClientes[i] = getListaClientes().get(i-1).nombreCliente;
				
			}
			
			
		}		
		
		//Elimina un cliente del conteo de clientes
		public static void eliminarCliente () {
			numeroClientes--;
			Apache.excelCliente();
		}
		
		//Búsqueda Binaria
		public static Cliente buscarCliente(String target, int begin, int end) {
			
			try {
				//En caso de que solo haya 1 elemento
				if(begin+end == 1 || end==0 )
					return getListaClientes().get(0);
				
				int mid = (begin+end)/2;
				
				//Posibles excepciones
				if(begin>end || mid>=end || mid>=numeroClientes || (begin==end && 
						!(getListaClientes().get(mid).getNombreCliente().equals(target)))) 
					return null;
				
				//Caso Base
				if(getListaClientes().get(mid).getNombreCliente().equals(target))
					return getListaClientes().get(mid);
					
				//Si target es mayor a mid
				if(getListaClientes().get(mid).getNombreCliente().compareTo(target) < 0) 
					return buscarCliente(target, mid+1, end);
				
				
				//Si target es menor a mid
				if(getListaClientes().get(mid).getNombreCliente().compareTo(target) > 0) 
					return buscarCliente(target, begin, mid-1);
				
				return null;
			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}					
		}
		
		public static Cliente buscarCliente2(String nombreCliente) {
			for(int i = 0; i < numeroClientes; i++) {
				if(ListaClientes.get(i).getNombreCliente().equals(nombreCliente) && 
						ListaClientes.get(i).getNombreCliente().equals(nombreCliente)) {
					Cliente uno = ListaClientes.get(i);
					return uno;
				}
			}
			return null;
		}
		
		//Determina si se encontró un cliente
	
		
		//Algoritmo para ordenar la lista de clientes 
		public static void ordenarClientes() {
			boolean flagswap = true;
			
			if(numeroClientes > 1) {
				for(int i = ListaClientes.size()-1; i > 0 && flagswap; i--) {
					String uno = ListaClientes.get(i).nombreCliente;
					String dos = ListaClientes.get(i-1).nombreCliente;
					
					 if (uno.compareTo(dos) < 0) {
						Cliente temp = ListaClientes.get(i-1);
						
						ListaClientes.set(i-1, ListaClientes.get(i));
						
						ListaClientes.set(i, temp);
						
						flagswap = true;
						
					} else 
						flagswap = false;
				}
			}
			
//				for (int i=1; i<ListaClientes.size()-1; i++) {
//					int min = i;
//					boolean found = false;
//					
//					for(int j = i+1; j < ListaClientes.size(); j++) {
//					
//						if (ListaClientes.get(min).getNombreCliente().toLowerCase().compareTo
//							(ListaClientes.get(j).getNombreCliente().toLowerCase()) > 0) {
//							min = j;
//							found = true;
//					 							
//						} 
//					 
//					}
//						if(found) {
//							Cliente temp = ListaClientes.get(min);
//							ListaClientes.set(min, ListaClientes.get(i));
//							ListaClientes.set(i, temp);
//		
//						}	
//				}							
		}
		

		
}
	