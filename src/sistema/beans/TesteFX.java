package sistema.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import sistema.controlador.Controlador;

public class TesteFX {
	public static void main(String[] args) {
	
		Controlador controlador = Controlador.getInstancia();
		//UsuarioTerraplanista user = new UsuarioTerraplanista(new ArrayList<>(), new ArrayList<>(), "José de Paula", "reginaldo", "123", null, LocalDateTime.now(), null, 50, true);
		//controlador.adicionarUsuario(user);
		//user.addAmigo(controlador.pesquisarPorLogin("romulin"));
		//user.addAmigo(controlador.pesquisarPorLogin("adm2"));
		//user.addAmigo(controlador.pesquisarPorLogin("123"));
		//controlador.salvar();
		//user.addAmigo(controlador.pesquisarPorLogin("bb"));
		//controlador.pesquisarPorLogin("roro").addAmigo(controlador.pesquisarPorLogin("rororo"));
		//controlador.pesquisarPorLogin("bb").addAmigo(controlador.pesquisarPorLogin("sdf"));
		
		//List<UsuarioTerraplanista> recomendados = controlador.indicacaoAmigoComum(user);
		//List<UsuarioTerraplanista> recomendados = controlador.indicacaoPorInteresse(controlador.pesquisarPorLogin("adm"));
		//System.out.println(recomendados);
		//System.out.println(user.getAmigos());
		//System.out.println(controlador.pesquisarPorLogin("roro").getAmigos());
		
		System.out.println(controlador.recomendacoesPara(controlador.pesquisarPorLogin("adm")));
	}
}
