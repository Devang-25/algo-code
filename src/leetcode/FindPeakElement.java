/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {

            if (l == r) {
                return l;
            }
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement fp = new FindPeakElement();
        System.out.println(fp.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(fp.findPeakElement(new int[]{1, 2, 3}));
        System.out.println(fp.findPeakElement(new int[]{1, -1, -2}));
        System.out.println(fp.findPeakElement(new int[]{2, 1}));
    }
}
