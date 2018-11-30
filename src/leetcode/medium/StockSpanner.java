package leetcode.medium;

import java.util.Stack;

public class StockSpanner {

    private Stack<int []> st = null;
    int index;
    public StockSpanner() {
        this.st= new Stack<>();
        this.st.push( new int []{-1,Integer.MIN_VALUE});
        this.index = 0;
    }

    public int next(int price) {
        int result = 1;
        while(!(st.peek()[0] == -1)){
            int [] top = st.peek();
            if(price >= top[1]){
                st.pop();
            }else{
                break;
            }
        }

        result = index - st.peek()[0];
        st.push(new int[]{index++,price});
        return result;
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(100));
        System.out.println(sp.next(80));
        System.out.println(sp.next(60));
        System.out.println(sp.next(70));
        System.out.println(sp.next(60));
        System.out.println(sp.next(75));
        System.out.println(sp.next(85));
    }
}
