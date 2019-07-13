package trie;

public class TrieApplication {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insertWord(new String("zbw"));
		trie.insertWord(new String("zhang"));
		trie.preTraverse(trie.root);
		
		boolean found = trie.searchWord(new String("zb"));
		System.out.println();
		System.out.println("trie tree has this string? " + found);
	}

}
