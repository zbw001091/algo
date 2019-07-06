package doublyLinkedList;

/**
 * 双向链表节点
 *
 * Author：ZhangBangwei
 */
public class DoublyNode {
	public int data;
	public DoublyNode prev;
	public DoublyNode next;
	
	public DoublyNode(int data, DoublyNode prev, DoublyNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}