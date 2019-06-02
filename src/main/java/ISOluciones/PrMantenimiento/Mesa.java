package ISOluciones.PrMantenimiento;

public class Mesa {

	private int ID;
	private Estado estado;
	private int NComensales;
	private boolean comida;
	private boolean cena;

	public Mesa(int ID, int NComensales) {
		// TODO - implement Mesa.Mesa
		this.ID = ID;
		this.NComensales = NComensales;
		this.estado = Estado.LIBRE;
		this.comida = false;
		this.cena = false;
	}

	public int getID() {
		// TODO - implement Mesa.getID
		return ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Mesa.setID
		throw new UnsupportedOperationException();
	}

	public Estado getEstado() {
		// TODO - implement Mesa.getEstado
		return estado;
	}

	/**
	 * 
	 * @param Estado
	 */
	public void setEstado(String e) {
		// TODO - implement Mesa.setEstado
		estado = Estado.RESERVADA;
	}

	public int getNComensales() {
		return NComensales;
	}

	/**
	 * 
	 * @param NComensales
	 */
	public void setNComensales(int NComensales) {
		// TODO - implement Mesa.setNComensales
		throw new UnsupportedOperationException();
	}

	public boolean getComida() {
		return comida;
	}

	public void setTurno(String turno){
		try{
			if(turno.equals("comida")) {
				comida=true;
			}else if(turno.equals("cena")) {
				cena=true;
			}
		}catch(NullPointerException e) {
			turno="";
		}
	}

	public boolean getCena() {
		return cena;
	}

	public String toString() {
		return "\nId Mesa: " + ID + "\nNº de comensales: " + NComensales + "\nEstado: " + this.estado + "\n";
	}

}