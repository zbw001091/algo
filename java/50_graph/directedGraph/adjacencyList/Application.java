package directedGraph.adjacencyList;

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
		GraphAdjList<Integer> directedGraph_connected = new GraphAdjList<Integer>();
		directedGraph_connected.createGraph(4); // 定义graph至多4个顶点vertex
		
		for(int i = 0; i < 4; ++i) {
			directedGraph_connected.insertVertex(i);
		}
		directedGraph_connected.insertArc(0, 1);
		directedGraph_connected.insertArc(1, 2);
		directedGraph_connected.insertArc(2, 3);
		directedGraph_connected.insertArc(3, 0);
		directedGraph_connected.insertArc(0, 2);
		System.out.println("begin to DFStraverse directedGraph_connected: ");
		directedGraph_connected.DFSTraverse();
		System.out.println("end DFStraverse directedGraph_connected");
		
		/**
		 * 有向图/非连通图
		 * 		0
		 *    / | \
		 *   1  |  3  4 - 5
		 *    \ | /
		 * 		2
		 */
		GraphAdjList<Integer> directedGraph_disconnected = new GraphAdjList<Integer>();
		directedGraph_disconnected.createGraph(6);
		
		for(int i = 0; i < 6; ++i) {
			directedGraph_disconnected.insertVertex(i);
		}
		directedGraph_disconnected.insertArc(0, 1);
		directedGraph_disconnected.insertArc(1, 2);
		directedGraph_disconnected.insertArc(2, 3);
		directedGraph_disconnected.insertArc(3, 0);
		directedGraph_disconnected.insertArc(0, 2);
		directedGraph_disconnected.insertArc(4, 5);
		System.out.println("begin to DFStraverse directedGraph_disconnected: ");
		directedGraph_disconnected.DFSTraverse();
		System.out.println("end DFStraverse directedGraph_disconnected");
	}

}
