package hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mns on 7/13/18.
 */
public class RedundantConnection2 {
    class DisjointSet {

        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            int curr = p;
            while (curr != parent[curr]) {
                curr = parent[curr];
            }
            return curr;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
        }

    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length + 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] candidate1 = null, candidate2 = null;
        for (int[] edge : edges) {
            Integer parent = map.get(edge[1]);
            if (parent != null) {
                candidate1 = new int[]{parent, edge[1]};
                candidate2 = new int[]{edge[0], edge[1]};
            } else {
                map.put(edge[1], edge[0]);
            }
        }

        for (int[] edge : edges) {
            if (equalsEdge(edge, candidate1) || equalsEdge(edge, candidate2)) {
                continue;
            }
            if (ds.find(edge[0]) == ds.find(edge[1])) {
                return edge;
            }
            ds.union(edge[0], edge[1]);
        }

        if(candidate1 != null && candidate2 != null) {
            if (ds.find(candidate1[0]) == ds.find(candidate1[1])) {
                return candidate1;
            }else{
               return candidate2;
            }
        }

        return new int[]{};
    }

    private boolean equalsEdge(int[] e1, int[] e2) {
        return e1 != null && e2 != null && e1[0] == e2[0] && e1[1] == e2[1];
    }

    public static void main(String[] args) {
        RedundantConnection2 rc = new RedundantConnection2();
        Arrays.stream(rc.findRedundantDirectedConnection(new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        })).forEach(System.out::println);
    }
}
