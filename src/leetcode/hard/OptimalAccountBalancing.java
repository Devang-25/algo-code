package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] t) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<t.length;i++){
            map.put(t[i][0],map.getOrDefault(t[i][0],0)-t[i][2]);
            map.put(t[i][1],map.getOrDefault(t[i][1],0)+t[i][2]);
        }

        return findMinUtil(0,new ArrayList<>(map.values()));
    }

    private int findMinUtil(int start, ArrayList<Integer> list){

        for(int i=start;i<list.size() && list.get(i) == 0;i++){
            start++;
        }

        if(start == list.size()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=start+1;i<list.size();i++){
            if(list.get(start) * list.get(i) < 0){
                list.set(i, list.get(i) + list.get(start));
                min = Math.min(min, 1 + findMinUtil(start+1,list));
                list.set(i, list.get(i)-list.get(start));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        OptimalAccountBalancing ob = new OptimalAccountBalancing();
        System.out.println(ob.minTransfers(new int[][]{
                {0,1,10},
                {1,0,1},
                {1,2,5},
                {2,0,5}
        }));
    }

}
