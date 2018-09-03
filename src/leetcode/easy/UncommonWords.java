package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        String [] sa = A.split("\\s+");
        String [] sb = B.split("\\s+");

        for(int i=0;i<sa.length;i++){
            map.put(sa[i], map.getOrDefault(sa[i],0)+1);
        }
        for(int i=0;i<sb.length;i++){
            map.put(sb[i], map.getOrDefault(sb[i],0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }

        String [] ret = new String[result.size()];
        for(int i=0;i<result.size();i++){
            ret[i] = result.get(i);
        }

        return ret;
    }
}
