package leet.apr30day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface BinaryMatrix {
  public int get(int x, int y);

  public List<Integer> dimensions();
}

class BinaryMatrixImpl implements BinaryMatrix {
  private int arr[][];

  BinaryMatrixImpl(int[][] arr) {
    this.arr = arr;
  }

  public int get(int x, int y) {
    return this.arr[x][y];
  }

  public List<Integer> dimensions() {
    return new ArrayList<>(Arrays.asList(this.arr.length, this.arr[0].length));
  }

}

public class BinaryMatrixLeft {
  // public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
  // int[] dim = binaryMatrix.dimensions().stream().mapToInt(i -> i).toArray();
  // int x = 0, y = dim[1]-1;
  // int res = -1;
  // while(y >= 0 && x < dim[0]) {
  // if(binaryMatrix.get(x,y) == 1) {
  // res = y;
  // y--;
  // }else {
  // x++;
  // }
  // }
  // return res;
  // }

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    int[] dim = binaryMatrix.dimensions().stream().mapToInt(i -> i).toArray();
    int colMin = 0, colMax = dim[1] - 1;
    int res = -1;
    while (colMin <= colMax) {
      int colMid = (colMin + colMax) / 2;

      for (int i = 0; i < dim[0]; i++) {
        if (binaryMatrix.get(i, colMid) == 1) {
          res = colMid;
          break;
        }
      }

      if (res == -1) {
        colMin = colMid + 1;
      } else {
        colMax = colMid - 1;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    BinaryMatrix bm = new BinaryMatrixImpl(
        new int[][] { { 0, 0, 0, 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1 } });

    BinaryMatrixLeft bl = new BinaryMatrixLeft();

    System.out.println(bl.leftMostColumnWithOne(bm));
  }
}
