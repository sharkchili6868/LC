class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			// check the children has been initialized at current char
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			// move to children node and continue operation on next level
			node = node.children[index];
		}
		node.isWord = true;
		node.word = word;
	}

	public boolean search(String word) {
		return find(word, root, 0);
	}

	public boolean find(String word, TrieNode node, int index) {
		if (node == null) return false;

		// or if node.word is the current word
		if (index == word.length()) return node.isWord;

		if (word.charAt(index) == '.') {
			for(TrieNode temp : node.children) {
				if(find(word, temp, index + 1)) {
					return true;
				}
			}
		} else {
			int tempIndex = word.charAt(index) - 'a';
			TrieNode temp = node.children[tempIndex];

			return find(word, temp, index + 1);
		}

		return false;
	}

	private class TrieNode {
		public TrieNode[] children;
		public boolean isWord;
		public String word;

		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
			this.word = "";
		}
	}
}