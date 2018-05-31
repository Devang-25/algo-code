/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.ArrayDeque;

/**
 *
 * @author sekha
 */
public class MinStack {
    
    private ArrayDeque<Long> stack = null;
    private long min = 0L;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
        }
        stack.push(x-min);
        
        if(x - min < 0 ){
            min = x;
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            long top = stack.poll();
            if(top < 0){
                min = min - (int)top;
            } 
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top > 0){
            return (int)(top + min);
        }else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}
