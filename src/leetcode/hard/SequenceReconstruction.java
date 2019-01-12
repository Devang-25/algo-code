package leetcode.hard;

import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, ArrayList<ArrayList<Integer>> seqs) {
        HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        int n = org.length;

        for(int i=1;i<=n;i++){
            adjList.put(i, new HashSet<>());
            inDegree.put(i,0);
        }

        boolean noEdges = true;
        for(List<Integer> l : seqs){
            for(int i =0;i<l.size();i++){
                noEdges = false;
                int u = l.get(i);
                if(u < 1 || u > n) return false;
                if(i == 0) continue;

                int v  = l.get(i-1);
                if(adjList.get(v).add(u)){
                    inDegree.put(u,inDegree.get(u)+1);
                }
            }
        }

        //For stupid test cases.
        if(noEdges){
            return false;
        }

        int countZeroinDegree = 0;
        for(int d : inDegree.values()) {
            if(d == 0 )
                countZeroinDegree++;
        }
        if(countZeroinDegree != 1) return false;

        for(int i=0; i<org.length; i++) {
            int u = org[i];
            if(!inDegree.containsKey(u) || inDegree.get(u) != 0) return false;

            if(i == org.length - 1) continue;
            for(int v : adjList.get(u)) {
                int d = inDegree.get(v) - 1;
                if (d == 0 && v != org[i+1]) return false;
                inDegree.put(v, d);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        SequenceReconstruction sr = new SequenceReconstruction();
        ArrayList<Integer> l = new ArrayList<>(),l1 = new ArrayList<>();
        l.addAll(Arrays.asList(1,2));l1.addAll(Arrays.asList(1,3));
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(l);a.add(l1);
        System.out.println(sr.sequenceReconstruction(new int[]{1,2,3},a));
    }
}
