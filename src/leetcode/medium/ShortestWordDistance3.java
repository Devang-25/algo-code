/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class ShortestWordDistance3 {

    class Pair {

        int min, max, self;

        Pair(int i, int j, int self) {
            this.min = i;
            this.max = j;
            this.self = self;
        }
    }

    public int shortestWordDistance2(String[] words, String word1, String word2) {
        HashMap<String, Pair> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Pair p = map.get(words[i]);
            if (p == null) {
                p = new Pair(i, i, Integer.MAX_VALUE);
                map.put(words[i], p);
            }

            if (p.max != i) {
                p.self = Math.min(p.self, i - p.max);
            }
            p.max = i;
        }

        Pair p1 = map.get(word1);
        Pair p2 = map.get(word2);

        if (word1.compareTo(word2) != 0) {
            return Arrays.stream(new int[]{
                Math.abs(p1.min - p2.min),
                Math.abs(p1.max - p2.max),
                Math.abs(p1.min - p2.max),
                Math.abs(p1.max - p2.min)
            }).min().getAsInt();
        } else {
            return map.get(word1).self;
        }
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int m = Integer.MAX_VALUE;
        Pair p1 = null,
                p2 = null;
        for (int i = 0; i < words.length; i++) {
            if (words[i].contentEquals(word1)) {
                if (p1 == null) {
                    p1 = new Pair(i, i, m);
                } else {
                    if (p1.max != i) {
                        p1.self = Math.min(p1.self, i - p1.max);
                    }
                }
                p1.max = i;
            }
            if (words[i].contentEquals(word2)) {
                if (p2 == null) {
                    p2 = new Pair(i, i, m);
                } else {
                    if (p2.max != i) {
                        p2.self = Math.min(p2.self, i - p2.max);
                    }
                }
                 p2.max = i;
            }
        }

        if (word1.compareTo(word2) != 0) {
            
            int x = Math.min(Math.abs(p1.min - p2.min),
                Math.abs(p1.max - p2.max));
            int y = Math.min(Math.abs(p1.min - p2.max),
                Math.abs(p1.max - p2.min));
            return Math.min(x,y);
        } else {
            return p1.self;
        }
    }

    public static void main(String[] args) {
        ShortestWordDistance3 s = new ShortestWordDistance3();
        System.out.println(s.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding"));

        System.out.println(s.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "makes"));
        System.out.println(s.shortestWordDistance(new String[]{"a", "a", "a"},
                "a", "a"));
        System.out.println(s.shortestWordDistance(new String[]{"a", "c", "b", "b", "a"},
                "a", "b"));
    }

}
