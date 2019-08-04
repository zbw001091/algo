package palindrome;

/**
 * @author st78sr
 *
 */
public class PalindromeString {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromeString ps = new PalindromeString();
		
		System.out.println(ps.isPalindrome("stringnirts"));
		System.out.println(ps.isPalindrome2("stringnirts"));
	}
	
	public boolean isPalindrome(String str) {
		if (str == null) {
			return false;
		}
		String reverseStr = (new StringBuilder(str)).reverse().toString();
		return str.equals(reverseStr);
	}
	
	/**
	 * 首尾字母进行比较，随后取出子串
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPalindrome2(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length() - 1;
		int leftIndex = 0;
		int rightIndex = length;
		
		while (leftIndex < rightIndex) {
			System.out.println(leftIndex + "   " + rightIndex + "   " +str);
			if (str.charAt(leftIndex) != str.charAt(rightIndex)) return false;
			
			// string，去掉首尾2个字母，变成trin。相应地，rightIndex也要缩短2位
			str = str.substring(leftIndex + 1, rightIndex);
			leftIndex = 0;
			rightIndex -= 2;
		}
		return true;
	}

}
