package leet.may30day;

import java.util.Stack;

public class StockSpanner {
  private Stack<int[]> st = null;
  int index;

  public StockSpanner() {
    this.st = new Stack<>();
    this.index = 0;
  }

  public int next(int price) {
    int result = index + 1;
    while (!st.isEmpty() && st.peek()[0] <= price) {
      st.pop();
    }
    if (!st.isEmpty()) {
      result = index - st.peek()[1];
    }
    st.push(new int[] { price, index++ });
    return result;
  }

  public static void main(String[] args) {
    StockSpanner sp = new StockSpanner();
    System.out.println(sp.next(31));
    System.out.println(sp.next(41));
    System.out.println(sp.next(48));
    System.out.println(sp.next(59));
    System.out.println(sp.next(79));
  }
}
