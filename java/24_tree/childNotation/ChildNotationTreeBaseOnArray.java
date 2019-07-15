package childNotation;

import parentNotation.Node;

/**
 * @author ZhangBangwei
 * 
 * 基于数组，实现的Tree
 * 孩子表示法
 * 
 * 参考《孩子表示法》的数据结构图
 * 用NodeHead表示所有的节点(数组结构)
 * 用NodeBody表示每个节点的子节点链表(链表结构)
 */
public class ChildNotationTreeBaseOnArray {
	private int root; // 根节点的数组下标
	private int count; // 节点数
	private NodeHead[] nodes = new NodeHead[100]; // 最多放100个节点
	
	// step1，所有节点，层次遍历法，放入NodeHead[]数组
	// step2，计算每个节点的子节点，构成链表，挂在对应NodeHead上面
}
