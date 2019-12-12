package sistema.beans;

import sistema.controlador.Controlador;

public class TesteFX {
	public static void main(String[] args) {
	
		Controlador controlador = Controlador.getInstancia();
		
		System.out.println(controlador.getUsuarios());
		
		System.out.println(controlador.pessoasParaSeita());
		System.out.println("adm"+controlador.pesquisarPorLogin("adm").getAmigos());
		System.out.println("123"+controlador.pesquisarPorLogin("123").getAmigos());
		System.out.println("roro"+controlador.pesquisarPorLogin("roro").getAmigos());
		System.out.println("sara"+controlador.pesquisarPorLogin("sara").getAmigos());

		//System.out.println(controlador.pesquisarPorLogin("adm").getInteresses());
		//System.out.println(controlador.possiveisPastores());
		
		
	}
}
