/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
       Graph g = new Graph(N);
       for(int i=0;i<edges.length;i++){
           g.addEdge(edges[i][0], edges[i][1]);
       }
    }
    
    class Graph {
        int vertices;
        HashMap<Integer,HashSet<Integer> > adjList = null;
        int [][] distMatrix = null;
        Graph( int N) {
            this.vertices  = N;
            adjList = new HashMap<>();
            for(int i=0;i<N;i++){
                adjList.put(i, new HashSet<>());
            }
            distMatrix = new int [N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    distMatrix[i][j]= Integer.MIN_VALUE;
                }
            }
        }
        
        public void addEdge(int x, int y) {
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        
        public int getDistance(int x, int y){
            boolean [] visited = new boolean[vertices];
            return getDistanceUtil(x, y,visited, 0);
        }
        private int getDistanceUtil(int x, int y, boolean [] visited, int acc) {
            if(distMatrix[x][y] != Integer.MIN_VALUE){
                return distMatrix[x][y]; 
            }
            
            if(adjList.get(x).contains(y)){
                distMatrix[x][y] = acc+1;
            }
            else{
                for(int v : adjList.get(x)){
                    if(!visited[v]){
                        visited[v] = true;
                        getDistanceUtil(v, y, visited, acc+1);
                    }
                }
            }
        }
    }
}
