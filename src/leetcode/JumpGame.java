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
public class JumpGame {

    static class Solution {

        public boolean canJumpMySolution(int[] nums) {
            if (nums.length > 0) {
                boolean[] reachable = new boolean[nums.length];
                Arrays.fill(reachable, false);
                reachable[0] = true;

                for (int i = 1; i < nums.length; i++) {
                    for (int j = 0; j < i; j++) {
                        reachable[i] = reachable[i] || (nums[j] >= i - j);
                    }
                }

                return reachable[nums.length - 1];

            }
            return false;
        }

        public boolean canJump(int[] A) {
            if (A.length <= 1) {
                return true;
            }

            int max = A[0]; //max stands for the largest index that can be reached.

            for (int i = 0; i < A.length; i++) {
                if (max < i) {
                    return false;
                }
    
                if (i + A[i] > max) {
                    max = i + A[i];
                }

                if (max >= A.length - 1) {
                    return true;
                }
            }

            return false;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
