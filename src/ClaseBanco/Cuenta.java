package ClaseBanco;

public class Cuenta {
	 
	private int numCuenta;
	private int saldo;
	
		public Cuenta(int numCuenta,int saldo) {
			
			this.numCuenta = numCuenta;
			this.saldo = saldo;
			
		}

		public int getNumCuenta() {
			return numCuenta;
		}

		public int getSaldo() {
			return saldo;
		}
	
	//----------------------------------------------------
		public String ingresar(int ingreso) {
			
			if(ingreso<0) {
				System.out.println("El monto no est� permitido");
			}else {	
				saldo+=ingreso;
			}
			return "El saldo de su cuenta es de: " + saldo;
		}
		
		public String retirar(int retiro) {
			
			if(saldo<retiro) {
				System.out.println("La cantidad que desea retirar es mayor al saldo de su cuenta");
			}else {
				saldo-=retiro;
			}
			return "El saldo de su cuenta es de: " + saldo;	
		}
		
		public String toString() {
			return "Cuenta numero " + numCuenta + " (tiene un saldo de: " + saldo + " euros)\n";
		}
		//Metodo extra
		public void transferencia(Cuenta cuentaDestino,int importe) {		
			
	        if (importe < 0) {
	            System.out.println("Este monto no est� permitido");
	            
	        } else {
	        	retirar(importe);
	            cuentaDestino.ingresar(importe);
	        } 
	        
	        System.out.println("Se han transferido " + importe + " euros a la cuenta beneficiaria\n");
	    }
		
}
