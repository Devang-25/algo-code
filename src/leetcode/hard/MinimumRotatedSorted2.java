package hard;

/**
 * Created by mns on 8/8/18.
 */
public class MinimumRotatedSorted2 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length-1;
        while(left < right){
            //System.out.println(left + " -> " + right);
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right--;
            }
        }

        //System.out.println(right);
        return nums[right];
    }

    public static void main(String[] args) {
        MinimumRotatedSorted2 ms = new MinimumRotatedSorted2();
        System.out.println(ms.findMin(new int[] {7,8,9,9,9,4,4,4,4,5,5, 5, 6, 6,7}));
        System.out.println(ms.findMin(new int[] {9,10,11,11,11,11,11,11,11,11,11,12,9}));
        System.out.println(ms.findMin(new int[] {9,10,11,11,11,11,11,11,11,11,11,12,8,8,8,9}));
        System.out.println(ms.findMin(new int[] {9,9,8,8,7,7,6,6,5,5,4,3,2,2,2,1,1}));
                                              //{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14}
    }
}
