package sistema.beans;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.util.ShortcutManager;

import sistema.controlador.Controlador;


public class Teste {
	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Controlador controlador = Controlador.getInstancia();
		Grafo grafo = Grafo.getInstancia();
		UsuarioTerraplanista usuario = new UsuarioTerraplanista(new ArrayList<UsuarioTerraplanista>(), new ArrayList<String>(), "Rodrigues", "RODROD", "123", LocalDate.of(2001, 04, 07), LocalDateTime.now(), "", 15, true);
		//controlador.pesquisarPorLogin("adm").addAmigo(controlador.pesquisarPorLogin("ademir"));
		controlador.salvar();
	    Viewer viewer = grafo.display();
	    viewer.getDefaultView().setShortcutManager(new ShortcutManager() {

            private View view;

            @Override
            public void init(GraphicGraph graph, View view) {
                this.view = view;
                view.addKeyListener(this);
            }

            @Override
            public void release() {
                view.removeKeyListener(this);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 116) {
                	grafo.construirgrafo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased!");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //System.out.println("keyTyped!");
            }
        });
	    
	}
}
