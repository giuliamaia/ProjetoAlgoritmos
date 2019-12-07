package sistema.controlador;

import sistema.beans.UsuarioTerraplanista;
import sistema.repositorios.RepositorioUsuariosTerraplanistas;

public class Controlador {
	private RepositorioUsuariosTerraplanistas repositorioUsuarioTerraPlanistas;
	
	
	public void adicionarUsuario(UsuarioTerraplanista usuario) {
		repositorioUsuarioTerraPlanistas.adicionarUsuario(usuario);
	}
	public void removerUsuario(UsuarioTerraplanista usuario) {
		repositorioUsuarioTerraPlanistas.removerUsuario(usuario);
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		repositorioUsuarioTerraPlanistas.editarUsuario(usuarioVelho, usuarioNovo);
	}
	static private Controlador instancia = new Controlador();
	static public Controlador getInstancia() {
		return instancia;
	}
	private Controlador () {
		repositorioUsuarioTerraPlanistas = new RepositorioUsuariosTerraplanistas();
	}
}
