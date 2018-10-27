package medium;

/**
 * Created by mns on 9/22/18.
 */
public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        return getIndex(6,4,4);
    }


    private int getIndex(int N, int i, int j){
        return (N-i-1)*N + ((N-i-1)%2 == 0 ? j+1: N-j);
    }

    public static void main(String[] args) {
        SnakesAndLadders sl = new SnakesAndLadders();
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.println(sl.getIndex(6,i,j));
            }
        }

    }
}
