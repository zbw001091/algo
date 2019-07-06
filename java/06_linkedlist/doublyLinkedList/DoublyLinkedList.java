package doublyLinkedList;

/**
 * 1）双向链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * Author：Zhang Bangwei
 */
public class DoublyLinkedList {
	private DoublyNode head = null;
	
	public DoublyNode insertToTail(int value) {
		DoublyNode newNode = new DoublyNode(value,null,null);
		if (head == null) {
			head = newNode;
		} else {
			DoublyNode p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = newNode;
			newNode.prev = p;
			newNode.next = null;
		}
		return head;
	}
	
	public DoublyNode insertToHead(int value) {
		DoublyNode newNode = new DoublyNode(value,null,null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		return newNode;
	}
	
	public void printAll() {
		DoublyNode p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
}
