/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 *
 * @author sekha
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] a, int k){
        if(a.length < k || k == 0){
            return new int[]{}; 
        }
        int [] result = new int [a.length-k+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int index = 0;
        while(index < a.length){
            while(!q.isEmpty() && q.peekFirst() < index-k+1){
                q.pollFirst();
            }
            
            while(!q.isEmpty() && a[q.peekLast()] < a[index]){
                q.pollLast();
            }
            q.addLast(index);
            
            if(index >= k-1){
                result[index-k+1] = a[q.peekFirst()];
            }
            index++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        SlidingWindowMaximum sm = new SlidingWindowMaximum();
        Arrays.stream(sm.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)).forEach(System.out::println);
        System.out.println("---");
        Arrays.stream(sm.maxSlidingWindow(new int[]{1}, 1)).forEach(System.out::println);
    }
}
