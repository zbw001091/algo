package sequential.search;

import java.util.Date;
import java.util.Random;

/**
 * @author st78sr
 * 
 */
public class SequentialSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SequentialSearch ss = new SequentialSearch();
		int[] nums = new int[100000000];
		Random random = new Random();
		
		for (int i = 0; i < 100000000; ++i) {
			nums[i] = random.nextInt(1000000000);
		}
		
		System.out.println(nums.length);
		
		Date start2 = new Date();
		System.err.println(ss.search(nums, 99));
		Date end2 = new Date();
		long l2 = end2.getTime() - start2.getTime(); // 获取时间差
		long day2 = l2 / (24 * 60 * 60 * 1000);
		long hour2 = (l2 / (60 * 60 * 1000) - day2 * 24);
		long min2 = ((l2 / (60 * 1000)) - day2 * 24 * 60 - hour2 * 60);
		long s2 = (l2 / 1000 - day2 * 24 * 60 * 60 - hour2 * 60 * 60 - min2 * 60);
		long millis2 = (l2 - day2 * 24 * 60 * 60 * 1000 - hour2 * 60 * 60 * 1000 - min2 * 60 * 1000 - s2 * 1000);
		System.out.println("" + day2 + "天" + hour2 + "小时" + min2 + "分" + s2 + "秒" + millis2 + "毫秒");
		
		Date start3 = new Date();
		System.err.println(ss.searchWithSentinel(nums, 99));
		Date end3 = new Date();
		long l3 = end3.getTime() - start3.getTime(); // 获取时间差
		long day3 = l3 / (24 * 60 * 60 * 1000);
		long hour3 = (l3 / (60 * 60 * 1000) - day3 * 24);
		long min3 = ((l3 / (60 * 1000)) - day3 * 24 * 60 - hour3 * 60);
		long s3 = (l3 / 1000 - day3 * 24 * 60 * 60 - hour3 * 60 * 60 - min3 * 60);
		long millis3 = (l3 - day3 * 24 * 60 * 60 * 1000 - hour3 * 60 * 60 * 1000 - min3 * 60 * 1000 - s3 * 1000);
		System.out.println("" + day3 + "天" + hour3 + "小时" + min3 + "分" + s3 + "秒" + millis3 + "毫秒");
	}

	/**
	 * 无哨兵
	 * @param nums
	 * @param key
	 * @return
	 */
	public int search(int[] nums, int key) {
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 带哨兵，性能更佳
	 * @param nums
	 * @param key
	 * @return
	 */
	public int searchWithSentinel(int[] nums, int key) {
		nums[nums.length - 1] = key;
		int i = 0;
		while (nums[i] != key) {
			++i;
		}
		return i;
	}
}
