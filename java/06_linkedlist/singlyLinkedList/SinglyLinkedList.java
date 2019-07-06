package singlyLinkedList;

/**
 * 1）单链表的插入、删除、查找操作； 2）链表中存储的是int类型的数据；
 *
 * Author：Zheng
 */
public class SinglyLinkedList {

	private Node head = null;

	public Node findByValue(int value) {
		Node p = head;
		while (p != null && p.data != value) {
			p = p.next;
		}
		return p;
	}

	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while (p != null && pos != index) {
			p = p.next;
			++pos;
		}
		return p;
	}

	// 无头结点
	// 表头部插入
	// 这种操作将于输入的顺序相反，逆序
	public void insertToHead(int value) {
		Node newNode = new Node(value, null);
		insertToHead(newNode);
	}

	public void insertToHead(Node newNode) {
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	// 顺序插入
	// 插入到链表尾部
	public Node insertToTail(int value) {
		Node newNode = new Node(value, null);
		// 空链表，可以插入新节点作为head，也可以不操作
		if (head == null) {
			head = newNode;
		} else {
			Node q = head;
			while (q.next != null) {
				q = q.next;
			}
			newNode.next = q.next;
			q.next = newNode;
		}
		return newNode;
	}
	
	// 构建1条有环的单链
	public Node buildLinkedListWithLoop() {
		int singlyDataWithLoop[] = { 1,2,5,2,2 };
		Node lastNode = null;
		for (int i = 0; i < singlyDataWithLoop.length; i++) {
			lastNode = this.insertToTail(singlyDataWithLoop[i]);
		}
		lastNode.next = this.head;
		return this.head;
	}

	// 在p节点的后面，进行插入
	public void insertAfter(Node p, int value) {
		Node newNode = new Node(value, null);
		insertAfter(p, newNode);
	}

	public void insertAfter(Node p, Node newNode) {
		if (p == null)
			return;
		newNode.next = p.next;
		p.next = newNode;
	}

	// 在p节点的前面，进行插入
	public void insertBefore(Node p, int value) {
		Node newNode = new Node(value, null);
		insertBefore(p, newNode);
	}

	public void insertBefore(Node p, Node newNode) {
		if (p == null)
			return;
		if (head == p) {
			insertToHead(newNode);
			return;
		}

		Node q = head;
		while (q != null && q.next != p) {
			q = q.next;
		}

		if (q == null) {
			return;
		}

		newNode.next = p;
		q.next = newNode;
	}

	public void deleteByNode(Node p) {
		if (p == null || head == null)
			return;

		if (p == head) {
			head = head.next;
			return;
		}

		Node q = head;
		while (q != null && q.next != p) {
			q = q.next;
		}

		if (q == null) {
			return;
		}

		q.next = q.next.next;
	}

	public void deleteByValue(int value) {
		if (head == null)
			return;

		Node p = head;
		Node q = null;
		while (p != null && p.data != value) {
			q = p;
			p = p.next;
		}

		if (p == null)
			return;

		if (q == null) {
			head = head.next;
		} else {
			q.next = q.next.next;
		}

		// 可重复删除指定value的代码
		/*
		 * if (head != null && head.data == value) { head = head.next; }
		 * 
		 * Node pNode = head; while (pNode != null) { if (pNode.next.data ==
		 * data) { pNode.next = pNode.next.next; continue; } pNode = pNode.next;
		 * }
		 */
	}

	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	// 判断true or false
	public boolean TFResult(Node left, Node right) {
		Node l = left;
		Node r = right;

		System.out.println("left_:" + l.data);
		System.out.println("right_:" + r.data);
		while (l != null && r != null) {
			if (l.data == r.data) {
				l = l.next;
				r = r.next;
				continue;
			} else {
				break;
			}
		}

		if (l == null && r == null) {
			System.out.println("什么结果");
			return true;
		} else {
			return false;
		}
	}
	
	// 判断是否为回文
	public boolean palindrome() {
		if (head == null) {
			return false;
		} else {
			System.out.println("判断是否回文: 开始执行找到中间节点");
			Node p = head;
			Node q = head;
			if (p.next == null) {
				System.out.println("判断是否回文: 只有一个元素");
				return true;
			}
			while (q.next != null && q.next.next != null) {
				p = p.next;
				q = q.next.next;
			}
			System.out.println("判断是否回文: 中间节点:" + p.data);
			System.out.println("判断是否回文: 开始执行奇数节点的回文判断");
			Node leftLink = null;
			Node rightLink = null;
			if (q.next == null) {
				// p 一定为整个链表的中点，且节点数目为奇数
				rightLink = p.next;
				leftLink = inverseLinkList(p).next;
				System.out.println("判断是否回文: 左边第一个节点" + leftLink.data);
				System.out.println("判断是否回文: 右边第一个节点" + rightLink.data);
			} else {
				// p q 均为中点
				rightLink = p.next;
				leftLink = inverseLinkList(p);
			}
			return TFResult(leftLink, rightLink);
		}
	}

	// 带结点的链表翻转
	// 从原链表的p节点开始，对p后面右边的链表进行翻转
	public Node inverseLinkList_head(Node p) {
		// Head为新建的一个头结点
		Node Head = new Node(9999, null);
		// p为原来整个链表的头结点,现在Head指向整个链表
		Head.next = p;
		/*
		 * 带头结点的链表翻转等价于 从第二个元素开始重新头插法建立链表
		 */
		Node Cur = p.next;
		p.next = null;
		Node next = null;

		while (Cur != null) {
			next = Cur.next;
			Cur.next = Head.next;
			Head.next = Cur;
//			System.out.println("first " + Head.data);

			Cur = next;
		}

		// 返回左半部分的中点之前的那个节点
		// 从此处开始同步像两边比较
		return Head;

	}

	// 无头结点的链表翻转
	// 从原链表head开始，到p节点为止，这段链表进行翻转
	public Node inverseLinkList(Node p) {
		Node pre = null;
		Node r = head;
		System.out.println("z---" + r.data);
		Node next = null;
		while (r != p) {
			next = r.next;
			r.next = pre;
			pre = r;
			r = next;
		}

		r.next = pre;
		// 返回左半部分的中点之前的那个节点
		// 从此处开始同步像两边比较
		return r;
	}

	public static Node createNode(int value) {
		return new Node(value, null);
	}

	public static void main(String[] args) {

		SinglyLinkedList link = new SinglyLinkedList();
		// int data[] = {1};
		// int data[] = {1,2};
		// int data[] = {1,2,3,1};
		// int data[] = {1,2,5};
		// int data[] = {1,2,2,1};
		// int data[] = {1,2,5,2,1};
		int data[] = { 1, 2, 5, 3, 1 };

		for (int i = 0; i < data.length; i++) {
			// link.insertToHead(data[i]);
			link.insertToTail(data[i]);
		}
		
		// 链表反转
		System.out.println("##############################");
		System.out.println("##### 1.以下开始,链表反转 #####");
		System.out.println("##############################");
		System.out.println("原始链表:");
		link.printAll();
		Node p = link.inverseLinkList_head(link.head);
		while(p != null){
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println();
		
		System.out.println("##############################");
		System.out.println("##### 2.以下开始,链表回文 #####");
		System.out.println("##############################");
		System.out.println("原始链表:");
		link.printAll();
		if (link.palindrome()) {
			System.out.println("是回文链表");
		} else {
			System.out.println("不是回文链表");
		}
		
		System.out.println("##############################");
		System.out.println("##### 3.以下开始,链表反转 #####");
		System.out.println("##############################");
		SinglyLinkedList singlyll = new SinglyLinkedList();
		int singlyData[] = { 1,2,5,2,2 };
		for (int i = 0; i < singlyData.length; i++) {
			singlyll.insertToTail(singlyData[i]);
		}
		System.out.print("原始链表:");
		singlyll.printAll();
		Node singlyReversellNode = LinkedListAlgo.reverse(singlyll.head);
		System.out.print("反转后的链表:");
		while (singlyReversellNode != null) {
			System.out.print(singlyReversellNode.data + " ");
			singlyReversellNode = singlyReversellNode.next;
		}
		System.out.println();
		
		System.out.println("##############################");
		System.out.println("##### 4.以下开始,链表测环 #####");
		System.out.println("##############################");
		SinglyLinkedList singlyllWithLoop = new SinglyLinkedList();
		Node head = singlyllWithLoop.buildLinkedListWithLoop();
		boolean isWithCircle = LinkedListAlgo.checkCircle(head);
		System.out.println("expect true, actual: " + isWithCircle);
		boolean isWithCircle2 = LinkedListAlgo.checkCircle(singlyReversellNode);
		System.out.println("expect false, actual: " + isWithCircle2);
	}

}
