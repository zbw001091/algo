/**
 * 
 */
package test;

import java.util.Date;

/**
 * @author st78sr
 * 
 *         Fibonacci问题的DP实现方法
 */
public class Fibonacci {

	private long[] memoRecursive;
	private long[] dp;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 208080; 

		// 普通暴力递归
		Fibonacci f = new Fibonacci();
		Date start = new Date();
//		long result = f.f_recursive(number);
		Date end = new Date();
		long l = end.getTime() - start.getTime(); // 获取时间差，单位:毫秒
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long millis = (l - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒" + millis + "毫秒");
//		System.out.println("result = " + result);

		// 带备忘录的递归
		Date start2 = new Date();
		long result2 = f.f_recursive_memory(number);
		Date end2 = new Date();
		long l2 = end2.getTime() - start2.getTime(); // 获取时间差
		long day2 = l2 / (24 * 60 * 60 * 1000);
		long hour2 = (l2 / (60 * 60 * 1000) - day2 * 24);
		long min2 = ((l2 / (60 * 1000)) - day2 * 24 * 60 - hour2 * 60);
		long s2 = (l2 / 1000 - day2 * 24 * 60 * 60 - hour2 * 60 * 60 - min2 * 60);
		long millis2 = (l2 - day2 * 24 * 60 * 60 * 1000 - hour2 * 60 * 60 * 1000 - min2 * 60 * 1000 - s * 1000);
		System.out.println("" + day2 + "天" + hour2 + "小时" + min2 + "分" + s2 + "秒" + millis2 + "毫秒");
		System.out.println("result = " + result2);
//		for (int i = 0; i < f.memoRecursive.length; ++i) {
//			System.err.println(f.memoRecursive[i]);
//		}

		// DP算法的实现
		Date start3 = new Date();
		long result3 = f.f_dp(number);
		Date end3 = new Date();
		long l3 = end3.getTime() - start3.getTime(); // 获取时间差
		long day3 = l3 / (24 * 60 * 60 * 1000);
		long hour3 = (l3 / (60 * 60 * 1000) - day3 * 24);
		long min3 = ((l3 / (60 * 1000)) - day3 * 24 * 60 - hour3 * 60);
		long s3 = (l3 / 1000 - day3 * 24 * 60 * 60 - hour3 * 60 * 60 - min3 * 60);
		long millis3 = (l3 - day3 * 24 * 60 * 60 * 1000 - hour3 * 60 * 60 * 1000 - min3 * 60 * 1000 - s * 1000);
		System.out.println("" + day3 + "天" + hour3 + "小时" + min3 + "分" + s3 + "秒" + millis3 + "毫秒");
		System.out.println("result = " + result3);
//		for (int i = 0; i < f.dp.length; ++i) {
//			System.err.println(f.dp[i]);
//		}
	}

	/**
	 * 暴力递归/性能很差/因为没有剪枝和降维
	 * 
	 * @param n
	 * @return
	 */
	public long f_recursive(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			return f_recursive(n - 1) + f_recursive(n - 2);
		}
	}

	/**
	 * 带备忘录的递归/性能很好
	 * 因为可以支持大量的递归调用，-Xss50m
	 * 
	 * @param n
	 * @return
	 */
	public long f_recursive_memory(int n) {
		if (n < 1)
			return 0;
		memoRecursive = new long[n + 1]; // 初始化为0，从元素下标1开始使用
		memoRecursive[1] = 1;
		memoRecursive[2] = 1;
		return helper(memoRecursive, n);
	}

	public long helper(long[] memoRecursive, int n) {
		if (n > 0 && memoRecursive[n] == 0) {
			memoRecursive[n] = helper(memoRecursive, n - 1) + helper(memoRecursive, n - 2);
		}
		return memoRecursive[n];
	}

	/**
	 * 动态规划/性能很好
	 * 
	 * @param n
	 * @return
	 */
	public long f_dp(int n) {
		dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
