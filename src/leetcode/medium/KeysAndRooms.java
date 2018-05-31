/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sekha
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       HashSet<Integer> visited = new HashSet<>();
       ArrayDeque<Integer> q = new ArrayDeque<>();
       
       visited.add(0);
       q.offer(0);
       while(!q.isEmpty()){
           int top = q.poll();
           if(visited.size() == rooms.size()){
               return true;
           }
           
           Set<Integer> keys = new HashSet<>(rooms.get(top));
           for(Integer key : keys){
               if(!visited.contains(key)){
                visited.add(key);
                q.offer(key);
               }
           }
       }
       
       return visited.size() == rooms.size();
    }
   
}
