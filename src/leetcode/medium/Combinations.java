package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer> > result = new ArrayList<>();
        combineUtil(n,k,1,new ArrayList<>(), result);
        return result;
    }

    private void combineUtil(int n, int k,int index, ArrayList<Integer> curr, List<List<Integer>> result){
        if(k==0){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i <= n;i++){
            curr.add(i);
            combineUtil(n,k-1,i+1,curr,result);
            curr.remove(curr.size()-1);
        }
    }


    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> result = c.combine(4, 2);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
