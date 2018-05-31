package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sekha
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        
        if(words1.length != words2.length){
            return false;
        }
        
        HashMap<String,Set<String> > map = new HashMap<>();
        
        
        if(pairs != null && pairs.length > 0){
            for(int i=0;i<pairs.length;i++){
                if(!map.containsKey(pairs[i][0])){
                    map.put(pairs[i][0], new HashSet<String>());   
                }
                if(!map.containsKey(pairs[i][1])){   
                    map.put(pairs[i][1], new HashSet<String>());
                }
                map.get(pairs[i][0]).add(pairs[i][1]);
                map.get(pairs[i][1]).add(pairs[i][0]);
            }
        }
        
        for(int i=0;i<words1.length;i++){
            if(!words1[i].contentEquals(words2[i]) && (map.get(words1[i]) == null || !map.get(words1[i]).contains(words2[i]))){
                return false;
            }
        }
        
        return true;
    }
}
