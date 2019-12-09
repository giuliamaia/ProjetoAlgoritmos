package sistema.beans;

import java.util.List;

import sistema.controlador.Controlador;

public class TesteFX {
	public static void main(String[] args) {
		System.out.println("oi");
		
		Controlador controlador = Controlador.getInstancia();
		UsuarioTerraplanista user = controlador.pesquisarPorLogin("adm");
		user.addAmigo(controlador.pesquisarPorLogin("roro"));
		System.out.println( "oi");
		//List<UsuarioTerraplanista> recomendados = controlador.indicacaoAmigoComum(controlador.pesquisarPorLogin("adm"));
		//List<UsuarioTerraplanista> recomendados = controlador.indicacaoPorInteresse(controlador.pesquisarPorLogin("adm"));
		System.out.println("Recomendados: " + "Looping infinito");
	}
}
