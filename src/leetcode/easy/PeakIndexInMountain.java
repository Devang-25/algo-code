package leetcode.easy;

public class PeakIndexInMountain {
    public int peakIndexInMountain(int [] a){
        if(a==null || a.length <3){
            return -1;
        }

        for(int i=1;i<a.length-1;i++){
            if(a[i] > a[i+1] && a[i] > a[i-1]){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PeakIndexInMountain pi = new PeakIndexInMountain();
        System.out.println(pi.peakIndexInMountain(new int[] {0,1,0}));
        System.out.println(pi.peakIndexInMountain(new int[] {0,2,1,0}));
    }
}
