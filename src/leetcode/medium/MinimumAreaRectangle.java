package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {

        if(points.length < 4){
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int [] point : points){
            ArrayList<Integer> l = map.get(point[0]);
            if(l == null){
                l = new ArrayList<>();
                map.put(point[0],l);
            }
            l.add(point[1]);
        }

        int min = Integer.MAX_VALUE;
        ArrayList<Integer> x = new ArrayList<>(map.keySet());
        Collections.sort(x);
        for(int i=0;i<x.size();i++){
            for(int j=i+1;j<x.size();j++){
                Set<Integer> s1 = new HashSet<>(map.get(x.get(i)));
                Set<Integer> s2 = new HashSet<>(map.get(x.get(j)));
                s1.retainAll(s2);

                if(s1.size() > 1) {
                    ArrayList<Integer> y = new ArrayList<>(s1);
                    Collections.sort(y);
                    for (int k = 0; k < y.size() - 1; k++) {
                        min = Math.min(min, (x.get(j) - x.get(i)) * (y.get(k+1) - y.get(k)) );
                        if(min == 1){
                            return 1;
                        }
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumAreaRectangle m = new MinimumAreaRectangle();
        System.out.println(m.minAreaRect(new int[][] {
                {1,1},
                {1,3},
                {3,1},
                {3,3},
                {2,2}
        }));
        System.out.println(m.minAreaRect(new int[][] {
                {1,1},
                {1,3},
                {3,1},
                {3,3},
                {4,1},
                {4,3}
        }));
        System.out.println(m.minAreaRect(new int[][] {
                {1,1},
                {1,3},
                {3,1},
                {3,3},
                {4,1},
                {4,2},
                {5,1},
                {5,2}
        }));
    }
}
