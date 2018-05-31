/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 *
 * @author sekha
 */
public class ContainsDuplicate3 {
   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       if(nums  == null || nums.length == 0 ){
           return false;
       }
       
       TreeSet<Long> set = new TreeSet<>();
       set.add(Long.valueOf(nums[0]));
       for(int i=1;i<nums.length;i++){
          
           Long val = Long.valueOf(nums[i]);
           if(set.size() > k){
               set.remove(Long.valueOf(nums[i-k-1]));
           }
           Long min = set.floor(val);
           Long max = set.ceiling(val);
           
           if((min != null && Math.abs(min-val) <=t)
                   || (max != null && Math.abs(max-val)<=t)){
               return true;
           }
           
           set.add(val);
       }
       
       return false;
    }
   
    public static void main(String[] args) {
        ContainsDuplicate3 c3 = new ContainsDuplicate3();
        System.out.println(c3.containsNearbyAlmostDuplicate(new int[]{1,2},0,1));
    }
}
