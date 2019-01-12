package leetcode.hard;

import java.util.HashSet;

public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        if( n == 0 || k == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i<n;i++){
            result.append('0');
        }
        visited.add(result.toString());
        if(util(visited,result,(int)Math.pow(k,n),n,k)){
            return result.toString();
        }
        return "";
    }

    private boolean util(HashSet<String> visited, StringBuilder result, int total, int n, int k){
        if(visited.size() == total){
            return true;
        }

        String subString = result.substring(result.length()-n+1);
        for(char i = '0'; i<'0'+k ;i++){
            if(!visited.contains(subString+i)){
                visited.add(subString+i);
                result.append(i);
                if(util(visited, result, total,n,k)){
                    return true;
                }
                visited.remove(subString+i);
                result.setLength(result.length()-1);

            }
        }
        return false;
    }

    public static void main(String[] args) {
        CrackingTheSafe cs = new CrackingTheSafe();
        //System.out.println(cs.crackSafe(10,1));
        System.out.println(cs.crackSafe(2,2));
    }
}
