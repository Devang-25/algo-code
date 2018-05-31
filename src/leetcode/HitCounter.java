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
public class HitCounter {
     /** Initialize your data structure here. */
    private int [] hits = null;
    private int [] timestamps = null;
    public HitCounter() {
        hits = new int [300];
        timestamps = new int[300];
        Arrays.fill(hits,0);
        Arrays.fill(timestamps,Integer.MAX_VALUE);
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(timestamps[index] != timestamp){
            hits[index] = 1;
            timestamps[index] = timestamp;
        }else{
            hits[index]++;
        }

    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i=0;i<300;i++){
            if(timestamps[i] > timestamp - 300){
                count+= hits[i];
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
        hc.hit(1);
        hc.hit(2);
        hc.hit(3);
        
        System.out.println(hc.getHits(4));
        hc.hit(300);
        System.out.println(hc.getHits(300));
        System.out.println(hc.getHits(901));
    }
}
