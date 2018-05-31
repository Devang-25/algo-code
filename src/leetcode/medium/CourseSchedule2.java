package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mns on 5/30/18.
 */
public class CourseSchedule2 {
    class TopologicalSort {
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
    }

    class DiGraph {

        int numVertices;
        Set<Integer>[] adjList = null;
        public DiGraph(int v){
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
        }

        public void removeEdge(int s, int d){
            adjList[s].remove(d);
        }

        public Set<Integer> getAdjacentVertices(int s){
            return adjList[s];
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        DiGraph dg = new DiGraph(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            dg.addEdge(prerequisites[i][0],prerequisites[i][1]);
        }

        TopologicalSort ts = new TopologicalSort(dg);
        if(ts.hasTopologicalOrder()){
            ArrayList<Integer> topOrder = ts.getTopologicalSortOrder();
            int [] result = new int[topOrder.size()];
            for(int i=0;i<topOrder.size();i++){
                result[i] = topOrder.get(i);
            }
            return result;
        }else{
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        CourseSchedule2 cs = new CourseSchedule2();
        Arrays.stream(cs.findOrder(2,new int[][]{{1,0},{0,1}})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(cs.findOrder(2, new int[][]{{1, 0}})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(cs.findOrder(1, new int[][]{})).forEach(System.out::print);
    }
}
