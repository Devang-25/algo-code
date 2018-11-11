package leetcode.medium;

public class KnightDialer {
    private static final int [][] KEYS = new int [][] {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}
    };
    private static final int [][] DIR = new int [][]{
            {-1,-2},
            {-2,-1},
            {-2,1},
            {-1,2},
            {1,2},
            {2,1},
            {2,-1},
            {1,-2}
    };
    public int knightDialer(int N) {
        if( N == 1){
            return 10;
        }
        int [][] mem = new int[10][N+1];
        for(int i=0;i<10;i++){
            mem[i][1] = 1;
        }
        return 0;
    }

    private int util(int N, int [][] mem, int curr, int n){
        if(mem[curr][N-n] == 0){
            return 0;
        }



        return mem[curr][N-n];
    }
}
