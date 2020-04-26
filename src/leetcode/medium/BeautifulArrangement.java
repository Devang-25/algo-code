/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class BeautifulArrangement {
    
    class Result {
        int res;
    }
    public int countArrangement(int N) {
        Result res = new Result();
        boolean [] included = new boolean[N+1];
        countArrangementUtil(N,1,res,included);
        return res.res;
    }
    
    public void countArrangementUtil(int N,int pos, Result r, boolean [] included){
        if(pos == N+1){
            r.res++;
        }
        
        for(int i=1;i<=N;i++){
            if(!included[i]){
                if(i%pos == 0 || pos % i ==0){
                    included[i] = true;
                    countArrangementUtil(N,pos+1,r,included);
                    included[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BeautifulArrangement ba = new BeautifulArrangement();
        System.out.println(ba.countArrangement(15));
    }
}
