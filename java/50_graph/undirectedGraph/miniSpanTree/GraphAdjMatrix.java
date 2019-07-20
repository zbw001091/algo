package undirectedGraph.miniSpanTree;


/**
 * @author ZhangBangwei
 *
 */
public class GraphAdjMatrix<Type> {
	private Vertex<Type>[] vertexs; // 顶点一维数组
	private int[][] arcs; // 边/弧二维数组。对于普通边/弧就存0/1，对于带权图就存weight
	private int vertexMaxNum; // 顶点最大允许个数
	private int vertexCurrNum = 0; // 当前Graph里的已有的顶点个数
	private boolean[] visited;
	
	public void createGraph(int vertexMaxNum) {
		this.vertexMaxNum = vertexMaxNum;
		this.vertexs = new Vertex[vertexMaxNum];
		this.arcs = new int[vertexMaxNum][vertexMaxNum];
		this.visited = new boolean[vertexMaxNum];
	}
	
	/**
	 * 【顶点操作】在图中，新增1顶点
	 * >>> 邻接矩阵的顶点数组中，增加顶点元素
	 */
	public void insertVertex(Type data) {
		if (vertexCurrNum >= vertexMaxNum) { // 图，满了
			return;
		}
		vertexs[vertexCurrNum++] = new Vertex<Type>(data);
	}
	
	/**
	 * 【边操作】在图中，新增1条带权重的弧arc <from,to>
	 * 注意：有向图
	 * >>> 邻接矩阵的二维数组中，增加弧arc
	 */
	public void insertArc(int from, int to, int weight) {
		// 检查from/to的数组下标，小于vertexCurrNum数。增加弧之前，顶点必须存在，否则不允许增加弧
		if (from >= vertexCurrNum || to >= vertexCurrNum) {
			return;
		}
		this.arcs[from][to] = weight;
	}
	
	/**
	 * 【边操作】在图中，新增1条带权重的边edge (from,to)
	 * 注意：无向图
	 * >>> 邻接矩阵的二维数组中，增加边edge
	 */
	public void insertEdge(int from, int to, int weight) {
		// 检查from/to的数组下标，小于vertexCurrNum数。增加边之前，顶点必须存在，否则不允许增加边
		if (from >= vertexCurrNum || to >= vertexCurrNum) {
			return;
		}
		this.arcs[from][to] = weight;
		this.arcs[to][from] = weight;
	}
	
	/** 
	 * 邻接矩阵 深度优先遍历
	 * 适用于：连通图 and 非连通图
	 */
	public void DFSTraverse() {
		for (int i = 0; i < this.vertexMaxNum; ++i) {
			this.visited[i] = false;
		}
		for (int i = 0; i < this.vertexMaxNum; ++i) {
			if (!this.visited[i]) { // 若是连通图，只会进DFS(i)一次。若是非连通图，会进DFS(i)若干次，取决于有多少个连通分量
				DFS(i);
			}
		}
	}
	
	/**
	 * @param i 从哪个顶点开始深度优先遍历
	 * i：矩阵的行
	 * colume：矩阵的列
	 */
	private void DFS(int i) {
		System.out.println(this.vertexs[i].data);
		this.visited[i] = true;
		for (int colume = 0; colume < this.vertexMaxNum; ++colume) {
			if ((this.visited[colume] == false) && (this.arcs[i][colume] != 0) && (i != colume)) {
				DFS(colume);
			}
		}
	}
	
	/**
	 * 邻接矩阵 广度优先遍历
	 * 适用于：连通图 and 非连通图
	 */
	public void HFSTraverse() {
		for (int i = 0; i < this.vertexMaxNum; ++i) {
			this.visited[i] = false;
		}
		for (int i = 0; i < this.vertexMaxNum; ++i) {
			if (!this.visited[i]) { // 若是连通图，只会进HFS(i)一次。若是非连通图，会进HFS(i)若干次，取决于有多少个连通分量
				HFS(i);
			}
		}
	}
	
	/**
	 * @param i 从哪个顶点开始广度优先遍历
	 * i：矩阵的行
	 * colume：矩阵的列
	 */
	private void HFS(int i) {
		System.out.println(this.vertexs[i].data);
		this.visited[i] = true;
		while (dequeue队列不是空) {
			int row = dequeue();
			for (int colume = 0; colume < this.vertexMaxNum; ++colume) {
				if ((this.visited[colume] == false) && (this.arcs[row][colume] != 0) && (row != colume)) {
					System.out.println(this.vertexs[colume].data);
					this.visited[colume] = true;
					enqueue(colume);
				}
			}
		}
			
	}
}
