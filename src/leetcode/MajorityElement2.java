/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mns
 */
public class MajorityElement2 {
    public List<Integer> majorityElement(int [] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();
        int times = (int)Math.floor(nums.length/3);
        
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
       
        for(Integer key : map.keySet()){
            if(map.get(key) > times){
                result.add(key);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MajorityElement2 me = new MajorityElement2();
        System.out.println(me.majorityElement(new int [] {1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3}));
        System.out.println(me.majorityElement(new int [] {1}));
    }
}
