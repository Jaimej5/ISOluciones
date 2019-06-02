package ISOluciones.PrMantenimiento;

import ISOluciones.PrMantenimiento.Mesa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MesaTest {

	private Mesa m;

	@Before
	public void setUp() {
		m = new Mesa(1, 4);
	}

	@Test
	public void setTurnoComidaTest() {
		m.setTurno("comida");
		boolean esperado = true;
		assertEquals(m.getComida(), esperado);
	}

	@Test
	public void setTurnoCenaTest() {
		m.setTurno("cena");
		boolean esperado = true;
		assertEquals(m.getCena(), esperado);
	}
	
	@Test
	public void setTurnoErroneoTest() {
		m.setTurno("cualquiera");
		boolean esperado = false;
		assertEquals(m.getComida(), esperado);
	}

	@Test
	public void setTurnoNullTest() {
		m.setTurno(null);
		boolean esperado = false;
		assertEquals(m.getComida(), esperado);
	}

}
