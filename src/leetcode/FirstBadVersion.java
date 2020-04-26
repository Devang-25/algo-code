package leetcode;

public class FirstBadVersion {

    private boolean isBadVersion(int num){
        return false;
    }
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        int pos = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(isBadVersion(mid)){
                pos = mid;
                r= mid-1;
            }else{
                l = mid+1;
            }
        }

        return pos;
    }
}
