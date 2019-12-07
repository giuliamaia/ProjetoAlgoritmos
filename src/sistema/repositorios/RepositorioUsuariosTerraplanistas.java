package sistema.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Node;

import sistema.beans.Grafo;
import sistema.beans.UsuarioTerraplanista;

public class RepositorioUsuariosTerraplanistas implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<UsuarioTerraplanista> usuarios = new ArrayList<UsuarioTerraplanista>();
	private Grafo grafo = Grafo.getInstancia();
	public void adicionarUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.add(usuario);
		grafo.addNode(usuario.getNome());
		Node no = grafo.getNode(usuario.getNome());
		no.addAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #e09410; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
		no.addAttribute("ui.label", usuario.getNome());
	}
	public void	removerUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.remove(usuario);
		grafo.removeNode(usuario.getNome());
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		usuarioVelho = usuarioNovo;
	}
}
