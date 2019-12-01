package sistema.beans;

import com.mxgraph.layout.*;
import com.mxgraph.swing.*;
import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;

/**
 * A demo applet that shows how to use JGraphX to visualize JGraphT graphs. Applet based on
 * JGraphAdapterDemo.
 *
 */
public class VerGrafo
    extends
    JApplet
{
    private static final long serialVersionUID = 2202072534703043194L;

    private static final Dimension DEFAULT_SIZE = new Dimension(1000, 700);

    private JGraphXAdapter<String, DefaultEdge> jgxAdapter;
    
    private Multigraph<String, DefaultEdge> grafo;

    private Grafo grafoAux = Grafo.getInstance();
    
    
    public Multigraph<String, DefaultEdge> getGrafo() {
		return grafo;
	}

	public void setGrafo(Multigraph<String, DefaultEdge> grafo) {
		this.grafo = grafo;
	}

	/**
     * An alternative starting point for this demo, to also allow running this applet as an
     * application.
     *
     * @param args command line arguments
     */
	static  JFrame frame = new JFrame();
    public static void main(String[] args)
    {
        VerGrafo applet = new VerGrafo();
        applet.init();

       
        
        frame.getContentPane().add(applet);
        frame.setTitle("Grafo TerraPlanizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
       
    }
    static class Action implements ActionListener{
    	public void Action() {
    		
    	}

		@Override
		public void actionPerformed(ActionEvent e) {
			VerGrafo a = new VerGrafo();
    		try {
				a.atualiza();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }
    @Override
    public void init()
    {
    	JButton button = new JButton("Atualizar");
        button.setLayout(null);
        button.setBounds(0,0,90,30);
        button.addActionListener(new Action());
        add(button);
        try {
			grafoAux.carregar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	grafo = grafoAux.getG();
        // create a JGraphT graph
        ListenableGraph<String, DefaultEdge> g = new DefaultListenableGraph<>(grafo);
            

        // create a visualization using JGraph, via an adapter
        jgxAdapter = new JGraphXAdapter<>(g);

        setPreferredSize(DEFAULT_SIZE);
        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.setConnectable(false);
        component.getGraph().setAllowDanglingEdges(false);
        getContentPane().add(component);
        resize(DEFAULT_SIZE);
        /*
        String v1 = "Rodrigues";
        String v2 = "Fernanda";
        String v3 = "Sabrina";
        String v4 = "Giulia";
		*/
        // add some sample data (graph manipulated via JGraphX)
        /*
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        g.addEdge(v1, v2);
        g.addEdge(v2, v1);
        g.addEdge(v2, v3);
        g.addEdge(v3, v2);
        g.addEdge(v3, v1);
        g.addEdge(v4, v3);
		*/
        // positioning via jgraphx layouts
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

        // center the circle
        
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);

        layout.execute(jgxAdapter.getDefaultParent());
        // that's all there is to it!...
    }
    public void atualiza() throws IOException {   	
    	grafoAux.carregar();
    	grafo = grafoAux.getG();
    	frame.setVisible(false);
    	frame.setVisible(true);
    	
    	System.out.println();
    	System.out.println("alou");
    }
}
