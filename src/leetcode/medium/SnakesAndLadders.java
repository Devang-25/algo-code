package medium;

/**
 * Created by mns on 9/22/18.
 */
public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        return getIndex(6,4,4);
    }


    private int getIndex(int N, int i, int j){
        if(i % 2 == 0){
            return (N-i) * N - j;
        }else{
            return (N-i) * N - (N-j-1);
        }
    }

    public static void main(String[] args) {
        SnakesAndLadders sl = new SnakesAndLadders();
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(sl.getIndex(6,i,j) + " ");
            }
            System.out.println();
        }

    }
}
