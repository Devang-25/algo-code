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
public class CountingBits {
    public int[] countBits(int num) {
        int [] result = new int[num+1];
        result[0] = 0;
        
        for(int i=1;i<=num;i++){
            if(i%2 == 1){
                result[i]= result[i/2]+1;
            }else{
                result[i] = result[i/2];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(16)));
    }
}
