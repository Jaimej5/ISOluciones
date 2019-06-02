package aplicacion;

public class Bebidas {

	private int idBebida;
	private String nombre;
	private float precio;
	private int cantidad;

	public Bebidas(final int idBebida, final String nombre, final float precio,final int cantidad) {
		this.idBebida=idBebida;
		this.nombre=nombre;
		this.precio=precio;
		this.cantidad=cantidad;
	}

	public int getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(final int idBebida) {
		this.idBebida = idBebida;
	}

	public String getombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre=nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(final float precio) {
		this.precio=precio;
	}

	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(final int cantidad) {
		this.cantidad=cantidad;
	}

}