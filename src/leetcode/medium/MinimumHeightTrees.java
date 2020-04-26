package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mns on 12/28/18.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 0 || edges == null ){
            return result;
        }

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int [] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int minHeight = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int height = getHeight(i,adjList,new boolean[n]);
            if(height <= minHeight){
                if(height < minHeight) {
                    minHeight = height;
                    result.clear();
                }
                result.add(i);
            }
            minHeight = Math.min(minHeight,getHeight(i,adjList,new boolean[n]));
        }

        return result;
    }

    int getHeight(int root , HashMap<Integer, ArrayList<Integer> > adj, boolean [] visited){

        visited[root] = true;
        int maxHeight = 0;
        for(Integer i : adj.get(root)){
            if(!visited[i]){
                maxHeight = Math.max(maxHeight, getHeight(i,adj,visited));
            }
        }

        return 1 + maxHeight;
    }

}
