package trie;

import java.util.HashMap;
import java.util.Map;

// N叉树的节点
public class TrieNode {
	Map<Character, TrieNode> children; // N叉树，所以用Map来保存
    boolean wordEnd; // 词尾标识位

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        wordEnd = false;
    }
}
