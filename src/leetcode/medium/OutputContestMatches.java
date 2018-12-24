package leetcode.medium;

import java.util.ArrayList;

public class OutputContestMatches {
    public String findContestMatch(int n) {
        if(n <= 0){
            return "";
        }

        ArrayList<String> init = new ArrayList<>();
        for(int i=1;i<=n;i++){
            init.add(Integer.toString(i));
        }

        int size = n;
        while(size > 1){
            ArrayList<String> comb = new ArrayList<>();
            for(int i=0;i<size/2;i++){
                comb.add("("+init.get(i)+","+init.get(size-i-1)+")");
            }
            init = comb;
            size = init.size();
        }

        return init.get(0);

    }

    public static void main(String[] args) {
        OutputContestMatches o = new OutputContestMatches();
        System.out.println(o.findContestMatch(8));
    }
}
