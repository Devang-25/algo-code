package leetcode.medium;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpannerOpt {
    private ArrayList<Integer> prices;
    private Stack<Integer> st;
    public StockSpannerOpt() {
        prices = new ArrayList<>();
        st = new Stack<>();
    }

    public int next(int price) {
        while(!st.isEmpty() && prices.get(st.peek()) <= price){
            st.pop();
        }
        int result;
        result = st.isEmpty()? (prices.size()+1) : prices.size()-st.peek();

        st.push(prices.size());
        prices.add(price);
        return result;
    }

    public static void main(String[] args) {
        StockSpannerOpt sp = new StockSpannerOpt();
        System.out.println(sp.next(31));
        System.out.println(sp.next(41));
        System.out.println(sp.next(48));
        System.out.println(sp.next(59));
        System.out.println(sp.next(79));
    }
}


