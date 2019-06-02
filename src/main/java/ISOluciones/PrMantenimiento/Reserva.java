package ISOluciones.PrMantenimiento;

import java.util.Date;


public class Reserva {

	private int ID;
	private Mesa Mesa;
	private String NombreReserva;
	private Date fecha;
	private String Turnos;

	public Mesa getMesa() {
		return Mesa;
	}

	/**
	 * 
	 * @param Mesa
	 */
	public void setMesa(int Mesa) {
		// TODO - implement Reserva.setMesa
		throw new UnsupportedOperationException();
	}

	public int getID() {
		// TODO - implement Reserva.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Reserva.setID
		throw new UnsupportedOperationException();
	}

	public String getNombreReserva() {
		// TODO - implement Reserva.getNombreReserva
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param NombreReserva
	 */
	public void setNombreReserva(int NombreReserva) {
		// TODO - implement Reserva.setNombreReserva
		throw new UnsupportedOperationException();
	}

	public void getHora() {
		// TODO - implement Reserva.getHora
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Hora
	 */
	public void setHora(int Hora) {
		// TODO - implement Reserva.setHora
		throw new UnsupportedOperationException();
	}
	
	
	
	public String getTurnos() {
		return Turnos;
	}

	public void setTurnos(String turnos) {
		Turnos = turnos;
	}

	public Reserva(Mesa Mesa, int ID,String NombreReserva,Date fecha,String turno) {
		this.Mesa=Mesa;
		this.ID=ID;
		this.NombreReserva=NombreReserva;
		this.fecha=fecha;
		this.Turnos=turno;
		
		
		
		// TODO - implement Reserva.Reserva
		
	}
	public String toString() {
		return "ID Reserva:"+ID+", Mesa:" + Mesa.getID()  + ", NombreReserva:" + NombreReserva + ", Fecha Reserva:" + fecha+", Turno: "+Turnos;
	}

}