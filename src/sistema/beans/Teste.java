package sistema.beans;

import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class Teste {
	public static void main(String[] args) {
		Grafo grafo = Grafo.getInstancia();
		Viewer viewer = grafo.display();
	}
}
