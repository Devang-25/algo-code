/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        long total = (nums.length*(nums.length+1))/2;
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        
        return (int)(total-sum);
    }
}
