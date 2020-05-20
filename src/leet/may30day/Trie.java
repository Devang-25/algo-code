package leet.may30day;

class Trie {
  class TrieNode {
    TrieNode[] children;
    boolean present;

    TrieNode() {
      this.children = new TrieNode[26];
    }
  }

  TrieNode root = null;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode current = root;
    int i = 0;
    for (; i < word.length(); i++) {
      if (current.children[word.charAt(i) - 'a'] == null) {
        current.children[word.charAt(i) - 'a'] = new TrieNode();
      }
      current = current.children[word.charAt(i) - 'a'];
    }
    current.present = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode end = startsWithUtil(word);
    if (end != null) {
      return end.present == true;
    }
    return false;
  }

  private TrieNode startsWithUtil(String prefix) {
    int i = 0;
    TrieNode current = root;
    for (; i < prefix.length(); i++) {
      if (current.children[prefix.charAt(i) - 'a'] == null) {
        return null;
      }
      current = current.children[prefix.charAt(i) - 'a'];
    }
    return current;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return startsWithUtil(prefix) != null;
  }
}
