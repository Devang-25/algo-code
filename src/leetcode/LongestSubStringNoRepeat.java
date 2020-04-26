/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class LongestSubStringNoRepeat {
     public int lengthOfLongestSubstring(String s) {
         if(s == null || s.length() == 0){
             return 0;
         }
         
         int length = s.length();
         int maxLength = 0;
         
         HashMap<Character,Integer> map = new HashMap<>();
         int i=0;
         int currLength = 0;
         while(i < length){
             if(map.containsKey(s.charAt(i))){
                 i = map.get(s.charAt(i))+1;
                 currLength = 0;
                 map.clear();
             }else{
                 currLength++;
                 map.put(s.charAt(i),i);
                 maxLength = Math.max(maxLength, currLength);
                 i++;
             }
         }
         
         return maxLength;
     }
     
     public static void main(String[] args) {
        LongestSubStringNoRepeat l = new LongestSubStringNoRepeat();
         System.out.println(l.lengthOfLongestSubstring("pwwkew"));
         System.out.println(l.lengthOfLongestSubstring("bbbbb"));
         System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
