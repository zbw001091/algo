package sortBaseOnArray;

import java.util.Arrays;

/**
 * 直接插入排序
 *
 */
public class InsertionSort {

	// 从左往右
	// 从数组的第2个元素开始，每次以1个元素为比较对象，把该元素尽可能地往前移动排序
	// 6-3-5-2-4 (这是原始数组，开始，以3为比较对象，若3前面的数>3，就把3往前移动，得到下面的结果)
	// 3-6-5-2-4 (随着，++i，这次以5为比较对象)
	// 3-5-6-2-4 (随着，++i，这次以2为比较对象)
	// 2-3-5-6-4 (随着，++i，这次以4位比较对象)
	// 2-3-4-5-6 
	// 插入排序，a表示数组，end表示数组大小
    public static void insertionSortL2R(int[] a, int end) {
        if (end <= 1) return;

        for (int i = 1; i < end; ++i) {
            int value = a[i]; // 以第i位数字为比较对象，帮它在序列里第i位往左找到自己的定位。每个循环处理1个数字
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            System.out.println(j);
            a[j + 1] = value;
            System.out.println(Arrays.toString(a));
        }
    }
    
    // ZhangBangwei
    // 从右往左
    // 插入排序，a表示数组，end表示数组大小
    public static void insertionSortR2L(int[] a, int end) {
    	if (end <= 1) return;
    	
    	for (int i = end - 2; i >= 0; --i) { 
    		int value = a[i]; // 以第i位数字为比较对象，帮它在序列里第i位往右找到自己的定位。每个循环处理1个数字
    		int j = i + 1;
    		for (; j <= end - 1; ++j) {
    			if (a[j] < value) {
    				a[j-1] = a[j]; // 以自己当前的位置j，往右移1格，变成j+1
    			} else {
    				break;
    			}
    		}
    		a[j-1] = value;
    		System.out.println(Arrays.toString(a));
    	}
    }
}
