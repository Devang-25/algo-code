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
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--; 
        }
        if (i >= 0) {                           
            int j = nums.length - 1;              
            while (nums[j] <= nums[i]) {
                j--;           
            }
            swap(nums, i, j);                     
        }
        reverse(nums, i + 1, nums.length - 1);  
    }
        

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int [] nums = new int [] {1,2,3,4,5,6,7};
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
