package leetcode.medium;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] a) {
        if(a == null || a.length <= 1){
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            int l = i, r = a.length-1;
            if(maxLength >= r-l){
                break;
            }
            while ( l < r){
                if(maxLength >= r-l){
                    break;
                }else if(a[l] <= a[r]){
                    if(maxLength < r-l){
                        maxLength = r-l;
                        break;
                    }
                }
                r--;
            }
        }

        return maxLength == Integer.MIN_VALUE? 0 : maxLength;
    }

    public static void main(String[] args) {
        MaximumWidthRamp mr = new MaximumWidthRamp();
        System.out.println(mr.maxWidthRamp(new int[] {6,0,8,2,1,5}));
        System.out.println(mr.maxWidthRamp(new int[] {9,8,1,0,1,9,4,0,4,1}));
        System.out.println(mr.maxWidthRamp(new int[] {1,1,1,1,1,1,1,1,1,2}));
        System.out.println(mr.maxWidthRamp(new int[] {9,8,7,6,5,4,3,2,10}));
    }
}
