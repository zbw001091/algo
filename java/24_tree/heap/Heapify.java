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
		// 第一位故意留0，让数组下标从1开始和位数保持一致
		int[] nums = {0, 50, 10, 90, 30, 70, 40, 80, 60, 100};
		int numsLength = nums.length - 1; // 去掉首位的0
		
		// 把上述完全二叉树，堆化
		Heapify h = new Heapify();
		h.heapify(nums, numsLength);
		
		// 堆化以后，查询堆顶元素
//		System.out.println(h.top(nums));
		h.print(nums);
	}
	
	/**
	 * 【堆化+堆排序】
	 * 将传入参数nums数组，进行堆化（大顶堆）
	 * 
	 * 堆化算法的思路，最外层for循环是从完全二叉树的右下角(有子节点的节点)开始，逐步堆化每一个小的三角形，由右向左，由下至上，bottom-up
	 * @param nums
	 */
	public void heapify(int[] nums, int numsLength) {
		
		// 下面的for循环做完，只能求得1个大顶（要做堆排序，需要不断地求出大顶）
		for (int i = numsLength/2; i > 0; --i) {
			heapAdjust(nums, i, numsLength);
		}
		
		// 每次求出大顶，pop出大顶，i减1，代表堆元素少了1个
		// 堆排序
		for (int i = numsLength-1; i > 0; --i) {
			swap(nums, 1, i+1);
			print(nums);
			for (int j = i/2; j > 0; --j) {
				heapAdjust(nums, j, i);
			}
		}
	}

	/**
	 * 查询堆顶元素
	 * @param nums
	 * @return
	 */
	public int top(int[] nums) {
		return nums[1];
	}
	
	private void print(int[] nums) {
		for (int i = 0; i < nums.length; ++i) {
			System.err.print(nums[i] + " ");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * 把数组第i位和第j位，互换
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * 程序逻辑就是处理以subRoot为根的3角形的3个元素的大顶堆
	 * @param nums
	 * @param subRoot 本次循环要处理的小的子树的subRoot
	 * @param length
	 */
	private void heapAdjust(int[] nums, int subRoot, int length) {
		int temp = nums[subRoot];
		
		int left = subRoot * 2;
		int right = subRoot * 2 + 1;
		int child = left;
		
		if ((left < length) && (nums[left] < nums[right])) {
			child = right;
		}
		if (temp < nums[child]) {
			nums[subRoot] = nums[child];
			nums[child] = temp;
		}
	}
}
