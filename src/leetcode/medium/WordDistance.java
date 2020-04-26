/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class WordDistance {


    HashMap<String, ArrayList<Integer> > map = new HashMap<>();

    public WordDistance(String[] words) {

        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> p = map.get(words[i]);
            if (p == null) {
                p = new ArrayList<>();
                map.put(words[i], p);
            }
            p.add(i);
        }
    }

    public int shortest2(String word1, String word2) {
        ArrayList<Integer> p1 = map.get(word1);
        ArrayList<Integer> p2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        for(Integer i1 : p1){
            for(Integer i2 : p2){
                min = Math.min(min, Math.abs(i1-i2));
            }
        }
        return min;

    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> p1 = map.get(word1);
        ArrayList<Integer> p2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        int i1 =0, i2 =0;
        
        while(i1<p1.size() && i2< p2.size()){
            int num1 = p1.get(i1);
            int num2 = p2.get(i2);
            min = Math.min(min, Math.abs(num1-num2));
            if(num1 < num2){
                i1++;
            }else{
                i2++;
            }
        }
        
        return min;

    }
}
