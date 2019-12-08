package sistema.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

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
		
	}
	
	private void construirgrafo() {
		grafo.setStrict(false);
		grafo.setAutoCreate(true);
		for (int i = 0; controlador.getUsuarios() != null && i < controlador.getUsuarios().size(); i++) {
			addNode(controlador.getUsuarios().get(i).getNome() +" ("+controlador.getUsuarios().get(i).getLogin()+")");
			Node no1 = getNode(controlador.getUsuarios().get(i).getNome() +" ("+controlador.getUsuarios().get(i).getLogin()+")");
			no1.addAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #e09410; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
			no1.addAttribute("ui.label", controlador.getUsuarios().get(i).getNome() +" ("+controlador.getUsuarios().get(i).getLogin()+")");
			for (int j = 0; controlador.getUsuarios().get(i).getAmigos() != null && j < controlador.getUsuarios().get(i).getAmigos().size(); j++) {
				addNode(controlador.getUsuarios().get(i).getAmigos().get(j).getNome() +" ("+controlador.getUsuarios().get(i).getAmigos().get(j).getLogin()+")");
				Node no2 =getNode(controlador.getUsuarios().get(i).getAmigos().get(j).getNome()+" ("+controlador.getUsuarios().get(i).getAmigos().get(j).getLogin()+")"); 
				no2.addAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #e09410; text-color: white; text-style: bold-italic; text-color: #FFF; text-offset: 5px, 0px;");
				no2.addAttribute("ui.label", controlador.getUsuarios().get(i).getAmigos().get(j).getNome()+" ("+controlador.getUsuarios().get(i).getAmigos().get(j).getLogin()+")");
				addEdge(no1.getId() + "   " + no2.getId(), no1, no2);
			}
		}
		
	}
	public <T extends Edge> T addEdge(String arg0, String arg1, String arg2)
			throws IdAlreadyInUseException, ElementNotFoundException, EdgeRejectedException {
		return grafo.addEdge(arg0, arg1, arg2);
	}

	public <T extends Node> T addNode(String arg0) throws IdAlreadyInUseException {
		return grafo.addNode(arg0);
	}

	public Viewer display() {
		construirgrafo();
		return grafo.display();
	}

	public <T extends Edge> T removeEdge(String arg0, String arg1) throws ElementNotFoundException {
		return grafo.removeEdge(arg0, arg1);
	}

	public <T extends Node> T removeNode(String arg0) throws ElementNotFoundException {
		return grafo.removeNode(arg0);
	}
	public void addAttribute(String arg0, Object... arg1) {
		grafo.addAttribute(arg0, arg1);
	}
	public void addAttributeSink(AttributeSink arg0) {
		grafo.addAttributeSink(arg0);
	}
	public void addAttributes(Map<String, Object> arg0) {
		grafo.addAttributes(arg0);
	}
	public <T extends Edge> T addEdge(String arg0, int arg1, int arg2, boolean arg3)
			throws IndexOutOfBoundsException, IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(arg0, arg1, arg2, arg3);
	}
	public <T extends Edge> T addEdge(String arg0, int arg1, int arg2)
			throws IndexOutOfBoundsException, IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(arg0, arg1, arg2);
	}
	public <T extends Edge> T addEdge(String arg0, Node arg1, Node arg2, boolean arg3)
			throws IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(arg0, arg1, arg2, arg3);
	}
	public <T extends Edge> T addEdge(String arg0, Node arg1, Node arg2)
			throws IdAlreadyInUseException, EdgeRejectedException {
		return grafo.addEdge(arg0, arg1, arg2);
	}
	public <T extends Edge> T addEdge(String arg0, String arg1, String arg2, boolean arg3)
			throws IdAlreadyInUseException, ElementNotFoundException {
		return grafo.addEdge(arg0, arg1, arg2, arg3);
	}
	public void addElementSink(ElementSink arg0) {
		grafo.addElementSink(arg0);
	}
	public void addSink(Sink arg0) {
		grafo.addSink(arg0);
	}
	public Iterable<AttributeSink> attributeSinks() {
		return grafo.attributeSinks();
	}
	public void changeAttribute(String arg0, Object... arg1) {
		grafo.changeAttribute(arg0, arg1);
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
	public Iterable<ElementSink> elementSinks() {
		return grafo.elementSinks();
	}
	public void forEach(Consumer<? super Node> action) {
		grafo.forEach(action);
	}
	public Object[] getArray(String arg0) {
		return grafo.getArray(arg0);
	}
	public <T> T getAttribute(String arg0, Class<T> arg1) {
		return grafo.getAttribute(arg0, arg1);
	}
	public <T> T getAttribute(String arg0) {
		return grafo.getAttribute(arg0);
	}
	public int getAttributeCount() {
		return grafo.getAttributeCount();
	}
	public Iterator<String> getAttributeKeyIterator() {
		return grafo.getAttributeKeyIterator();
	}
	public Collection<String> getAttributeKeySet() {
		return grafo.getAttributeKeySet();
	}
	public Iterable<String> getEachAttributeKey() {
		return grafo.getEachAttributeKey();
	}
	public <T extends Edge> Iterable<? extends T> getEachEdge() {
		return grafo.getEachEdge();
	}
	public <T extends Node> Iterable<? extends T> getEachNode() {
		return grafo.getEachNode();
	}
	public <T extends Edge> T getEdge(int arg0) throws IndexOutOfBoundsException {
		return grafo.getEdge(arg0);
	}
	public <T extends Edge> T getEdge(String arg0) {
		return grafo.getEdge(arg0);
	}
	public int getEdgeCount() {
		return grafo.getEdgeCount();
	}
	public <T extends Edge> Iterator<T> getEdgeIterator() {
		return grafo.getEdgeIterator();
	}
	public <T extends Edge> Collection<T> getEdgeSet() {
		return grafo.getEdgeSet();
	}
	public <T> T getFirstAttributeOf(Class<T> arg0, String... arg1) {
		return grafo.getFirstAttributeOf(arg0, arg1);
	}
	public <T> T getFirstAttributeOf(String... arg0) {
		return grafo.getFirstAttributeOf(arg0);
	}
	public HashMap<?, ?> getHash(String arg0) {
		return grafo.getHash(arg0);
	}
	public String getId() {
		return grafo.getId();
	}
	public int getIndex() {
		return grafo.getIndex();
	}
	public CharSequence getLabel(String arg0) {
		return grafo.getLabel(arg0);
	}
	public <T extends Node> T getNode(int arg0) throws IndexOutOfBoundsException {
		return grafo.getNode(arg0);
	}
	public <T extends Node> T getNode(String arg0) {
		return grafo.getNode(arg0);
	}
	public int getNodeCount() {
		return grafo.getNodeCount();
	}
	public <T extends Node> Iterator<T> getNodeIterator() {
		return grafo.getNodeIterator();
	}
	public <T extends Node> Collection<T> getNodeSet() {
		return grafo.getNodeSet();
	}
	public double getNumber(String arg0) {
		return grafo.getNumber(arg0);
	}
	public double getStep() {
		return grafo.getStep();
	}
	public ArrayList<? extends Number> getVector(String arg0) {
		return grafo.getVector(arg0);
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
	public boolean hasArray(String arg0) {
		return grafo.hasArray(arg0);
	}
	public boolean hasAttribute(String arg0, Class<?> arg1) {
		return grafo.hasAttribute(arg0, arg1);
	}
	public boolean hasAttribute(String arg0) {
		return grafo.hasAttribute(arg0);
	}
	public boolean hasHash(String arg0) {
		return grafo.hasHash(arg0);
	}
	public boolean hasLabel(String arg0) {
		return grafo.hasLabel(arg0);
	}
	public boolean hasNumber(String arg0) {
		return grafo.hasNumber(arg0);
	}
	public boolean hasVector(String arg0) {
		return grafo.hasVector(arg0);
	}
	public boolean isAutoCreationEnabled() {
		return grafo.isAutoCreationEnabled();
	}
	public boolean isStrict() {
		return grafo.isStrict();
	}
	public Iterator<Node> iterator() {
		return grafo.iterator();
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
	public boolean nullAttributesAreErrors() {
		return grafo.nullAttributesAreErrors();
	}
	public void read(FileSource arg0, String arg1) throws IOException, GraphParseException {
		grafo.read(arg0, arg1);
	}
	public void read(String arg0) throws IOException, GraphParseException, ElementNotFoundException {
		grafo.read(arg0);
	}
	public void removeAttribute(String arg0) {
		grafo.removeAttribute(arg0);
	}
	public void removeAttributeSink(AttributeSink arg0) {
		grafo.removeAttributeSink(arg0);
	}
	public <T extends Edge> T removeEdge(Edge arg0) {
		return grafo.removeEdge(arg0);
	}
	public <T extends Edge> T removeEdge(int arg0, int arg1)
			throws IndexOutOfBoundsException, ElementNotFoundException {
		return grafo.removeEdge(arg0, arg1);
	}
	public <T extends Edge> T removeEdge(int arg0) throws IndexOutOfBoundsException {
		return grafo.removeEdge(arg0);
	}
	public <T extends Edge> T removeEdge(Node arg0, Node arg1) throws ElementNotFoundException {
		return grafo.removeEdge(arg0, arg1);
	}
	public <T extends Edge> T removeEdge(String arg0) throws ElementNotFoundException {
		return grafo.removeEdge(arg0);
	}
	public void removeElementSink(ElementSink arg0) {
		grafo.removeElementSink(arg0);
	}
	public <T extends Node> T removeNode(int arg0) throws IndexOutOfBoundsException {
		return grafo.removeNode(arg0);
	}
	public <T extends Node> T removeNode(Node arg0) {
		return grafo.removeNode(arg0);
	}
	public void removeSink(Sink arg0) {
		grafo.removeSink(arg0);
	}
	public void setAttribute(String arg0, Object... arg1) {
		grafo.setAttribute(arg0, arg1);
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
	public void setNullAttributesAreErrors(boolean arg0) {
		grafo.setNullAttributesAreErrors(arg0);
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
	public void write(FileSink arg0, String arg1) throws IOException {
		grafo.write(arg0, arg1);
	}
	public void write(String arg0) throws IOException {
		grafo.write(arg0);
	}
	
}
