public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums,target),findLast(nums,target)};
    }

    private int findFirst(int [] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        int pos = -1;
        while(l <= r){
            mid = l + (r-l)/2;

            if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] < target){
                l =mid+1;
            }else{
                pos = mid;
                r = mid-1;
            }
        }

        return pos;
    }

    private int findLast(int [] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        int pos = -1;
        while(l <= r){
            mid = l + (r-l)/2;

            if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] < target){
                l =mid+1;
            }else{
                pos = mid;
                l = mid+1;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        SearchForARange sr = new SearchForARange();
        System.out.println(sr.findFirst(new int[]{2,2,3,4,5,6,7,7,7},2));
        System.out.println(sr.findLast(new int[]{2,2,3,4,5,6,7,7,7},2));
    }
}
