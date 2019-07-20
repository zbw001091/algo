package directedGraph.adjacencyMatrix;

import directedGraph.adjacencyMatrix.Vertex;

/**
 * @author ZhangBangwei
 *
 */
public class GraphAdjMatrix<Type> {
	private Vertex[] vertexs; // 顶点一维数组
	private int[][] arcs; // 边/弧二维数组
	private int vertexMaxNum; // 顶点最大允许个数
	private int vertexCurrNum = 0; // 当前Graph里的已有的顶点个数
	
	public void createGraph(int vertexMaxNum) {
		this.vertexMaxNum = vertexMaxNum;
		this.vertexs = new Vertex[vertexMaxNum];
		this.arcs = new int[vertexMaxNum][vertexMaxNum];
	}
	
	/**
	 * 【顶点操作】在图中，新增1顶点
	 * >>> 邻接矩阵的顶点数组中，增加顶点元素
	 */
	public void insertVertex(Type data) {
		if (vertexCurrNum >= vertexMaxNum) { // 图，满了
			return;
		}
		vertexs[vertexCurrNum++] = new Vertex(data);
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
	
	// TODO 邻接矩阵 深度优先遍历
	public void DFSTraverse() {
		
	}
	
	// TODO 邻接矩阵 广度优先遍历
	public void HFSTraverse() {
		
	}
}
