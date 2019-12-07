package sistema.beans;

import java.net.MalformedURLException;
import java.time.LocalDate;

import sistema.controlador.Controlador;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		
		Controlador controlador = Controlador.getInstancia();
		Grafo grafo = Grafo.getInstancia();
		UsuarioTerraplanista user2 = new UsuarioTerraplanista(null, "Tiranossauro", "Advinha", "123", LocalDate.of(2001, 10, 04), null);
		
		UsuarioTerraplanista user1 = new UsuarioTerraplanista(null, "Regialdin", "Ademir", "123", LocalDate.of(2001, 10, 04), null);
		controlador.adicionarUsuario(user1);
		controlador.adicionarUsuario(user2);
		user1.addAmigo(user2);
		for (int i = 0; i < controlador.getUsuarios().size(); i ++) {
			System.out.println(controlador.getUsuarios().get(i).getNome());
		}
	    grafo.display();

	}
}
