
/**
 * 基于链表(单链表)实现的栈。
 *
 * 注：单链表有head指针，栈需要top指针。就用单链表的head代表栈的top。
 * 注意不是用单链表的tail，因为head操作O(1)，tail操作O(n)，性价比。
 * Author: Zheng
 */
public class StackBasedOnLinkedList {
	private Node top = null;

	public void push(int value) {
		Node newNode = new Node(value, null);
		// 判断是否栈空
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	/**
	 * 我用-1表示栈中没有数据。
	 */
	public int pop() {
		if (top == null)
			return -1;
		int value = top.data;
		top = top.next;
		return value;
	}

	// TODO 若栈存在，销毁它
	public void destroyStack() {
		
	}
	
	// TODO 返回栈的元素个数
	public int stackLength() {
		return 0;
	}
	
	public void printAll() {
		Node p = top;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}
	}
}
