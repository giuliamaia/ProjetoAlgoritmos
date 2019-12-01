package sistema.repositorios;

import java.util.List;

import sistema.beans.UsuarioTerraplanista;
import sistema.beans.UsuarioTerraplanistaException;

public class RepositorioUsuariosTerraplanistas {
	private List<UsuarioTerraplanista> usuarios;
	
	public void adicionarUsuario(UsuarioTerraplanista usuario) throws UsuarioTerraplanistaException {
		try {
			this.usuarios.add(usuario);
		}catch(NullPointerException e) {
			throw new UsuarioTerraplanistaException("Usuario não pode ser vazio!");
		}
		
	}
	public void	removerUsuario(UsuarioTerraplanista usuario) throws UsuarioTerraplanistaException {
		try {
			this.usuarios.remove(usuario);
		}catch(NullPointerException e) {
			throw new UsuarioTerraplanistaException("uat r u doing mannnnnnn!");
		}
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		usuarioVelho = usuarioNovo;
	}
}
