package sistema.repositorios;

<<<<<<< HEAD
=======
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
>>>>>>> refs/remotes/origin/Rodrigues
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Node;

import sistema.beans.Grafo;
import sistema.beans.UsuarioTerraplanista;

<<<<<<< HEAD
public class RepositorioUsuariosTerraplanistas implements Serializable{
	private static final long serialVersionUID = 1L;
=======
public class RepositorioUsuariosTerraplanistas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 132234234L;
>>>>>>> refs/remotes/origin/Rodrigues
	private List<UsuarioTerraplanista> usuarios = new ArrayList<UsuarioTerraplanista>();
	public List<UsuarioTerraplanista> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioTerraplanista> usuarios) {
		this.usuarios = usuarios;
	}


	private Grafo grafo = Grafo.getInstancia();
	public void adicionarUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.add(usuario);
<<<<<<< HEAD
		grafo.addNode(usuario.getNome());
		Node no = grafo.getNode(usuario.getNome());
		no.addAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #e09410; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
		no.addAttribute("ui.label", usuario.getNome());
=======
		salvar();
>>>>>>> refs/remotes/origin/Rodrigues
	}
	public void	removerUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.remove(usuario);
		salvar();
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		usuarioVelho = usuarioNovo;
<<<<<<< HEAD
=======
		salvar();
>>>>>>> refs/remotes/origin/Rodrigues
	}
	public RepositorioUsuariosTerraplanistas() {
		try {
			carregar();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("deu rim no carregar");
		}
	}
	public void salvar()  {
		
		FileOutputStream fos = null;
		
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("Repositorios.hnf");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(usuarios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	public void carregar() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("Repositorios.hnf");
		ObjectInputStream ois = new ObjectInputStream(fis);
		this.usuarios = (ArrayList<UsuarioTerraplanista>) ois.readObject();
		ois.close();

	}

}
