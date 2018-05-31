/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author mns
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length <= 1)
            return null;
        
        HashMap<Integer,Boolean> map = new HashMap<>();
        int [] result = new int[2];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result[0] = nums[i];
            }else{
                map.put(nums[i],true);
                sum+= nums[i];
            }
        }
        
        result[1] = ((nums.length* (nums.length+1))/2)- sum;
        return result;
    }
    
    public static void main(String[] args) {
        SetMismatch sm = new SetMismatch();
        System.out.println(Arrays.toString(sm.findErrorNums(new int[]{1,2,3,4,6,5,8,8,9})));
        System.out.println(Arrays.toString(sm.findErrorNums(new int[]{1,2,2,3})));
    }
}
