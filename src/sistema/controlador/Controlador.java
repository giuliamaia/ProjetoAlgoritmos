package sistema.controlador;

public class Controlador {
	static private Controlador instancia = new Controlador();
	static public Controlador getInstancia() {
		return instancia;
	}
	private Controlador () {
		
	}
}
