/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mns
 */
public class ReachANumber {
    public int reachNumber(int target){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        int jump = 1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                int currentPosition = q.poll();
                if(currentPosition + jump == target || currentPosition-jump == target){
                    return jump;
                }else{
                    q.offer(currentPosition+jump);
                    q.offer(currentPosition-jump);
                }
            }
            jump++;
        }
     
        return -1;
    }
    
    public static void main(String[] args) {
        ReachANumber r = new ReachANumber();
        System.out.println(r.reachNumber(-1));
    }
}
