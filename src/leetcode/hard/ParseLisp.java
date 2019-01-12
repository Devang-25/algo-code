package leetcode.hard;

import java.util.HashMap;

public class ParseLisp {

    public int evaluate(String expression) {
        return parseExpression(expression, new HashMap<>());
    }

    private int parseExpression( String e, HashMap<String, Integer> vars) {
        int i=1;
        StringBuilder sb = new StringBuilder();
        while( e.charAt(i) != ' '){
            sb.append(e.charAt(i));
            i++;
        }

        if(sb.toString().contentEquals("add")){
            int [] operand1 = getOperand(e,i+1,vars);
            int [] operand2 = getOperand(e, operand1[1]+1,vars);
            return operand1[0] + operand2[0];
        }else if(sb.toString().contentEquals("mult")){
            int [] operand1 = getOperand(e,i+1,vars);
            int [] operand2 = getOperand(e, operand1[1]+1,vars);
            return operand1[0] * operand2[0];
        }else if(sb.toString().contentEquals("let")){
            HashMap<String,Integer> map = new HashMap<>(vars);
            int ind = setVariable(e,i+1, map);
            int prev = ind;
            while(ind !=-1){
                prev = ind;
                ind = setVariable(e,prev+1,map);
            }
            return getOperand(e,prev+1,map)[0];
        }

        return 0;
    }

    private int setVariable(String e, int start, HashMap<String, Integer> vars){
        if(e.charAt(start) == '('){
           return -1;
        }else {
            int i= start;
            StringBuilder sb = new StringBuilder();
            while( e.charAt(i) != ' ' && e.charAt(i) != ')'){
                sb.append(e.charAt(i));
                i++;
            }

            if(e.charAt(i) == ')' ){
                return -1;
            }

            int[] val = getOperand(e,i+1,vars);
            vars.put(sb.toString(), val[0]);
            return val[1];
        }
    }
    private int [] getOperand(String e, int start, HashMap<String, Integer > vars){
        if(e.charAt(start) == '('){
            int cnt = 1, i= start+1;
            while(cnt >= 1){
                if(e.charAt(i) == '(') cnt++;
                else if(e.charAt(i) == ')') cnt--;
                i++;
            }
            return new int [] { parseExpression(e.substring(start,i), vars), i };
        }else if(Character.isDigit(e.charAt(start)) || e.charAt(start) == '-'){
            int i = start;
            StringBuilder sb = new StringBuilder();
            while( e.charAt(i) != ' ' && e.charAt(i) != ')'){
                sb.append(e.charAt(i));
                i++;
            }
            return new int[] { Integer.parseInt(sb.toString()), i};
        }else {
            int i= start;
            StringBuilder sb = new StringBuilder();
            while( e.charAt(i) != ' ' && e.charAt(i) != ')'){
                sb.append(e.charAt(i));
                i++;
            }
            return new int [] { vars.get(sb.toString()), i};
        }
    }

    public static void main(String[] args) {
        ParseLisp p = new ParseLisp();
//        System.out.println(p.evaluate("(let a1 3 b2 (add a1 1) b2)"));
//        System.out.println(p.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
//        System.out.println(p.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
//        System.out.println(p.evaluate("(let x 3 x 2 x)"));
//        System.out.println(p.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
//        System.out.println(p.evaluate("(mult 3 (add 2 3))"));
        System.out.println(p.evaluate("(let var 78 b 77 (let c 33 (add c (mult var 66))))"));

    }
}
