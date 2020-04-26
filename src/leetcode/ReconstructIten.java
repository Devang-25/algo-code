/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mns
 */
public class ReconstructIten {

    private static class Solution {

        public List<String> findItinerary(String[][] tickets) {
            List<String> output = new ArrayList<>();
            Map<String,ArrayList<String> > myMap = new HashMap<String,ArrayList<String>>();
            for(int i=0;i<tickets.length;i++){
                if(myMap.get(tickets[i][0]) ==null){
                    myMap.put(tickets[i][0],new ArrayList<String>());
                    myMap.get(tickets[i][0]).add(tickets[i][1]);
                }else{
                    myMap.get(tickets[i][0]).add(tickets[i][1]);
                }
            }
            
            for(String key : myMap.keySet()){
                Collections.sort(myMap.get(key),new Comparator<String>(){
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                    
                });
            }
            
            String start = "JFK";
            
            output.add(start);
            while(myMap.get(start) !=null && myMap.get(start).size() > 0){
                String next = myMap.get(start).get(0);
                output.add(next);
                myMap.remove(start);
                start = next;
                
            }
            //System.out.println(output.toString());
            return output;
        };

    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String [][] inp = new String [][]{{"MUC", "LHR"},{"JFK", "MUC"},{"SFO", "SJC"},{"LHR", "SFO"}};
        s.findItinerary(inp);
    }
}
