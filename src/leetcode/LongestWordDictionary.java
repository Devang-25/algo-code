/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 *
 * @author mns
 */
public class LongestWordDictionary {
    public String longestWord(String[] words) {
        
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.length() == o1.length()){
                    return o1.compareToIgnoreCase(o2);
                }else{
                    return o2.length()-o1.length();
                }
            }
        });
        
        String currentString = "";
        for(int i=0;i<words.length;i++){
            currentString = words[i];
            int j = 0;
            for(;j<currentString.length();j++){
                if(!set.contains(currentString.substring(0, j+1))){
                    break;
                }
            }
            if(j == currentString.length()){
                return currentString;
            }
        }
        return "";
    }
    
    public static void main(String[] args) {
        LongestWordDictionary l = new LongestWordDictionary();
        System.out.println(l.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "applz"}));
        System.out.println(l.longestWord(new String[] {"w","wo","wor","worl", "world"}));
        System.out.println(l.longestWord(new String[] {"","a","b"}));
    }
}
