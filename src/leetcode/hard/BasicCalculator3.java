package leetcode.hard;

public class BasicCalculator3 {
    public int calculate(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }
        System.out.println(s.replaceAll(" ",""));
        return calculateUtil(s.replaceAll(" ",""),0)[0];
    }


    public int[] calculateUtil(String s, int j) {
        int i = j;
        int prevVal = 0, num = 0;
        int res = 0;
        char prevOp = '+';
        while (i < s.length()) {
            if(s.charAt(i) == '('){
                int [] temp = calculateUtil(s,i+1);
                num = temp[0];
                i = temp[1]+1;
            }

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
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
            } else if (prevOp == '/'){
                prevVal = prevVal / num;
            }
            if( i == s.length() || s.charAt(i) == ')'){
                res += prevVal;
                break;
            }else  {
                prevOp = s.charAt(i);
                i++;
                num = 0;
            }
        }

        return new int[]{res, i};
    }

    public static void main(String[] args) {
        BasicCalculator3 b = new BasicCalculator3();
        System.out.println(b.calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
