package sortBaseOnArray;
import java.util.Arrays;

public class SortApplication {

	public static void main(String[] args) {
		int bubbleData[] = { 1, 5, 3, 2, 4 };
		System.out.print("冒泡排序前: ");
		System.out.println(Arrays.toString(bubbleData));
		
		BubbleSort.bubbleSort(bubbleData, bubbleData.length);
		System.out.print("冒泡排序后: ");
		System.out.println(Arrays.toString(bubbleData));
		
		
		
		System.out.println("################################");
		int selectionData[] = { 1, 5, 3, 2, 4 };
		System.out.print("选择排序前: ");
		System.out.println(Arrays.toString(selectionData));
		
		SelectionSort.selectionSort(selectionData, selectionData.length);
		System.out.print("选择排序后: ");
		System.out.println(Arrays.toString(selectionData));
		
		
		
		System.out.println("################################");
		int insertionData[] = { 1, 5, 3, 2, 4 };
		System.out.print("插入排序前: ");
		System.out.println(Arrays.toString(insertionData));
		
		InsertionSort.insertionSort(insertionData, insertionData.length);
		System.out.print("插入排序后: ");
		System.out.println(Arrays.toString(insertionData));
		
		
		
		System.out.println("################################");
		int shellData[] = { 1, 5, 3, 2, 4 };
		System.out.print("希尔排序前: ");
		System.out.println(Arrays.toString(shellData));
		
		ShellSort.shellSort(shellData);
		System.out.print("希尔排序后: ");
		System.out.println(Arrays.toString(shellData));
		
		
		
		System.out.println("################################");
		int mergeData[] = { 1, 5, 3, 2, 4 };
		System.out.print("归并排序前: ");
		System.out.println(Arrays.toString(mergeData));
		
		MergeSort.mergeSort(mergeData, mergeData.length);
		System.out.print("归并排序后: ");
		System.out.println(Arrays.toString(mergeData));

		
		
		System.out.println("################################");
		int quickData[] = { 1, 5, 3, 2, 4 };
		System.out.print("快速排序前: ");
		System.out.println(Arrays.toString(quickData));
		
		QuickSort.quickSort(quickData, quickData.length);
		System.out.print("快速排序后: ");
		System.out.println(Arrays.toString(quickData));

		
		
		System.out.println("################################");
		int countingData[] = { 1, 5, 3, 2, 4 };
		System.out.print("计数排序前: ");
		System.out.println(Arrays.toString(countingData));
		
		CountingSort.countingSort(countingData, countingData.length);
		System.out.print("计数排序后: ");
		System.out.println(Arrays.toString(countingData));

		
		
		System.out.println("################################");
		int bucketData[] = { 1, 5, 3, 2, 4 };
		System.out.print("桶排序前: ");
		System.out.println(Arrays.toString(bucketData));
		
		BucketSort.bucketSort(bucketData, bucketData.length);
		System.out.print("桶排序后: ");
		System.out.println(Arrays.toString(bucketData));
	}

}
