/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void swap(int[] n, int x, int y) {
        int temp = n[x];
        n[x] = n[y];
        n[y] = temp;
    }

    public void reverse(int[] n, int l, int r) {
        while (l < r) {
            swap(n, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] n = new int[]{1, 2, 3, 4, 5, 6, 7};
        ra.rotate(n, 5);
        System.out.println(Arrays.toString(n));
    }
}
