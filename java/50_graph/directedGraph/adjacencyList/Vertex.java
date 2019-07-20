package directedGraph.adjacencyList;

/**
 * @author ZhangBangwei
 *
 */
public class Vertex<Type> {
	public Type data;
	public EdgeNode firstEdge;
	
	public Vertex(Type data) {
		this.data = data;
		this.firstEdge = null;
	}	
}
