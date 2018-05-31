/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author sekha
 */
public class LongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int longestSubstringLength = 0;
        int length = s.length();
        int currentSubstringLength = 0;
        int i=0;
        
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        while(i < length){
            if(map.containsKey(s.charAt(i)) || map.size() < 2){
                
                if(map.containsKey(s.charAt(i))){
                    map.remove(s.charAt(i));
                }
                map.put(s.charAt(i), i);
                currentSubstringLength++;
                i++;
            }else{
                Character oldestCharacter = map.keySet().iterator().next();
                i = map.get(oldestCharacter)+1;
                currentSubstringLength = 0;
                map.remove(oldestCharacter);
            }
            longestSubstringLength = Math.max(currentSubstringLength,longestSubstringLength);
        }
        
        return longestSubstringLength;
    }
    
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int longestSubstringLength = 0;
        int length = s.length();
        int currentSubstringLength = 0;
        int i=0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        while(i < length){
            if(map.containsKey(s.charAt(i)) || map.size() < 2){
                map.put(s.charAt(i), i);
                currentSubstringLength++;
                i++;
            }else{
                Character oldestCharacter = null;
                for(Character c : map.keySet()){
                    if(c != s.charAt(i-1)){
                        oldestCharacter = c;
                        break;
                    }
                }
                i = map.get(oldestCharacter)+1;
                currentSubstringLength = 0;
                map.remove(oldestCharacter);
            }
            longestSubstringLength = Math.max(currentSubstringLength,longestSubstringLength);
        }
        
        return longestSubstringLength;
    }
    
    public static void main(String[] args) {
        LongestSubstringTwoDistinct l = new LongestSubstringTwoDistinct();
        System.out.println(l.lengthOfLongestSubstringTwoDistinct2("eceba"));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct2("abcdefg"));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct2("a"));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct2(""));
        System.out.println(l.lengthOfLongestSubstringTwoDistinct2("aaaaabbbbbaaaaaaaaacccacaccaccaccccacccaccccccccacccc"));
    }
}
