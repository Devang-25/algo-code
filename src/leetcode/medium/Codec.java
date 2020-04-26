package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append(',').append(s);
        }
        return sb.toString();
    }

    // 6,sekhar,4,varc,3,abc,1,a,
    public List<String> decode(String s){
        List<String> result = new ArrayList<>();
        if(s.length() == 0) return result;

        for(int i=0;i<s.length();){
            int prev = i;
            while(s.charAt(i++)!=',');
            int end = i+Integer.parseInt(s.substring(prev,i-1));
            result.add(s.substring(i,end));
            i = end;
        }

        return result;
    }

    public static void main(String [] args){
        Codec c = new Codec();
        List<String> st = Arrays.asList( new String[]{"sekhar","varc","abc","a"});
        c.decode(c.encode(st)).stream().forEach(System.out::println);
        st = Arrays.asList( new String[]{});
        c.decode(c.encode(st)).stream().forEach(System.out::println);

    }
}