/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.hard;

import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int maxLength = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                continue;
            }
            
            int num = nums[i]-1;
            int size = 1;
            while(set.contains(num)){
                set.remove(num);
                size++;
                num--;
            }
            num = nums[i]+1;
            while(set.contains(num)){
                set.remove(num);
                size++;
                num++;
            }
            
            maxLength = Math.max(maxLength, size);
            
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[] {100,4,200,1,3,2} ));
    }
}
