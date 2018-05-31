/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author mns
 */
public class CountUniqueDigits {
    private static int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        long max = (long) Math.pow(10,n);
        boolean [] usedDigits = new boolean[10];
        Arrays.fill(usedDigits, false);
        count = 1;
        
        for(int i= 1;i<10;i++){
            usedDigits[i] = true;
            findCount(max,i,usedDigits);
            usedDigits[i] = false;
        }
        
        return count;
    }
    
    public void findCount(long max, long currVal , boolean [] usedDigits){
        if(currVal < max){
            count++;
        }else{
            return;
        }
        
        for(int i=0;i<10;i++){
            if(usedDigits[i] == false){
                usedDigits[i] = true;
                findCount(max,currVal*10+i,usedDigits);
                usedDigits[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        CountUniqueDigits cud = new CountUniqueDigits();
        System.out.println(cud.countNumbersWithUniqueDigits(3));
    }
}
