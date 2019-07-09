package sortBaseOnArray;
/**
 * 归并排序
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {

	// 归并排序算法, a是数组，n表示数组大小
	public static void mergeSort(int[] a, int n) {
		mergeSortInternally(a, 0, n - 1);
	}

	// 递归调用函数
	// start/end，都是数组下标，最大为n-1
	private static void mergeSortInternally(int[] a, int start, int end) {
		// 递归终止条件
		if (start >= end)
			return;
		
		// 取start到end之间的中间位置q,防止（start+end）的和超过int类型最大值
		int mid = start + (end - start) / 2;
		System.out.println(mid);
		// 分治递归
		mergeSortInternally(a, start, mid);
		mergeSortInternally(a, mid + 1, end);
		
		// 将a[start...mid]和a[mid+1...end]合并为a[start...end]
		merge(a, start, mid, end);
	}

	/**
	 * 合并(无哨兵)
	 *
	 */
	// 将2段有序表，a[begin...mid]和a[mid+1...stop]合并为a[begin...stop]
	private static void merge(int[] a, int begin, int mid, int stop) {
		int i = begin;
		int j = mid + 1;
		int k = 0; // 初始化变量i, j, k
		int[] tmp = new int[stop - begin + 1]; // 申请一个大小跟a[p...r]一样的临时数组
		while (i <= mid && j <= stop) { // 在大多数情况下，越界的情况是非常少的，那么每一次循环对越界的检查也会浪费 CPU 资源，而哨兵就是优化条件判断的。
			if (a[i] <= a[j]) {
				tmp[k++] = a[i++]; // i++等于i:=i+1
			} else {
				tmp[k++] = a[j++];
			}
		}

		// 判断哪个子数组中有剩余的数据
		int start = i;
		int end = mid;
		if (j <= stop) {
			start = j;
			end = stop;
		}

		// 将剩余的数据拷贝到临时数组tmp
		while (start <= end) {
			tmp[k++] = a[start++];
		}

		// 将tmp中的数组拷贝回a[p...r]
		for (i = 0; i <= stop - begin; ++i) {
			a[begin + i] = tmp[i];
		}
	}

	/**
	 * 合并(哨兵)
	 * 哨兵的merge方法，相比无哨兵的merge方法，节省了1个while和1个(i <= mid && j <= stop)条件判断
	 */
	private static void mergeBySentry(int[] arr, int begin, int mid, int stop) {
		int[] leftArr = new int[mid - begin + 2];
		int[] rightArr = new int[stop - mid + 1];

		for (int i = 0; i <= mid - begin; i++) {
			leftArr[i] = arr[begin + i];
		}
		// 第一个数组添加哨兵（最大值）
		leftArr[mid - begin + 1] = Integer.MAX_VALUE;

		for (int i = 0; i < stop - mid; i++) {
			rightArr[i] = arr[mid + 1 + i];
		}
		// 第二个数组添加哨兵（最大值）
		rightArr[stop - mid] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		int k = begin;
		while (k <= stop) {
			// 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else {
				arr[k++] = rightArr[j++];
			}
		}
	}
}
