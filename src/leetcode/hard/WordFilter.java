package hard;

import ds.TrieNode;

import java.util.*;

/**
 * Created by mns on 7/9/18.
 */
public class WordFilter {
     class TrieNode {
         public boolean isWord;
         public Map<Character, TrieNode> childrenMap = new HashMap<>();
     }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public Trie(String[] words) {
            this.root = new TrieNode();
            for (String word : words) {
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

        public ArrayList<String> find(String prefix) {
            ArrayList<String> result = new ArrayList<>();
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.childrenMap.get(c) == null) {
                    return result;
                }
                cur = cur.childrenMap.get(c);
            }

            findUtil(prefix, "", cur, result);
            return result;
        }

        private void findUtil(String prefix, String suffix, TrieNode cur, ArrayList<String> result) {
            if (cur.isWord) {
                result.add(prefix + suffix);
            }

            for (Character c : cur.childrenMap.keySet()) {
                findUtil(prefix, suffix + c, cur.childrenMap.get(c), result);
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
    }

    Trie forward, backward;
    HashMap<String,Integer> wordWeightMap;
    public WordFilter(String[] words) {
        forward = new Trie(words);
        backward = new Trie();
        wordWeightMap = new HashMap<>();
        StringBuilder tmp = new StringBuilder();
        for(int i=0;i<words.length;i++){
            tmp.append(words[i]);
            backward.insert(tmp.reverse().toString());
            tmp.setLength(0);
            wordWeightMap.put(words[i],i);
        }
    }

    public int f(String prefix, String suffix) {
        Set<String> prefixMatches = new HashSet<>(forward.find(prefix));
        Set<String> suffixMatches = new HashSet<>(backward.find(new StringBuilder(suffix).reverse().toString()));

        if(prefixMatches.size() == 0 || suffixMatches.size() == 0){
            return -1;
        }

        int maxWeight = Integer.MIN_VALUE;
        for(String word : prefixMatches){
            if(suffixMatches.contains(new StringBuilder(word).reverse().toString())){
                if(wordWeightMap.get(word) > maxWeight){
                    maxWeight = wordWeightMap.get(word);
                }
            }
        }
        return maxWeight;
    }
}
