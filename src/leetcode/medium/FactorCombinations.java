package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer> > result = new ArrayList<>();
        util(n,-1,new ArrayList<>(), result);
        return result;
    }

    private void util(int n, int prev,List<Integer> current, List<List<Integer>> result ){

        if(prev != -1){
            current.add(n);
            result.add(new ArrayList<>(current));
            current.remove(current.size()-1);
        }

        for(int i=Math.max(2, prev);i<=Math.sqrt(n);i++){
            if(n%i == 0){
                current.add(i);
                util(n/i,i,current,result);
                current.remove(current.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        FactorCombinations fc = new FactorCombinations();
        List<List<Integer>> result = fc.getFactors(32);
        for(List<Integer> list : result){
            for(Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
