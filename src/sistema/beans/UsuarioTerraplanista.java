package sistema.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UsuarioTerraplanista {
	private List<UsuarioTerraplanista> amigos;
	private List<String> interesses;
	private LocalDate dataNascimento;
	private LocalDateTime horaCriaçãoConta;
	
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
	
	
}
