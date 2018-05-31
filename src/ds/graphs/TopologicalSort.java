package ds.graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mns on 5/30/18.
 */


public class TopologicalSort {
    private int [] visited;
    private ArrayList<Integer> order;
    public TopologicalSort(DiGraph g){
        visited = new int [g.getNumVertices()];
        order = new ArrayList<>();
        Arrays.fill(visited,-1);
        boolean noCycle = true;
        for(int i=0;i<visited.length && noCycle;i++){
            if(visited[i] == -1){
                noCycle = dfs(g,i);
            }
        }
    }

    private boolean dfs(DiGraph g, int v){
        visited[v] = 0;
        for(int neighbor : g.getAdjacentVertices(v)){
            if(visited[neighbor] == -1){
                dfs(g,neighbor);
            }else if(visited[neighbor] == 0){
                return false;
            }
        }
        visited[v] = 1;
        order.add(v);
        return true;
    }

    public ArrayList<Integer> getTopologicalSortOrder(){
        return order;
    }

    public boolean hasTopologicalOrder(){
        return getTopologicalSortOrder().size() == visited.length;
    }
    public static void main(String[] args) {
        DiGraph g = new DiGraph(2);
        g.addEdge(0,1);
        g.addEdge(1,0);

        TopologicalSort ts = new TopologicalSort(g);
        System.out.println(ts.hasTopologicalOrder());
    }
}
