package leetcode.hard;

public class ShortestSubArraySumAtleastK {
    public int shortestSubarray(int[] A, int K) {

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sumWindow = 0;
        while(right < A.length){
            while(sumWindow < K && right < A.length){
                sumWindow+= A[right++];
            }

            if(sumWindow >= K) {
                minLength = Math.min(minLength, (right - left));
            }

            while(sumWindow >= K && left <= right ){
                minLength = Math.min(minLength, (right - left));
                sumWindow -= A[left++];
            }
        }

        return minLength == Integer.MAX_VALUE? -1 : minLength;
    }

    public static void main(String[] args) {
        ShortestSubArraySumAtleastK s = new ShortestSubArraySumAtleastK();
//        System.out.println(s.shortestSubarray(new int[]{2,-1,2},3));
//        System.out.println(s.shortestSubarray(new int[]{1},1));
//        System.out.println(s.shortestSubarray(new int[]{1,2},4));
        System.out.println(s.shortestSubarray(new int[]{4,3,-2,-1,0,6,3,2,-1,4},10));
    }
}
