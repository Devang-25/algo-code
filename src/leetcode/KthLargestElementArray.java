/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.PriorityQueue;

/**
 *
 * @author mns
 */
public class KthLargestElementArray {
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for ( int num : nums){
            pq.offer(num);
        }
        
        k = nums.length - k + 1;
        while(k-- > 1 ){
                pq.poll();
        }

        return pq.poll();


    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }
    
    public int quickSelect(int [] nums,int left, int right, int k){
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int i = left;
        int j = right;
        
        while(i < j){
            while(nums[i] <= pivot && i<j){
                i++;
            }
            while(nums[j] >= pivot && i<j){
                j--;
            }
            
            if(i<j){
                swap(nums, i, j);
            }
        }
        
        
        if(nums[i] <= pivot){
            pivotIndex = i;
        }else{
            pivotIndex = i-1;
        }
        swap(nums, pivotIndex, left);
        
        if(pivotIndex == k){
            return nums[k];
        }else if(pivotIndex > k){
            return quickSelect(nums, left, pivotIndex-1, k);
        }else{
            return quickSelect(nums, pivotIndex+1, right, k);
        }
    }
    
    public void swap(int [] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        KthLargestElementArray k = new KthLargestElementArray();
        System.out.println(k.findKthLargest(new int[]{3,9,4,2,1,7,6,8,2,1}, 1));
        System.out.println(k.findKthLargest(new int[]{3,9,4,2,1,7,6,8,2,1}, 2));
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(k.findKthLargest(new int[]{0}, 1));
        System.out.println(k.findKthLargest(new int[]{9,8}, 1));
    }
    
    
}
