package trie;

class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into Trie
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (p.children[index] == null) {
                TrieNode temp = new TrieNode();
                p.children[index] = temp;
                p = temp;
            } else {
                p = p.children[index];
            }
        }
        p.isLeaf = true;
    }

    // Search if the word is in Trie
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p != null && p.isLeaf) return true;
        return false;
    }

    // Search if there's any word in Trie which starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if (p == null) return false;
        return true;
    }

    private TrieNode searchNode(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            // if any one of the character not found then word not present
            if (p.children[index] == null) return null;
            else p = p.children[index];
        }

        // if the word is not present only
        if (p == root) return null;

        return p;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println("is \"app\" present in trie: " + trie.search("apple"));
        System.out.println("is there any word with prefix \"app\": " + trie.startsWith("app"));
    }
}
