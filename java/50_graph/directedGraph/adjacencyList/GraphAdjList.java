package directedGraph.adjacencyList;

/**
 * @author ZhangBangwei
 *
 */
public class GraphAdjList<Type> {

	private Vertex[] vertexs;
	private int vertexMaxNum; // 顶点最大允许个数
	private int vertexCurrNum = 0; // 当前Graph里的已有的顶点个数
	private boolean[] visited;
	
	public void createGraph(int vertexMaxNum) {
		this.vertexMaxNum = vertexMaxNum;
		this.vertexs = new Vertex[vertexMaxNum];
		this.visited = new boolean[vertexMaxNum];
	}
	
	public int getVertexIdByVertexValue(Type data) {
		return 0;
	}
	
	public void setVertexValueByVertexId(int id) {
		
	}
	
	/**
	 * 【顶点操作】在图中，新增1顶点
	 * >>> 邻接表的数组中，增加顶点元素
	 */
	public void insertVertex(Type data) {
		if (vertexCurrNum >= vertexMaxNum) { // 图，满了
			return;
		}
		vertexs[vertexCurrNum++] = new Vertex<Type>(data);
	}
	
	/**
	 * 【边操作】在图中，新增1条弧<from,to>
	 * 注意：有向图
	 * >>> 邻接表的链表中，增加链表元素
	 */
	public void insertArc(int from, int to) {
		// 检查from/to的数组下标，小于vertexCurrNum数。增加弧之前，顶点必须存在，否则不允许增加弧
		if (from >= vertexCurrNum || to >= vertexCurrNum) {
			return;
		}
		
		EdgeNode arc = new EdgeNode();
		arc.setAdjVex(to);
		arc.setNextEdge(this.vertexs[from].firstEdge);
		// 把新insert的弧，加入到数组的第一个adjList元素
		this.vertexs[from].firstEdge = arc;
	}
	
	/**
	 * 【顶点操作】在图中，删除1顶点及其边(无向)/弧(有向)
	 */
	public void deleteVertexById(int id) {
		
	}
	
	/**
	 * 【边操作】在图中，删除1条弧<from,to>
	 */
	public void deleteArc(int from, int to) {
		
	}
	
	/**
	 * 【顶点操作】在图中，返回顶点v的第一个邻接顶点(的数组下标)
	 * 若顶点v在Graph中无邻接顶点，则返回null
	 */
	public int getFirstAdjVertex(int v) {
		return 0;
	}
	
	/**
	 * 【顶点操作】在图中，返回顶点v相对于顶点w的下一个邻接顶点
	 * 若顶点w是顶点v的最后一个邻接顶点，则返回null
	 */
	public int getNextAdjVertex(int v, int w) {
		return 0;
	}
	
	/**
	 * 邻接表 深度优先遍历
	 * 适用于：连通图 and 非连通图
	 */
	public void DFSTraverse() {
		for (int i = 0; i < this.vertexMaxNum; ++i) {
			this.visited[i] = false;
		}
		for (int i = 0; i < this.vertexCurrNum; ++i) {
			if (!this.visited[i]) { // 若是连通图，只会进DFS(i)一次。若是非连通图，会进DFS(i)若干次，取决于有多少个连通分量
				DFS(i);
			}
		}
	}
	
	/**
	 * @param i 从哪个顶点开始深度优先遍历
	 */
	private void DFS(int i) {
		System.out.println("vertex: " + vertexs[i].data);
		this.visited[i] = true;
		
		EdgeNode next = vertexs[i].firstEdge;
		while (next != null) {
			if (!visited[next.getAdjVex()]) {
				DFS(next.getAdjVex());
			}
			next = next.getNextEdge();
		}
	}
	
	/**
	 * 广度优先遍历
	 * 适用于：连通图 and 非连通图
	 */
	public void HFSTraverse() {
		for (int i = 0; i <= this.vertexMaxNum; ++i) {
			this.visited[i] = false;
		}
		for (int i = 0; i <= this.vertexCurrNum; ++i) {
			if (!this.visited[i]) { // 若是连通图，只会进HFS(i)一次。若是非连通图，会进HFS(i)若干次，取决于有多少个连通分量
				HFS(i);
			}
		}
	}
	
	/**
	 * @param i 从哪个顶点开始广度优先遍历
	 */
	private void HFS(int i) {
		enqueue(把i入队);
		while (queue不是空) {
			int v = dequeue();
			
			if (!this.visited[v]) {
				System.out.println(this.vertexs[i].data);
				this.visited[i] = true;
			}
			
			EdgeNode next = this.vertexs[v].firstEdge;
			while (next != null) {
				if (!this.visited[next.getAdjVex()]) {
					System.out.println(this.vertexs[next.getAdjVex()].data);
					this.visited[next.getAdjVex()] = true;
				}
				enqueue(next.getAdjVex());
				next = next.getNextEdge();
			}
		}
	}
}
