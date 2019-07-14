package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

// 字典树未必是二叉树，而是N叉树。所以底层只能用链表来存储
public class Trie {
	public TrieNode root;

	public Trie() {
		root = new TrieNode();
		root.wordEnd = false;
	}

	public void insertWord(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		
		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i) {
			Character c = new Character(word.charAt(i));

			// 无该字母，则插入一个TrieNode
			if (!node.children.containsKey(c)) {
				TrieNode newNode = new TrieNode();
				node.children.put(c, newNode);
			}

			// 有该字母
			node = node.children.get(c);
		}
		node.wordEnd = true;
	}

	public boolean searchWord(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		
		TrieNode node = root;
		for (int i = 0; i < word.length(); ++i) {
			Character c = new Character(word.charAt(i));

			// 无该字母
			if (!node.children.containsKey(c)) {
				return false;
			}

			// 有该字母
			node = node.children.get(c);
		}

		return node.wordEnd;
	}

	public void deleteWord(String word) {

	}

	// TODO 根据输入的前缀，返回autoCompletion的所有潜在的字符串
	public List<String> autoCompletionByPrefix(String prefix) {
		List<String> autoCompletionList = new ArrayList<String>();
		TrieNode node = root;
		//
		for (int i = 0; i < prefix.length(); ++i) {
			Character c = new Character(prefix.charAt(i));

			// 无该字母，返回空List
			if (!node.children.containsKey(c)) {
				return autoCompletionList;
			}

			// 有该字母
			node = node.children.get(c);
		}
		
		// 找到了prefix的位置，下面开始打印prefix下面的字节点
//		autoCompletionList.add(arg0);
		return autoCompletionList;
	}

	// 字典N叉树的遍历【深度优先】(先序)(递归recursive)
	public void preTraverse(TrieNode trieNode) {
		if (trieNode.children.isEmpty()) {
			return;
		} else {
			for (Entry<Character, TrieNode> entry : trieNode.children.entrySet()) {
				System.out.print(entry.getKey() + " ");
				preTraverse(entry.getValue());
			}
		}
	}
}
