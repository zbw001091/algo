package parentNotation;

/**
 * @author ZhangBangwei
 * 
 * 基于数组，实现的Tree
 * 双亲表示法
 */
public class Node {
	public int data;
	public int parent; // 指向双亲节点的"数组"下标
	
	public Node(int data) {
		this.data = data;
	}
}
