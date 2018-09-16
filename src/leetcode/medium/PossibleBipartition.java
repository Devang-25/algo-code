package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {

        int [][] adjMatrix = new int[N][N];
        for(int i=0;i<dislikes.length;i++){
            adjMatrix[dislikes[i][0]-1][dislikes[i][1]-1] = 1;
        }
        return isBipartite(adjMatrix, 0);
    }

    boolean isBipartite(int G[][],int src)
    {
        int V = G.length;
        int id[] = new int[V];
        for (int i=0; i<V; ++i)
            id[i] = -1;
        id[src] = 1;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);

        while (q.size() != 0)
        {
            int u = q.poll();
            if (G[u][u] == 1)
                return false;
            for (int v=0; v<V; ++v)
            {
                if (G[u][v]==1 && id[v]==-1)
                {
                    id[v] = 1-id[u];
                    q.add(v);
                }
                else if (G[u][v]==1 && id[v]==id[u])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition pb =new PossibleBipartition();
        System.out.println(pb.possibleBipartition(4, new int[][]{
                {1,2},
                {1,3},
                {2,4},
        }));
//        System.out.println(pb.possibleBipartition(3, new int[][]{
//                {1,2},
//                {1,3},
//                {2,3}
//        }));
//        System.out.println(pb.possibleBipartition(5, new int[][]{
//                {1,2},
//                {2,3},
//                {3,4},
//                {4,5},
//                {1,5}
//        }));
    }
}
