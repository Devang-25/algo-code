package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class ValidWordAbbr {
    HashMap<String,Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abbr = getAbbr(s);
            if(!set.contains(s)) {
                set.add(s);
                map.put(abbr,map.getOrDefault(abbr,0)+1);
            }

        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(map.get(abbr) == null){
            return true;
        }
        if(map.get(abbr) >= 2 || map.get(abbr) == 1 && !set.contains(word)){
            return false;
        }
        return true;
    }

    private String getAbbr(String s){
        return s.length() <= 2 ? s : ""+s.charAt(0)+""+(s.length()-2)+""+s.charAt(s.length()-1);
    }
}
