/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author mns
 */
public class JumpGame2 {

    static class Solution {

        public int minNumJumpMySolution(int[] nums) {
            if (nums.length > 0) {
                int[] reachable = new int[nums.length];
                Arrays.fill(reachable, Integer.MAX_VALUE);
                reachable[0] = 0;
                for (int i = 1; i < nums.length; i++) {
                    for (int j = 0; j < i; j++) {
                        if (nums[j] >= i - j) {
                            reachable[i] = Math.min(reachable[i], 1 + reachable[j]);
                        }
                    }
                }

                if (reachable[nums.length - 1] == Integer.MAX_VALUE) {
                    return -1;
                }
                return reachable[nums.length - 1];

            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minNumJumpMySolution(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.minNumJumpMySolution(new int[]{3, 2, 1, 0, 4}));
    }
}
