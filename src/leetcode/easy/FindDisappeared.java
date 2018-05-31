/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sekha
 */
public class FindDisappeared {
   public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0){
                nums[num-1] = -nums[num-1];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
