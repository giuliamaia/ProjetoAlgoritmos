package sistema.beans;

import java.net.MalformedURLException;
import sistema.controlador.Controlador;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		
		Controlador controlador = Controlador.getInstancia();
		Grafo grafo = Grafo.getInstancia();
		//controlador.adicionarUsuario(new UsuarioTerraplanista(null, "Reginaldo", "isnobb", "123", LocalDate.of(2001, 10, 04), null));
		for (int i = 0; i < controlador.getUsuarios().size(); i ++) {
			System.out.println(controlador.getUsuarios().get(i).getNome());
		}
	    grafo.display();

	}
}
