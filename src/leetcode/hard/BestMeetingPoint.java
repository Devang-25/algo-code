package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        ArrayList<Integer> x = new ArrayList<>(m);
        ArrayList<Integer> y = new ArrayList<>(n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    x.add(i);
                    y.add(j);
                }
            }
        }

        return getDist(x) + getDist(y);
    }

    int getDist(ArrayList<Integer> l){
        Collections.sort(l);
        int i = 0, j = l.size()-1;
        int tot = 0;
        while(i < j){
            tot += l.get(j--) - l.get(i++);
        }

        return tot;
    }
}
