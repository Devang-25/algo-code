package leetcode.hard;

import java.util.Stack;

/**
 * Created by mns on 7/22/18.
 */
public class MaxStack {
    /** initialize your data structure here. */
    Stack <Integer> st, maxSt;
    public MaxStack() {
        st = new Stack<>();
        maxSt = new Stack<>();
    }

    public void push(int x) {
        int max = st.isEmpty() || x > maxSt.peek()? x : maxSt.peek();
        st.push(x);
        maxSt.push(max);
    }

    public int pop() {
        int top = st.pop();
        maxSt.pop();
        return top;
    }

    public int top() {
        return st.peek();
    }

    public int peekMax() {
        return maxSt.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack ms = new MaxStack();
        ms.push(10);
        System.out.println(ms.peekMax());
        System.out.println(ms.top());
        ms.push(5);
        ms.push(9);
        ms.push(11);
        System.out.println(ms.popMax());
    }
}
