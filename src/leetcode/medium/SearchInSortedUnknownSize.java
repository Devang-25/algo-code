package leetcode.medium;

interface  ArrayReader {
    default int get(int k){
        return Integer.MAX_VALUE;
    }
}

class ArrayReaderImpl implements ArrayReader {
    private int [] nums = null;
    public ArrayReaderImpl ( int [] a){
        nums = a;
    }

    @Override
    public int get(int k) {
        if( k >= nums.length || k < 0){
            return Integer.MAX_VALUE;
        }else {
            return nums[k];
        }
    }
}

public class SearchInSortedUnknownSize {

    public int search(ArrayReader reader, int target) {
        int l = 0, r = Integer.MAX_VALUE;

        while( l <= r) {
            int mid = l + (r-l)/2;
            int num = reader.get(mid);
            if(num == target) {
                return mid;
            }else if( num > target ){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInSortedUnknownSize s = new SearchInSortedUnknownSize();
        ArrayReader a = new ArrayReaderImpl(new int[]{-1,0,3,5,9,12});
        System.out.println(s.search(a,9));
    }

}
