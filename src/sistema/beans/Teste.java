package sistema.beans;

import java.net.MalformedURLException;
import java.time.LocalDate;
import sistema.controlador.Controlador;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		Controlador controlador = Controlador.getInstancia();
		Grafo grafo = Grafo.getInstancia();
		controlador.adicionarUsuario(new UsuarioTerraplanista(null, "Isntyou", "isnobb", "123", LocalDate.of(2001, 10, 04), null));
	    grafo.display();

	}
}
