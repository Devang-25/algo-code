/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author mns
 */
public class MaxChunksSorted {

    public int maxChunksToSorted2(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int chunks = 0;

        if(arr.length > 0){
            for(int i=0;i<arr.length;i++){
                pq.offer(arr[i]);
                if( i == pq.peek()){
                    chunks++;
                }
            }
        }
        
        return chunks;
    }
    
    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int chunks = 0;

        if(arr.length > 0){
            for(int i=0;i<arr.length;i++){
                max = Math.max(max, arr[i]);
                if( i == max){
                    chunks++;
                }
            }
        }
        
        return chunks;
    }

    public static void main(String[] args) {
        MaxChunksSorted mcs = new MaxChunksSorted();
        System.out.println(mcs.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(mcs.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(mcs.maxChunksToSorted(new int[]{2,0,1}));
    }
}
