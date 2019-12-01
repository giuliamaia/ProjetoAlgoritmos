package sistema.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UsuarioTerraplanista {
	private List<UsuarioTerraplanista> amigos;
	private List<String> interesses;
	private LocalDate dataNascimento;
	private LocalDateTime horaCriaçãoConta;
	private String senha;
	private String nickName;
	private boolean ehPastor;
	
	public List<UsuarioTerraplanista> getAmigos() {
		return amigos;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean isEhPastor() {
		return ehPastor;
	}
	public void setEhPastor(boolean ehPastor) {
		this.ehPastor = ehPastor;
	}
	
	
}
