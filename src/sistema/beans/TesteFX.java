package sistema.beans;

import java.util.List;

import sistema.controlador.Controlador;

public class TesteFX {
	public static void main(String[] args) {
	
		Controlador controlador = Controlador.getInstancia();
		UsuarioTerraplanista user = controlador.pesquisarPorLogin("adm");
		user.addAmigo(controlador.pesquisarPorLogin("roro"));
		user.addAmigo(controlador.pesquisarPorLogin("bb"));
		controlador.pesquisarPorLogin("roro").addAmigo(controlador.pesquisarPorLogin("rororo"));
		controlador.pesquisarPorLogin("bb").addAmigo(controlador.pesquisarPorLogin("sdf"));
		
		List<UsuarioTerraplanista> recomendados = controlador.indicacaoAmigoComum(controlador.pesquisarPorLogin("adm"));
		//List<UsuarioTerraplanista> recomendados = controlador.indicacaoPorInteresse(controlador.pesquisarPorLogin("adm"));
		System.out.println(recomendados);
		System.out.println(controlador.pesquisarPorLogin("adm").getAmigos());
		System.out.println(controlador.pesquisarPorLogin("roro").getAmigos());
	}
}
