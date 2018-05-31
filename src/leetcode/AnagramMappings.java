/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author mns
 */
public class AnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer,Stack<Integer>> map = new HashMap<>();
        int [] result = new int [A.length];
        for(int i=0;i<B.length;i++){
            if(!map.containsKey(B[i])){
                map.put(B[i],new Stack<>());
                
            }
            map.get(B[i]).push(i);
        }
        
        for(int i=0;i<A.length;i++){
            result[i] = map.get(A[i]).pop();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        AnagramMappings am = new AnagramMappings();
        System.out.println(Arrays.toString(am.anagramMappings(new int [] {12, 28, 46, 32, 50}, new int [] {50, 12, 32, 46, 28} )));
        System.out.println(Arrays.toString(am.anagramMappings(new int [] {5, 5, 5, 5, 5}, new int [] {5, 5, 5, 5, 5} )));
    }
}

