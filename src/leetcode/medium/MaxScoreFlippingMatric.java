package leetcode.medium;

public class MaxScoreFlippingMatric {
    public int matrixScore(int[][] A) {
        for(int i=0;i<A.length;i++){
            if(A[i][0] == 0){
                flip(A,i,0);
            }
        }

        for(int j=1;j <A[0].length;j++){
            int cntOne = 0;
            int cntZero = 0;
            for(int i =0;i<A.length;i++){
                if(A[i][j] == 1){
                    cntOne++;
                }else{
                    cntZero++;
                }
            }
            if(cntZero > cntOne){
                flip(A,j,1);
            }
        }

        int result = 0;
        for(int i=0;i<A.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<A[0].length;j++){
                sb.append(A[i][j]);
            }
            result+= Integer.parseInt(sb.toString(),2);
        }

        return result;
    }

    private void flip(int [][] a,int rowCol, int mode){
        if(mode == 0){
            for(int j=0;j<a[0].length;j++){
                a[rowCol][j] = a[rowCol][j] == 0?1:0;
            }
        }else{
            for(int i=0;i<a.length;i++){
                a[i][rowCol] = a[i][rowCol] == 0?1:0;
            }
        }
    }

    public static void main(String[] args) {
        MaxScoreFlippingMatric m = new MaxScoreFlippingMatric();
        System.out.println(m.matrixScore(new int[][]{
                {0,0,1,1},{1,0,1,0},{1,1,0,0}     
        }));
    }
}
