package directedGraph.adjacencyMatrix;

/**
 * @author ZhangBangwei
 *
 */
public class Application {
	
	public static void main(String[] args) {
		
		/**
		 * 有向图/连通图
		 * 		0
		 *    / | \
		 *   1  |  3
		 *    \ | /
		 * 		2
		 */
		GraphAdjMatrix<Integer> directedGraph_connected = new GraphAdjMatrix<Integer>();
		directedGraph_connected.createGraph(4);
		
		for(int i = 0; i < 4; ++i) {
			directedGraph_connected.insertVertex(i);
		}
		directedGraph_connected.insertArc(0, 1, 100);
		directedGraph_connected.insertArc(1, 2, 200);
		directedGraph_connected.insertArc(2, 3, 300);
		directedGraph_connected.insertArc(3, 0, 400);
		directedGraph_connected.insertArc(0, 2, 500);
		System.out.println("begin to DFStraverse directedGraph_connected: ");
		directedGraph_connected.DFSTraverse();
		System.out.println("end DFStraverse directedGraph_connected");
		
		/**
		 * 无向图/连通图
		 * 		0
		 *    / | \
		 *   1  |  3
		 *    \ | /
		 * 		2
		 */
		GraphAdjMatrix<Integer> undirectedGraph_connected = new GraphAdjMatrix<Integer>();
		undirectedGraph_connected.createGraph(4);
		
		for(int i = 0; i < 4; ++i) {
			undirectedGraph_connected.insertVertex(i);
		}
		undirectedGraph_connected.insertArc(0, 1, 100);
		undirectedGraph_connected.insertArc(1, 2, 200);
		undirectedGraph_connected.insertArc(2, 3, 300);
		undirectedGraph_connected.insertArc(3, 0, 400);
		undirectedGraph_connected.insertArc(0, 2, 500);
	}
}
