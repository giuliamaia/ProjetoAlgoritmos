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
	
	
	public ArrayList<UsuarioTerraplanista> pesquisarPorNome(String nome) {
		nome = nome.toUpperCase();
		ArrayList<UsuarioTerraplanista> ret = new ArrayList<UsuarioTerraplanista>();
		//essa parte aqui é só pra testar se ta funcionando, lembrar de excluir depois:
		/*ArrayList<UsuarioTerraplanista> lista = new ArrayList<UsuarioTerraplanista>();
		UsuarioTerraplanista fulano = new UsuarioTerraplanista("fulano");
		UsuarioTerraplanista beltrano = new UsuarioTerraplanista("beltrano");
		UsuarioTerraplanista ciclano = new UsuarioTerraplanista("ciclano");
		lista.add(fulano);
		lista.add(ciclano);
		lista.add(beltrano);
		*/
		if (nome == null)
			return null;
		
		// no teste trocar esse for e no lugar de this.usuarios colocar lista
		for (UsuarioTerraplanista user : this.usuarios) {
			if (user.getNome().toUpperCase().contains(nome)) {
				ret.add(user);
			}
		}
		return ret;
	}
	
	 public ArrayList<UsuarioTerraplanista> pesquisarPorLogin(String login) {
		 login = login.toUpperCase();
			ArrayList<UsuarioTerraplanista> ret = new ArrayList<UsuarioTerraplanista>();
			
			if (login == null)
				return null;

			for (UsuarioTerraplanista user : this.usuarios) {
				if (user.getLogin().toUpperCase().contains(login)) {
					ret.add(user);
				}
			}
			return ret; 
	 }
}
