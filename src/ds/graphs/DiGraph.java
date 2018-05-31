package ds.graphs;

/**
 * Created by mns on 5/30/18.
 */
public class DiGraph extends Graph {
    public DiGraph(int v){
        super(v);
    }

    @Override
    public void addEdge(int s, int d) {
        adjList[s].add(d);
    }

    @Override
    public void removeEdge(int s, int d) {
        adjList[s].remove(d);
    }
}
