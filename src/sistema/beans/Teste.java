package sistema.beans;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import sistema.controlador.Controlador;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		
		Controlador controlador = Controlador.getInstancia();
		Grafo grafo = Grafo.getInstancia();
		UsuarioTerraplanista usuario = new UsuarioTerraplanista(new ArrayList<UsuarioTerraplanista>(), new ArrayList<String>(), "Rodrigues", "RODROD", "123", LocalDate.of(2001, 04, 07), LocalDateTime.now(), "", 15, true);
	    grafo.display();

	}
}
