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
public class ShortedUnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int [] copy = nums.clone();
        Arrays.sort(copy);
        
        int left = 0;
        int right = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != copy[i]){
                left = i;
                break;
            }
        }
        
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] != copy[i]){
                right = i;
                break;
            }
        }
        
        return left == right? 0 : right - left + 1;
        
    }
    
    public static void main(String[] args) {
        ShortedUnsortedSubArray sa = new ShortedUnsortedSubArray();
        System.out.println(sa.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));
        System.out.println(sa.findUnsortedSubarray(new int[] {1,2,3,4,5,6,7}));
        System.out.println(sa.findUnsortedSubarray(new int[] {9,8,7,6,5,4,3}));
        System.out.println(sa.findUnsortedSubarray(new int[] {1}));
    }
}
