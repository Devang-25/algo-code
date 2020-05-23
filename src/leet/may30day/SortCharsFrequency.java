package leet.may30day;

import java.util.PriorityQueue;

public class SortCharsFrequency {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int [] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));
        
        for(int i=0;i<256;i++) {
            if(freq[i] > 0) {
                pq.add(new int[]{freq[i],i});
            }
        }
        while(!pq.isEmpty()){
            int [] top = pq.poll();
            for(int i=0;i<top[0];i++){
                sb.append((char)(top[1]));
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SortCharsFrequency sf = new SortCharsFrequency();
        System.out.println(sf.frequencySort("tree"));
        System.out.println(sf.frequencySort("cccaaa"));
        System.out.println(sf.frequencySort("Aabb"));
    }
}