package sistema.beans;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


public class Teste {
	
	
	
	
	public static void main(String[] args) {
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

		Graph grafo = new MultiGraph("Usuários");
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
		grafo.addAttribute("ui.stylesheet", "url('CSS/grafo.css')");
		
		Viewer visualizador = grafo.display();
		//View visao = visualizador.getDefaultView();
		//visao.getCamera().setViewCenter(4, 2, 1);
		//visualizador.close();
	}
}
