/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.List;

/**
 *
 * @author mns
 */
public class P648Replacewords {

    private class Trie2 extends Trie {

        public String getPrefix(String word) {
            TrieNode curr = this.getRoot();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.isWord) {
                    break;
                }
                
                if (curr.childrenMap.get(c) != null) {
                    sb.append(c);
                    curr = curr.childrenMap.get(c);
                } else {
                    break;
                }
            }
            
            if(curr.isWord){
                return sb.toString();
            }else{
                return word;
            }
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie2 trie = new Trie2();
        for (String word : dict) {
            trie.insert(word);
        }

        String[] words = sentence.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += trie.getPrefix(words[i]) + " ";
        }

       return result.trim();

    }

    public static void main(String[] args) {

    }
}
