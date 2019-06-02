package aplicacion;
import java.util.ArrayList;
import java.util.Date;


public class GestorMesa {

	final private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<MesaRestaurante> listaMesas =new ArrayList<MesaRestaurante>();
	
	public GestorMesa(final ArrayList<MesaRestaurante> listaMesas) {
			this.listaMesas=listaMesas;
	}
	 
	public void hacerReserva(final MesaRestaurante mesa,final int idReserva,final String Nombre,final Date fecha,final String turno) {
		// TODO - implement GestorMesa.HacerReserva
		try {
			if(idReserva>=0 && fecha != null && Nombre.length()>0 && idReserva<= listaMesas.size()*2) {
			final Reserva reserva=new Reserva(mesa,idReserva,Nombre,fecha,turno);
			if(comprobarDisponible(disponibles(), reserva)) {
				mesa.setEstado("");
				mesa.setTurno(turno);
				System.out.println("\nRESERVA\n-------\n"+reserva.toString()+"\n");
				reservas.add(reserva);
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean comprobarDisponible(final ArrayList<MesaRestaurante> disponibles,final Reserva reserva) {
		boolean disponible=false;
		try {
			for (final MesaRestaurante mesa : disponibles) {
				
				if(mesa.getIdMesa()==reserva.getMesa().getIdMesa() && (!mesa.isCena() && reserva.getTurnos().equals("cena")  || !mesa.isComida() && reserva.getTurnos().equals("comida"))){
					disponible=true;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return disponible;
	}
	public ArrayList<Reserva> obtenerReservas() {
		return reservas;
	}
	
	public void asignarMesa() {
		// TODO - implement GestorMesa.AsignarMesa
		throw new UnsupportedOperationException();
	}
	public int nreservas() {
		return reservas.size();
	}

	public void cancelarReserva() {
		// TODO - implement GestorMesa.CancelarReserva
		throw new UnsupportedOperationException();
	}
	
	public ArrayList<MesaRestaurante> disponibles() {
		final ArrayList<MesaRestaurante> libres =new ArrayList<MesaRestaurante>();
		for (final MesaRestaurante mesa : listaMesas) {
			if(!mesa.isComida()||!mesa.isCena()) {	
				libres.add(mesa);
			}
		}
		return libres;
	}
	
	public void mostrarReservas() {
		if (!reservas.isEmpty()){
			System.out.println("LISTA DE RESERVAS\n-----------------\n");
			for (final Reserva reserva : reservas) {
				System.out.println(reserva.toString());
			}
			System.out.println("");
		}
	}
	
	public MesaRestaurante buscarMesa(final int idMesa) {
		MesaRestaurante mesaPrueba=null;
		for(final MesaRestaurante mesaRestaurante:this.listaMesas){
			if(mesaRestaurante.getIdMesa()==idMesa){
				mesaPrueba=mesaRestaurante;
			}
		}
		return mesaPrueba;
	}

}