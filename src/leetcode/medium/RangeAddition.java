/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] result = new int[length];
        for(int i=0;i<updates.length;i++){
            int left = updates[i][0],right = updates[i][1];
            int val = updates[i][2];
            
            
            result[left]+=val;
            if(right < length-1){
                result[right+1] -= val;
            }
        }
        
        for(int i=1;i<length;i++){
            result[i] = result[i]+result[i-1];
        }
        
        return result;
       
    }
    
    public static void main(String[] args) {
        RangeAddition ra = new RangeAddition();
        Arrays.stream(ra.getModifiedArray(5,new int[][]{
            {1,  3,  2},
            {2,  4,  3},
            {0,  2, -2}
        })).forEach(System.out::println);
    }
}
