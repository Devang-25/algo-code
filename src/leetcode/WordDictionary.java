/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mns
 */
class Trie {


    public class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

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
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }

    public TrieNode getRoot(){
        return this.root;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                // insert a new node if the path does not exist
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    public void delete(String word){
        TrieNode curr = root;
        for(int i=0; i < word.length();i++){
            char c = word.charAt(i);
            if(curr.childrenMap.get(c) != null){
                curr = curr.childrenMap.get(c);
            }else{
                break;
            }
        }
        if(curr.isWord){
            curr.isWord = false;
        }
    }
}

public class WordDictionary {

    /**
     * Initialize your data structure here.
     */



    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the
     * dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchUtil(word, trie.getRoot());
    }

    private boolean searchUtil(String word, Trie.TrieNode root) {
        Trie.TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {

                boolean found = false;
                for (Character key : curr.childrenMap.keySet()) {
                    found = found || searchUtil(word.substring(i+1), curr.childrenMap.get(key));
                    if (found) {
                        return true;
                    }
                }
                return false;

            } else {
                if (curr.childrenMap.get(c) != null) {
                    curr = curr.childrenMap.get(c);
                } else {
                    return false;
                }
            }
        }

        if (curr.isWord) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
//        System.out.println(obj.search("pad"));
//        System.out.println(obj.search("bad"));
//        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
