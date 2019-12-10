package sistema.repositorios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
		
		usuarioVelho.setAmigos(usuarioNovo.getAmigos());
		usuarioVelho.setDataNascimento(usuarioNovo.getDataNascimento());
		usuarioVelho.setImage(usuarioNovo.getImage());
		usuarioVelho.setInteresses(usuarioNovo.getInteresses());
		usuarioVelho.setLogin(usuarioNovo.getLogin());
		usuarioVelho.setNome(usuarioNovo.getNome());
		usuarioVelho.setRecomendacoes(usuarioNovo.getRecomendacoes());
		usuarioVelho.setSenha(usuarioNovo.getSenha());
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
			Map<String, UsuarioTerraplanista> mapa = new TreeMap<String, UsuarioTerraplanista>();
			
			if(user.getInteresses() == null) {
				System.out.println("Não há interesses para comparar");
				return null;
			}
			
			for(int i = 0; i<this.usuarios.size(); i++) { //percorrendo a lista de todos os usuários
				
				int temp = 1;
				
				if(!(this.usuarios.get(i).equals(user)) && user.getInteresses() != null && this.usuarios.get(i).getInteresses() != null) {
					for(int j = 0; j<this.usuarios.get(i).getInteresses().size(); j++) { //percorrendo a lista de interesses de um determinado usuário
						for(int k = 0; k<user.getInteresses().size(); k++) { //percorrer a lista de interesses do usuário que queremos recomendar
							if(this.usuarios.get(i).getInteresses().get(j).equalsIgnoreCase(user.getInteresses().get(k))){
								temp++;
							}
						}
					}
					
					while(!(mapa.containsValue(this.usuarios.get(i)))) {
						if(mapa.containsKey(Integer.toString(temp))) {
							temp = temp * 10;
						}
						else{
							mapa.put(Integer.toString(temp), this.usuarios.get(i));
							temp = 1;
						}
						
					}
				}
			}
			
			List<UsuarioTerraplanista> indicados = new ArrayList<UsuarioTerraplanista>(mapa.values());
			Collections.reverse(indicados);
			
			return indicados;
		}
		
		public List<UsuarioTerraplanista> indicacaoAmigoComum(UsuarioTerraplanista user)
		{
			int temp = 1;
			
			Map<String, UsuarioTerraplanista> mapa = new TreeMap<String, UsuarioTerraplanista>();
			
			for(int i = 0; i<this.usuarios.size(); i++) { //percorrendo a lista de todos os usuários
				if(!(this.usuarios.get(i).equals(user)) && !(user.getAmigos().contains(this.usuarios.get(i)))) {
					for(int j = 0; j<this.usuarios.get(i).getAmigos().size(); j++) { //percorrendo a lista de amigos de um determinado usuário
							if(user.getAmigos().contains(this.usuarios.get(i).getAmigos().get(j))) {
								temp++;
							}
						}
					
					while(!(mapa.containsValue(this.usuarios.get(i)))) {
						if(mapa.containsKey(Integer.toString(temp))) {
							temp = temp * 10;
						}
						else{
							mapa.put(Integer.toString(temp), this.usuarios.get(i));
							temp = 1;
						}
						
					}
				}
			}	
			
			List<UsuarioTerraplanista> indicados = new ArrayList<UsuarioTerraplanista>(mapa.values());
			Collections.reverse(indicados);
			return indicados;
		}
		public List<UsuarioTerraplanista> recomendacoesPara(UsuarioTerraplanista usuarioTerraplanista){
			
			List<UsuarioTerraplanista> retorno = new ArrayList<UsuarioTerraplanista>();
			List<UsuarioTerraplanista> lista1 = new ArrayList<>();
			HashMap<String, Integer> mapa = new HashMap<>();
			if(usuarioTerraplanista.getAmigos().size()>0) {
				lista1 = indicacaoAmigoComum(usuarioTerraplanista);
				for(int i = 0; i < lista1.size() ; i++) {
					mapa.put(lista1.get(i).getLogin(), 50 - i);
				}
			}
			if(usuarioTerraplanista.getInteresses().size()>0){
				List<UsuarioTerraplanista> lista2 = indicacaoPorInteresse(usuarioTerraplanista);
				for(int i = 0; i < lista2.size() ; i++) {
					
					if(usuarioTerraplanista.getAmigos().size()>0&&mapa.containsKey(lista2.get(i).getLogin())){
						mapa.replace(lista2.get(i).getLogin(), mapa.get(lista2.get(i).getLogin())+50-i);
					}
					else {
						mapa.put(lista2.get(i).getLogin(), 50 - i);
					}
				}
			}
			
			List<String> logins = new ArrayList<>(mapa.keySet());
			List<Integer> valores = new ArrayList<>(mapa.values());
			Collections.sort(valores);
			Collections.reverse(valores);
			//System.out.println(valores);
			//.out.println(logins);
			for(int i = 0; i<valores.size(); i++) {
				for(int j = 0; j < logins.size(); j ++) {
					//System.out.println(mapa.get(logins.get(j)));
					if (mapa.get(logins.get(j))==valores.get(i)) {
						retorno.add(pesquisarPorLogin(logins.get(j)));
						logins.remove(j);
						j-=1;
					}
					
				}
				valores.remove(i);
				i-=1;
			}
			return retorno;
		}
}
