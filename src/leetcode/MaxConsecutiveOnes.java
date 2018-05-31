/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        
        if(nums != null){
            int currLength = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 1){
                    currLength++;
                }else{
                    if(currLength > maxLength){
                        maxLength = currLength;
                    }
                    currLength = 0;
                }
            }
            
            if(currLength > maxLength){
                maxLength = currLength;
            }
            
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        MaxConsecutiveOnes m = new MaxConsecutiveOnes();
        System.out.println(m.findMaxConsecutiveOnes(new int[] {0,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,0}));
    }
}
