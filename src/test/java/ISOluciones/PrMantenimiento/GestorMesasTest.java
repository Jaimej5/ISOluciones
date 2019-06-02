package ISOluciones.PrMantenimiento;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import aplicacion.GestorMesa;
import aplicacion.MesaRestaurante;
import aplicacion.Reserva;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class GestorMesasTest{
	
	private MesaRestaurante m;
	private MesaRestaurante m1;
	private MesaRestaurante m2;
	private MesaRestaurante m3;
	private MesaRestaurante m4;
	private GestorMesa gm;
	private Date fecha;
	private Reserva reserva;
	private ArrayList<MesaRestaurante> disponibles;
	
	@Before
	public void SetUP() throws ParseException {		
		String fechaR=  "2019/02/30 10:29:29";
		SimpleDateFormat formato = new  SimpleDateFormat ( "yyyy/MM/dd HH:mm:ss" );  
		fecha=formato.parse(fechaR);
		
		ArrayList<MesaRestaurante> ListaMesas =new ArrayList<MesaRestaurante>();
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
		reserva = new Reserva(m, 1, "Efrain", fecha, "comida");
		disponibles= new ArrayList<MesaRestaurante>();
	}
	
	
	
	@Test
	public void BuscarMesaNoExistenteTest() {
		MesaRestaurante mprueba=gm.buscarMesa(-5);	
		assertEquals(mprueba, null);
	}

	@Test
	public void BuscarMesaLimiteInferiorTest() {
		MesaRestaurante mprueba=gm.buscarMesa(0);
		assertEquals(mprueba, null);
	}

	@Test
	public void BuscarMesaLimite0() {
		MesaRestaurante mprueba=gm.buscarMesa(0);
		assertEquals(mprueba, null);
	}
	
	@Test
	public void BuscarMesaLimite1() {
		MesaRestaurante mprueba=gm.buscarMesa(1);
		assertEquals(mprueba, m);
	}
	
	@Test
	public void BuscarMesaLimite5() {
		MesaRestaurante mprueba=gm.buscarMesa(5);
		assertEquals(mprueba, m4);
	}
	
	@Test
	public void BuscarMesaFueraLimites() {
		MesaRestaurante mprueba=gm.buscarMesa(6);
		assertEquals(mprueba, null);
	}
	
	@Test
	public void BuscarMesaFueraLimitesMAX() {
		MesaRestaurante mprueba=gm.buscarMesa(200);
		assertEquals(mprueba, null);
	}
	
	@Test
	public void DisponiblesNingunaReservadaTest() {
		assertEquals(5, gm.disponibles().size());
	}
	
	@Test
	public void DisponiblesReservada1TurnoTest() {
		gm.hacerReserva(m, 1, "Efrain", fecha, "comida");
		assertEquals(5, gm.disponibles().size());
	}

	@Test
	public void DisponiblesReservadaUnTurnoTest() {
		gm.hacerReserva(m, 1, "Efrain", fecha, "cena");
		assertEquals(5, gm.disponibles().size());
	}

	@Test
	public void DisponiblesReservaCompletaTest() {
		gm.hacerReserva(m, 1, "Efrain", fecha, "comida");
		gm.hacerReserva(m, 2, "Jacobo", fecha, "cena");
		assertEquals(4, gm.disponibles().size());
	}
	
	@Test
	public void DisponiblesTodasReservadasTest() {
		gm.hacerReserva(m, 1, "Efrain", fecha, "comida");
		gm.hacerReserva(m, 2, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m1, 3, "Efrain", fecha, "comida");
		gm.hacerReserva(m1, 4, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m2, 5, "Efrain", fecha, "comida");
		gm.hacerReserva(m2, 6, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m3, 7, "Efrain", fecha, "comida");
		gm.hacerReserva(m3, 8, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m4, 9, "Efrain", fecha, "comida");
		gm.hacerReserva(m4, 10, "Jacobo", fecha, "cena");
		
		
		
		assertEquals(0, gm.disponibles().size());
	}
	
	@Test
	public void hacerReservaNingunaTest() {
		
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest1() {
		gm.hacerReserva(m, -5, "Efrain", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}

	@Test
	public void hacerReservaTest2() {
		gm.hacerReserva(m1, -5, "Jacobo", fecha, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest3() {
		gm.hacerReserva(m2, -5, "Eqqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", null, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest4() {
		gm.hacerReserva(m4, -5, "", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest5() {
		gm.hacerReserva(m4, -5, "a", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest6() {
		gm.hacerReserva(null, -5, "Jacobo", fecha, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}	
	
	@Test
	public void hacerReservaTest7() {
		gm.hacerReserva(m4, 4, "Efrain", fecha, "comida");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest8() {
		gm.hacerReserva(m2, 4, "Jacobo", fecha, "comida");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest9() {
		gm.hacerReserva(m1, 4, "", null, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest10() {
		gm.hacerReserva(m3, 4, "", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest11() {
		gm.hacerReserva(m, 4, "a", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest12() {
		gm.hacerReserva(null, 4, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest13() {
		gm.hacerReserva(m1, 6, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest14() {
		gm.hacerReserva(m4, 6, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest15() {
		gm.hacerReserva(m, 6, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest16() {
		gm.hacerReserva(m3, 6, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest17() {
		gm.hacerReserva(m2, 6, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest18() {
		gm.hacerReserva(null, 6, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest19() {
		gm.hacerReserva(m1, 2000, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest20() {
		gm.hacerReserva(m4, 2000, "Efrain", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest21() {
		gm.hacerReserva(m, 2000, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest22() {
		gm.hacerReserva(m3, 2000, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest23() {
		gm.hacerReserva(m3, 2000, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest24() {
		gm.hacerReserva(null, 2000, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest25() {
		gm.hacerReserva(m1, 0, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest26() {
		gm.hacerReserva(m4, 0, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest27() {
		gm.hacerReserva(m, 0, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest28() {
		gm.hacerReserva(m3, 0, "a", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest29() {
		gm.hacerReserva(m3, 0, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest30() {
		gm.hacerReserva(m2, 0, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, "null");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest31() {
		gm.hacerReserva(null, 0, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest32() {
		gm.hacerReserva(m1, 1, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest33() {
		gm.hacerReserva(m4, 1, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest34() {
		gm.hacerReserva(m, 1, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest35() {
		gm.hacerReserva(m3, 1, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest36() {
		gm.hacerReserva(m2, 1, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest37() {
		gm.hacerReserva(null, 1, "a", fecha, "cena");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest38() {
		gm.hacerReserva(m1, 5, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest39() {
		gm.hacerReserva(m4, 5, "Efrain", fecha, "cena");
		assertEquals(1, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest40() {
		gm.hacerReserva(m, 5, "", null, "comida");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest41() {
		gm.hacerReserva(m3, 5, "a", fecha, "desayuno");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest42() {
		gm.hacerReserva(m2, 5, "qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"Qqqqqwwwwweeeeerrrrrtt\"tttyyyyyuuuuuiiiiioooooppppph qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppph\r\n" + 
				"qqqqqwwwwweeeeerrrrrtttttyyyyyuuuuuiiiiioooooppppphg\r\n" + 
				"", fecha, null);
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTest43() {
		gm.hacerReserva(null, 5, "a", fecha, "fecha");
		assertEquals(0, gm.obtenerReservas().size());
	}
	
	@Test
	public void hacerReservaTestError() {
		gm.hacerReserva(m, 1, "Efrain", fecha, "comida");
		gm.hacerReserva(m, 2, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m1, 3, "Efrain", fecha, "comida");
		gm.hacerReserva(m1, 4, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m2, 5, "Efrain", fecha, "comida");
		gm.hacerReserva(m2, 6, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m3, 7, "Efrain", fecha, "comida");
		gm.hacerReserva(m3, 8, "Jacobo", fecha, "cena");
		
		gm.hacerReserva(m4, 9, "Efrain", fecha, "comida");
		gm.hacerReserva(m4, 10, "Jacobo", fecha, "cena");
		
	
		gm.hacerReserva(m, 11, "Efrain", fecha, "comida");
		
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