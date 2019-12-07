package sistema.controlador;

import java.io.IOException;
import java.util.List;

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
	public List<UsuarioTerraplanista> getUsuarios() {
		return repositorioUsuarioTerraPlanistas.getUsuarios();
	}
	public void salvar() {
		repositorioUsuarioTerraPlanistas.salvar();
	}
	public void carregar() throws IOException, ClassNotFoundException {
		repositorioUsuarioTerraPlanistas.carregar();
	}
	static private Controlador instancia = null;
	static public Controlador getInstancia() {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}
	private Controlador () {
		repositorioUsuarioTerraPlanistas = new RepositorioUsuariosTerraplanistas();
	}
	
}
