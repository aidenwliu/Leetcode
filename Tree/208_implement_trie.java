class Trie {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word==null || word.length() == 0) return;
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (pNode.children[index] == null) {
                TrieNode newNode = new TrieNode();
                pNode.children[index] = newNode;
            }
            pNode = pNode.children[index];
        }
        pNode.isWord = true;
        
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word==null || word.length() == 0) return true;
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (pNode.children[index] == null) 
                return false;
            pNode = pNode.children[index];
        }
        return pNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix==null || prefix.length() == 0) return true;
        TrieNode pNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (pNode.children[index] == null) 
                return false;
            pNode = pNode.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
