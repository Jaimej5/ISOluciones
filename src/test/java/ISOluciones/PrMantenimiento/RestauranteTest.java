package ISOluciones.PrMantenimiento;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import aplicacion.GestorMesa;
import aplicacion.MesaRestaurante;
import aplicacion.Reserva;
import aplicacion.Restaurante;

public class RestauranteTest {
	
	private MesaRestaurante m;
	private MesaRestaurante m1;
	private MesaRestaurante m2;
	private MesaRestaurante m3;
	private MesaRestaurante m4;
	private GestorMesa gm;
	private ArrayList<MesaRestaurante> ListaMesas;
	
	@Before
	public void SetUP() throws ParseException {		
		
		ListaMesas=new ArrayList<MesaRestaurante>();
		m1 = new MesaRestaurante(2,5);
		m2 = new MesaRestaurante(3,5);
		m3 = new MesaRestaurante(4,5);
		m4= new MesaRestaurante(5,5);
		
		m=new MesaRestaurante(1,4);
		ListaMesas.add(m);
		ListaMesas.add(m1);
		ListaMesas.add(m2);
		ListaMesas.add(m3);
		ListaMesas.add(m4);
		gm = new GestorMesa(ListaMesas);
		
	}
	
	@Test
	public void opcionReservarTest() {
		Restaurante restaurantes=new Restaurante();
		
	}
}
