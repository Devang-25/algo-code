/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class ShortedWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1=-1, i2=-1, dist = Integer.MAX_VALUE;
        
        for(int i=0;i<words.length;i++){
            if(words[i].contentEquals(word1)){
                i1 = i;
            }else if(words[i].contentEquals(word2)){
                i2 = i;
            }
            if(i1 != -1 && i2 !=-1)
                dist = Math.min(dist,Math.abs(i1-i2));
        }
        
        return dist;
    }
}
