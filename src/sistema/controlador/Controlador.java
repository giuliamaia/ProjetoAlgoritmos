package sistema.controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import sistema.beans.UsuarioTerraplanista;
import sistema.repositorios.RepositorioUsuariosTerraplanistas;

public class Controlador {
	private RepositorioUsuariosTerraplanistas repositorioUsuarioTerraPlanistas = new RepositorioUsuariosTerraplanistas();

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
	static private Controlador instancia = new Controlador();
	static public Controlador getInstancia() {
		return instancia;
	}
	private Controlador () {
		
	}
	
}
