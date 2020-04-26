package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by mns on 9/5/18.
 */
public class RemoveInvalidParenthesis {
//    public List<String> removeInvalidParentheses2(String s) {
//        Set<String> result = new HashSet<>();
//        String pre = "", post = "";
//        int i = 0, j = s.length()-1;
//        while(i < j && s.charAt(i) != '(' ){
//            if(s.charAt(i) != ')'){
//                pre += s.charAt(i);
//            }
//            i++;
//        }
//
//        while( j >=i && s.charAt(j) != ')' ){
//            if(s.charAt(j) != '('){
//                post = s.charAt(j) + post;
//            }
//            j--;
//        }
//        String middle  = (i<j)? s.substring(i,j+1):"";
//        String filtered = pre+ middle +post;
//        int cnt = 0;
//        for(i=0;i<filtered.length();i++){
//            if(filtered.charAt(i) == '(') cnt++;
//            else if(filtered.charAt(i) == ')') cnt--;
//        }
//        if(cnt == 0){
//            result.add(filtered);
//        }else{
//            util(filtered,0, cnt, result, new StringBuilder());
//        }
//
//        return new ArrayList<>(result);
//
//    }

//    private void util(String s, int index, int cnt, Set<String> result, StringBuilder sb){
//        if(cnt < 0){
//            return;
//        }
//        if(index == s.length()){
//            if(isValid(sb)) {
//                result.add(sb.toString());
//            }
//        }else{
//            char ch = s.charAt(index);
//            if(ch == '(' || ch == '('){
//
//            }
//        }
//    }

    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> res =new ArrayList<>();
        Queue<String> q= new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(s);

        boolean minFound = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                res.add(curr);
                minFound = true;
            }else{
                if(!minFound) {
                    for (int i = 0; i < curr.length(); i++) {
                        if(curr.charAt(i) >='a'|| curr.charAt(i) == 'z'){
                            continue;
                        }
                        String pre = curr.substring(0, i);
                        String post = curr.substring(i + 1);
                        if (!visited.contains(pre + post)) {
                            visited.add(pre + post);
                            q.add(pre + post);
                        }
                    }
                }

            }
        }

        return res;

    }

    private boolean isValid(String s){
        int cnt = 0, len = s.length();
        for(int i=0;i < len ;i++){
            if(s.charAt(i) == '(') cnt++;
            else if(s.charAt(i) == ')') cnt--;
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
