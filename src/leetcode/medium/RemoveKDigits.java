/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 *
 * @author sekha
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() < k) {
            return num;
        }

        char[] arr = num.toCharArray();
        ArrayDeque<Character> st = new ArrayDeque<>();
        st.push(arr[0]);
        int currIndex = 1;
        while (currIndex < arr.length) {
            while (k > 0 && !st.isEmpty() && st.peekLast() > arr[currIndex]) {
                st.pollLast();
                k--;
            }
            st.addLast(arr[currIndex]);
            currIndex++;
        }

        StringBuffer sb = new StringBuffer();
        while (!st.isEmpty()) {
            if (k > 0) {
                st.pollLast();
                k--;
            } else {
                char c = st.pollFirst();
                if(sb.length() == 0 && c == '0'){
                    continue;
                }
                sb.append(c);
            }
        }

        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        System.out.println(r.removeKdigits("1432219", 3));
        System.out.println(r.removeKdigits("10200", 1));
        System.out.println(r.removeKdigits("10", 2));
        System.out.println(r.removeKdigits("123450", 4));
        System.out.println(r.removeKdigits("112", 1));
    }
}
