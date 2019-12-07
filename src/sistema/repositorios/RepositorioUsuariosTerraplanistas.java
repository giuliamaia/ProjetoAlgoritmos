package sistema.repositorios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.graphstream.graph.Node;

import sistema.beans.Grafo;
import sistema.beans.UsuarioTerraplanista;

public class RepositorioUsuariosTerraplanistas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 132234234L;
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
		salvar();
	}
	public void	removerUsuario(UsuarioTerraplanista usuario) {
		this.usuarios.remove(usuario);
		salvar();
	}
	public void editarUsuario(UsuarioTerraplanista usuarioVelho, UsuarioTerraplanista usuarioNovo) {
		usuarioVelho = usuarioNovo;
		salvar();
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
