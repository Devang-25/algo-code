package medium;

import java.util.Arrays;

/**
 * Created by mns on 7/13/18.
 */
public class RedundantConnection {
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
            while(curr != parent[curr]){
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

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        for(int [] edge : edges){
            if(ds.find(edge[0]) == ds.find(edge[1])){
                return edge;
            }
            ds.union(edge[0],edge[1]);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        RedundantConnection rc = new RedundantConnection();
        Arrays.stream(rc.findRedundantConnection(new int[][]{
                {1,2}, {1,3}, {2,3}
        })).forEach(System.out::println);
    }
}
