package sistema.controlador;

import sistema.repositorios.RepositorioUsuariosTerraplanistas;

public class Controlador {
	private RepositorioUsuariosTerraplanistas repositorioUsuarioTerraPlanistas;
	
	
	static private Controlador instancia = new Controlador();
	static public Controlador getInstancia() {
		return instancia;
	}
	private Controlador () {
		repositorioUsuarioTerraPlanistas = new RepositorioUsuariosTerraplanistas();
	}
}
