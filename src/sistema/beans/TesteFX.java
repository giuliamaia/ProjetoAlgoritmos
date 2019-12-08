package sistema.beans;

import javafx.application.Application;
import org.graphstream.graph.Graph;

import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TesteFX extends Application{
	public static void main(String[] args) {
		Application.launch(TesteFX.class, args);
	}
	
	protected String styleSheet = "graph {padding: 60px;}";

	public void start(Stage primaryStage) throws Exception {
		Grafo g1= Grafo.getInstancia();
		Graph g = g1.getGrafo();
		FxViewer v = new FxViewer(g, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
		g1.construirgrafo(true);
		g.setAttribute("ui.antialias");
		g.setAttribute("ui.quality");
		g.setAttribute("ui.stylesheet", "graph {padding: 60px;}");
		v.enableAutoLayout();
		FxViewPanel panel = (FxViewPanel)v.addDefaultView(false, new FxGraphRenderer());
		Scene scene = new Scene(panel, 800, 600);
  		primaryStage.setScene(scene);
  		
		primaryStage.show();
	}
}
