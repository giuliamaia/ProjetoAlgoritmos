package sistema.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UsuarioTerraplanista implements Serializable{
	
	private static final long serialVersionUID = 8939899618090534011L;
	private List<UsuarioTerraplanista> amigos;
	private List<String> interesses;
	private String nome;
	private String login;
	private String senha;
	private LocalDate dataNascimento;
	private LocalDateTime horaCriaçãoConta;
	private Grafo grafo = Grafo.getInstancia();
	public List<UsuarioTerraplanista> getAmigos() {
		return amigos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setAmigos(List<UsuarioTerraplanista> amigos) {
		this.amigos = amigos;
	}
	public List<String> getInteresses() {
		return interesses;
	}
	public void setInteresses(List<String> interesses) {
		this.interesses = interesses;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDateTime getHoraCriaçãoConta() {
		return horaCriaçãoConta;
	}
	public void setHoraCriaçãoConta(LocalDateTime horaCriaçãoConta) {
		this.horaCriaçãoConta = horaCriaçãoConta;
	}
	public void addAmigo(UsuarioTerraplanista amigo) {
		amigos.add(amigo);
		grafo.addEdge(this.getNome() + " - " +amigo.getNome(), this.getNome(), amigo.getNome());
	}
	public void removerAmigo(UsuarioTerraplanista exAmigo) {
		amigos.remove(exAmigo);
		grafo.removeEdge(this.getNome(), exAmigo.getNome());
	}
	public UsuarioTerraplanista(List<String> interesses, String nome, String login, String senha,
			LocalDate dataNascimento) {
		this.interesses = interesses;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.horaCriaçãoConta = LocalDateTime.now();
	}
}
