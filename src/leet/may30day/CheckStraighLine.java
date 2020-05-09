package leet.may30day;

public class CheckStraighLine {
  private static final double PRECISION = 10e-4;

  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length == 0) {
      return false;
    }

    if (coordinates.length < 2) {
      return true;
    }

    for (int i = 0; i < coordinates.length - 2; i++) {
      double slope1 = getSlope(coordinates[i], coordinates[i + 1]);
      double slope2 = getSlope(coordinates[i + 1], coordinates[i + 2]);

      if (Math.abs(slope2 - slope1) > PRECISION) {
        return false;
      }
    }

    return true;
  }

  private double getSlope(int[] p1, int[] p2) {
    return p2[0] == p1[0] ? Double.MAX_VALUE : (double) (p2[1] - p1[1]) / (double) (p2[0] - p1[0]);
  }

  public static void main(String[] args) {
    CheckStraighLine csl = new CheckStraighLine();
    System.out
        .println(csl.checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 }, }));
    System.out
        .println(csl.checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 }, { 6, 6 }, }));
  }
}
