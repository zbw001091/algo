
/**
 * Created by wangzheng on 2018/10/9.
 * Modified by ZhangBangwei
 */
// 用数组实现的队列
// 入队：从tail入队
// 出队：从head出队
public class QueueBasedOnArrayDynamic {
	// 数组:items。数组大小:cap
	private String[] items;
	private int cap = 0;
	// head表示队头下标，tail表示队尾下标
	private int head = 0;
	private int tail = 0;

	// 申请一个大小为capacity的数组
	public QueueBasedOnArrayDynamic(int capacity) {
		items = new String[capacity];
		cap = capacity;
	}

	// 入队操作，将item放入队尾
	public boolean enqueue(String item) {
		// tail == cap表示队列末尾没有空间了
		if (tail == cap) {
			// tail == cap && head == 0，表示整个队列都占满了
			if (head == 0)
				return false;
			// 数据搬移
			for (int i = head; i < tail; ++i) {
				items[i - head] = items[i];
			}
			// 搬移完之后重新更新head和tail
			tail -= head;
			head = 0;
		}

		items[tail] = item;
		tail++;
		return true;
	}

	// 出队
	public String dequeue() {
		// 如果head == tail 表示队列为空
		if (head == tail)
			return null;
		String ret = items[head];
		++head;
		return ret;
	}

	public void printAll() {
		for (int i = head; i < tail; ++i) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}
}
