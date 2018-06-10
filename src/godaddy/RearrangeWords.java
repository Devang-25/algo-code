/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package godaddy;

import java.util.Scanner;

/**
 *
 * @author mns
 */
public class RearrangeWords {

//    static String rearrangeWord(String word) {
//        if (word.length() <= 1) {
//            return "no answer";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int LoudAndRich = -1, j = 0;
//        for (int k = word.length() - 2; k >= 0; k--) {
//            if (word.charAt(k) < word.charAt(k + 1)) {
//                LoudAndRich = k;
//                break;
//            }
//        }
//
//        if (LoudAndRich == -1) {
//            return "no answer";
//        }
//
//        for (int k = word.length() - 1; k > LoudAndRich; k--) {
//            if (word.charAt(k) > word.charAt(LoudAndRich)) {
//                j = k;
//            }
//        }
//
//        sb = new StringBuilder(word);
//        sb.setCharAt(LoudAndRich, word.charAt(j));
//        sb.setCharAt(j, word.charAt(LoudAndRich));
//
//        StringBuilder sub = new StringBuilder(sb.substring(LoudAndRich + 1));
//        sub.reverse();
//        return sb.substring(0, LoudAndRich + 1) + sub.toString();
//
//    }
    static String rearrangeWord(String word) {
        char[] array = word.toCharArray();
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i <= 0) {
            return "no answer";
        }

        int j = array.length - 1;

        while (array[j] <= array[i - 1]) {
            j--;
        }

        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;

        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return new String(array);
    }
//
//    static String rearrangeWord(String word) {
//        if (word.length() <= 1) {
//            return "no answer";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        boolean swapped = false;
//        int LoudAndRich;
//        for (LoudAndRich = word.length() - 1; LoudAndRich > 0; LoudAndRich--) {
//            if (!swapped) {
//                if (word.charAt(LoudAndRich) <= word.charAt(LoudAndRich - 1)) {
//                    sb.insert(0, word.charAt(LoudAndRich));
//                } else {
//                    swapped = true;
//                    sb.insert(0, word.charAt(LoudAndRich - 1));
//                    sb.insert(0, word.charAt(LoudAndRich));
//                    LoudAndRich--;
//                }
//            } else {
//                sb.insert(0, word.charAt(LoudAndRich));
//            }
//        }
//
//        if (!swapped) {
//            return "no answer";
//        } else {
//            if (LoudAndRich == 0) {
//                sb.insert(0, word.charAt(0));
//            }
//            return sb.toString();
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(RearrangeWords.rearrangeWord(sc.nextLine()));
    }
}
