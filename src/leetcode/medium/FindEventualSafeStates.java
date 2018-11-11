package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int l = graph.length;
        int [] state = new int[l];
        for(int i=0;i<l;i++){
            if(dfs(i,state,graph) == 1){
                result.add(i);
            }
        }

        return result;
    }

    private int dfs(int curr, int [] state, int  [][] graph){
        if(state[curr] == 2 || state[curr] == -1){
            return 2;
        }else if(state[curr] == 1){
            return 1;
        }

        state[curr] = -1;
        for(int neigh : graph[curr]){
            int res = dfs(neigh,state,graph);
            if(res == 2){
                state[curr] = 2;
                return state[curr];
            }
        }

        state[curr] = 1;
        return state[curr];
    }

    public static void main(String[] args) {
        FindEventualSafeStates f = new FindEventualSafeStates();
        System.out.println(f.eventualSafeNodes( new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
        System.out.println(f.eventualSafeNodes(new int [][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));
    }
}
