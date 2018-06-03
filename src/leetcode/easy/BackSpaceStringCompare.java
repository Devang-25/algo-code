package leetcode.easy;

import java.util.Stack;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String S, String T){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) != '#'){
                st.push(S.charAt(i));
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }

        StringBuffer sb1 = new StringBuffer();
        while (!st.isEmpty()){
            sb1.append(st.pop());
        }

        for(int i=0;i<T.length();i++){
            if(T.charAt(i) != '#'){
                st.push(T.charAt(i));
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }


        StringBuffer sb2 = new StringBuffer();
        while (!st.isEmpty()){
            sb2.append(st.pop());
        }

        return sb1.toString().contentEquals(sb2.toString());
    }

    public static void main(String[] args) {
        BackSpaceStringCompare bs = new BackSpaceStringCompare();
        System.out.println(bs.backspaceCompare("ab#c","ad#c"));
    }
}
