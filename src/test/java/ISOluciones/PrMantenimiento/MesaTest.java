package ISOluciones.PrMantenimiento;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aplicacion.MesaRestaurante;

public class MesaTest{
	
	private MesaRestaurante m; 
	
	@Before
	public void setUp(){
		m= new MesaRestaurante(1,4);
	}
	
	@Test
	public void setTurnoComidaTest() {
		m.setTurno("comida");
		boolean esperado = true;
		assertEquals(m.isComida(), esperado);
	}
	
	@Test
	public void setTurnoCenaTest() {
		m.setTurno("cena");
		boolean esperado = true;
		assertEquals(m.isCena(), esperado);
	}
	
	@Test
	public void setTurnoErroneoTest() {
		m.setTurno("cualquiera");
		boolean esperado = false;
		assertEquals(m.isComida(), esperado);
	}
}
