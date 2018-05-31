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
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length > 0){
            int trap = 0;
            int l = 0, r=height.length-1;
            int leftMax = l, rightMax = r; 
            
            while(l <= r ){
                if(height[leftMax] <= height[rightMax]){
                    if(height[l] >= height[leftMax]){
                        leftMax = l;
                    }else{
                        trap += Math.min(height[leftMax], height[rightMax]) - height[l];
                    }
                    l++;
                }else{
                    if(height[r] >= height[rightMax]){
                        rightMax = r;
                    }else{
                        trap += Math.min(height[leftMax], height[rightMax]) - height[r];
                    }
                    r--;
                }
            }
            
            return trap;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        TrappingRainWater tp = new TrappingRainWater();
        System.out.println(tp.trap(new int[] {3,0,3}));
        System.out.println(tp.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
