/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ds;

import java.util.ArrayList;

/**
 * @author mns
 */

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    public Trie(String [] words) {
        this.root = new TrieNode();
        for(String word : words){
            this.insert(word);
        }
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

    public ArrayList<String> find(String prefix){
        ArrayList<String> result = new ArrayList<>();
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.childrenMap.get(c) == null) {
                return result;
            }
            cur = cur.childrenMap.get(c);
        }

        findUtil(prefix,"",cur,result);
        return result;
    }

    private void findUtil(String prefix, String suffix, TrieNode cur, ArrayList<String> result){
        if(cur.isWord){
            result.add(prefix+suffix);
        }

        for(Character c : cur.childrenMap.keySet()){
            findUtil(prefix,suffix+c,cur.childrenMap.get(c),result);
        }
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

    public static void main(String[] args) {
        Trie t = new Trie(new String[]{"a","aa","bbb","b","cc","abc","axbcc"});
        t.find("a").stream().forEach(System.out::println);

    }
}
