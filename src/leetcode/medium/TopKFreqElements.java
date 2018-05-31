/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sekha
 */
public class TopKFreqElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (Integer i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for (Integer i : freqMap.keySet()) {
            int freq = freqMap.get(i);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(i);
            
        }

        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        
        while(result.size() > k){
            result.remove(result.size()-1);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TopKFreqElements tk = new TopKFreqElements();
        tk.topKFrequent(new int[] {1}, 1).stream().forEach(System.out::print);
    }
}
