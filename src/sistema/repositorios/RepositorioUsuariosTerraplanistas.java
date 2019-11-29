package sistema.repositorios;

import java.util.List;

import sistema.beans.UsuarioTerraplanista;

public class RepositorioUsuariosTerraplanistas {
	private List<UsuarioTerraplanista> usuarios;
	
	public void adicionarUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.add(usuario);
	}
	public void	removerUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.remove(usuario);
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		usuarioVelho = usuarioNovo;
	}
}
