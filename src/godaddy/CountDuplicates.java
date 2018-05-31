package godaddy;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mns
 */
public class CountDuplicates {

    static int countDuplicates(int[] numbers) {
        HashMap<Integer,Integer> map  = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
                map.put(numbers[i],map.get(numbers[i])+1);
            }else{
                map.put(numbers[i], 1);
            }
        }
        int count = 0;
        for(Integer i : map.keySet()){
            if(map.get(i) > 1){
                count++;
            }
        }
        
        return count;
    }
}
