package Iteracion9;
public class JefeSala extends Usuario {
	
	
	
	public JefeSala() {
		
		
		
	}
	
	
	public void hacerReserva(GestorMesa GMesa) {
		
		GMesa.HacerReserva( );
		
		GMesa.mostrarReservas();
		
		
	}
}