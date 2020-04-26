package leetcode.medium;

import java.util.Stack;

/**
 * Created by mns on 8/7/18.
 */
public class ReversePolish {
    public int evalRPN(String[] tokens) {
        int index = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            parse(tokens[i],st);
        }

        return st.pop();
    }

    private void parse(String s, Stack<Integer> st){
        if(s.length() == 1){
            char ch = s.charAt(0);
            if(ch == '+'){
                st.push(st.pop() + st.pop());
            }else if(ch == '-'){
                st.push(- st.pop() + st.pop());
            }else if(ch == '*'){
                st.push(st.pop() * st.pop());
            }else if(ch == '/'){
                int a = st.pop(), b = st.pop();
                st.push(b/a);
            }else{
                st.push(Integer.parseInt(s));
            }
        }else{
            st.push(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {
        ReversePolish rp = new ReversePolish();
        System.out.println(rp.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
