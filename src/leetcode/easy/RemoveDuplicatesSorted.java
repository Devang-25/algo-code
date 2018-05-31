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
public class RemoveDuplicatesSorted {
     public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int currNum = nums[0];
        int insPos = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] != currNum){
                nums[insPos] = nums[i];
                currNum = nums[i];
                insPos++;
            }
        }
        
        return insPos;
    }
     
    public static void main(String[] args) {
        RemoveDuplicatesSorted r = new RemoveDuplicatesSorted();
        System.out.println(r.removeDuplicates(new int[]{1,1,1,2,3,4,4,4,4,4}));
        System.out.println(r.removeDuplicates(new int[]{1,1,1,2,2,2}));
    }
}
