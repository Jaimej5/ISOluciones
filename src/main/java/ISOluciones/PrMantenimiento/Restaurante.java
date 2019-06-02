package ISOluciones.PrMantenimiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Restaurante {
	private static Scanner leer = new Scanner(System.in);

	public void menu() {

		System.out.println("¡Bienvenido al restaurante ComeyCalla!\n");
		int opcion;
		boolean repetir = true;
		final ArrayList<Mesa> ListaMesas = new ArrayList<Mesa>();
		final Mesa mesa = new Mesa(1, 4);
		final Mesa mesa1 = new Mesa(2, 4);
		final Mesa mesa2 = new Mesa(3, 2);
		final Mesa mesa3 = new Mesa(4, 4);
		final Mesa mesa4 = new Mesa(5, 2);
		final Mesa mesa5 = new Mesa(6, 6);
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

	public static void opcionReservar(final GestorMesa gestorMesa, final ArrayList<Mesa> listaMesas) {
		Mesa mesa;
		System.out.println("Estas son las mesas del restaurante:");
		System.out.println(gestorMesa.Disponibles());
		final int Nreservas = gestorMesa.Nreservas();
		int idmesa;
		System.out.println("Seleccione la mesa que desea:");
		idmesa = leer.nextInt();
		mesa = gestorMesa.buscar_mesa(idmesa);
		while (mesa == null) {
			System.out.println("Esta mesa no existe, introduzca el ID de la mesa otra vez");
			idmesa = leer.nextInt();
			mesa = gestorMesa.buscar_mesa(idmesa);
		}
		while (mesa.getComida() && mesa.getCena()) {
			System.out.println("Mesa ya reservada para comida y cena, las mesas Disponibles son:");
			System.out.println(gestorMesa.Disponibles());
			idmesa = leer.nextInt();
			mesa = gestorMesa.buscar_mesa(idmesa);
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
		while ("comida".equals(turno) && mesa.getComida()|| "cena".equals(turno) && mesa.getCena()) {
			System.out.println("Ésta mesa ya esta reservada pare el turno de " + turno + " introduzcalo de nuevo");
			turno = leer.next();
		}
		gestorMesa.HacerReserva(mesa, Nreservas, nombre, fecha, turno);
	}

	public static void opcionMostrarReservas(final GestorMesa gestorMesa) {
		gestorMesa.mostrarReservas();
	}
}