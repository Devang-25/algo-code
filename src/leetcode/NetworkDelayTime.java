/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author sekha
 */
public class NetworkDelayTime {
     class Edge {
        int start;
        int end;
        int delay;

        Edge(int s, int e, int w) {
            this.start = s;
            this.end = e;
            this.delay = w;
        }
    }

    class Graph {

        ArrayList<ArrayList<Edge>> adjList = null;
        int size = 0;

        public Graph(int n) {
            this.size = n;
            adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<Edge>());
            }
        }

        public void addEdge(int start, int end, int weight) {
            Edge e = new Edge(start, end, weight);
            adjList.get(start).add(e);
        }

        public ArrayList<Edge> adjacent(int vertex) {
            return adjList.get(vertex);
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {

        Graph g = new Graph(N);
        for (int i = 0; i < times.length; i++) {
            g.addEdge(times[i][0] - 1, times[i][1] - 1, times[i][2]);
        }

        int [] distTo = new int[N];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return distTo[o1] - distTo[o2];
            }
            
        });
        
        distTo[K-1] = 0;
        pq.offer(K-1);
        
        while(!pq.isEmpty()){
            int vertex = pq.poll();
            
            ArrayList<Edge> neighbors = g.adjacent(vertex);
            for(Edge e : neighbors) {
                if(distTo[e.end] > distTo[e.start]+e.delay){
                    distTo[e.end] = distTo[e.start]+e.delay;
                    
                    if(pq.contains(e.end)){
                        pq.remove(e.end);
                    }
                    pq.add(e.end);
                }
            }
        }
        
        int result = -1;
        for(int i=0;i<distTo.length;i++){
            if(distTo[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                result = Math.max(distTo[i], result);
            }
        }
        
        return result;
    }
}
