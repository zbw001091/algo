package palindrome;

/**
 * @author st78sr
 *
 */
public class PalindromeInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromeInt pi = new PalindromeInt();
		
		System.out.println(pi.isPalindrome(12321));
		System.out.println(pi.isPalindrome2(12321));
	}

	public boolean isPalindrome(int num) {
		if (num < 0) return false;
		String reverseNum = (new StringBuilder(num + "")).reverse().toString();
		return (num + "").equals(reverseNum);
	}
	
	/**
	 * 用数学除法/余数，进行首尾比较
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPalindrome2(int num) {
		int div = 1;
		while (num / div > 10) {
			div *= 10;
		}
		
		while (num > 0) {
			int left = num / div;
			int right = num % 10;
			if (left != right) return false;
			
			// 12321，去掉首尾2个数字，变成232。相应地，div也要缩小100倍
			num = (num % div) / 10;
			div /= 100;
		}
		return true;
	}
}
