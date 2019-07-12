

public class GreedyAlgorithm {

	public static void main(String[] args) {
		int num = GreedyAlgorithm.solve(456);
		System.out.println("为了得到456元，需要的纸币张数：" + num);
	}

	public static int N = 5;
	public static int Count[] = {5, 2, 2, 3, 5}; // 每一面值纸币的张数
	public static int Value[] = {1, 5, 10, 50, 100}; // 每一面值的纸币

	// num: 钞票的张数
	// money: 比如456，就是我需要得到的最后的金额
	// 返回值：为了得到金额456，需要多少张纸币
	public static int solve(int money) {
		int num = 0;
		for (int i = N - 1; i >= 0; i--) { // 从最大面值的纸币开始，贪心
			int c = Math.min(money / Value[i], Count[i]);// 每一个所需要的张数
			money = money - c * Value[i];
			num += c; // 总张数
		}
		if (money > 0)
			num = -1;
		return num;
	}
}
