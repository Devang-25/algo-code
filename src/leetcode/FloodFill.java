/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0) {
      return image;
    }

    if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) {
      return image;
    }

    int[][] newImage = new int[image.length][image[0].length];
    for (int i = 0; i < newImage.length; i++) {
      for (int j = 0; j < newImage[0].length; j++) {
        newImage[i][j] = image[i][j];
      }
    }
    floodFillUtil(image, newImage, sr, sc, newColor, image[sr][sc]);
    return newImage;
  }

  private void floodFillUtil(int[][] image, int[][] newImage, int sr, int sc, int newColor, int oldColor) {
    if (newColor == oldColor || image == null || image.length == 0) {
      return;
    }

    if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) {
      return;
    }

    if (image[sr][sc] != -1) {
      if (image[sr][sc] == oldColor) {
        newImage[sr][sc] = newColor;
        image[sr][sc] = -1;
        floodFillUtil(image, newImage, sr + 1, sc, newColor, oldColor);
        floodFillUtil(image, newImage, sr, sc + 1, newColor, oldColor);
        floodFillUtil(image, newImage, sr - 1, sc, newColor, oldColor);
        floodFillUtil(image, newImage, sr, sc - 1, newColor, oldColor);

      }
    }
  }

  public static void main(String[] args) {
    FloodFill f = new FloodFill();
    int[][] arr1 = new int[][] { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 }, };

    int[][] arr = f.floodFill(arr1, 1, 1, 2);
    System.out.println(arr);
  }
}
