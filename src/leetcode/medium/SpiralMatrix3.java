package leetcode.medium;

import java.util.ArrayList;

public class SpiralMatrix3 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        ArrayList<int []> result = new ArrayList<>();
        move(R,C,new int[]{1,1,2,2},r0,c0,result);
        int [][] res = new int[R*C][2];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }

    void move( int R, int C, int [] dir, int x, int y, ArrayList<int []> res) {

        if (y >= 0 && y < C && x >= 0 && x < R) {
            res.add(new int[]{x, y});
        }

        while (res.size() < R * C) {
            for (int i = 0; i < dir[0]; i++) {
                y++;
                if (y >= 0 && y < C && x >= 0 && x < R) {
                    res.add(new int[]{x, y});
                }
            }
            for (int i = 0; i < dir[1]; i++) {
                x++;
                if (y >= 0 && y < C && x >= 0 && x < R) {
                    res.add(new int[]{x, y});
                }
            }
            for (int i = 0; i < dir[2]; i++) {
                y--;
                if (y >= 0 && y < C && x >= 0 && x < R) {
                    res.add(new int[]{x, y});
                }
            }
            for (int i = 0; i < dir[3]; i++) {
                x--;
                if (y >= 0 && y < C && x >= 0 && x < R) {
                    res.add(new int[]{x, y});
                }
            }
            for(int i=0;i<4;i++){
                dir[i] += 2;
            }
        }
    }

    public static void main(String[] args) {
        SpiralMatrix3 sm = new SpiralMatrix3();
        sm.spiralMatrixIII(1,4,0,0);
    }
}
