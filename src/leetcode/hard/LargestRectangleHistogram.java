/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.hard;

import java.util.Stack;

/**
 *
 * @author sekha
 */
public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram ls = new LargestRectangleHistogram();
        System.out.println(ls.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(ls.largestRectangleArea(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(ls.largestRectangleArea(new int[]{1, 2, 3, 4, 5, 6, 77}));
        System.out.println(ls.largestRectangleArea(new int[]{}));
        System.out.println(ls.largestRectangleArea(new int[]{10}));
        System.out.println(ls.largestRectangleArea(new int[]{9,8,7,6,5,4,3}));
        System.out.println(ls.largestRectangleArea(new int[]{9,8,7,6,5,4,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,4,5,6,7,8,9}));
    }
}
