package childNotation;

/**
 * @author ZhangBangwei
 * 
 * 基于数组，实现的Tree
 * 孩子表示法
 * 
 * Node的存储结构为，本身的data，及若干个指向子节点的指针
 * 取整棵树的度（此处为3），作为Node的指针个数（若节点的度相差很大，会存在空间浪费的情况）
 */
public class Node {
	public int data;
	public int child1; // 第一个子节点的数组下标
	public int child2; // 第二个子节点的数组下标
	public int child3; // 第三个子节点的数组下标
}
