package ISOluciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ISOluciones.Estado;
import ISOluciones.Mesa;
import ISOluciones.Reserva;
import ISOluciones.Turno;
public class GestorMesa {

	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<Mesa> listaMesas =new ArrayList<Mesa>();
	
	public GestorMesa(ArrayList<Mesa> listaMesas) {
			this.reservas=reservas;
			this.listaMesas=listaMesas;
		}
	 
	public void HacerReserva() {
		// TODO - implement GestorMesa.HacerReserva
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduce nombre de reserva:");
		String Nombre =sc.next();
		int ID=Nreservas();
		Mesa mesa=elegirMesa(Disponibles(listaMesas));
		Date fecha= new Date();
		System.out.println("Elija el horario de la reserva");
		Horario horario=Horario.COMIDA;
		Turno turno =Turno.TURNO1;
		
		Reserva Rv=new Reserva(mesa,ID,Nombre,fecha, horario, turno);
		reservas.add(Rv);
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

	public ArrayList<Reserva> getListaMesas() {
		// TODO - implement GestorMesa.getListaMesas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ListaMesas
	 */
	public void setListaMesas(int ListaMesas) {
		// TODO - implement GestorMesa.setListaMesas
		throw new UnsupportedOperationException();
	}
	public ArrayList<Mesa> Disponibles(ArrayList<Mesa> listaMesas) {
		Mesa mesaLibre = null;
		ArrayList<Mesa> libres =new ArrayList<Mesa>();
		Estado libre = Estado.LIBRE;
		for (Mesa mesa : listaMesas) {
			
			if(mesa.getEstado().equals(libre))
				libres.add(mesa);
			
		}
		return libres;
		
	}
	public Mesa elegirMesa(ArrayList<Mesa> Libres) {
		Mesa mesaLibre = null;
		int count=-1;
		System.out.println("Las mesas disponibles son : ");
		for (Mesa mesa : Libres) {
			count++;			
			System.out.println("Mesa "+count+"	=> Nº comensales : "+mesa.getNComensales());
		}
		Scanner sc =new Scanner(System.in);
		System.out.println("seleciona mesa : ");
		count =sc.nextInt();
		
		return Libres.get(count);
	}
	public void mostrarReservas() {
		for (Reserva reserva : reservas) {
			System.out.println(reserva.toString());
		}
		
	}

}