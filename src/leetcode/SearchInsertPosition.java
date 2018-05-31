public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
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

        if(nums[mid] < target){
            return mid+1;
        }

        return mid;
    }

}
