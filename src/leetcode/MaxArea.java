/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */

//PROB:11
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l=0,r=height.length-1;
        
        while(l<r){
            maxArea =Math.max(maxArea, (Math.min(height[l],height[r])* (r-l)));
            if(height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        System.out.println(ma.maxArea(new int[] {4,3,1,2,0,4,6,2}));
    }
}
