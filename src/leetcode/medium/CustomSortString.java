package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class CustomSortString {
    public String customSortString(String S, String T) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<T.length();i++){
            map.put(T.charAt(i),map.getOrDefault(T.charAt(i),0)+1);
        }

        for(int i=0;i<S.length();i++){
            if(!set.contains(i)){
                set.add(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : set){
            int cnt = map.getOrDefault(c,0);
            for(int i=0;i<cnt;i++){
                sb.append(c);
            }
        }

        for(Character c : map.keySet()){
            if(!set.contains(c)){
                int cnt = map.getOrDefault(c,0);
                for(int i=0;i<cnt;i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortString cs = new CustomSortString();
        System.out.println(cs.customSortString("cba","abcd"));
    }
}
