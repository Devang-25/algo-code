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
class Solution {

    public int integerBreak(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        int result = 1;
        if (n % 3 == 0) {
            int m = n / 3;
            result = (int) Math.pow(3, m);
        } else if (n % 3 == 2) {
            int m = n / 3;
            result = (int) Math.pow(3, m) * 2;
        } else if (n % 3 == 1) {
            int m = (n - 4) / 3;
            result = (int) Math.pow(3, m) * 4;
        }

        return result;
    }
}

public class IntegerBreak {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.integerBreak(20));
    }
}
