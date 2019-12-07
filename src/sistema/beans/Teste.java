package sistema.beans;
import java.io.File;
import java.net.MalformedURLException;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

import javafx.scene.paint.Color;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	    SingleGraph graph = new SingleGraph("Use");
	    graph.addNode("A");
	    graph.addNode("B");
	    graph.addNode("C");
	    graph.addNode("D");
	    graph.addNode("E");
	    graph.addNode("F");
	    graph.addNode(1+"");
	    graph.addNode(2+"");
	    graph.addEdge("AB", "A", "B");
	    graph.addEdge(1+""+2+"", 1+"", 2+"");
	    graph.addEdge("BC", "B", "C");
	    graph.addEdge("CA", "C", "A");
	    graph.addEdge("CD", "C", "D");
	    graph.addEdge("DF", "D", "F");
	    graph.addEdge("EF", "E", "F");
	    graph.addEdge("DE", "D", "E");
	    Node e1=graph.getNode("A");
	    e1.addAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #e09410; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
	    e1.addAttribute("ui.label", "A");
	    graph.display();
	}
}
