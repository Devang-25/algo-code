package leetcode.easy;

import leetcode.medium.NextGreaterElement3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] result = new int[nums1.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< nums1.length;i++){
            map.put(nums1[i],i);
        }

        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                Integer index = map.get(nums2[i]);
                if(index != null) {
                    result[index] = nums2[stack.peek()];
                }
            }
            stack.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement1 ng = new NextGreaterElement1();
        System.out.println(Arrays.toString(ng.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
