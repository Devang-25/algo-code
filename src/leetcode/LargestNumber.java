/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mns
 */
public class LargestNumber {
    
    
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        
        
        ArrayList<String> numStrings = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            numStrings.add(String.valueOf(nums[i]));
        }
        
        Collections.sort(numStrings, new Comparator<String> () {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
            
        });
        for(String s : numStrings){
            sb.append(s);
        }
        if(sb.length() > 0 && sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
   
    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(new int [] {3,31,34,5,9}));
    }
    
    
}
