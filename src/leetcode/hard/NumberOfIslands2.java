package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfIslands2 {
    class DisjointSet {

        private int[] parent;
        private int[] size;
        private int count;

        public DisjointSet(int n) {
            count = 0;
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = -1;
                size[i] = -1;
            }
        }

        public void add(int n){
            parent[n] = n;
            size[n] = 1;
            count++;
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

    private final int [][] dir = { {-1,0},{0,1},{1,0},{0,-1}};
     public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        DisjointSet ds = new DisjointSet(m*n);
        for(int i=0;i<positions.length;i++){
            int x = positions[i][0];
            int y = positions[i][1];
            ds.add(x*n + y);
            for(int j=0;j<dir.length;j++){
                int a = x + dir[j][0];
                int b = y + dir[j][1];
                if(a >=0 && a < m && b>=0 && b < n){
                    if(ds.parent[a*n+b] != -1) {
                        ds.union(positions[i][0] * n + positions[i][1], a*n+b);
                    }
                }
            }
            result.add(ds.count());
        }

        return result;
     }

    public static void main(String[] args) {
        NumberOfIslands2 nm = new NumberOfIslands2();
        //nm.numIslands2(3,3, new int[][]{{0,0},{0,1},{1,2},{2,1}}).stream().forEach(System.out::print);
        //nm.numIslands2(8,2, new int[][]{{7,0}}).stream().forEach(System.out::print);
        nm.numIslands2(3,3, new int[][]{{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}}).stream().forEach(System.out::print);
    }
}
