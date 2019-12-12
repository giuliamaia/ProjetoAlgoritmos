package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import sistema.controlador.Controlador;

public class TesteFX {
	public static void main(String[] args) {
	
		Controlador controlador = Controlador.getInstancia();
		
		System.out.println(controlador.getUsuarios());
		
		System.out.println(controlador.pessoasParaSeita());
		controlador.pesquisarPorLogin("adm").getAmigos();
		System.out.println(controlador.pesquisarPorLogin("adm").getInteresses());
		System.out.println(controlador.possiveisPastores());
		
		
	}
}
