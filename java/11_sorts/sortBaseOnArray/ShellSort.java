package sortBaseOnArray;
/**
 * 希尔排序
 *
 * Author: wliu
 */
public class ShellSort {

	public static void shellSort(int[] arr) {
		int len = arr.length;
		if (len == 1)
			return;

		int step = len / 2;
		while (step >= 1) {
			for (int i = step; i < len; i++) {
				int value = arr[i];
				int j = i - step;
				for (; j >= 0; j -= step) {  // 直接插入排序
					if (value < arr[j]) {
						arr[j + step] = arr[j];
					} else {
						break;
					}
				}
				arr[j + step] = value;
			}

			step = step / 2;
		}
	}

	private static void print(int[] arr) {
		System.out.println("Print array:");
		for (int x : arr) {
			System.out.print(x + "\t");
		}
		System.out.println("");
	}
}
