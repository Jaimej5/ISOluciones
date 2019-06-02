package ISOluciones.PrMantenimiento;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import ISOluciones.PrTesting.GestorMesa;
import ISOluciones.PrTesting.Mesa;
import ISOluciones.PrTesting.Reserva;

public class GestorMesasTest{
	private Reserva r;
	private Mesa m;
	private Mesa m1;
	private Mesa m2;
	private Mesa m3;
	private Mesa m4;
	private GestorMesa gm;
	private Date fecha;
	private Reserva reserva;
	private ArrayList<Mesa> disponibles;
	
	@Before
	public void SetUP() throws ParseException {		
		String fechaR=  "2019/02/30 10:29:29";
		SimpleDateFormat formato = new  SimpleDateFormat ( "yyyy/MM/dd HH:mm:ss" );  
		fecha=formato.parse(fechaR);
		
		ArrayList<Mesa> ListaMesas =new ArrayList<Mesa>();
		m1 = new Mesa(2,5);
		m2 = new Mesa(3,5);
		m3 = new Mesa(4,5);
		m4= new Mesa(5,5);
		
		m=new Mesa(1,4);
		ListaMesas.add(m);
		ListaMesas.add(m1);
		ListaMesas.add(m2);
		ListaMesas.add(m3);
		ListaMesas.add(m4);
		gm = new GestorMesa(ListaMesas);
		reserva = new Reserva(m, 1, "Efrain", fecha, "comida");
		disponibles= new ArrayList<Mesa>();
	}
	
	
	
	@Test
	public void BuscarMesaNoExistenteTest() {
		Mesa mprueba=gm.buscar_mesa(-5);	
		assertEquals(mprueba, null);
	}

	@Test
	public void BuscarMesaLimiteInferiorTest() {
		Mesa mprueba=gm.buscar_mesa(0);
		assertEquals(mprueba, null);
	}

	@Test
	public void BuscarMesaLimite0() {
		Mesa mprueba=gm.buscar_mesa(0);
		assertEquals(mprueba, null);
	}
	
	@Test
	public void BuscarMesaLimite1() {
		Mesa mprueba=gm.buscar_mesa(1);
		assertEquals(mprueba, m);
	}
	
	@Test
	public void BuscarMesaLimite5() {
		Mesa mprueba=gm.buscar_mesa(5);
		assertEquals(mprueba, m4);
	}
	
	@Test
	public void BuscarMesaFueraLimites() {
		Mesa mprueba=gm.buscar_mesa(6);
		assertEquals(mprueba, null);
	}
	
	@Test
	public void BuscarMesaFueraLimitesMAX() {
		Mesa mprueba=gm.buscar_mesa(200);
		assertEquals(mprueba, null);
	}
	
	@Test
	public void DisponiblesNingunaReservadaTest() {
		assertEquals(5, gm.Disponibles().size());
	}
	
	@Test
	public void DisponiblesReservada1TurnoTest() {
		gm.HacerReserva(m, 1, "Efrain", fecha, "comida");
		assertEquals(5, gm.Disponibles().size());
	}

	@Test
	public void DisponiblesReservadaUnTurnoTest() {
		gm.HacerReserva(m, 1, "Efrain", fecha, "cena");
		assertEquals(5, gm.Disponibles().size());
	}

	@Test
	public void DisponiblesReservaCompletaTest() {
		gm.HacerReserva(m, 1, "Efrain", fecha, "comida");
		gm.HacerReserva(m, 2, "Jacobo", fecha, "cena");
		assertEquals(4, gm.Disponibles().size());
	}
	
	@Test
	public void DisponiblesTodasReservadasTest() {
		gm.HacerReserva(m, 1, "Efrain", fecha, "comida");
		gm.HacerReserva(m, 2, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m1, 3, "Efrain", fecha, "comida");
		gm.HacerReserva(m1, 4, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m2, 5, "Efrain", fecha, "comida");
		gm.HacerReserva(m2, 6, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m3, 7, "Efrain", fecha, "comida");
		gm.HacerReserva(m3, 8, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m4, 9, "Efrain", fecha, "comida");
		gm.HacerReserva(m4, 10, "Jacobo", fecha, "cena");
		
		
		
		assertEquals(0, gm.Disponibles().size());
	}
	
