package directedGraph.adjacencyList;

/**
 * @author ZhangBangwei
 *
 */
public class Vertex<Type> {
	private Type data;
	private EdgeNode adjList;
	
	public Vertex(Type data) {
		this.data = data;
		this.adjList = null;
	}	
}
