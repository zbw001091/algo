/**
 * @author ZhangBangwei
 *
 * 用数组实现的栈。下标0作为栈底bottom，下标最大值作为top
 */
public class StackBasedOnArray {

	private int top = -1;
	private int[] stack = new int[100]; // stack最多仅有100个元素
	
	// TODO O(1)
	public void push(int elem) {
		stack[++top] = elem;
	}
	
	// TODO O(1)
	public int pop() {
		if (top == -1) {
			return -100;
		}
		return stack[top--];
	}
}
