package heap;

/**
 * @author st78sr
 *
 */
public class Heapify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 该数组，对应一棵完全二叉树，从top到level1到level2的次序
		int[] nums = {50, 10, 90, 30, 70, 40, 80, 60, 20};
		
		// 把上述完全二叉树，堆化
		Heapify h = new Heapify();
		h.heapify(nums);
		
		// 堆化以后，查询堆顶元素
		h.top(nums);
	}
	
	/**
	 * 将传入参数nums数组，进行堆化（大顶堆）
	 * @param nums
	 */
	public void heapify(int[] nums) {
		
	}

	/**
	 * 查询堆顶元素
	 * @param nums
	 * @return
	 */
	public int top(int[] nums) {
		return -1;
	}
	
	private void swap() {
		
	}
}
