/**
 * @author ZhangBangwei
 *
 * 基于数组的栈
 * 2栈共享一个数组，节省存储空间，避免栈溢出
 */
public class StackOfSharedArray {

	private int top1; // for stack1，从左往右
	private int top2; // for stack2，从右往左
	private int[] doubleStack = new int[100]; // 共享100个元素的数组
	
	// TODO push到指定stack
	public boolean push(int elem, int stackNo) {
		if (top1 + 1 == top2) { // 数组已满，不能再push
			return false;
		}
		if (stackNo == 1) {
			doubleStack[++top1] = elem;
		} else if (stackNo == 2) {
			doubleStack[--top2] = elem;
		}
		return true;
	}
	
	// TODO 从指定stack进行pop
	public int pop(int stackNo) {
		if (stackNo == 1) {
			return doubleStack[top1--];
		} else if (stackNo == 2) {
			return doubleStack[top2++];
		}
		return 0;
	}
}
