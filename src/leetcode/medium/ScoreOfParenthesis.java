package leetcode.medium;

import java.util.Stack;

public class ScoreOfParenthesis {
    public int scoreOfParentheses(String s){
        Stack<Integer> st = new Stack<>();
        int l = s.length();
        for(int i=0;i< l;i++){
            if (s.charAt(i) =='(') {
                st.push(0);
            }else{
                if(st.peek() == 0){
                    st.pop();
                    st.push(1);
                }else {
                    int sum = 0;
                    while (st.peek() != 0) {
                        sum += st.pop();
                    }
                    st.pop();
                    st.push(sum * 2);
                }
            }
        }

        int total = 0;
        while (!st.isEmpty()){
            total += st.pop();
        }

        return total;
    }

    public static void main(String[] args) {
        ScoreOfParenthesis sc = new ScoreOfParenthesis();
        System.out.println(sc.scoreOfParentheses("()"));
        System.out.println(sc.scoreOfParentheses("()()()()"));
        System.out.println(sc.scoreOfParentheses("(((((())))))"));
        System.out.println(sc.scoreOfParentheses("(()(()))"));
    }
}
