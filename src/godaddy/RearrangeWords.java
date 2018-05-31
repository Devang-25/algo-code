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
//        int i = -1, j = 0;
//        for (int k = word.length() - 2; k >= 0; k--) {
//            if (word.charAt(k) < word.charAt(k + 1)) {
//                i = k;
//                break;
//            }
//        }
//
//        if (i == -1) {
//            return "no answer";
//        }
//
//        for (int k = word.length() - 1; k > i; k--) {
//            if (word.charAt(k) > word.charAt(i)) {
//                j = k;
//            }
//        }
//
//        sb = new StringBuilder(word);
//        sb.setCharAt(i, word.charAt(j));
//        sb.setCharAt(j, word.charAt(i));
//
//        StringBuilder sub = new StringBuilder(sb.substring(i + 1));
//        sub.reverse();
//        return sb.substring(0, i + 1) + sub.toString();
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
//        int i;
//        for (i = word.length() - 1; i > 0; i--) {
//            if (!swapped) {
//                if (word.charAt(i) <= word.charAt(i - 1)) {
//                    sb.insert(0, word.charAt(i));
//                } else {
//                    swapped = true;
//                    sb.insert(0, word.charAt(i - 1));
//                    sb.insert(0, word.charAt(i));
//                    i--;
//                }
//            } else {
//                sb.insert(0, word.charAt(i));
//            }
//        }
//
//        if (!swapped) {
//            return "no answer";
//        } else {
//            if (i == 0) {
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
