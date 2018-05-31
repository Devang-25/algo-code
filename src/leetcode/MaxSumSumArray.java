/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class MaxSumSumArray {
    
    public static class Pair{
        public int first;
        public int second;
        
        public Pair(){}
        public Pair(int a,int b){
            first = a;
            second = b;
        }
        
        public Pair(Pair p){
            this.first = p.first;
            this.second = p.second;
        }
    }
    public static Pair Solve(int [] arr){
        
        Pair p = new Pair();
        
        p.first = -1;
        p.second = -1;
        
        Pair best = new Pair(p);
        
        int max_so_far = 0;
        int max_ending_here = 0;
        
        for(int i=0;i<arr.length;i++){
            max_ending_here += arr[i];
            if(max_ending_here < 0){
                max_ending_here = 0;
                p.first=i+1;
                p.second=i+1;
            }
            
            if(max_ending_here > max_so_far){
                max_so_far = max_ending_here;
                p.second = i;
                best = new Pair(p);
            }
        }
        
        if(best.first >= arr.length || best.second >= arr.length){
            best.first = -1;
            best.second = -1;
        }
        return best;
    }
    
    public static void main(String[] args) {
        int a[] = {-2, 3, -4, -1, 5, -1, -5, -3};
        Pair p = Solve(a);
        System.out.println(p.first + " "+p.second);
    }
}
