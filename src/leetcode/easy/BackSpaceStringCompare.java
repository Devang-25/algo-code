package leetcode.easy;

import java.util.Stack;

public class BackSpaceStringCompare {
    private String  condense( String S){
        Stack<Character> st = new Stack<>();
        StringBuffer sb1 = new StringBuffer();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) != '#'){
                st.push(S.charAt(i));
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }

        while (!st.isEmpty()){
            sb1.append(st.pop());
        }
        return sb1.toString();
    }
    public boolean backspaceCompare(String S, String T){
        if(S == null || T == null){
            return false;
        }

        return condense(S).contentEquals(condense(T));
    }

    public static void main(String[] args) {
        BackSpaceStringCompare bs = new BackSpaceStringCompare();
        System.out.println(bs.backspaceCompare("ab#c","ad#c"));
    }
}
