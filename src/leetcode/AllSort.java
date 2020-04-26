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
public class AllSort {

    public static void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[min_index] > nums[j]) {
                    min_index = j;
                }
            }

            swap(nums, i, min_index);
        }
    }

    public static void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            int key_index = i;
            int j = key_index - 1;
            while (j >= 0 && nums[key_index] > nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            swap(nums, j, key_index);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertSort(nums);
        //selectSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
