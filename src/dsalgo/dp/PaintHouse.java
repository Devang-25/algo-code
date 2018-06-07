package dsalgo.dp;

public class PaintHouse {
    public int minCost(int [][] costs){
        if(costs == null || costs.length == 0)
            return 0;


        int minRed = costs[0][0],
                minBlue = costs[0][1],
                minGreen = costs[0][2];

        for(int i=1;i<costs.length;i++){
            int r = Math.min(minBlue,minGreen)+costs[i][0];
            int b = Math.min(minRed,minGreen)+costs[i][1];
            int g = Math.min(minBlue,minRed)+costs[i][2];
            minRed = r;
            minBlue = b;
            minGreen = g;
        }
       return Math.min(minRed, Math.min(minBlue,minGreen));
    }

    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        System.out.println(ph.minCost(new int[][]{
                {17,2,17},
                {16,16,5},
                {14,3,19}
        }));
    }
}
