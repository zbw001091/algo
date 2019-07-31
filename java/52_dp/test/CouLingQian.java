/**
 * 
 */
package test;

import java.util.Date;

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
		int amount = 4000000;
		CouLingQian clq = new CouLingQian();
		
		// 普通暴力递归
		Date start = new Date();
//		int howManyCoins = clq.coinChange(amount, coins);
//		System.out.println("We need " + howManyCoins + " coins.");
		Date end = new Date();
		long l = end.getTime() - start.getTime(); // 获取时间差，单位:毫秒
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long millis = (l - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒" + millis + "毫秒");
		
		// 带备忘录的递归
		Date start2 = new Date();
		int howManyCoins_memory = clq.coinChange_memory(amount, coins);
		System.out.println("We need " + howManyCoins_memory + " coins.");
//		for (int i = 0; i < clq.memoRecursive.length; ++i) {
//			System.out.println("f(" + i + ") = " + clq.memoRecursive[i]);
//		}
		Date end2 = new Date();
		long l2 = end2.getTime() - start2.getTime(); // 获取时间差
		long day2 = l2 / (24 * 60 * 60 * 1000);
		long hour2 = (l2 / (60 * 60 * 1000) - day2 * 24);
		long min2 = ((l2 / (60 * 1000)) - day2 * 24 * 60 - hour2 * 60);
		long s2 = (l2 / 1000 - day2 * 24 * 60 * 60 - hour2 * 60 * 60 - min2 * 60);
		long millis2 = (l2 - day2 * 24 * 60 * 60 * 1000 - hour2 * 60 * 60 * 1000 - min2 * 60 * 1000 - s * 1000);
		System.out.println("" + day2 + "天" + hour2 + "小时" + min2 + "分" + s2 + "秒" + millis2 + "毫秒");
		
		// DP算法的实现
		Date start3 = new Date();
		int howManyCoins_dp = clq.coinChange_dp(amount, coins);
		System.out.println("We need " + howManyCoins_dp + " coins.");
		Date end3 = new Date();
		long l3 = end3.getTime() - start3.getTime(); // 获取时间差
		long day3 = l3 / (24 * 60 * 60 * 1000);
		long hour3 = (l3 / (60 * 60 * 1000) - day3 * 24);
		long min3 = ((l3 / (60 * 1000)) - day3 * 24 * 60 - hour3 * 60);
		long s3 = (l3 / 1000 - day3 * 24 * 60 * 60 - hour3 * 60 * 60 - min3 * 60);
		long millis3 = (l3 - day3 * 24 * 60 * 60 * 1000 - hour3 * 60 * 60 * 1000 - min3 * 60 * 1000 - s * 1000);
		System.out.println("" + day3 + "天" + hour3 + "小时" + min3 + "分" + s3 + "秒" + millis3 + "毫秒");
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
		// dp数组，下标代表amount金额，value代表最少需要几枚硬币
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; ++i) {
			dp[i] = amount + 1; // 初始化dp数组的每个元素，都为很大的值。以便后面求min最少需要几枚硬币的min值
		}
		dp[0] = 0;
		
		for (int i = 0; i <= amount; ++i) { // 从小到大的顺序进行循环迭代，这是有讲究的，体现了dp算法是自底向上的
			for (int coin : coins) {
				if (i - coin < 0) continue; // 如果这枚硬币面额大于amount了，就继续试验下一枚硬币(穷举)
				dp[i] = min(dp[i], 1 + dp[i - coin]);
			}
		}
		return dp[amount] == (amount + 1) ? -1 : dp[amount];
	}

}
