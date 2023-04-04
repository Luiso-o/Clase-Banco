package ClaseBanco;

import java.util.ArrayList;

public class App_Banco {

	public static void main(String[] args) {			
		
//			MetodosBanco.mostrarListaClientes(miLista());	
		
		int menu=MetodosBanco.pideInt("A que opcion deseas accede?\n\n0-Salir de la aplicacion."
				+ "\n1-Crear un cliente.\n2-Eliminar cliente.\n3-Crear nueva cuenta para un cliente."
				+ "\n4-Hacer un ingreso.\n5-Hacer un retiro.\n6-Hacer un movimiento o transferencia.");
		
			while(menu>0 && menu<7) {
				
				switch(menu) {
				
					case 1://Crear cliente
						
						crearCliente(miLista(),MetodosBanco.pideString("Introduce el nombre y el primer apellido del nuevo cliente"));
						
							menu=MetodosBanco.pideInt("\nDesea realizar una tarea?");
							
								break;
								
					case 2://Eliminar
						
						eliminarCliente(miLista(),MetodosBanco.pideString("Introduce el nombre y el primer apellido del cliente"));
				
							menu=MetodosBanco.pideInt("\nDesea realizar una tarea?");
						
								break;
								
					case 3://Crear cuenta nueva
						
						crearCuenta(miLista(),MetodosBanco.pideString("Introduce el nombre y el primer apellido del cliente"));
				
							menu=MetodosBanco.pideInt("\nDesea realizar una tarea?");
						
								break;
								
					case 4://Ingresar
						
						ingreso(miLista(),MetodosBanco.pideString("Introduce el nombre y el primer apellido del cliente"));
				
							menu=MetodosBanco.pideInt("\nDesea realizar una tarea?");
						
								break;
								
					case 5://retirar
						
						retiro(miLista(),MetodosBanco.pideString("Introduce el nombre y el primer apellido del cliente"));
					
							menu=MetodosBanco.pideInt("\nDesea realizar una tarea?");
						
								break;
								
					case 6://movimiento o transferencia
								
						transferencia(miLista(),MetodosBanco.pideString("Introduzca su nombre y su primer apellido"));	
						
							menu=MetodosBanco.pideInt("\nDesea realizar una tarea?");
					
									break;
									
				}
					
			}

		System.out.println("Fin del programa");
		
	}//MAIN
	
	static ArrayList<Cliente> miLista() {
		
		ArrayList<Cliente>clientes=new ArrayList<Cliente>();
		
		Cliente cliente1=new Cliente("Marcos Peralta");
			Cuenta cuenta1=new Cuenta(1,0);
				cliente1.agregaCuenta(cuenta1);
					cuenta1.ingresar(1000);
						clientes.add(cliente1);	
					
		Cliente cliente2=new Cliente("Maria Romero");
			Cuenta cuenta2=new Cuenta(1,0);
			Cuenta cuenta3=new Cuenta(2,0);
				cliente2.agregaCuenta(cuenta2);
				cliente2.agregaCuenta(cuenta3);
					cuenta2.ingresar(1000);
					cuenta3.ingresar(2000);
						clientes.add(cliente2);
						
		Cliente cliente3=new Cliente("Ana Ramires");
			Cuenta cuenta4=new Cuenta(1,0);
			Cuenta cuenta5=new Cuenta(2,0);
			Cuenta cuenta6=new Cuenta(3,0);
				cliente3.agregaCuenta(cuenta4);
				cliente3.agregaCuenta(cuenta5);
				cliente3.agregaCuenta(cuenta6);
					cuenta4.ingresar(5000);
					cuenta5.ingresar(100);
					cuenta6.ingresar(1040);
						clientes.add(cliente3);
						
						return clientes;
		
	}
	
	static void crearCliente(ArrayList<Cliente>clientes,String nombreCompleto) {
		
		int indice=MetodosBanco.verificaCliente(clientes,nombreCompleto);
		
		if(indice==-1) {
			
			Cliente nuevoCliente=new Cliente(nombreCompleto);
				Cuenta nuevaCuenta=new Cuenta(1,0);
					nuevoCliente.agregaCuenta(nuevaCuenta);
				clientes.add(nuevoCliente);
					System.out.println(nuevoCliente + "\nHa sido agregado como nuevo cliente");
			
		}else {
		
				System.out.println("Este cliente ya tiene una cuenta en este banco");
		}
		
	}
	
	static void eliminarCliente(ArrayList<Cliente>clientes,String nombreCompleto) {
		
		int indice=MetodosBanco.verificaCliente(clientes,nombreCompleto);
		
			if(indice==-1) {
				
				System.out.println("Este cliente no tiene ninguna cuenta en este banco");
				
			}else {
				
					clientes.remove(indice);
					
					System.out.println("Hemos eliminado a " + nombreCompleto + " con sus cuentas asociadas");
				
			}
			
	}
	
