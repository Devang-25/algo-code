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
public class MinSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int l = 0,r=0, minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        while(r < nums.length){
            if(windowSum < s){
                windowSum += nums[r];
                r++;
            }
            
            while(windowSum >= s){
                minLength = Math.min(minLength,r-l);
                windowSum -= nums[l];
                l++;
            }
            
        }
        
        if(minLength == Integer.MAX_VALUE)
            return 0;
        
        return minLength;
        
    }
    
    public static void main(String[] args) {
        MinSubArraySum m = new MinSubArraySum();
        System.out.println(m.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(m.minSubArrayLen(4, new int[] {1,4,4}));
    }
}
