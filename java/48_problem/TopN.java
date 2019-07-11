/**
 * @author xiaoshi on 2018/10/14.
 * 
 * ZhangBangwei
 * TopN问题，有若干种解，这里用小顶堆来解
 * 
 * 从10亿个整型数中，选出Top1000
 * 
 * TopN的问题，只需利用小顶堆，构建小顶堆。但无需堆排序。
 * 因为我们仅需TopN，无需对TopN排序
 */
public class TopN {

	public static void main(String[] args) {
		int originData[] = { 1, 5, 3, 2, 4 };
		TopN.print(originData);
		TopN.findTopN(2, originData);
	}
	
    // 父节点
    private static int parent(int n) {
        return (n - 1) / 2;
    }

    // 左孩子
    private static int left(int n) {
        return 2 * n + 1;
    }

    // 右孩子
    private static int right(int n) {
        return 2 * n + 2;
    }

    // 构建堆（要求TopN，就建1个仅有N个元素的小顶堆）
    // data[]，一个有10亿个元素的数组
    // n，需要求TopN的n
    // 本质是对拥有10亿个元素的数组的前1000个元素进行位置的互换
    private static void buildHeap(int n, int[] data) {
        for(int i = 1; i < n; i++) {
            int t = i;
            // 调整堆
            while(t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    // 调整data[i]
    // 把数组中第i个元素，拿来和拥有1000个元素的小顶堆的顶元素，进行比较
    // n是TopN的n，告诉比较逻辑，在重新构建小顶堆的过程中，只比较n以下的元素。n以外的元素不属于堆，不用比较
    private static void adjust(int i, int n, int[] data) {
        if(data[i] <= data[0]) { // 第i个元素 < 小顶堆的顶元素，忽略，因为不可能成为TopN
            return;
        }
        // 置换堆顶。把原堆顶元素换出Top1000以外
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        // 调整堆顶(重新构建小顶堆，但不是堆排序)，得到当前的小顶，以便后一个元素进来比较时，直接只和顶元素比较即可
        int t = 0;
        while( (left(t) < n && data[t] > data[left(t)])
            || (right(t) < n && data[t] > data[right(t)]) ) {
            if(right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 寻找topN，该方法改变data，将topN排到最前面
    public static void findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整，逐个拿去和小顶堆的堆顶元素进行比较，求得TopN
        for(int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
        printTopN(data, n);
    }

    // 打印数组
    public static void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    
    // 打印TopN
    public static void printTopN(int[] data, int n) {
    	System.out.print("Top" + n + ": ");
    	for(int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}