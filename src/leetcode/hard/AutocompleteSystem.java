package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class AutocompleteSystem {

    private class TrieNode {
        boolean isWord;
        int hotness;
        Map<Character,TrieNode> childMap;
        TrieNode (){
            this.isWord = false;
            this.hotness = 0;
            childMap = new HashMap<>();
        }
    }

    private class Trie {
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        public void insert(String s, int hotness){
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.childMap.get(c) == null) {
                    // insert a new node if the path does not exist
                    cur.childMap.put(c, new TrieNode());
                }
                cur = cur.childMap.get(c);
            }
            cur.isWord = true;
            cur.hotness = hotness;
        }
    }

    private class Pair {
        String s;
        int hotness;
        Pair(String s, int i){
            this.s = s;
            this.hotness = i;
        }
    }

    private Trie trie;
    private StringBuilder currPrefix;
    private TrieNode currPrefixNode;
    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        currPrefix = new StringBuilder();
        currPrefixNode = trie.root;

        for(int i=0;i<sentences.length;i++){
            trie.insert(sentences[i],times[i]);
        }

    }

    public List<String> input(char c) {
        if(c == '#'){
            currPrefix = new StringBuilder();
            currPrefixNode.hotness += 1;
            currPrefixNode.isWord = true;
            currPrefixNode = trie.root;
            return new ArrayList<>();
        }

        TrieNode next = currPrefixNode.childMap.get(c);
        if(next == null){
            next= new TrieNode();
            currPrefixNode.childMap.put(c,next);
        }
        currPrefixNode = next;
        currPrefix.append(c);

        ArrayDeque<String> q = new ArrayDeque<>();
        PriorityQueue<Pair> pq = topKWordsBelow(currPrefixNode,3);
        while(!pq.isEmpty()){
            q.addFirst(pq.poll().s);
        }


        return new ArrayList<>(q);
    }


    private PriorityQueue<Pair> topKWordsBelow(TrieNode t, int k){
        PriorityQueue<Pair> result = new PriorityQueue<>( (a,b) -> {
            if(a.hotness != b.hotness){
                return a.hotness - b.hotness;
            }
            return b.s.compareTo(a.s);
        });
        topKWordsBelowUtil(t,currPrefix.toString(),"",result,k);
        return result;
    }

    private void topKWordsBelowUtil(TrieNode t,final String cPrefix, String soFar,  PriorityQueue<Pair> result, int k){
        if(t.isWord){
            result.add(new Pair(cPrefix+soFar,t.hotness));
            if(result.size() > k){
                result.poll();
            }
        }

        for(Character c : t.childMap.keySet()){
            topKWordsBelowUtil(t.childMap.get(c),cPrefix,soFar+c,result,k);
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem ac = new AutocompleteSystem(new String[] {"i love you", "island","ironman", "i love leetcode"},new int[]{5,3,2,2});
//        ac.input('i').stream().forEach(System.out::println);
//        System.out.println();
//        ac.input(' ').stream().forEach(System.out::println);
//        System.out.println();
//        ac.input('a').stream().forEach(System.out::println);
//        System.out.println();
//        ac.input('#').stream().forEach(System.out::println);
//        System.out.println();

        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);
        ac.input('#').stream().forEach(System.out::println);
        ac.input('i').stream().forEach(System.out::println);

    }
}
