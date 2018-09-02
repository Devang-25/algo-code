package leetcode.easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if(A.length <= 2){
            return true;
        }

        int inc = 0;
        for(int i=0;i<A.length-1;i++){
            if(A[i] < A[i+1]){
                if(inc == -1){
                    return false;
                }
                inc = 1;
            }else if(A[i] > A[i+1] ){
                if(inc == 1){
                    return false;
                }
                inc = -1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray ma = new MonotonicArray();
        System.out.println(ma.isMonotonic(new int[]{4,4,4,4,3,3,3,2}));
    }
}
