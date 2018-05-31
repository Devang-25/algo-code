package leetcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sekha
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            if(l==r){
                return nums[l];
            }
            
            int mid = l + (r-l)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }else{
                if(nums[mid] == nums[mid+1]){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        SingleNonDuplicate s = new SingleNonDuplicate();
        System.out.println(s.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        System.out.println(s.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
        System.out.println(s.singleNonDuplicate(new int[] {3,3,1,7,7,10,10,11,11}));
    }
}
