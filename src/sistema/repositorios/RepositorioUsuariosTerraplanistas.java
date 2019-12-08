package sistema.repositorios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	public ArrayList<UsuarioTerraplanista> pesquisarPorNome(String nome) {
		nome = nome.toUpperCase();
		ArrayList<UsuarioTerraplanista> ret = new ArrayList<UsuarioTerraplanista>();
		if (nome == null)
			return null;
		
		for (UsuarioTerraplanista user : this.usuarios) {
			if (user.getNome().toUpperCase().contains(nome)) {
				ret.add(user);
			}
		}
		return ret;
	}
	
	 public UsuarioTerraplanista pesquisarPorLogin(String login) {
		 	login = login.toUpperCase();
			
			if (login == null)
				return null;

			for (UsuarioTerraplanista user : this.usuarios) {
				if (user.getLogin().toUpperCase().equals(login)) {
					return user;
				}
			}
			return null;
	 }
	 public List<UsuarioTerraplanista> indicacaoPorInteresse(UsuarioTerraplanista user)
		{
			int temp = 0;
			
			Map<String, UsuarioTerraplanista> mapa = new TreeMap<String, UsuarioTerraplanista>();
			
			for(int i = 0; i<this.usuarios.size(); i++) { //percorrendo a lista de todos os usuários
				for(int j = 0; j<this.usuarios.get(i).getInteresses().size(); j++) { //percorrendo a lista de interesses de um determinado usuário
					for(int k = 0; k<user.getInteresses().size(); k++) { //percorrer a lista de interesses do usuário que queremos recomendar
						if(this.usuarios.get(i).getInteresses().get(j).equalsIgnoreCase(user.getInteresses().get(k))){
							temp++;
						}
					}
				}
				mapa.put(Integer.toString(temp), this.usuarios.get(i));
				temp = 0;
			}
			
			List<UsuarioTerraplanista> indicados = new ArrayList<UsuarioTerraplanista>(mapa.values());
			return indicados;
		}
}
