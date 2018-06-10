/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mns
 */
public class RedBlueBlueRed {

    static boolean wordPattern(String str, String pat) {
        Map<Character, String> map = new HashMap<>();
        return wordPattern(str, 0, pat, 0, map);
    }

    static boolean wordPattern(String str, int i, String pat, int j, Map<Character, String> map) {
        // base case
        if (i == str.length() && j == pat.length()) {
            return true;
        }
        if (i == str.length() || j == pat.length()) {
            return false;
        }

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[LoudAndRich...LoudAndRich+s.length()]
            if (i + s.length() > str.length() || !str.substring(i, i + s.length()).equals(s)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return wordPattern(str, i + s.length(), pat, j + 1, map);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            // create or update the map
            map.put(c, str.substring(i, k + 1));

            // continue to match the rest
            if (wordPattern(str, k + 1, pat, j + 1, map)) {
                return true;
            }
        }

        // we've tried our best but still no luck
        map.remove(c);

        return false;

    }

    public static int getCount(String str, String findStr) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("blueblusssssser", "aabb"));
    }
}
