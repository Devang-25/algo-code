package leetcode.easy;

import java.util.HashMap;

public class StrobogrammaticNumber {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static {
        map.put(1,1);
        map.put(0,0);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
    }

    public boolean isStrobogrammatic(String num){
        int length = num.length();
        int j = length-1;
        for(int i=0;i<=length/2;i++){
            if(!map.containsKey(num.charAt(i)-'0') || (num.charAt(j)-'0') != map.get(num.charAt(i)-'0')){
                return false;
            }
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber sb = new StrobogrammaticNumber();
        System.out.println(sb.isStrobogrammatic("101"));
    }
}
