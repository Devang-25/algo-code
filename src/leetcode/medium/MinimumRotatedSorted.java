/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class MinimumRotatedSorted {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[right];
    }

    public static void main(String[] args) {
        MinimumRotatedSorted ms = new MinimumRotatedSorted();
        System.out.println(ms.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(ms.findMin(new int[]{2, 1}));
        System.out.println(ms.findMin(new int[]{2, 3, 1}));

    }
}
