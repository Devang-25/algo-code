package leetcode.medium;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char prevOp = '+';
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || i == s.length() - 1) {
                int currNumber = Integer.parseInt(sb.toString());
                if (prevOp == '*') {
                    st.push(st.pop() * currNumber);
                } else if (prevOp == '/') {
                    st.push(st.pop() / currNumber);
                } else if (prevOp == '-') {
                    st.push(currNumber * -1);
                } else {
                    st.push(currNumber);
                }

                prevOp = s.charAt(i);
                sb.setLength(0);
            }
            i++;
        }

        int res = 0;
        while (!st.empty()) {
            res += st.pop();
        }

        return res;
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int prevVal = 0, num = 0;
        int res = 0;
        char prevOp = '+';
        while (i < s.length()) {
            while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                i++;
            }

            if (prevOp == '+') {
                res += prevVal;
                prevVal = num;
            } else if (prevOp == '-') {
                res += prevVal;
                prevVal = -num;
            } else if (prevOp == '*') {
                prevVal = prevVal * num;
            } else {
                prevVal = prevVal / num;
            }
            if (i != s.length()) {
                prevOp = s.charAt(i);
                i++;
                num = 0;
            } else {
                res += prevVal;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        BasicCalculator2 bc = new BasicCalculator2();
        System.out.println(bc.calculate("1+2+3"));
        System.out.println(bc.calculate("1"));
    }
}
