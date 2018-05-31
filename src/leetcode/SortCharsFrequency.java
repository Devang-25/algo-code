/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author sekha
 */
public class SortCharsFrequency {

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> q
                = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> t, Map.Entry<Character, Integer> t1) {
                        return -1*Integer.compare(t.getValue(), t1.getValue());
                    }

                });
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            q.add(entry);
        }
        
        while(!q.isEmpty()){
            Map.Entry<Character , Integer> top = q.poll();
            for(int i=0;i<top.getValue();i++){
                sb.append(top.getKey());
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SortCharsFrequency sf = new SortCharsFrequency();
        System.out.println(sf.frequencySort("tree"));
        System.out.println(sf.frequencySort("cccaaa"));
        System.out.println(sf.frequencySort("Aabb"));
    }
}
