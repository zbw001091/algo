package directedGraph.adjacencyList;

/**
 * @author ZhangBangwei
 *
 */
public class EdgeNode {
	private int adjVex; // 本邻接顶点的数组下标
	private int weight; // 权重
	private EdgeNode nextEdge; // 指向下一个邻接顶点的EdgeNode对象，单链表
	
	public EdgeNode() {
		
	}

	public int getAdjVex() {
		return adjVex;
	}

	public void setAdjVex(int adjVex) {
		this.adjVex = adjVex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public EdgeNode getNextEdge() {
		return nextEdge;
	}

	public void setNextEdge(EdgeNode nextEdge) {
		this.nextEdge = nextEdge;
	}
	
}
