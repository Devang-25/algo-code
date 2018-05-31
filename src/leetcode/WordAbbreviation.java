/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mns
 */
public class WordAbbreviation {

    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> revMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for (String s : dict) {
            if (s.length() - 2 <= 1) {
                map.put(s, s);
                revMap.put(s, s);
            } else {
                String abbr = s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);
                //System.out.println(s + " " +abbr);
                if (map.containsKey(abbr)) {
                    resolve(map.get(abbr), s, map, revMap);
                } else {
                    map.put(abbr, s);
                    revMap.put(s, abbr);
                }
            }
        }

        for (String s : dict) {
            result.add(revMap.get(s));
        }

        return result;

    }

    public void resolve(String s1, String s2, HashMap<String, String> map, HashMap<String, String> revMap) {
        map.remove(revMap.get(s1));
        revMap.remove(s1);
        for (int i = 1; i < s1.length() - 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {

                String abbr1 = s1.substring(0, i + 1) + (s1.length() - i - 2) + s1.substring(s1.length() - 1);
                String abbr2 = s2.substring(0, i + 1) + (s2.length() - i - 2) + s2.substring(s2.length() - 1);;

                if (!abbr1.contentEquals(abbr2)) {

                    if ((s1.length() - i - 2) <= 1) {
                        map.put(s1, s1);
                        map.put(s2, s2);
                        revMap.put(s1, s1);
                        revMap.put(s2, s2);
                    } else {
                        map.put(abbr1, s1);
                        map.put(abbr2, s2);
                        revMap.put(s1, abbr1);
                        revMap.put(s2, abbr2);
                    }
                    
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        WordAbbreviation wa = new WordAbbreviation();
        List<String> res = wa.wordsAbbreviation(Arrays.asList("abcdefg","abccefg","abcckkg"));
        for (String s : res) {
            System.out.println(s);
        }
    }
}
