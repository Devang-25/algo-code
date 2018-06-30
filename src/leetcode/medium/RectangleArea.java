package medium;


/**
 * Created by mns on 6/26/18.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);

        int left = Math.max(A,E);
        int bottom = Math.max(B,F);
        int top = Math.min(D,H);
        int right = Math.min(C,G);

        int overlap = 0;
        if(right > left && top > bottom)
            overlap = (right - left) * (top - bottom);
        return area1 + area2 - overlap;
     }

    public static void main(String[] args) {
        RectangleArea ra = new RectangleArea();
        System.out.println(ra.computeArea(-3,0,3,4,0,-1,9,2));
    }
}
