
/**
 * Created by wangzheng on 2018/10/9.
 * Modified by ZhangBangwei
 */
// 用数组实现的队列
// 入队：从tail入队
// 出队：从head出队
public class QueueBasedOnArrayStatic {
	// 数组:items。数组大小:cap
	private String[] items;
	private int cap = 0;
	// head表示队头下标，tail表示队尾下标
	private int head = 0;
	private int tail = 0;

	// 申请一个大小为capacity的数组
	public QueueBasedOnArrayStatic(int capacity) {
		items = new String[capacity];
		cap = capacity;
	}

	// 入队
	public boolean enqueue(String item) {
		// 如果tail == cap，表示队列已经满了
		if (tail == cap)
			return false;
		items[tail] = item;
		++tail;
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
