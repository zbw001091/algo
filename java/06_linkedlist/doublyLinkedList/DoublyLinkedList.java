package doublyLinkedList;
/**
 * 1）双向链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * Author：Zhang Bangwei
 */
public class DoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class DoublyNode {
		private int data;
		private DoublyNode prev;
		private DoublyNode next;
		
		public DoublyNode(int data, DoublyNode prev, DoublyNode next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
}
