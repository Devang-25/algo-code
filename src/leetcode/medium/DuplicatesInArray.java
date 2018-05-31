/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sekha
 */
public class DuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0){
                nums[num-1] = -nums[num-1];
            }else{
                result.add(num);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        DuplicatesInArray da = new DuplicatesInArray();
        System.out.println(da.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
