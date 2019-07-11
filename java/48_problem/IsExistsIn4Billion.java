import java.util.BitSet;

// 判断某数字是否存在于40亿个数字中
// 利用Bitmap
public class IsExistsIn4Billion {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 100, 3, 5, 4 };
		BitSet bitSet = new BitSet(5); // 有5个bit的数组
		// 将数组内容，注入bitmap
		for (int i = 0; i < array.length; ++i) {
			bitSet.set(array[i], true);
		}
		System.out.println();
		System.out.println(bitSet.size()); // BitSet内部默认用1个long来保存64位(对应保存64个整数的是否存在)，如果判断原始数组的max大于64就自动加1个long变成128位
		System.out.println(bitSet.get(100)); // bitset第100位，代表整形数字100
		
		// 打印原始数组中，不存在的整数
		for (int i = 0; i < bitSet.size(); ++i) {
			if (bitSet.get(i) == false) {
				System.out.println(i + " not exists.");
			}
		}
	}
}
