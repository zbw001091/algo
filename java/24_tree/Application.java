public class Application {

	public static void main(String[] args) {
		BinarySearchTreeBaseOnLinkedList tree = new BinarySearchTreeBaseOnLinkedList();
		int data[] = { 5, 2, 3, 7, 1 };

		for (int i = 0; i < data.length; i++) {
			tree.insert(data[i]);
		}
	}

}
