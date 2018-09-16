package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Character> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        boolean [] taken = new boolean[26];
        for(int i = 0;i<words.length;i++){
            boolean matches = true;
            if(words[i].length() == pattern.length()){
                for(int j=0;j<words[i].length() && matches;j++){
                    char c1 = words[i].charAt(j);
                    char c2 = pattern.charAt(j);

                    Character mp = map.get(c2);
                    if(mp == null){
                        if(taken[c1-'a']){
                            matches = false;
                        }else{
                            map.put(c2,c1);
                            taken[c1-'a'] = true;
                        }
                    }else{
                        if(mp != c1){
                            matches = false;
                        }
                    }
                }

                if(matches){
                    result.add(words[i]);
                }
            }
            Arrays.fill(taken,false);
            map.clear();
        }

        return result;
    }
}
