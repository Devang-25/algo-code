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
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        
        
        if(asteroids == null || asteroids.length == 0){
            return asteroids;
        }
       
        Stack<Integer> stack = new Stack<>();
        for(int index =0;index < asteroids.length;index++){
            if(asteroids[index] >= 0){
                stack.push(asteroids[index]);
            }else{
                
                boolean survives = true;
                while(!stack.isEmpty() && survives){
                    int top = stack.peek();
                    if(top >= 0){
                        if(Math.abs(asteroids[index]) > top){
                            stack.pop();
                        }else if(Math.abs(asteroids[index]) == top){
                            stack.pop();
                            survives = false;
                        }else{
                            survives = false;
                        }
                    }else{
                        break;
                    }
                }
                
                if(survives){
                    stack.push(asteroids[index]);
                }
            }
        }
        
        
        int [] result = new int [stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{-10,-2,-5})));
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{6,6,-6,-6})));
    }
}
