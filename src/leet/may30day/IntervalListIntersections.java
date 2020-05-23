package leet.may30day;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> intersections = new ArrayList<>();
        
        int i=0,j=0;
        while(i < a.length && j <b.length ) {
            int[] x = a[i], y = b[j];
            int[] ov = overlap(x, y);
            if(ov[0] <= ov[1]){
                intersections.add(ov);
            }
            if(y[1] < x[1]){
                j++;
            }else if(x[1] < y[1]){
                i++;
            }else{
                i++; j++;
            }
            
        }

        return intersections.toArray(new int[intersections.size()][]);
    }

    private int[] overlap(int []x , int[] y) {
        return new int[]{Math.max(x[0], y[0]), Math.min(x[1], y[1])};
    }
}