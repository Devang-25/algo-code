package leetcode.hard;

/**
 * Created by mns on 6/25/18.
 */
public class PatchingArray {
    public int minPatches(int [] nums, int n){
        int patches = 0;
        long maxAttainable = 0;
        int i = 0;

        while(maxAttainable < n){
            if(i >= nums.length || nums[i] > maxAttainable+1){
                patches++;
                maxAttainable = maxAttainable*2+1;
            }else{
                maxAttainable += nums[i++];
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        System.out.println(pa.minPatches(new int[]{10},10));
        System.out.println(pa.minPatches(new int[]{1,2,3,4},10));
        System.out.println(pa.minPatches(new int[]{1,2,31,32},2147483647));
    }
}
