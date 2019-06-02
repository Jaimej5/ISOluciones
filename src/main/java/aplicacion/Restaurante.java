package aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Restaurante {
	private static Scanner leer = new Scanner(System.in,"UTF-8");

	public void menu() {

		System.out.println("¡Bienvenido al restaurante ComeyCalla!\n");
		int opcion;
		boolean repetir = true;
		final ArrayList<MesaRestaurante> ListaMesas = new ArrayList<MesaRestaurante>();
		final MesaRestaurante mesa = new MesaRestaurante(1, 4);
		final MesaRestaurante mesa1 = new MesaRestaurante(2, 4);
		final MesaRestaurante mesa2 = new MesaRestaurante(3, 2);
		final MesaRestaurante mesa3 = new MesaRestaurante(4, 4);
		final MesaRestaurante mesa4 = new MesaRestaurante(5, 2);
		final MesaRestaurante mesa5 = new MesaRestaurante(6, 6);
		ListaMesas.add(mesa);
		ListaMesas.add(mesa1);
		ListaMesas.add(mesa2);
		ListaMesas.add(mesa3);
		ListaMesas.add(mesa4);
		ListaMesas.add(mesa5);

		final GestorMesa gestorMesa = new GestorMesa(ListaMesas);
		do {
			opcion = opcionMenu();
			switch (opcion) {
			case 1:
				opcionReservar(gestorMesa, ListaMesas);
				break;

			case 2:
				opcionMostrarReservas(gestorMesa);
				break;

			case 3:
				System.out.println("Ha salido del programa");
				repetir = false;
				break;

			default:
				System.out.println("Opción no válida, inténtelo de nuevo");
				repetir = true;
				break;
			}
		} while (repetir);
	}

	public static int opcionMenu() {
		String opcion = null;
		boolean correcto = true;
		int numero = 0;
		do {
			try {
				System.out.println("¿Qué quieres hacer?\n1-  Hacer reserva\n2-  Mostrar reservas\n3-  Salir");
				opcion = leer.next();
				numero = Integer.parseInt(opcion);
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un numero entero para la opcion del menú");
				correcto = false;
			}
		} while (!correcto);
		return numero;
	}

	public static void opcionReservar(final GestorMesa gestorMesa, final ArrayList<MesaRestaurante> listaMesas) {
		MesaRestaurante mesa;
		System.out.println("Estas son las mesas del restaurante:");
		System.out.println(gestorMesa.disponibles());
		final int nReservas = gestorMesa.nreservas();
		int idmesa;
		System.out.println("Seleccione la mesa que desea:");
		idmesa = leer.nextInt();
		mesa = gestorMesa.buscarMesa(idmesa);
		while (mesa == null) {
			System.out.println("Esta mesa no existe, introduzca el ID de la mesa otra vez");
			idmesa = leer.nextInt();
			mesa = gestorMesa.buscarMesa(idmesa);
		}
		while (mesa.isComida() && mesa.isCena()) {
			System.out.println("Mesa ya reservada para comida y cena, las mesas disponibles son:");
			System.out.println(gestorMesa.disponibles());
			idmesa = leer.nextInt();
			mesa = gestorMesa.buscarMesa(idmesa);
		}
		String nombre;
		System.out.println("¿A nombre de quién quiere poner la reserva?");
		nombre = leer.next();
		final Date fecha = new Date();
		String turno;
		System.out.println("Seleccione el turno (comida o cena)");
		turno = leer.next();
		while (!"comida".equals(turno) && !"cena".equals(turno)) {
			System.out.println("Turno inválido, introduzca de nuevo");
			turno = leer.next();
		}
		while ("comida".equals(turno) && mesa.isComida()|| "cena".equals(turno) && mesa.isCena()) {
			System.out.println("Ésta mesa ya esta reservada pare el turno de " + turno + " introduzcalo de nuevo");
			turno = leer.next();
		}
		gestorMesa.hacerReserva(mesa, nReservas, nombre, fecha, turno);
	}

	public static void opcionMostrarReservas(final GestorMesa gestorMesa) {
		gestorMesa.mostrarReservas();
	}
}
