package sistema.beans;

import sistema.controlador.Controlador;

public class TesteFX {
	public static void main(String[] args) {
	
		Controlador controlador = Controlador.getInstancia();
		
		//System.out.println(controlador.getUsuarios());
		
		//System.out.println(controlador.pessoasParaSeita());
		//controlador.pesquisarPorLogin("adm").getAmigos();
		//System.out.println(controlador.pesquisarPorLogin("adm").getInteresses());
		//System.out.println(controlador.possiveisPastores());
		//System.out.println(controlador.seitasDe3Pessoas());
		
		System.out.println(controlador.getSeitas());
		System.out.println();
		System.out.println("adm" + controlador.pesquisarPorLogin("adm").getAmigos());
		System.out.println("roro" + controlador.pesquisarPorLogin("roro").getAmigos());
		System.out.println("123" + controlador.pesquisarPorLogin("123").getAmigos());
		System.out.println("bibi" + controlador.pesquisarPorLogin("bibi").getAmigos());

	}
}
