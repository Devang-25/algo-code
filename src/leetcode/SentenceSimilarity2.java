/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author sekha
 */
public class SentenceSimilarity2 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

        if (words1.length != words2.length) {
            return false;
        }

        HashMap<String, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (int i = 0; i < pairs.length; i++) {
            if(!indexMap.containsKey(pairs[i][0])){
                indexMap.put(pairs[i][0], index++);
            }
            if(!indexMap.containsKey(pairs[i][1])){
                indexMap.put(pairs[i][1], index++);
            }
            
        }

        DisjointSet ds = new DisjointSet(indexMap.size());
        for (int i = 0; i < pairs.length; i++) {
            ds.union(indexMap.get(pairs[i][0]), indexMap.get(pairs[i][1]));
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].contentEquals(words2[i])) {
                continue;
            }

            if (!indexMap.containsKey(words1[i]) || !indexMap.containsKey(words2[i])) {
                return false;
            } else {
                int root1 = ds.find(indexMap.get(words1[i]));
                int root2 = ds.find(indexMap.get(words2[i]));
                if (root1 != root2) {
                    return false;
                }
            }
        }
        return true;
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
