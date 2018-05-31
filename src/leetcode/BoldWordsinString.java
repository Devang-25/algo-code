/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.BitSet;

/**
 *
 * @author mns
 */
public class BoldWordsinString {

    public String boldWords(String[] words, String S) {
        BitSet bitset = new BitSet(S.length());
        bitset.set(0, S.length(), false);
        System.out.println("");
        for (int i = 0; i < words.length; i++) {
            int startSearchIndex = 0;
            int sindex = 0;
            
            while (startSearchIndex < S.length() && (sindex = S.indexOf(words[i], startSearchIndex)) != -1) {
                bitset.set(sindex, sindex + words[i].length());
                startSearchIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < S.length();) {
            if (!bitset.get(j)) {
                sb.append(S.charAt(j));
                j++;
            } else {
                StringBuilder sb1 = new StringBuilder();
                sb1.append("<b>");
                int i = j;
                while (i < S.length() && bitset.get(i)) {
                    sb1.append(S.charAt(i));
                    i++;
                    j++;
                }
                sb1.append("</b>");
                sb.append(sb1.toString());
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        BoldWordsinString b = new BoldWordsinString();
//        System.out.println(b.boldWords(new String[]{"ab", "bc"}, "aabcd"));
//        System.out.println(b.boldWords(new String[]{"ab", "bc", "abc", "efg", "d"}, "abcdefgabc"));
        System.out.println(b.boldWords(new String[]{"ccb", "b", "d", "cba", "dc"}, "eeaadadadc"));

    }
}
