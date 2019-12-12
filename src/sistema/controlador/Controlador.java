package sistema.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import sistema.beans.UsuarioTerraplanista;
import sistema.repositorios.RepositorioUsuariosTerraplanistas;

public class Controlador {
	public int numeroDeConvitesPara(UsuarioTerraplanista esseCara) {
		return repositorioUsuarioTerraPlanistas.numeroDeConvitesPara(esseCara);
	}
	private RepositorioUsuariosTerraplanistas repositorioUsuarioTerraPlanistas;
	private UsuarioTerraplanista usuarioLogado;
	public UsuarioTerraplanista getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(UsuarioTerraplanista usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
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
	public List<UsuarioTerraplanista> indicacaoPorInteresse(UsuarioTerraplanista user) {
		return repositorioUsuarioTerraPlanistas.indicacaoPorInteresse(user);
	}
	public List<UsuarioTerraplanista> indicacaoAmigoComum(UsuarioTerraplanista user) {
		return repositorioUsuarioTerraPlanistas.indicacaoAmigoComum(user);
	}
	public boolean temConvitePara(UsuarioTerraplanista user) {
		return repositorioUsuarioTerraPlanistas.temConvitePara(user);
	}
	public void enviarConvite(UsuarioTerraplanista desseCara, UsuarioTerraplanista praEsseCara) {
		repositorioUsuarioTerraPlanistas.enviarConvite(desseCara, praEsseCara);
	}
	public void salvarConvites() {
		repositorioUsuarioTerraPlanistas.salvarConvites();
	}
	public void carregarConvites() throws IOException, ClassNotFoundException {
		repositorioUsuarioTerraPlanistas.carregarConvites();
	}
	public boolean removerConvite(UsuarioTerraplanista desseCara, UsuarioTerraplanista praEsseCara) {
		return repositorioUsuarioTerraPlanistas.removerConvite(desseCara, praEsseCara);
	}
	public List<UsuarioTerraplanista> convitesPara(UsuarioTerraplanista usuario) {
		return repositorioUsuarioTerraPlanistas.convitesPara(usuario);
	}
	public List<UsuarioTerraplanista> recomendacoesPara(UsuarioTerraplanista usuarioTerraplanista) {
		return repositorioUsuarioTerraPlanistas.recomendacoesPara(usuarioTerraplanista);
	}
	public void salvar() {
		repositorioUsuarioTerraPlanistas.salvar();
	}
	public void carregar() throws IOException, ClassNotFoundException {
		repositorioUsuarioTerraPlanistas.carregar();
	}
	public ArrayList<UsuarioTerraplanista> pesquisarPorNome(String nome) {
		return repositorioUsuarioTerraPlanistas.pesquisarPorNome(nome);
	}
	public UsuarioTerraplanista pesquisarPorLogin(String login) {
		return repositorioUsuarioTerraPlanistas.pesquisarPorLogin(login);
	}
	static private Controlador instancia = null;
	public HashMap<String, String> getConvites() {
		return repositorioUsuarioTerraPlanistas.getConvites();
	}
	static public Controlador getInstancia() {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}
	private Controlador () {
		repositorioUsuarioTerraPlanistas = new RepositorioUsuariosTerraplanistas();
	}
	public List<UsuarioTerraplanista> convitesEnviadosPor(UsuarioTerraplanista esseCara) {
		return repositorioUsuarioTerraPlanistas.convitesEnviadosPor(esseCara);
	}
	
}
