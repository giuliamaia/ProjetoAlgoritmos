package sistema.repositorios;

import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Node;

import sistema.beans.Grafo;
import sistema.beans.UsuarioTerraplanista;

public class RepositorioUsuariosTerraplanistas {
	private List<UsuarioTerraplanista> usuarios = new ArrayList<UsuarioTerraplanista>();
	private Grafo grafo = Grafo.getInstancia();
	public void adicionarUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.add(usuario);
		grafo.addNode(usuario.getNome());
	}
	public void	removerUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.remove(usuario);
		grafo.removeNode(usuario.getNome());
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		usuarioVelho = usuarioNovo;
		Node no = grafo.getNode(usuarioVelho.getNome());
		no.setAttribute(usuarioVelho.getNome(), usuarioNovo.getNome());
	}
	
	public void pesquisarUsuario () {
		
	}
}
