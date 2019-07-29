package test;

/**
 * @author st78sr
 * 
 * 给定数列，求所有的排列组合
 * 比如4个元素的数列，排列的个数是阶乘，4! = 4*3*2*1 = 24
 */
public class FullSort {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		fullSort(arr, 0, arr.length - 1);
	}
	private static int cnt = 1;

	public static void fullSort(int[] arr, int start, int end) {
		// 递归终止条件
		if (start == end) {
			System.out.print("line" + FullSort.cnt++ +": ");
			for (int i : arr) {
				System.out.print(i);
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= end; i++) {
			swap(arr, i, start); // 2个元素换位
			fullSort(arr, start + 1, end);
			swap(arr, i, start); // 处理完，2个元素还原
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}