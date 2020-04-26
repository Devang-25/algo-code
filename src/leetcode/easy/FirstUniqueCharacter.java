package leetcode.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        LinkedHashMap<Character, Integer> tm = new LinkedHashMap<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            tm.put(x, tm.getOrDefault(x, 0) + 1);
            hm.putIfAbsent(x,i);
        }

        for(Character c : tm.keySet()){
            if(tm.get(c) == 1){
                return hm.get(c);
            }
        }

        return -1;
    }

//    public int firstUniqChar(String s) {
//        int freq [] = new int[26];
//        for(int i = 0; i < s.length(); i ++)
//            freq [s.charAt(i) - 'a'] ++;
//        for(int i = 0; i < s.length(); i ++)
//            if(freq [s.charAt(i) - 'a'] == 1)
//                return i;
//        return -1;
//    }

    public static void main(String[] args) {
        FirstUniqueCharacter fs = new FirstUniqueCharacter();
        System.out.println(fs.firstUniqChar("loveleetcode"));
        System.out.println(fs.firstUniqChar("leetcode"));
    }
}
