package directedGraph.adjacencyList;

/**
 * @author ZhangBangwei
 *
 */
public class EdgeNode {
	private int adjvex; // 本邻接顶点的数组下标
	private int weight; // 权重
	private EdgeNode next; // 指向下一个邻接顶点的对象，单链表
	
	public EdgeNode(int adjvex, int weight, EdgeNode next) {
		this.adjvex = adjvex;
		this.weight = weight;
		this.next = next;
	}
}
