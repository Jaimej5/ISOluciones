package aplicacion;


public class MesaRestaurante {

	private int idMesa;
	private Estado estado;
	private int nComensales;
	private boolean comida;
	private boolean cena;

	
	public MesaRestaurante(final int idMesa ,final int nComensales) {
		this.idMesa=idMesa;
		this.nComensales=nComensales;
		this.estado=Estado.LIBRE;
		this.comida=false;
		this.cena=false;
	}
	
	
	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(final int idMesa) {
		this.idMesa=idMesa;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(final String estadoMesa) {
		estado = Estado.RESERVADA;
	}
	
	public int getNComensales() {
	return nComensales;
	}

	public void setNComensales(final int nComensales) {
		this.nComensales=nComensales;
	}
	
	public boolean isComida() {
		return comida;
	}
	
	public void setTurno(final String turno) {
		if("comida".equals(turno)) {
			comida=true;
		}else if("cena".equals(turno)) {
			cena=true;
		}
	}
	
	public boolean isCena() {
		return cena;
	}

	
	public String toString(){
		return "\nId Mesa: "+idMesa+"\nNº de comensales: "+nComensales+"\nEstado: "+this.estado+"\n";
	}

}