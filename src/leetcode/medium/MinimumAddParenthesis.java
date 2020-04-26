package leetcode.medium;

/**
 * Created by mns on 10/14/18.
 */
public class MinimumAddParenthesis {
    public int minAddToMakeValid(String s) {
        int i = 0;
        int open = 0, closed = 0;
        while ( i < s.length()){
            if(s.charAt(i) == ')'){
                if(open > 0){
                    open -- ;
                }else{
                    closed++;
                }
            }else{
                open++;
            }
            i++;
        }

        return Math.abs(open+closed);
    }

    public static void main(String[] args) {
        MinimumAddParenthesis m = new MinimumAddParenthesis();
        System.out.println(m.minAddToMakeValid("()))(("));
        System.out.println(m.minAddToMakeValid(""));
        System.out.println(m.minAddToMakeValid("((("));
        System.out.println(m.minAddToMakeValid("())"));
    }
}
