/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class SortColors {
     public void sortColors(int[] nums) {
         if(nums == null || nums.length == 0){
             return ;
         }
         
         int red = 0, white=0, blue = 0;
         
         for(int i=0;i<nums.length;i++){
             if(nums[i] == 0){
                 red++;
             }else if(nums[i] == 1){
                 white++;
             }
             else if(nums[i] == 2){
                 blue++;
             }
         }
         
         for(int i=0;i<nums.length;i++){
             if(i<red){
                 nums[i] = 0;
             }else if(i< red+white){
                 nums[i] = 1;
             }else{
                 nums[i] = 2;
             }
         }
        
     }
     
     public void sortColors2(int[] nums) {
         if(nums == null || nums.length == 0){
             return ;
         }
         
         int red = 0;
         while(red < nums.length){
             if(nums[red] == 0){
                 red++;
             }else{
                 break;
             }
         }
         
         
         int blue = nums.length - 1;
         while(blue >= 0){
             if(nums[blue] == 2){
                 blue--;
             }else{
                 break;
             }
         }
         
         int currIndex = red;
         
         while( currIndex <= blue && red < blue){
             if(nums[currIndex] == 1 ){
                 currIndex++;
             }
             else if(nums[currIndex] == 0){
                 swap(nums,currIndex,red);
                 red++;
                 currIndex++;
             }else if (nums[currIndex] == 2){
                 swap(nums,currIndex,blue);
                 blue--;
             }
         }
        
     }
     
     private void swap(int [] arr , int x, int y){
         int temp = arr[x];
         arr[x] = arr[y];
         arr[y] = temp;
     }
     public static void main(String[] args) {
        SortColors sc = new SortColors();
        int [] colors = new int[] {1,0,1,2}; 
        sc.sortColors2( colors);
        
         System.out.println(Arrays.toString(colors));
    }
}
