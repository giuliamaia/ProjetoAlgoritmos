package sistema.beans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Multigraph;


public class Grafo {
	private Multigraph<String, DefaultEdge> g;

	private static Grafo Instance = null;
	static public Grafo getInstance(){
		if (Instance == null) {
			Instance = new Grafo();
		}
		return Instance;
	}
	
	public Multigraph<String, DefaultEdge> getG() {
		return g;
	}

	public void setG(Multigraph<String, DefaultEdge> g) {
		this.g = g;
	}

	private Grafo() {
		
		try {
			carregar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			g = new Multigraph<>(DefaultEdge.class);
			System.out.println("Não tinha arquivo");
		}
	}
	
	public void addVertice(String v) throws IOException {
		g.addVertex(v);
		salvar();
	}
	public void addAresta(String v1, String v2) throws IOException {
		g.addEdge(v1, v2);
		g.addEdge(v2, v1);
		salvar();
	}
	public void removerAresta(String v1, String v2) throws IOException {
		g.removeEdge(v1, v2);
		g.removeEdge(v2, v1);
		salvar();
	}
	public void removerVertice(String v) throws IOException {
		g.removeVertex(v);
		salvar();
	}
	@SuppressWarnings("unchecked")
	public boolean carregar() throws IOException {
		FileInputStream fis = new FileInputStream("Grafo.hnf");
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			this.g = (Multigraph<String, DefaultEdge>)ois.readObject();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		finally {
			ois.close();
		}
		
	}
	public void salvar() throws IOException {
		FileOutputStream fos = new FileOutputStream("Grafo.hnf");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		try {
			oos.writeObject(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			oos.close();
		}
	}
}
