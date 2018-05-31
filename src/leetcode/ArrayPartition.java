/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        ArrayPartition ap = new ArrayPartition();
        System.out.println(ap.arrayPairSum(new int[]{1,4,3,2}));
    }
}
