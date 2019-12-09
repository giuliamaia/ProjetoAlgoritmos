package sistema.beans;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.graphstream.graph.Edge;
import org.graphstream.graph.EdgeFactory;
import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.NodeFactory;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.AttributeSink;
import org.graphstream.stream.ElementSink;
import org.graphstream.stream.GraphParseException;
import org.graphstream.stream.Sink;
import org.graphstream.stream.file.FileSink;
import org.graphstream.stream.file.FileSource;
import org.graphstream.ui.view.Viewer;

import sistema.controlador.Controlador;

public class Grafo {
	private Graph grafo;
	private Controlador controlador = Controlador.getInstancia();
	static private Grafo instancia = new Grafo();
	static public Grafo getInstancia() {
		return instancia;
	}
	public Graph getGrafo() {
		return grafo;
	}
	public void setGrafo(Graph grafo) {
		this.grafo = grafo;
	}
	private Grafo () {
		grafo = new DefaultGraph("Usuários");
		setStrict(false);
		setAutoCreate(true);
		//grafo.setAttribute("ui.stylesheet", "graph { fill-color: #DCC; }");
		//construirgrafo();
	}
	
	public void construirgrafo(boolean éEstilizado) {
		try {
			controlador.carregar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setarNos(éEstilizado);
		setarArestas();
		
	}
	private void setarArestas() {
		for(UsuarioTerraplanista u : controlador.getUsuarios()) {
			for(UsuarioTerraplanista a : u.getAmigos()) {
				Edge aresta = grafo.addEdge(u.getLogin()  + a.getLogin(), u.getLogin(), a.getLogin());
				System.out.println(aresta);
				if(aresta != null)aresta.setAttribute("ui.style", "shape: cubic-curve;");
			}
		}
		
	}
	private void setarNos(boolean éEstilizado) {
		for (UsuarioTerraplanista u : controlador.getUsuarios()) {
			Node no = addNode(u.getLogin());
			if(éEstilizado) {
				if(u.isPastor()) {
					no.setAttribute("ui.style", "fill-color: #5eb5a8; text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #A7CC; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
				}
				else {
					no.setAttribute("ui.style", "fill-color: #292725; text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #A7CC; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
				}
				
				no.setAttribute("ui.label", u.getNome() + " (" + u.getLogin()+ ")");
			}
			
		}
		
	}
	private void setarNosRecomendacao() {
		//TODO 
	}
	public void addAttributeSink(AttributeSink arg0) {
		grafo.addAttributeSink(arg0);
	}
	public Edge addEdge(String id, String node1, String node2)
			throws IdAlreadyInUseException, ElementNotFoundException, EdgeRejectedException {
		return grafo.addEdge(id, node1, node2);
	}
	public Edge addEdge(String id, int index1, int index2)
			throws IndexOutOfBoundsException, IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(id, index1, index2);
	}
	public Edge addEdge(String id, Node node1, Node node2) throws IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(id, node1, node2);
	}
	public Edge addEdge(String id, String from, String to, boolean directed)
			throws IdAlreadyInUseException, ElementNotFoundException, EdgeRejectedException {
		return grafo.addEdge(id, from, to, directed);
	}
	public Edge addEdge(String id, int fromIndex, int toIndex, boolean directed)
			throws IndexOutOfBoundsException, IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(id, fromIndex, toIndex, directed);
	}
	public Edge addEdge(String arg0, Node arg1, Node arg2, boolean arg3)
			throws IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(arg0, arg1, arg2, arg3);
	}
	public void addElementSink(ElementSink arg0) {
		grafo.addElementSink(arg0);
	}
	public Node addNode(String arg0) throws IdAlreadyInUseException {
		return grafo.addNode(arg0);
	}
	public void addSink(Sink arg0) {
		grafo.addSink(arg0);
	}
	public Stream<String> attributeKeys() {
		return grafo.attributeKeys();
	}
	public Iterable<AttributeSink> attributeSinks() {
		return grafo.attributeSinks();
	}
	public void clear() {
		grafo.clear();
	}
	public void clearAttributeSinks() {
		grafo.clearAttributeSinks();
	}
	public void clearAttributes() {
		grafo.clearAttributes();
	}
	public void clearElementSinks() {
		grafo.clearElementSinks();
	}
	public void clearSinks() {
		grafo.clearSinks();
	}
	public Viewer display() {
		
		return grafo.display();
	}
	public Viewer display(boolean arg0) {
		return grafo.display(arg0);
	}
	public void edgeAdded(String arg0, long arg1, String arg2, String arg3, String arg4, boolean arg5) {
		grafo.edgeAdded(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public void edgeAttributeAdded(String arg0, long arg1, String arg2, String arg3, Object arg4) {
		grafo.edgeAttributeAdded(arg0, arg1, arg2, arg3, arg4);
	}
	public void edgeAttributeChanged(String arg0, long arg1, String arg2, String arg3, Object arg4, Object arg5) {
		grafo.edgeAttributeChanged(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public void edgeAttributeRemoved(String arg0, long arg1, String arg2, String arg3) {
		grafo.edgeAttributeRemoved(arg0, arg1, arg2, arg3);
	}
	public EdgeFactory<? extends Edge> edgeFactory() {
		return grafo.edgeFactory();
	}
	public void edgeRemoved(String arg0, long arg1, String arg2) {
		grafo.edgeRemoved(arg0, arg1, arg2);
	}
	public Stream<Edge> edges() {
		return grafo.edges();
	}
	public Iterable<ElementSink> elementSinks() {
		return grafo.elementSinks();
	}
	public Iterator<Node> iterator() {
		return grafo.iterator();
	}
	public void forEach(Consumer<? super Node> action) {
		grafo.forEach(action);
	}
	public Object[] getArray(String key) {
		return grafo.getArray(key);
	}
	public Object getAttribute(String arg0) {
		return grafo.getAttribute(arg0);
	}
	public <T> T getAttribute(String arg0, Class<T> arg1) {
		return grafo.getAttribute(arg0, arg1);
	}
	public int getAttributeCount() {
		return grafo.getAttributeCount();
	}
	public Edge getEdge(String arg0) {
		return grafo.getEdge(arg0);
	}
	public Edge getEdge(int arg0) throws IndexOutOfBoundsException {
		return grafo.getEdge(arg0);
	}
	public int getEdgeCount() {
		return grafo.getEdgeCount();
	}
	public Object getFirstAttributeOf(String... arg0) {
		return grafo.getFirstAttributeOf(arg0);
	}
	public <T> T getFirstAttributeOf(Class<T> arg0, String... arg1) {
		return grafo.getFirstAttributeOf(arg0, arg1);
	}
	public String getId() {
		return grafo.getId();
	}
	public int getIndex() {
		return grafo.getIndex();
	}
	public CharSequence getLabel(String key) {
		return grafo.getLabel(key);
	}
	public Map<?, ?> getMap(String key) {
		return grafo.getMap(key);
	}
	public Node getNode(String arg0) {
		return grafo.getNode(arg0);
	}
	public Node getNode(int arg0) throws IndexOutOfBoundsException {
		return grafo.getNode(arg0);
	}
	public int getNodeCount() {
		return grafo.getNodeCount();
	}
	public double getNumber(String key) {
		return grafo.getNumber(key);
	}
	public double getStep() {
		return grafo.getStep();
	}
	public List<? extends Number> getVector(String key) {
		return grafo.getVector(key);
	}
	public void graphAttributeAdded(String arg0, long arg1, String arg2, Object arg3) {
		grafo.graphAttributeAdded(arg0, arg1, arg2, arg3);
	}
	public void graphAttributeChanged(String arg0, long arg1, String arg2, Object arg3, Object arg4) {
		grafo.graphAttributeChanged(arg0, arg1, arg2, arg3, arg4);
	}
	public void graphAttributeRemoved(String arg0, long arg1, String arg2) {
		grafo.graphAttributeRemoved(arg0, arg1, arg2);
	}
	public void graphCleared(String arg0, long arg1) {
		grafo.graphCleared(arg0, arg1);
	}
	public boolean hasArray(String key) {
		return grafo.hasArray(key);
	}
	public boolean hasAttribute(String arg0) {
		return grafo.hasAttribute(arg0);
	}
	public boolean hasAttribute(String arg0, Class<?> arg1) {
		return grafo.hasAttribute(arg0, arg1);
	}
	public boolean hasLabel(String key) {
		return grafo.hasLabel(key);
	}
	public boolean hasMap(String key) {
		return grafo.hasMap(key);
	}
	public boolean hasNumber(String key) {
		return grafo.hasNumber(key);
	}
	public boolean hasVector(String key) {
		return grafo.hasVector(key);
	}
	public boolean isAutoCreationEnabled() {
		return grafo.isAutoCreationEnabled();
	}
	public boolean isStrict() {
		return grafo.isStrict();
	}
	public void nodeAdded(String arg0, long arg1, String arg2) {
		grafo.nodeAdded(arg0, arg1, arg2);
	}
	public void nodeAttributeAdded(String arg0, long arg1, String arg2, String arg3, Object arg4) {
		grafo.nodeAttributeAdded(arg0, arg1, arg2, arg3, arg4);
	}
	public void nodeAttributeChanged(String arg0, long arg1, String arg2, String arg3, Object arg4, Object arg5) {
		grafo.nodeAttributeChanged(arg0, arg1, arg2, arg3, arg4, arg5);
	}
	public void nodeAttributeRemoved(String arg0, long arg1, String arg2, String arg3) {
		grafo.nodeAttributeRemoved(arg0, arg1, arg2, arg3);
	}
	public NodeFactory<? extends Node> nodeFactory() {
		return grafo.nodeFactory();
	}
	public void nodeRemoved(String arg0, long arg1, String arg2) {
		grafo.nodeRemoved(arg0, arg1, arg2);
	}
	public Stream<Node> nodes() {
		return grafo.nodes();
	}
	public void read(String filename) throws IOException, GraphParseException, ElementNotFoundException {
		grafo.read(filename);
	}
	public void read(FileSource input, String filename) throws IOException, GraphParseException {
		grafo.read(input, filename);
	}
	public void removeAttribute(String arg0) {
		grafo.removeAttribute(arg0);
	}
	public void removeAttributeSink(AttributeSink arg0) {
		grafo.removeAttributeSink(arg0);
	}
	public Edge removeEdge(int index) throws IndexOutOfBoundsException {
		return grafo.removeEdge(index);
	}
	public Edge removeEdge(String id) throws ElementNotFoundException {
		return grafo.removeEdge(id);
	}
	public Edge removeEdge(Edge arg0) {
		return grafo.removeEdge(arg0);
	}
	public Edge removeEdge(int fromIndex, int toIndex) throws IndexOutOfBoundsException, ElementNotFoundException {
		return grafo.removeEdge(fromIndex, toIndex);
	}
	public Edge removeEdge(Node arg0, Node arg1) throws ElementNotFoundException {
		return grafo.removeEdge(arg0, arg1);
	}
	public Edge removeEdge(String from, String to) throws ElementNotFoundException {
		return grafo.removeEdge(from, to);
	}
	public void removeElementSink(ElementSink arg0) {
		grafo.removeElementSink(arg0);
	}
	public Node removeNode(int index) throws IndexOutOfBoundsException {
		return grafo.removeNode(index);
	}
	public Node removeNode(String id) throws ElementNotFoundException {
		return grafo.removeNode(id);
	}
	public Node removeNode(Node arg0) {
		return grafo.removeNode(arg0);
	}
	public void removeSink(Sink arg0) {
		grafo.removeSink(arg0);
	}
	public void setAttribute(String arg0, Object... arg1) {
		grafo.setAttribute(arg0, arg1);
	}
	public void setAttributes(Map<String, Object> attributes) {
		grafo.setAttributes(attributes);
	}
	public void setAutoCreate(boolean arg0) {
		grafo.setAutoCreate(arg0);
	}
	public void setEdgeFactory(EdgeFactory<? extends Edge> arg0) {
		grafo.setEdgeFactory(arg0);
	}
	public void setNodeFactory(NodeFactory<? extends Node> arg0) {
		grafo.setNodeFactory(arg0);
	}
	public void setStrict(boolean arg0) {
		grafo.setStrict(arg0);
	}
	public Spliterator<Node> spliterator() {
		return grafo.spliterator();
	}
	public void stepBegins(double arg0) {
		grafo.stepBegins(arg0);
	}
	public void stepBegins(String arg0, long arg1, double arg2) {
		grafo.stepBegins(arg0, arg1, arg2);
	}
	public void write(String filename) throws IOException {
		grafo.write(filename);
	}
	public void write(FileSink output, String filename) throws IOException {
		grafo.write(output, filename);
	}
	
}