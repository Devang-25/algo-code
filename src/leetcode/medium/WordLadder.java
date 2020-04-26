/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sekha
 */
public class WordLadder {

    // This takes 136ms (Single end bfs)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : wordList) {
            map.put(s, Boolean.FALSE);
        }

        if(map.get(endWord) == null){
            return 0;
        }
        
        
        ArrayDeque<String> q = new ArrayDeque<String>();
        q.offerLast(beginWord);
        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            length++;
            for (int i = 0; i < size; i++) {
                String str = q.pollFirst();
                for (int j = 0; j < str.length(); j++) {
                     StringBuilder currWord = new StringBuilder(str);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currWord.setCharAt(j, ch);
                        String cws = currWord.toString();
                        if(cws.contentEquals(endWord)){
                            return length+1;
                        }
                        
                        if (map.containsKey(cws)
                               && map.get(cws) == Boolean.FALSE) {
                            map.put(cws, Boolean.TRUE);
                            q.offerLast(cws);
                        }
                    }
                }

            }
            
        }
        
        return 0;
    }
    
    
    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(wl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
