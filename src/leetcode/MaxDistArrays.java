/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mns
 */
public class MaxDistArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = -1;
        
        if(arrays != null){
            for(int i=0;i<arrays.size();i++){
                for(int j=i+1;j<arrays.size();j++){
                    List<Integer> first = arrays.get(i);
                    List<Integer> second = arrays.get(j);

                    for(Integer num1 : first){
                        for(Integer num2 : second){
                            if(Math.abs(num1 - num2) > maxDistance){
                                maxDistance = Math.abs(num1 - num2);
                            }
                        }
                    }
                }
            }
        }
        return maxDistance;
    }
    
    public int maxDistanceOpt(List<List<Integer>> arrays) {
        int maxDistance = -1;
        if(arrays.size() > 0){
            int [] mins = new int[4]; 
            int [] maxs = new int[4];
            Arrays.fill(mins, Integer.MAX_VALUE);
            Arrays.fill(maxs, Integer.MIN_VALUE);
            
            for(int i=0;i<arrays.size();i++){
                List<Integer> currList = arrays.get(i);
                if(currList.size() > 0) {
                    
                    int min = currList.get(0);
                    int max = currList.get(currList.size()-1);
                    
                    if(mins[0] >= min){
                        mins[1] = mins[0];
                        mins[3] = mins[2];
                        mins[0] = min;
                        mins[2] = i;
                        
                    }else if(mins[1] >= min){
                        mins[1] = min;
                        mins[3] = i;
                    }
                    
                    if(maxs[0] <= max){
                        maxs[1] = maxs[0];
                        maxs[3] = maxs[2];
                        maxs[0] = max;
                        maxs[2] = i;
                    }else if(maxs[1] <= max){
                        maxs[1] = max;
                        maxs[3] = i;
                    }
                }
            }
            
            if(mins[2] != maxs[2]){
                maxDistance = Math.abs(mins[0]-maxs[0]);
            }else{
                maxDistance = Math.max(Math.abs(mins[1]-maxs[0]), Math.abs(mins[0]-maxs[1]));
            }
        }
        
        return maxDistance;
        
    }
    
    public static void main(String [] args){
        MaxDistArrays ma = new MaxDistArrays();
        List<List<Integer> > list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(1));
//        list.add(Arrays.asList(1,2,3));
        System.out.println(ma.maxDistanceOpt(list));
    }
}
