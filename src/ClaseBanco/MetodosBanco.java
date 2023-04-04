package ClaseBanco;

import java.util.ArrayList;
import java.util.Scanner;

public class MetodosBanco {

	static int verificaCliente(ArrayList<Cliente>clientes,String nombreCompleto) {
		
		int indice=-1;
		int contador=0;

			while(contador<clientes.size() && indice==-1){

				if(clientes.get(contador).getTitular().equalsIgnoreCase(nombreCompleto)){

					indice=contador;

				}

						contador++;

					}

						return indice;

				}

	static int verificaCuenta(ArrayList<Cliente>clientes,int indice) {
		
		return clientes.get(indice).getCuentas().size()-1;
			
	}
	
	static void mostrarListaClientes(ArrayList<Cliente>clientes) {
		//for each, codigo mas corto que un for normal
		   for(Cliente lista :clientes) { 
			  System.out.println(lista);   
		   }
		}
	
	static void mostrarListaCuentas(ArrayList<Cuenta>cuentas) {
		//for each, codigo mas corto que un for normal
		   for(Cuenta lista :cuentas) {
			      System.out.println(lista);
			    }
		}
	
	static int pideInt(String mensaje) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
			System.out.println(mensaje);
				return input.nextInt();
}
	
	static String pideString(String mensaje) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
			System.out.println(mensaje);
				return input.nextLine();
}
	
}
