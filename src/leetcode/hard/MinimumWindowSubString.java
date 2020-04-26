package leetcode.hard;

import java.util.HashMap;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t==null || t.length() == 0){
            return "";
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int cnt = map.size(), i=0,j=0 , min = Integer.MAX_VALUE;
        String minString = "";
        while(j < s.length()){
            if(cnt != 0) {
                Integer val = map.get(s.charAt(j));
                if (val != null) {
                    map.put(s.charAt(j), --val);
                    if(val == 0){
                        cnt--;
                    }
                }
            }

            if(cnt==0){
                while(cnt == 0){
                   if(min > j-i){
                       min = j-i;
                       minString = s.substring(i,j+1);
                   }
                    Integer val = map.get(s.charAt(i));
                    if (val != null) {
                        map.put(s.charAt(i), ++val);
                        if(val == 1){
                            cnt++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }

        return minString;
    }

    public static void main(String[] args) {
        MinimumWindowSubString ms = new MinimumWindowSubString();
        System.out.println(ms.minWindow("AA","AA"));
        System.out.println(ms.minWindow("AAABBCCDDDEEEF","ABCDEF"));
    }
}
