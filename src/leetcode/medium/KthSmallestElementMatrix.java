package leetcode.medium;

import java.util.PriorityQueue;

public class KthSmallestElementMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        if(k<0 || matrix.length == 0 || k > matrix.length* matrix[0].length){
            throw new IndexOutOfBoundsException();
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i=0;i<matrix[0].length;i++){
            pq.add(new int[]{0,i});
        }

        while(!pq.isEmpty() && k > 0){
            int [] top = pq.poll();
            int x = top[0],y=top[1];
            if(--k == 0){
                return matrix[x][y];
            }
            if( x < matrix.length-1){
                pq.add(new int[]{x+1,y});
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        KthSmallestElementMatrix km = new KthSmallestElementMatrix();
        System.out.println(km.kthSmallest(new int[][]{
                { 1,  5,  9},{10, 11, 13},{12, 13, 15}
        },10));
    }
}
