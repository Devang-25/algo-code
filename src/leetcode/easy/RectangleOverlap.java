/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
      return !(rec2[0] >= rec1[2] ||  rec2[1] >= rec1[3] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3]);
    }
    
    public static void main(String[] args) {
        RectangleOverlap ro = new RectangleOverlap();
        System.out.println(ro.isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
        System.out.println(ro.isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
    }
   
}
