package doublyLinkedList;

/**
 * 双向链表，主类
 *
 * Author：ZhangBangwei
 */
public class Application {

	public static void main(String[] args) {
		DoublyLinkedList link = new DoublyLinkedList();
		int data[] = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < data.length; i++) {
//			link.insertToHead(data[i]);
			link.insertToTail(data[i]);
		}
		link.printAll();
	}

}
