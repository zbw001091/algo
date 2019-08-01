import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author st78sr
 *
 */
public class TopNByBucketSort {

	private int[] nums = { 1, 1, 1, 5, 3, 2, 5, 4, 5, 5, 5, 8, 8 };
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TopNByBucketSort object = new TopNByBucketSort();
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		// 构建hashmap，对原始数组进行group by
		for (int num : object.nums) {
			if (hashmap.containsKey(num)) {
				hashmap.put(num, hashmap.get(num) + 1);
			} else {
				hashmap.put(num, 1);
			}
		}
		
		// 遍历hashmap
		// resultArray[]数组，下标是count个数，value是该下标对应的数字，比如5个3，则下标为5，value为3
		// resultArray[]数组里的每一个元素都是一个List<Integer>，存储着，count个数相同的元素数字
		List<Integer>[] resultArray = new List[object.nums.length];
		for (int key : hashmap.keySet()) {
			int count = hashmap.get(key);
			if (resultArray[count] == null) {
				resultArray[count] = new ArrayList<Integer>();
			}
			resultArray[count].add(key);
		}
		
		for (int i = resultArray.length - 1; i > 0; --i) {
			if (resultArray[i] != null) {
				for (int num : resultArray[i]) {
					System.out.println("共有" + i + "个，数字" + num);
				}
			}
		}
	}

	
}
