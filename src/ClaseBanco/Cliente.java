package ClaseBanco;

import java.util.ArrayList;

public class Cliente {

	private String titular; //nombre+apellido
	private ArrayList<Cuenta>cuentas;
	
		public Cliente(String nombreCompleto) {
			
			titular = nombreCompleto;
			cuentas=new ArrayList<Cuenta>();
			
		}

	public String getTitular() {
			return titular;
		}
		
	public void setTitular(String titular) {
			this.titular = titular;
		}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	//----------------------------------------------------------
	
	public void agregaCuenta(Cuenta nuevaCuenta){
		cuentas.add(nuevaCuenta);	
	}
	
	public String toString() {
		return "Titutar " + titular + " tiene las siguientes cuentas:\n" + cuentas+"\n";
	}
		
}
