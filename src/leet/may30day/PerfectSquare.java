package leet.may30day;

public class PerfectSquare {
  public boolean isPerfectSquare(int num) {
    return Math.abs(Math.sqrt(num) - (int) Math.sqrt(num)) < 10e-4;
  }

  public static void main(String[] args) {
    PerfectSquare ps = new PerfectSquare();
    System.out.println(ps.isPerfectSquare(100));
    System.out.println(ps.isPerfectSquare(99));
  }
}
