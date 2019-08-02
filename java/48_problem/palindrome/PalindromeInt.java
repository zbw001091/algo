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
	}

	public boolean isPalindrome(int num) {
		if (num < 0) return false;
		String reverseNum = (new StringBuilder(num + "")).reverse().toString();
		return (num + "").equals(reverseNum);
	}
	
	
}
