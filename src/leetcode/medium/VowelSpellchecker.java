package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        if(wordlist == null || queries == null || wordlist.length == 0 || queries.length == 0){
            return new String [] {};
        }

        String [] result = new String[queries.length];
        HashMap<String, String> dict = new HashMap<>();
        for(int i =wordlist.length-1; i >= 0 ;i--) {
            dict.put(wordlist[i], wordlist[i]);
            dict.put(wordlist[i].toLowerCase()+'@', wordlist[i]);
            dict.put(convertVowels(wordlist[i].toLowerCase()), wordlist[i]);
        }

        for(int i=0;i<queries.length;i++){
            String s = queries[i];
            if(dict.containsKey(s)){
                result[i] = s;
                continue;
            }

            String low = s.toLowerCase();
            if(dict.containsKey(low+'@')){
                result[i] = dict.get(low+'@');
                continue;
            }
            String conv = convertVowels(s.toLowerCase());
            if(dict.containsKey(conv)) {
                result[i] = dict.get(conv);
                continue;
            }
            result[i] = "";
        }
        return result;
    }

    private String convertVowels(String s){
        StringBuilder sb = new StringBuilder(s);
        for (int j = 0; j < sb.length(); j++) {
            if (isVowel(sb.charAt(j))){
                sb.setCharAt(j,'#');
            }
        }
        return sb.toString();
    }
    private boolean isVowel (char c){
        char ch  = Character.toLowerCase(c);
        return ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        VowelSpellchecker v = new VowelSpellchecker();
//        System.out.println(Arrays.toString(v.spellchecker( new String[]{"KiTe","kite","hare","Hare"},
//                new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"})));
//        System.out.println(Arrays.toString(v.spellchecker( new String[]{"Yellow"},
//                new String[]{"yellow"})));
        System.out.println(Arrays.toString(v.spellchecker( new String[]{"iaf"},
                new String[]{"aiF"})));
    }
}
