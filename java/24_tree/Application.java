public class Application {

	public static void main(String[] args) {
		BinarySearchTreeBaseOnLinkedList binaryTree = new BinarySearchTreeBaseOnLinkedList();
		int data[] = { 5, 2, 3, 7, 1 };
//		int data[] = { 1, 2, 3, 4, 5 };
		
		for (int i = 0; i < data.length; i++) {
			binaryTree.insert(data[i]);
		}
		int height = binaryTree.getTreeHeight(binaryTree.tree);
		System.out.println("treeHeight is: " + height);
		
		int countNodes = binaryTree.countTreeNodes(binaryTree.tree);
		System.out.println("总节点个数: " + countNodes);
		
		Node parentOf = binaryTree.getParentNode(binaryTree.tree, 3);
		System.out.println("节点3的父节点是: " + parentOf.data);
		
		System.out.print("先序遍历: ");
		binaryTree.preTraverse(binaryTree.tree);
		System.out.println();
		
		System.out.print("中序遍历: ");
		binaryTree.middleTraverse(binaryTree.tree);
		System.out.println();
		
		System.out.print("后序遍历: ");
		binaryTree.postTraverse(binaryTree.tree);
		System.out.println();
		
		//-----------------------------------------------------------------
		
		// 完全二叉树，用递归来创建
		int completeBTreeNodes[] = {0, 1, 2, 3, 4, 5, 6};
		Node root = binaryTree.buildCompleteBTree(completeBTreeNodes, 1);
		System.out.print("先序遍历: ");
		binaryTree.preTraverse(root);
		System.out.println();
	}

}
