package ISOluciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class GestorMesa {

	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Mesa> ListaMesas =new ArrayList<Mesa>();
	
	public GestorMesa(ArrayList<Mesa> listaMesas) {
			this.reservas=reservas;
			this.ListaMesas=listaMesas;
	}
	 
	public void HacerReserva(Mesa mesa,int ID, String Nombre, Date fecha, String turno) {
		// TODO - implement GestorMesa.HacerReserva
		Reserva Rv=new Reserva(mesa,ID,Nombre,fecha,turno);
		if(comprobarDisponible(Disponibles(), Rv)) {
			mesa.setEstado("");
			mesa.setTurno(turno);
			System.out.println("\nRESERVA\n-------\n"+Rv.toString()+"\n");
			reservas.add(Rv);
		}
	}
	public ArrayList<Reserva> obtenerReservas() {
		return reservas;
	}
	
	public void AsignarMesa() {
		// TODO - implement GestorMesa.AsignarMesa
		throw new UnsupportedOperationException();
	}
	public int Nreservas() {
		return reservas.size();
	}

	public void CancelarReserva() {
		// TODO - implement GestorMesa.CancelarReserva
		throw new UnsupportedOperationException();
	}
	
	public ArrayList<Mesa> Disponibles() {
	
		ArrayList<Mesa> libres =new ArrayList<Mesa>();
		for (Mesa mesa : ListaMesas) {
			if(mesa.getComida()==false || mesa.getCena()==false)	
				libres.add(mesa);
		}
		return libres;
	}
	public boolean comprobarDisponible(ArrayList<Mesa> disponibles, Reserva reserva) {
		boolean disponible=false;
		
		for (Mesa mesa : disponibles) {
			
			if(mesa.getID()==reserva.getMesa().getID() && ((mesa.getCena()==false && reserva.getTurnos().equals("cena") ) || (mesa.getComida()==false && reserva.getTurnos().equals("comida")))){
				disponible=true;
			}
		}
		
		
		return disponible;
	}
	
	public void mostrarReservas() {
		if (reservas.size()!=0){
			System.out.println("LISTA DE RESERVAS\n-----------------\n");
			for (Reserva reserva : reservas) {
				System.out.println(reserva.toString());
			}
			System.out.println("");
		}
	}
	
	public Mesa buscar_mesa(int IDMesa) {
		Mesa a=null;
		for(Mesa m:this.ListaMesas){
			if(m.getID()==IDMesa){
				a=m;
			}
		}
		return a;
	}

}