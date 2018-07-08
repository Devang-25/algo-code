package leetcode.easy;

public class TransposeMatrix {
    public int [][] transpose(int [][] a){
        if(a == null || a.length == 0){
            return a;
        }

        int [][] t = new int[a[0].length][a.length];
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                t[i][j] = a[j][i];
            }
        }
        return t;
    }

}
