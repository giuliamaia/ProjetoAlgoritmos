package sistema.beans;
import java.io.File;
import java.net.MalformedURLException;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		Graph grafo = new MultiGraph("Usuários");
		File file = new File("CSS/grafo.css");
		System.out.println(file.exists());
		grafo.addAttribute("ui.stylesheet", "url('CSS/grafo.css')");
		grafo.setStrict(false);
		grafo.setAutoCreate(true);
		grafo.addEdge("SaGiu", "Sabrina", "Giulia");
		grafo.addEdge("SaGu", "Rodrigues", "Kakarot");
		grafo.addEdge("Saiu", "Sabrina", "Kakarot");
		grafo.addEdge("Giu", "Rodrigues", "Giulia");
		grafo.addEdge("Bunda", "Sabrina", "Furico");
		grafo.addEdge("Giiu", "Romulo", "Copo");
		grafo.addEdge("Bunda", "Copo", "Rodrigues");
		grafo.addEdge("Bundaa", "Corpo", "Copo");
		
		Viewer visualizador = grafo.display();
		//View visao = visualizador.getDefaultView();
		//visao.getCamera().setViewCenter(4, 2, 1);
		//visualizador.close();
	}
}
