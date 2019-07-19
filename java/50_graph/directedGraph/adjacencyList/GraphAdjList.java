package directedGraph.adjacencyList;

/**
 * @author ZhangBangwei
 *
 */
public class GraphAdjList<Type> {

	// 图，至多100个顶点
	private Vertex<Integer>[] vertexs = new Vertex[100];
	
	public void createGraph() {
		
	}
	
	public int getVertexIdByVertexValue(GraphAdjList g, Type data) {
		return 0;
	}
	
	public void setVertexValueByVertexId(GraphAdjList g, int id) {
		
	}
	
	/**
	 * 【顶点操作】在图中，新增1顶点
	 */
	public void insertVertex(GraphAdjList g, Type data) {
		Vertex v = new Vertex<Integer>(1);
		// 再把该vertex放入数组里
	}
	
	/**
	 * 【顶点操作】在图中，删除1顶点及其边(无向)/弧(有向)
	 */
	public void deleteVertexById(GraphAdjList g, int id) {
		
	}
	
	/**
	 * 【边操作】在图中，新增1条弧<from,to>
	 */
	public void insertArc(GraphAdjList g, int from, int to) {
		
	}
	
	/**
	 * 【边操作】在图中，删除1条弧<from,to>
	 */
	public void deleteArc(GraphAdjList g, int from, int to) {
		
	}
	
	/**
	 * 【顶点操作】在图中，返回顶点v的第一个邻接顶点(的数组下标)
	 * 若顶点v在Graph中无邻接顶点，则返回null
	 */
	public int getFirstAdjVertex(GraphAdjList g, int v) {
		return 0;
	}
	
	/**
	 * 【顶点操作】在图中，返回顶点v相对于顶点w的下一个邻接顶点
	 * 若顶点w是顶点v的最后一个邻接顶点，则返回null
	 */
	public int getNextAdjVertex(GraphAdjList g, int v, int w) {
		return 0;
	}
	
	/**
	 * 深度优先遍历
	 */
	public void DFSTraverse(GraphAdjList g) {
		
	}
	
	/**
	 * 广度优先遍历
	 */
	public void HFSTraverse(GraphAdjList g) {
		
	}
}
