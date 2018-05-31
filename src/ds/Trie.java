/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;
/**
 * @author mns
 */

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public class NoTrieElementException extends Exception {

        @Override
        public String getMessage() {
            return "The given element is not found";
        }

    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.childrenMap.get(c) == null) {
                // insert a new node if the path does not exist
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    public void delete(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childrenMap.get(c) != null) {
                curr = curr.childrenMap.get(c);
            } else {
                break;
            }
        }
        if (curr.isWord) {
            curr.isWord = false;
        }
    }
}
