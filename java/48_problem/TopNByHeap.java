import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author st78sr
 * 
 * 本题，要计算出现频率TopN高的元素
 * Heap，直接用PriorityQueue来满足
 */
public class TopNByHeap {
	private HashMap<Integer,Integer> hashmap = new HashMap();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int originData[] = { 1, 1, 1, 5, 3, 2, 5, 4, 5, 5, 5, 8, 8 };
		TopNByHeap object = new TopNByHeap();
		object.findTopN(originData, 3);
	}

	public void findTopN(int[] originData, int n) {
		for (int i = 0; i < originData.length; ++i) {
			if(hashmap.containsKey(originData[i])) {
				hashmap.put(originData[i], hashmap.get(originData[i]) + 1);
			} else {
				hashmap.put(originData[i], 1);
			}
		}
		for (int key : hashmap.keySet()) {
			System.out.println(key + ": " + hashmap.get(key));
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return hashmap.get(a) - hashmap.get(b);
            }
        }); // 小顶堆
		
		for (int key : hashmap.keySet()) {
			if (minHeap.size() < n) { // 保持小顶堆，仅有n个元素
				minHeap.add(key);
			} else if (hashmap.get(minHeap.peek()) < hashmap.get(key)) {
				minHeap.remove();
				minHeap.add(key);
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		while (!minHeap.isEmpty()) {
			System.err.println(minHeap.poll());
		}
	}
}
