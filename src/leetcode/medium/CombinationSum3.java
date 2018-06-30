package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer> > result = new ArrayList<>();
        combineUtil(n,k,1,new ArrayList<>(), result);
        return result;
    }

    private void combineUtil(int n, int k,int startNum, ArrayList<Integer> curr, List<List<Integer>> result){
        if(k==0 && n==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=startNum; i <= 9;i++){
            curr.add(i);
            combineUtil(n-i,k-1,i+1,curr,result);
            curr.remove(curr.size()-1);
        }
    }


    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
//        List<List<Integer>> result = c.combine(3, 7);
        List<List<Integer>> result = c.combinationSum3(3, 9);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
