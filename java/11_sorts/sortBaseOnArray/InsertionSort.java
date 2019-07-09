package sortBaseOnArray;
/**
 * 直接插入排序
 *
 */
public class InsertionSort {

	// 从左往右
	// 从数组的第2个元素开始，每次以1个元素为比较对象，把该元素尽可能地往前移动排序
	// 6-3-5-2-4 (以3为比较对象，若3前面的数>3，就把3往前移动，得到下面的结果)
	// 3-6-5-2-4 (随着，++i，这次以5为比较对象)
	// 3-5-6-2-4 (随着，++i，这次以2为比较对象)
	// 2-3-5-6-4 (随着，++i，这次以4位比较对象)
	// 2-3-4-5-6 
	// 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
