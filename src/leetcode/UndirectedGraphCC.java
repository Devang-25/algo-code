/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class UndirectedGraphCC {
    public int countComponents(int n, int[][] edges) {
        if(n > 0 && edges != null && edges.length > 0){
            DisjointSet ds = new DisjointSet(n);
            for(int i=0;i<edges.length;i++){
                ds.union(edges[i][0], edges[i][1]);
            }
            
            return ds.count();
        }
        
        return 0;
    }
    
    class DisjointSet {

        private int[] parent;  
        private int[] size;    
        private int count;

        public DisjointSet(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            int root = p;
            while (root != parent[root]) {
                root = parent[root];
            }
            while (p != root) {
                int newp = parent[p];
                parent[p] = root;
                p = newp;
            }
            return root;
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
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }

    }
}
