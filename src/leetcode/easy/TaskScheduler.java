/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author mns
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c : tasks){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer> > q = new PriorityQueue<>( (a,b) -> {
            return Integer.compare(b.getValue(), a.getValue());
        });
        
        q.addAll(map.entrySet());
        int cnt = 0;
        while(!q.isEmpty()){
            ArrayList<Map.Entry<Character,Integer> > buffer = new ArrayList<>();
            int slotSize = 0;
            
            while(slotSize <= n+1 && !q.isEmpty()){
                Map.Entry<Character,Integer> entry = q.poll();
                entry.setValue(entry.getValue()-1);
                buffer.add(entry);
                cnt++;
                slotSize++;
            }
            
            q.addAll( buffer.stream().filter((a)->a.getValue() > 0).collect(Collectors.toList()));
            if(!q.isEmpty()){
                cnt += (n+1)-slotSize > 0 ? (n+1)-slotSize:0;
            }
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
        System.out.println(ts.leastInterval(new char[] {'A','A','A','B','B','B'}, 0));
    }
}
