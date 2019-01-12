package leetcode.hard;

public class BasicCalculator {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int prevVal = 0, num = 0;
        int res = 0;
        char prevOp = '+';
        while (i < s.length()) {
            if(s.charAt(i) == ' ') { i++; continue;}
            if(s.charAt(i) == '('){
                int cnt = 0;
                int start = i+1;
                boolean found = false;
                while(i < s.length() && !found){
                    if(s.charAt(i) == '('){
                        cnt++;
                    }else if(s.charAt(i) == ')'){
                        cnt--;
                    }
                    if(cnt == 0){
                        num = calculate(s.substring(start,i));
                        found = true;
                    }
                    i++;
                }

            }

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
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate(" ( 3 )"));
        System.out.println(bc.calculate("1+1"));
        System.out.println(bc.calculate("(1+1)"));
        System.out.println(bc.calculate("(1+1)+2+(3*4)"));
        System.out.println(bc.calculate("1 * (2+4)"));
        System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
