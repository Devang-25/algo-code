package leetcode.easy;

import java.util.HashMap;

public class VerifyAlienDict {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];

            int j=0;
            boolean stop = false;
            for(;j<curr.length() && j < next.length();j++){
                if(map.get(curr.charAt(j)) < map.get(next.charAt(j))){
                    stop = true;
                    break;
                }else if(map.get(curr.charAt(j)) > map.get(next.charAt(j))){
                    return false;
                }
            }

            if(stop){
                continue;
            }
            if( j!=curr.length()){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        VerifyAlienDict v = new VerifyAlienDict();
        System.out.println(v.isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(v.isAlienSorted(new String[] {"app","apple"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(v.isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

}