	@Test
	public void HacerReservaNingunaTest() {
		
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest1() {
		gm.HacerReserva(m, -5, "Efrain", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}

	@Test
	public void HacerReservaTest2() {
		gm.HacerReserva(m1, -5, "Jacobo", fecha, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest3() {
		gm.HacerReserva(m2, -5, "Eqqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", null, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest4() {
		gm.HacerReserva(m4, -5, "", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest5() {
		gm.HacerReserva(m4, -5, "a", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest6() {
		gm.HacerReserva(null, -5, "Jacobo", fecha, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}	
	
	@Test
	public void HacerReservaTest7() {
		gm.HacerReserva(m4, 4, "Efrain", fecha, "comida");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest8() {
		gm.HacerReserva(m2, 4, "Jacobo", fecha, "comida");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest9() {
		gm.HacerReserva(m1, 4, "", null, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest10() {
		gm.HacerReserva(m3, 4, "", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest11() {
		gm.HacerReserva(m, 4, "a", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest12() {
		gm.HacerReserva(null, 4, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest13() {
		gm.HacerReserva(m1, 6, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest14() {
		gm.HacerReserva(m4, 6, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest15() {
		gm.HacerReserva(m, 6, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest16() {
		gm.HacerReserva(m3, 6, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest17() {
		gm.HacerReserva(m2, 6, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest18() {
		gm.HacerReserva(null, 6, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest19() {
		gm.HacerReserva(m1, 2000, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest20() {
		gm.HacerReserva(m4, 2000, "Efrain", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest21() {
		gm.HacerReserva(m, 2000, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest22() {
		gm.HacerReserva(m3, 2000, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest23() {
		gm.HacerReserva(m3, 2000, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest24() {
		gm.HacerReserva(null, 2000, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest25() {
		gm.HacerReserva(m1, 0, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest26() {
		gm.HacerReserva(m4, 0, "Efrain", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest27() {
		gm.HacerReserva(m, 0, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest28() {
		gm.HacerReserva(m3, 0, "a", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest29() {
		gm.HacerReserva(m3, 0, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest30() {
		gm.HacerReserva(m2, 0, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "null");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest31() {
		gm.HacerReserva(null, 0, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest32() {
		gm.HacerReserva(m1, 1, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest33() {
		gm.HacerReserva(m4, 1, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest34() {
		gm.HacerReserva(m, 1, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest35() {
		gm.HacerReserva(m3, 1, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest36() {
		gm.HacerReserva(m2, 1, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest37() {
		gm.HacerReserva(null, 1, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest38() {
		gm.HacerReserva(m1, 5, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest39() {
		gm.HacerReserva(m4, 5, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest40() {
		gm.HacerReserva(m, 5, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest41() {
		gm.HacerReserva(m3, 5, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest42() {
		gm.HacerReserva(m2, 5, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTest43() {
		gm.HacerReserva(null, 5, "a", fecha, "fecha");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void HacerReservaTestError() {
		gm.HacerReserva(m, 1, "Efrain", fecha, "comida");
		gm.HacerReserva(m, 2, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m1, 3, "Efrain", fecha, "comida");
		gm.HacerReserva(m1, 4, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m2, 5, "Efrain", fecha, "comida");
		gm.HacerReserva(m2, 6, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m3, 7, "Efrain", fecha, "comida");
		gm.HacerReserva(m3, 8, "Jacobo", fecha, "cena");
		
		gm.HacerReserva(m4, 9, "Efrain", fecha, "comida");
		gm.HacerReserva(m4, 10, "Jacobo", fecha, "cena");
		
	
		gm.HacerReserva(m, 11, "Efrain", fecha, "comida");
		
		assertEquals(10, gm.obtenerReservas().size());
	}
	@Test
	public void comprobarDisponibilidadTest() {
		assertEquals(false,gm.comprobarDisponible(null, null) );
	}
	@Test
	public void comprobarDisponibilidadTest2() {
		assertEquals(false,gm.comprobarDisponible(null, reserva) );
	}
	@Test
	public void comprobarDisponibilidadTest3() {
		disponibles.add(m);
		assertEquals(false,gm.comprobarDisponible(disponibles, null) );
	}
	@Test
	public void comprobarDisponibilidadTest4() {
		disponibles.add(m);
		assertEquals(true,gm.comprobarDisponible(disponibles, reserva) );
	}
	@Test
	public void comprobarDisponibilidadTest5() {
		disponibles.add(m);
		disponibles.add(m1);
		disponibles.add(m2);
		disponibles.add(m3);
		disponibles.add(m4);
		assertEquals(false,gm.comprobarDisponible(disponibles, null) );
	}
	@Test
	public void comprobarDisponibilidadTest6() {
		disponibles.add(m);
		disponibles.add(m1);
		disponibles.add(m2);
		disponibles.add(m3);
		disponibles.add(m4);
		assertEquals(true,gm.comprobarDisponible(disponibles, reserva) );
	}
	@Test
	public void comprobarDisponibilidadTest7() {
		
		assertEquals(false,gm.comprobarDisponible(disponibles, null) );
	}
	@Test
	public void comprobarDisponibilidadTest8() {
		assertEquals(false,gm.comprobarDisponible(disponibles, reserva) );
	}
	@Test
	public void comprobarDisponibilidadTest9() {
		disponibles.add(m);
		disponibles.add(m1);
		disponibles.add(m2);
		disponibles.add(m3);
		disponibles.add(m4);
		disponibles.add(m4);
		assertEquals(false,gm.comprobarDisponible(disponibles, null) );
	}
	@Test
	public void comprobarDisponibilidadTest10() {
		disponibles.add(m);
		disponibles.add(m1);
		disponibles.add(m2);
		disponibles.add(m3);
		disponibles.add(m4);
		disponibles.add(m4);
		assertEquals(true,gm.comprobarDisponible(disponibles, reserva) );
	}
}
