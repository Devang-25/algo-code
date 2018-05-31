/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int result = 1;
        boolean [] visited = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int start = i;
            int currSize = 0;
            while(!visited[nums[start]]){
                visited[nums[start]] = true;
                start = nums[start];
                result = Math.max(++currSize, result);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        ArrayNesting an = new ArrayNesting();
        System.out.println(an.arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
