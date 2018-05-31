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
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        if(nums.length > 0){
            int maxIndex = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[maxIndex] <= nums[i]){
                    maxIndex = i;
                }
            }
            
            for(int i=0;i<nums.length;i++){
                if(i!=maxIndex && 2*nums[i] > nums[maxIndex]){
                    return -1;
                }
            }
            
            return maxIndex;
            
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        DominantIndex di = new DominantIndex();
        System.out.println(di.dominantIndex(new int[] {3,6,1,0}));
        System.out.println(di.dominantIndex(new int[] {1,2,3,4}));
    }
}
