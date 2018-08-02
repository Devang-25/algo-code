package dp;

/**
 * Created by mns on 7/23/18.
 */
public class PaintFence {
    public int numWays(int n, int k){
        if(n==0){
            return 0;
        }
        if(n == 1){
            return k;
        }

        int endSameColor = k;
        int endDiffColor = k * (k-1);
        for(int i=2;i<n;i++){
            int tmp = endDiffColor;
            endDiffColor = (endSameColor+endDiffColor)*(k-1);
            endSameColor = tmp;
        }

        return endDiffColor + endSameColor;
    }

    public static void main(String[] args) {
        PaintFence pf = new PaintFence();
        System.out.println(pf.numWays(3,2));
    }
}
