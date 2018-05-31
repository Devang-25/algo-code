/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author mns
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        boolean isOdd = false;
        int sumOdd = 0;
        int sumEven = 0;
        for (Character ch : map.keySet()) {
            int val = map.get(ch);
            if (val % 2 == 0) {
                sumEven += val;
            } else {
                sumOdd += val;
                sumOdd--;
                isOdd = true;
            }
        }

        if (isOdd) {
            sumOdd++;
        }
        return sumOdd + sumEven;
    }
}
