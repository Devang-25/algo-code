package leet.may30day;

import java.util.Arrays;

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int[][] newImage = new int[image.length][image[0].length];
    floodFillUtil(image, newImage, sr, sc, image[sr][sc]);
    for (int i = 0; i < newImage.length; i++) {
      for (int j = 0; j < newImage[0].length; j++) {
        newImage[i][j] = newImage[i][j] == -1 ? newColor : image[i][j];
      }
    }
    return newImage;
  }

  private void floodFillUtil(int[][] image, int[][] newImage, int sr, int sc, int oldColor) {
    if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != oldColor) {
      return;
    }

    if (newImage[sr][sc] != -1) {
      newImage[sr][sc] = -1;
      floodFillUtil(image, newImage, sr + 1, sc, oldColor);
      floodFillUtil(image, newImage, sr, sc + 1, oldColor);
      floodFillUtil(image, newImage, sr - 1, sc, oldColor);
      floodFillUtil(image, newImage, sr, sc - 1, oldColor);
    }
  }

  public static void main(String[] args) {
    FloodFill f = new FloodFill();
    int[][] arr1 = new int[][] { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 }, };

    int[][] arr = f.floodFill(arr1, 1, 1, 2);
    System.out.println(arr);
  }
}
