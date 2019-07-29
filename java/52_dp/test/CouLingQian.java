/**
 * 
 */
package test;

/**
 * @author st78sr
 * 
 * 凑零钱问题的DP实现方法
 */
public class CouLingQian {

	private int[] memoRecursive;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		
		CouLingQian clq = new CouLingQian();
		int howManyCoins = clq.coinChange(11, coins);
		System.out.println("We need " + howManyCoins + " coins.");
		
		int howManyCoins_memory = clq.coinChange_memory(11, coins);
		System.out.println("We need " + howManyCoins_memory + " coins.");
//		for (int i = 0; i < clq.memoRecursive.length; ++i) {
//			System.out.println("f(" + i + ") = " + clq.memoRecursive[i]);
//		}
	}
	
	/**
	 * 暴力递归算法
	 * 
	 * @param amount 要凑的钱的总金额
	 * @param coins 数组，所有面额的钱，比如1元/2元/5元
	 * @return
	 */
	public int coinChange(int amount, int[] coins) {
		if (amount == 0) { // 递归的退出条件
			return 0;
		}
		int ans = amount + 1; // 设置1个最大值，amount金额所对应的coin枚数(前提硬币都是>=1元的)，不可能超过amount+1
		
		// 下面for循环，针对amount金额，用各种coin面值进行暴力破解
		for(int coin : coins) {
			// 金额不可达
			if (amount - coin < 0) continue;
			
			// 求解子问题
			int subProblem = coinChange((amount - coin), coins);
			
			// 子问题无解。也就是说，剩下的amount比任何一枚硬币面值都要小，所以无解
			if (subProblem == -1) continue;
			
			ans = min(ans, subProblem + 1);
		}
		return ans == (amount + 1) ? -1 : ans; // amount + 1是前面设置的ans默认值
	}
	
	private int min(int a, int b) {
		if (a <= b) return a;
		else return b;
	}
	
	/**
	 * 带备忘录的递归算法
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int coinChange_memory(int amount, int[] coins) {
		// 初始化备忘录
		this.memoRecursive = new int[amount + 1]; // 数组下标0，空着不用
		for (int i = 0; i < amount + 1; ++i) {
			this.memoRecursive[i] = -100; // 初始化为-100
		}
		
		return helper(amount, coins, this.memoRecursive);
	}
	
	public int helper(int amount, int[] coins, int[] memoRecursive) {
		if (memoRecursive[amount] != -100) return memoRecursive[amount];
		if (amount == 0) { // 递归的退出条件
			return 0;
		}
		
		int ans = amount + 1; // 设置1个最大值，amount金额所对应的coin枚数(前提硬币都是>=1元的)，不可能超过amount+1
		// 下面for循环，针对amount金额，用各种coin面值进行暴力破解
		for(int coin : coins) {
			// 金额不可达
			if (amount - coin < 0) continue;
			
			// 求解子问题
			int subProblem = helper((amount - coin), coins, memoRecursive);
			
			// 子问题无解。也就是说，剩下的amount比任何一枚硬币面值都要小，所以无解
			if (subProblem == -1) continue;
			
			ans = min(ans, subProblem + 1);
		}
		memoRecursive[amount] = (ans == (amount + 1)) ? -1 : ans; // amount + 1是前面设置的ans默认值
		
		return memoRecursive[amount];
	}
	
	/**
	 * 动态规划/性能很好
	 * @param amount
	 * @param coins
	 * @return
	 */
	public int coinChange_dp(int amount, int[] coins) {
		
	}

}
