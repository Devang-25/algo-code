package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mns on 9/5/18.
 */
public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        String pre = "", post = "";
        int i = 0, j = s.length()-1;
        while(i < j && s.charAt(i) != '(' ){
            if(s.charAt(i) != ')'){
                pre += s.charAt(i);
            }
            i++;
        }

        while( j >=i && s.charAt(j) != ')' ){
            if(s.charAt(j) != '('){
                post = s.charAt(j) + post;
            }
            j--;
        }
        String middle  = (i<j)? s.substring(i,j+1):"";
        String filtered = pre+ middle +post;
        int cnt = 0;
        for(i=0;i<filtered.length();i++){
            if(filtered.charAt(i) == '(') cnt++;
            else if(filtered.charAt(i) == ')') cnt--;
        }
        if(cnt == 0){
            result.add(filtered);
        }else{
            util(filtered,0, cnt, result, new StringBuilder());
        }

        return new ArrayList<>(result);

    }

    private void util(String s, int index, int cnt, Set<String> result, StringBuilder sb){
        if(cnt < 0){
            return;
        }
        if(index == s.length()){
            if(isValid(sb)) {
                result.add(sb.toString());
            }
        }else{
            char ch = s.charAt(index);
            if(ch == '(' || ch == '('){

            }
        }
    }

    private boolean isValid(StringBuilder sb){
        if(sb.toString().startsWith("(")) {
            System.out.println(sb.toString());
        }
        int cnt = 0, len = sb.length();
        for(int i=0;i < len ;i++){
            if(sb.charAt(i) == '(') cnt++;
            else if(sb.charAt(i) == ')') cnt--;
            if(cnt < 0){
                return false;
            }
        }

        return cnt == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesis rp = new RemoveInvalidParenthesis();
        //rp.removeInvalidParentheses("))))))))))a))((((((((((((").stream().forEach(System.out::println);
        rp.removeInvalidParentheses("())(((()m)(").stream().forEach(System.out::println);
    }
}
