package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumber2 {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static {
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if(n == 1){
            result.addAll(Arrays.asList("0","1","8"));
            return result;
        }
        for(Integer key : map.keySet()){
            if(key != 0) {
                findStrobogrammaticUtil(n - 2, ""+key, map.get(key)+"", result);
            }
        }
        return result;
    }

    public void findStrobogrammaticUtil(int n, String left, String right, List<String> result){
        if(n == 0){
            result.add(left+right);
            return;
        }

        if(n == 1){
            result.add(left+ 0 + right);result.add(left+ 1 + right);result.add(left+ 8 + right);
            return;
        }

        for(Integer key : map.keySet()){
            findStrobogrammaticUtil(n-2,left+key,map.get(key)+right,result);
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumber2 sb = new StrobogrammaticNumber2();
        sb.findStrobogrammatic(4).stream().forEach(System.out::println);
    }
}
