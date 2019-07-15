package childNotation;

/**
 * @author ZhangBangwei
 * 
 * 基于数组+链表，实现的Tree
 * 孩子表示法
 * 
 * 所有节点由数组存储，每个数组元素（节点）上有一个指针指向1个链表（该节点的所有子节点）。
 * 本类是Body结构。参考《孩子表示法》的数据结构图
 */
public class NodeBody {
	public int node; // 节点所在的数组下标
	public NodeBody next; // 同1个双亲节点的下一个子节点
}
