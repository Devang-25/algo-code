package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public int[] nextGreaterElements(int [] nums){
        int [] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            stack.add(i);
        }

        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement2 nm = new NextGreaterElement2();
        System.out.println(Arrays.toString(nm.nextGreaterElements(new int[]{1,2,1})));
    }
}

