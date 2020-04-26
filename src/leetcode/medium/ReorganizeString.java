/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author mns
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer> >pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());
        
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            
            Map.Entry<Character,Integer> top = pq.poll(), next = pq.poll();
            
            result.append(top.getKey());
            top.setValue(top.getValue()-1);
            if(top.getValue() != 0){
                pq.add(top);
            }
            
            if(next != null){
                result.append(next.getKey());
                next.setValue(next.getValue()-1);
                if(next.getValue() != 0){
                    pq.add(next);
                }
            }
            
            if(top.getValue() != 0 && next == null){
                return "";
            }
            
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("aab"));
        System.out.println(rs.reorganizeString("aaab"));
        System.out.println(rs.reorganizeString("aaaaaaaaabcdefgh"));
    }
}
