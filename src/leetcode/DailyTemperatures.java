/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author sekha
 */
public class DailyTemperatures {
     public int[] dailyTemperatures(int[] temperatures) {
         int [] result = new int[temperatures.length];
         
         Stack<Integer> st = new Stack<>();
         if(temperatures.length > 1){
            st.push(0);
            for(int i=1;i<temperatures.length;i++){
                while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                    int index = st.pop();
                    result[index] = i-index;
                }
                st.push(i);
            }
         }
         
         while(!st.isEmpty()){
             result[st.pop()] = 0;
         }
         
         return result;
     }
     
     public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
         System.out.println(Arrays.toString(dt.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
         System.out.println(Arrays.toString(dt.dailyTemperatures(new int[] {0,0,0,0})));
         System.out.println(Arrays.toString(dt.dailyTemperatures(new int[] {1,2,3,4,5,6,7,8})));
         System.out.println(Arrays.toString(dt.dailyTemperatures(new int[] {33,32,31,30,29})));
    }
}
