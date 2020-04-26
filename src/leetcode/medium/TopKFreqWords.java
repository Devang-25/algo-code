package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by mns on 7/26/18.
 */
public class TopKFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>( (a,b) -> {
            if(a.getValue() == b.getValue()){
                return a.getKey().compareTo(b.getKey());
            }
            return a.getValue() - b.getValue();
        });

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while(!pq.isEmpty()){
            result.addFirst(pq.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFreqWords tk = new TopKFreqWords();
        tk.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2).stream().forEach(System.out::println);
        tk.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4).stream().forEach(System.out::println);
    }

}
