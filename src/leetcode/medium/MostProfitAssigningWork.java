/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author sekha
 */
public class MostProfitAssigningWork {

    class Pair{
        int diff, prof;
        Pair (int d , int p){
            this.diff = d;
            this.prof = p;
        }
        
        
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> {
           return b.prof-a.prof;
       });
       
       for(int i=0;i<difficulty.length;i++){
           pq.offer(new Pair(difficulty[i],profit[i]));
       }
       int totalProfit = 0;
       Arrays.sort(worker);
       
       for(int i=worker.length-1;i>=0;--i){
           while(!pq.isEmpty() && pq.peek().diff > worker[i]){
               pq.poll();
           }
           if(pq.isEmpty())
               break;
           totalProfit += pq.peek().prof;
       }
       
       return totalProfit;
    }
    
    public static void main(String[] args) {
        MostProfitAssigningWork ms = new MostProfitAssigningWork();
        System.out.println(ms.maxProfitAssignment(new int[]{2,4,6,8,10},
                new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
    }
}
