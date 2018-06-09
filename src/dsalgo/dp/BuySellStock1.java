package dsalgo.dp;

public class BuySellStock1 {
    public int maxProfit(int [] prices){
        if(prices == null || prices.length <= 1){
            return 0;
        }

        int buy = 0;
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] - prices[buy] <=0 ){
                buy = i;
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - prices[buy]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellStock1 bs = new BuySellStock1();
        System.out.println(bs.maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(bs.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
