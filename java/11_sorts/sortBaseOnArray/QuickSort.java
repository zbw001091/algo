package sortBaseOnArray;

import java.util.Arrays;

/**
 * 快速排序 Created by wangzheng on 2018/10/16.
 */
public class QuickSort {

	// 快速排序，a是数组，n表示数组的大小
	public static void quickSort(int[] a, int n) {
		quickSortInternally(a, 0, n - 1);
	}

	// 快速排序递归函数，p,r为下标
	private static void quickSortInternally(int[] a, int p, int r) {
		if (p >= r)
			return;

		int q = partition(a, p, r); // 获取分区点
		quickSortInternally(a, p, q - 1);
		quickSortInternally(a, q + 1, r);
	}

	private static int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int i = p;
		for (int j = p; j < r; ++j) {
			if (a[j] < pivot) {
				if (i == j) {
					++i;
				} else {
					int tmp = a[i];
					a[i++] = a[j];
					a[j] = tmp;
				}
			}
		}

		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;

		System.out.println("i=" + i);
		System.out.println(Arrays.toString(a));
		return i;
	}

	// 快速排序
	public static void qSort(int a[], int p, int r) {
		if (p < r) {
//			System.out.println("p="+p+",r="+r);
			int pivot = a[p];
			int i = p, j = r;
			while (i < j)
	        {
	            while (i < j && a[j] >= pivot)
	            {
	                j--;
	            }
	            if(i < j) a[i++] = a[j];
//	            System.out.println("aaa: " + Arrays.toString(a));
	            
	            while (i < j && a[i] <= pivot)
	            {
	                i++;
	            }
	            if(i < j) a[j--] = a[i];
//	            System.out.println("bbb: " + Arrays.toString(a));
	        }
			a[i] = pivot; // 把pivot放到正确的位子，分成左右2段
//			System.out.println("ccc: " + Arrays.toString(a));
			qSort(a, p, i - 1);
			qSort(a, j + 1, r);
		}
	}
}
