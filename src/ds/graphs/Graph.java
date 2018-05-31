package ds.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mns on 5/30/18.
 */

public class Graph {

    int numVertices;
    Set<Integer> [] adjList = null;
    public Graph(int v){
        this.numVertices = v;
        adjList = new Set[v];
        for(int i=0;i<v;i++){
            adjList[i] = new HashSet<>();
        }
    }

    public int getNumVertices(){
        return this.numVertices;
    }

    public int getNumEdges(){
        int total = 0;
        for(Set s : adjList){
            total += s.size();
        }
        return total;
    }

    public void addEdge(int s,int d){
        adjList[s].add(d);
        adjList[d].add(s);
    }

    public void removeEdge(int s, int d){
        adjList[s].remove(d);
        adjList[d].remove(s);
    }

    public Set<Integer> getAdjacentVertices(int s){
        return adjList[s];
    }
}
