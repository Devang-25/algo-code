package leetcode;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mns
 */
public class SingleNumber {

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            if (hMap.get(num) == null) {
                hMap.put(num, 1);
            } else {
                hMap.remove(num);
            }
        }

        for (int num : hMap.keySet()) {
            return num;
        }
        return -1;
    }
    
    public int singleNumber(int[] nums) {
        if(nums == null ||  nums.length == 0){
            return -1;
        }
        
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor ^= nums[i];
        }
        
        return xor;
    }
}
