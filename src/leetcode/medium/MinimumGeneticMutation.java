/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class MinimumGeneticMutation {
    private static final char [] CHOICES = {'A','C','G','T'};
    public int minMutation(String start, String end, String[] bank) {
       HashMap<String, Boolean> map = new HashMap<>();
        for (String s : bank) {
            map.put(s, Boolean.FALSE);
        }

        if(map.get(end) == null){
            return -1;
        }
        
        
        ArrayDeque<String> q = new ArrayDeque<String>();
        q.offerLast(start);
        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.pollFirst();
                for (int j = 0; j < str.length(); j++) {
                     StringBuilder currWord = new StringBuilder(str);
                    for (char ch : CHOICES) {
                        currWord.setCharAt(j, ch);
                        String cws = currWord.toString();
                        if(cws.contentEquals(end)){
                            return length+1;
                        }
                        
                        if (map.containsKey(cws)
                               && map.get(cws) == Boolean.FALSE) {
                            map.put(cws, Boolean.TRUE);
                            //System.out.println(cws);
                            q.offerLast(cws);
                        }
                    }
                }
            }
            length++;   
        }
        
        return -1; 
    }
    
    public static void main(String[] args) {
        MinimumGeneticMutation m = new MinimumGeneticMutation();
        System.out.println(m.minMutation("AACCGGTT", "AACCGGTA",new String[]{"AACCGGTA"}));
        System.out.println(m.minMutation("AACCGGTT", "AAACGGTA",new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(m.minMutation("AAAAACCC", "AACCCCCC",new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
