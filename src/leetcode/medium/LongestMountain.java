package leetcode.medium;

public class LongestMountain {
    public int longestMountain(int[] A) {
        if(A==null || A.length <= 2){
            return 0;
        }

        int index = 1;
        int maxLength = 0;
        int currLength = 0;
        boolean rising = true;
        while(index < A.length){
            if(rising){
                if(A[index] > A[index-1]){
                    currLength += 1;
                }else if(A[index] < A[index-1] && currLength > 0){
                    rising = false;
                    currLength += 1;
                }else{
                    rising = true;
                    currLength = 0;
                }
            }else{
                if(A[index] < A[index-1]){
                    currLength += 1;
                }else if(A[index] >= A[index-1]){
                    maxLength = Math.max(currLength+1,maxLength);
                    rising = true;
                    currLength = 0;
                    index--;
                }
            }
            index++;
        }

        if(!rising){
            maxLength = Math.max(currLength+1,maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestMountain lm = new LongestMountain();
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(lm.longestMountain(new int[]{9,8,7,6,5,4,3,4,5,6,3}));
        System.out.println(lm.longestMountain(new int[]{2,2,2}));
        System.out.println(lm.longestMountain(new int[]{9,8,7,6,10,12,14}));
    }
}
