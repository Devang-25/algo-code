/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class SumTwoWithoutArithOperators {

    static class Solution {

        public int getSum(int x, int y) {
            while (y != 0) {

                int carry = x & y;

                x = x ^ y;

                y = carry << 1;

                System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y) + " " + Integer.toBinaryString(carry));
            }
            return x;

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSum(15, -1));
    }

}
