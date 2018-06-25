package dsalgo.dp;

public class BuySellStock2 {
    public int maxProfit(int [] prices){
        if(prices == null || prices.length <= 1){
            return 0;
        }

        int maxProfit = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i] < prices[i+1] ){
                maxProfit += prices[i+1]-prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellStock2 bs = new BuySellStock2();
        System.out.println(bs.maxProfit(new int [] { 7,1,5,3,6,4}));
    }
}
