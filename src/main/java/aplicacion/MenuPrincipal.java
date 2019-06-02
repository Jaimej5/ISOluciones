package aplicacion;

final class MenuPrincipal {


private MenuPrincipal()
{
    throw new AssertionError("Instantiating utility class...");

}
public static void main(final String[] args) {
	final Restaurante restaurante = new Restaurante();
	restaurante.menu();
}


}