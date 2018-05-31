/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author mns
 */
public class MajorityElement {
    public int majorityElement(int [] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int times = (int)Math.floor(nums.length/2);
        
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
       
        for(Integer key : map.keySet()){
            if(map.get(key) > times){
                return key;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int [] {1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3}));
        System.out.println(me.majorityElement(new int [] {1}));
    }
}
