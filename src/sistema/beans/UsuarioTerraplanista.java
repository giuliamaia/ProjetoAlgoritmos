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
	private String image;
	private int recomendacoes = 0;
	private boolean pastor = false;
	public boolean isPastor() {
		return pastor;
	}
	public void setPastor(boolean pastor) {
		this.pastor = pastor;
	}
	public int getRecomendacoes() {
		return recomendacoes;
	}
	public void setRecomendacoes(int recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
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
		amigo.getAmigos().add(this);
	}
	public void removerAmigo(UsuarioTerraplanista exAmigo) {
		amigos.remove(exAmigo);
		exAmigo.getAmigos().remove(this);
	}
	
	public UsuarioTerraplanista(List<UsuarioTerraplanista> amigos, List<String> interesses, String nome, String login,
			String senha, LocalDate dataNascimento, LocalDateTime horaCriaçãoConta, String image, int recomendacoes,
			boolean pastor) {
		super();
		this.amigos = amigos;
		this.interesses = interesses;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.horaCriaçãoConta = horaCriaçãoConta;
		this.image = image;
		this.recomendacoes = recomendacoes;
		this.pastor = pastor;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void addRecomendacao() {
		this.recomendacoes++;
	}
	public UsuarioTerraplanista(String nome) {
		super();
		this.nome = nome;
	}
	@Override
	public String toString() {
		return  nome + " (" +login + ")";
	}
	public UsuarioTerraplanista(UsuarioTerraplanista user) {
		this.amigos = user.getAmigos();
		this.interesses = user.getInteresses();
		this.nome = user.getNome();
		this.login = user.getLogin();
		this.senha = user.getSenha();
		this.dataNascimento = user.getDataNascimento();
		this.horaCriaçãoConta = user.getHoraCriaçãoConta();
		this.image = user.getImage();
		this.recomendacoes = user.getRecomendacoes();
	}
	public boolean temInteressePor(String interesse) {
		for(String str : interesses) {
			if(str.toUpperCase().contentEquals(interesse.toUpperCase())) return true;
		}
		return false;
	}
	
	
}