	static void crearCuenta(ArrayList<Cliente>clientes,String nombreCompleto) {
			
		int indice=MetodosBanco.verificaCliente(clientes,nombreCompleto);
		
			if(indice==-1) {
				
				String opcion=MetodosBanco.pideString("Este cliente no tiene una cuenta en este banco,"
						+ " desea crear una?");
				
					if(opcion.equalsIgnoreCase("Si")) {
						crearCliente(clientes,nombreCompleto);
					}
					
				
			}else {
				
				int indiceCuenta=MetodosBanco.verificaCuenta(clientes,indice);
				
					Cuenta nueva=new Cuenta(indiceCuenta+2,0);
					
						clientes.get(indice).agregaCuenta(nueva);
						
							System.out.println("Hemos agregado la cuenta " + nueva + "al titular "
									+ nombreCompleto);
				
			}		
					
		}
	
	static void ingreso(ArrayList<Cliente>clientes,String nombreCompleto) {
		
		int indice=MetodosBanco.verificaCliente(clientes,nombreCompleto);
		
			if(indice==-1) {
				
				System.out.println("Este cliente no consta en la base de datos");
				
			}else {
				
				int indiceCuenta=MetodosBanco.verificaCuenta(clientes,indice);
				
					if(indiceCuenta==0) {
						
						clientes.get(indice).getCuentas().get(0).ingresar(MetodosBanco.pideInt("Cual el monto que desea ingresar?"));
						
							System.out.println(clientes.get(indice).getCuentas().get(0));
							
					}else {
						
						int numero=MetodosBanco.pideInt("Ingrese el numero de cuenta al que quiere ingresar");
						
							clientes.get(indice).getCuentas().get(numero-1).ingresar(MetodosBanco.pideInt("Cual el monto que desea ingresar?"));
							
								MetodosBanco.mostrarListaCuentas(clientes.get(indice).getCuentas());
								/*tambien se puede imprimir solamente la cuenta donde deposit�(como hice en el 
								 * metodo crearCuenta),pero prefiero hacer una impresion de todas sus cuentas para que 
								 * puedas comparar con cuentas ingresadas manuelmente y sea mas facil
								 * su compresion*/
								
					}
					
			}
		
	}
	
	
	static void retiro(ArrayList<Cliente>clientes,String nombreCompleto) {
		
		int indice=MetodosBanco.verificaCliente(clientes,nombreCompleto);
		
			if(indice==-1) {
				
				System.out.println("Este cliente no consta en la base de datos");
				
			}else {
				
				int indiceCuenta=MetodosBanco.verificaCuenta(clientes,indice);
				
					if(indiceCuenta==0) {
						
						clientes.get(indice).getCuentas().get(0).retirar(MetodosBanco.pideInt("Cual el monto que desea retirar?"));
						
							System.out.println(clientes.get(indice).getCuentas().get(0));
							
					}else {
						
						int numero=MetodosBanco.pideInt("Ingrese el numero de cuenta al que quiere retirar");
						
							clientes.get(indice).getCuentas().get(numero-1).retirar(MetodosBanco.pideInt("Cual el monto que desea retirar?"));
							
								MetodosBanco.mostrarListaCuentas(clientes.get(indice).getCuentas());
					}
					
				}
			
			}
	
	static void transferencia(ArrayList<Cliente>clientes,String nombreCompleto){
		
		int indiceCliente1=MetodosBanco.verificaCliente(clientes,nombreCompleto);
		
		int	opcion=MetodosBanco.pideInt("Quiere transferir a:\n1-Una de sus cuentas?\n2-A una cuenta de otra persona?");
		
		if(opcion==1) {
			
			int cuenta1=MetodosBanco.pideInt("Introduce el numero de cuenta de donde har�s la transferencia");
			int cuenta2=MetodosBanco.pideInt("Introduce el numero de cuenta al que quieres ingresar");
			
			clientes.get(indiceCliente1).getCuentas().get(cuenta1-1).transferencia(clientes.get(indiceCliente1).getCuentas().get(cuenta2-1), 
					MetodosBanco.pideInt("Introduce el monto que deseas transferir"));
			
				MetodosBanco.mostrarListaCuentas(clientes.get(indiceCliente1).getCuentas());				
			
		}else if(opcion==2) {
			
			int indiceCliente2=MetodosBanco.verificaCliente(clientes,
				MetodosBanco.pideString("Introduce el nombre y el primer apellido del beneficiario:"));
			
			int indiceMiCuenta=MetodosBanco.pideInt("Introduce el numero de cuenta de donde har�s la transferencia");
			
			clientes.get(indiceCliente1).getCuentas().get(indiceMiCuenta-1).transferencia(clientes.get(indiceCliente2).getCuentas().get(0),
					MetodosBanco.pideInt("Introduce el monto que deseas tranferir"));
			
			MetodosBanco.mostrarListaCuentas(clientes.get(indiceCliente1).getCuentas());	
			System.out.println(clientes.get(indiceCliente2));//prueba
			
		}else {
			System.out.println("El dato ingresado no es correcto");
		}
		
	}
	
		}//APP
