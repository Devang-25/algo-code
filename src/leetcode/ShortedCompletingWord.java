/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class ShortedCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        HashMap<Character,Integer> set = new HashMap<>();
        HashMap<Character,Integer> set2 = new HashMap<>();
        String minWord = "";
        makeSet(licensePlate,set);
        for(int i=0;i<words.length;i++){
            makeSet(words[i],set2);
            boolean flag = true;
            for(Character c : set.keySet()){
                if(!set2.containsKey(c) || set2.get(c) < set.get(c)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                if(minWord.length() == 0 || minWord.length() > words[i].length()){
                    minWord = words[i];
                }
            }
        }
        
        return minWord;
    }
    
    public void makeSet(String str,HashMap<Character,Integer> set){
        set.clear();
        char [] wordArray = str.toCharArray();
        
        for(int i=0;i<wordArray.length;i++){
            if(Character.isAlphabetic(wordArray[i])){
                Integer val = set.get(Character.toLowerCase(wordArray[i]));
                if(val == null){
                    set.put(Character.toLowerCase(wordArray[i]),1);
                }else{
                    set.put(Character.toLowerCase(wordArray[i]),val+1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        ShortedCompletingWord s = new ShortedCompletingWord();
        System.out.println(s.shortestCompletingWord("1s3 PSt", new String [] {"step", "steps", "stripe", "stepple"}));
        System.out.println(s.shortestCompletingWord("1s3 456", new String [] {"looks", "pest", "stew", "show"}));
    }
}
