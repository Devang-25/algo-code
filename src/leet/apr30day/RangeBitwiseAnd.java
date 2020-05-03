package leet.apr30day;

public class RangeBitwiseAnd {

  public int rangeBitwiseAnd(int m, int n) {
    int res = 0;

    int msbm = (int) (Math.log(m) / Math.log(2));
    int msbn = (int) (Math.log(n) / Math.log(2));

    while (msbm == msbn && m > 0 && n > 0) {
      int diff = (int) (Math.pow(2, msbm));
      res += diff;
      m -= diff;
      n -= diff;

      msbm = (int) (Math.log(m) / Math.log(2));
      msbn = (int) (Math.log(n) / Math.log(2));
    }

    return res;
  }

  public static void main(String[] args) {
    RangeBitwiseAnd r = new RangeBitwiseAnd();
    System.out.println(r.rangeBitwiseAnd(5, 7));
    System.out.println(r.rangeBitwiseAnd(0, 1));
  }
}
