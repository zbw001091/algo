// 用链表实现的排序二叉树
public class BinarySearchTreeBaseOnLinkedList {
	public Node tree;

	// 构建 排序二叉树
	public void insert(int data) {
		if (tree == null) {
			tree = new Node(data);
			return;
		}

		Node p = tree;
		while (p != null) {
			if (data > p.data) {
				if (p.right == null) {
					p.right = new Node(data);
					return;
				}
				p = p.right;
			} else { // data < p.data
				if (p.left == null) {
					p.left = new Node(data);
					return;
				}
				p = p.left;
			}
		}
	}

	// O(log2n)
	// 因为是排序二叉树（除了1个case，有序序列时会退化成单链表，O(n)）
	public Node find(int data) {
		Node p = tree;
		while (p != null) {
			if (data < p.data)
				p = p.left;
			else if (data > p.data)
				p = p.right;
			else
				return p;
		}
		return null;
	}

	public Node findMin() {
		if (tree == null)
			return null;
		Node p = tree;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}

	public Node findMax() {
		if (tree == null)
			return null;
		Node p = tree;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}

	public void delete(int data) {
		Node p = tree; // p指向要删除的节点，初始化指向根节点
		Node pp = null; // pp记录的是p的父节点
		while (p != null && p.data != data) {
			pp = p;
			if (data > p.data)
				p = p.right;
			else
				p = p.left;
		}
		if (p == null)
			return; // 没有找到要删的节点

		// 要删除的节点有两个子节点
		if (p.left != null && p.right != null) { // 查找右子树中最小节点
			Node minP = p.right;
			Node minPP = p; // minPP表示minP的父节点
			while (minP.left != null) {
				minPP = minP;
				minP = minP.left;
			}
			p.data = minP.data; // 将minP的数据替换到p中
			p = minP; // 下面就变成了删除minP了
			pp = minPP;
		}

		// 删除节点是叶子节点或者仅有一个子节点
		Node child; // p的子节点
		if (p.left != null)
			child = p.left;
		else if (p.right != null)
			child = p.right;
		else
			child = null;

		if (pp == null)
			tree = child; // 删除的是根节点
		else if (pp.left == p)
			pp.left = child;
		else
			pp.right = child;
	}
	
	// 求二叉树的高度(递归recursive)
	// 带返回值的recursive递归
	public int getTreeHeight(Node treeNode) {
		if (treeNode == null) {
			return 0;
		} else {
			int l = getTreeHeight(treeNode.left);
			int r = getTreeHeight(treeNode.right);
			return l>r ? (l+1):(r+1);
		}
	}
	
	// 求二叉树的总节点个数(递归recursive)
	// 带返回值的recursive递归
	public int countTreeNodes(Node treeNode) {
		if (treeNode == null) {
			return 0;
		} else {
			int l = countTreeNodes(treeNode.left);
			int r = countTreeNodes(treeNode.right);
			return l+r+1;
		}
	}
	
	// 求某节点的父节点(递归recursive)
	// 带返回值的recursive递归
	public Node getParentNode(Node treeNode, int childNodeData) {
		if (treeNode == null) {
			return null;
		}
		if (treeNode.left.data == childNodeData || treeNode.right.data == childNodeData) {
			return treeNode;
		}
		Node parent = getParentNode(treeNode.left, childNodeData);
		if (parent != null) {
			return parent;
		} else {
			return getParentNode(treeNode.right, childNodeData);
		}
	}
	
	// 二叉树的遍历【深度优先】(先序)(递归recursive)
	// 不带返回值的recursive递归
	public void preTraverse(Node treeNode) {
		if (treeNode == null) {
			return;
		} else {
			System.out.print(treeNode.data + " ");
			preTraverse(treeNode.left);
			preTraverse(treeNode.right);
		}
	}
	
	// 二叉树的遍历【深度优先】(中序)(递归recursive)
	// 不带返回值的recursive递归
	public void middleTraverse(Node treeNode) {
		if (treeNode == null) {
			return;
		} else {
			middleTraverse(treeNode.left);
			System.out.print(treeNode.data + " ");
			middleTraverse(treeNode.right);
		}
	}
	
	// TODO 二叉树的遍历【深度优先】(中序)(不用递归，用迭代)
	public void middleTraverseWithWhile(Node treeNode) {
		
	}
	
	// 二叉树的遍历(后序)(递归recursive)
	// 不带返回值的recursive递归
	public void postTraverse(Node treeNode) {
		if (treeNode == null) {
			return;
		} else {
			postTraverse(treeNode.left);
			postTraverse(treeNode.right);
			System.out.print(treeNode.data + " ");
		}
	}
	
	// TODO 二叉树的层次遍历【广度优先】
	public void traverseByLevel(Node treeNode) {
		
	}
}
