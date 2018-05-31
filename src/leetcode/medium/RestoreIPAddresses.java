package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mns on 5/25/18.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s){
        ArrayList<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        ArrayList<Integer> state = new ArrayList<>();
        restoreIpAddressesUtil(s,result,state,0);
        return result;
    }

    private void restoreIpAddressesUtil(String s, ArrayList<String> result, ArrayList<Integer> state, int index ){

        if(state.size() == 4 && index == s.length()){
            StringBuilder ip = new StringBuilder();
            for(Integer i : state){
                ip.append(i).append('.');
            }
            ip.setLength(ip.length()-1);
            result.add(ip.toString());
        } else if(state.size() >= 4) {
            return;
        }

        for(int end=index;end<index+3 && end<s.length();end++){
            String currString = s.substring(index,end+1);
            if(isValid(currString)){
                state.add(Integer.parseInt(currString));
                restoreIpAddressesUtil(s,result,state,end+1);
                state.remove(state.size()-1);
            }
        }

    }

    boolean isValid(String s) {
        if(s.startsWith("00") || (s.startsWith("0")&& Integer.parseInt(s) != 0)  || Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddresses rip = new RestoreIPAddresses();
//        rip.restoreIpAddresses("25525511135").stream().forEach(System.out::println);
//        rip.restoreIpAddresses("0000").stream().forEach(System.out::println);
//        rip.restoreIpAddresses("00200").stream().forEach(System.out::println);
        rip.restoreIpAddresses("010010").stream().forEach(System.out::println);
    }
}
