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
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        if(nums != null){
            for(int i=0;i<nums.length;i++){
                if(nums[i] != val){
                    nums[index++] = nums[i];
                }
            }
        }
        
        return index;
    }
    
    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        System.out.println(r.removeElement(new int[] {3,2,2,3}, 3));
    }
}
