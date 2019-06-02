package aplicacion;

import java.util.Date;


public class Reserva {

	final private int idReserva;
	final private MesaRestaurante mesaRestaurante;
	final private String nombreReserva;
	final private Date fecha;
	private String turnos;

	public MesaRestaurante getMesa() {
		return mesaRestaurante;
	}

	/**
	 * 
	 * @param mesaRestaurante
	 */
	public void setMesa(final int mesaRestaurante) {
		// TODO - implement Reserva.setMesa
		throw new UnsupportedOperationException();
	}

	public int getID() {
		// TODO - implement Reserva.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idReserva
	 */
	public void setID(final int idReserva) {
		// TODO - implement Reserva.setID
		throw new UnsupportedOperationException();
	}

	public String getNombreReserva() {
		// TODO - implement Reserva.getNombreReserva
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombreReserva
	 */
	public void setNombreReserva(final int nombreReserva) {
		// TODO - implement Reserva.setNombreReserva
		throw new UnsupportedOperationException();
	}

	public void getHora() {
		// TODO - implement Reserva.getHora
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param hora
	 */
	public void setHora(final int hora) {
		// TODO - implement Reserva.setHora
		throw new UnsupportedOperationException();
	}
	
	
	
	public String getTurnos() {
		return turnos;
	}

	public void setTurnos(final String turnos) {
		this.turnos = turnos;
	}

	public Reserva(final MesaRestaurante mesaRestaurante,final int idReserva,final String nombreReserva,final Date fecha,final String turno) {
		this.mesaRestaurante=mesaRestaurante;
		this.idReserva=idReserva;
		this.nombreReserva=nombreReserva;
		this.fecha=(Date) fecha.clone();
		this.turnos=turno;
		
		
		
		// TODO - implement Reserva.Reserva
		
	}
	public String toString() {
		return "ID Reserva:"+idReserva+", Mesa:" + mesaRestaurante.getIdMesa()  + ", NombreReserva:" + nombreReserva + ", Fecha Reserva:" + fecha+", Turno: "+turnos;
	}

}