package dsalgo.dp;

public class PaintHouse2 {
    public int minCostII(int [][] costs){
        if(costs == null || costs.length == 0 ){
            return 0;
        }

        int minCost = 0, minIndex=-1,secondMinCost =0;
        for(int i=0;i<costs.length;i++) {
            int tempMinCost = Integer.MAX_VALUE, tempMinIndex=-1,tempSecondMinCost = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                int cost = 0;
                if (j == minIndex) {
                    cost = costs[i][j] + secondMinCost;
                } else {
                    cost = costs[i][j] + minCost;
                }

                if (cost < tempMinCost) {
                    int temp = tempMinCost;
                    tempMinCost = cost;
                    tempSecondMinCost = temp;
                    tempMinIndex = j;
                } else if (cost < tempSecondMinCost) {
                    tempSecondMinCost = cost;
                }
            }
            minCost = tempMinCost;
            minIndex = tempMinIndex;
            secondMinCost = tempSecondMinCost;
        }

        return minCost;
    }

    public static void main(String[] args) {
        PaintHouse2 ph = new PaintHouse2();
        System.out.println(ph.minCostII(new int[][]{
                {1,5,3},
                {2,9,4}
        }));
    }
}
